package p1;

import p2.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class transfer3
 */
public class transfer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transfer3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String d=date2.now();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		Connection conn = null;
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		int taccno;
	   int daccno;
	   String acctype="";
	   String acctype2="";
	   int amt;
	   String dname="";
	   String strQuery= ""; 
	   String strQuery1= "";
	   String strQuery2= "";
	   String strQuery3= "";
	   String strQuery4= "";
   		Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);
		

		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection("jdbc:odbc:test","","");
			
			if(request.getParameter("taccno")!=null && request.getParameter("daccno")!="" && request.getParameter("daccno")!=null && request.getParameter("daccno")!=""
				&& request.getParameter("amt")!=null && request.getParameter("amt")!=""
						&& request.getParameter("dname")!=null && request.getParameter("dname")!="")
			{
				taccno = Integer.parseInt(request.getParameter("taccno"));
				daccno = Integer.parseInt(request.getParameter("daccno"));
				acctype = request.getParameter("acctype").toString();
				acctype2 = request.getParameter("acctype2").toString();
				amt = Integer.parseInt(request.getParameter("amt"));
				dname = request.getParameter("dname").toString();
								
				st = conn.createStatement();
				
				strQuery1="SELECT balance FROM master WHERE accno="+taccno+"";
				 rs=st.executeQuery(strQuery1);
					
				int balance1=0;
				while (rs.next()) {
				balance1=rs.getInt("balance");
				}

				int bal1=balance1-amt;
				strQuery2="UPDATE master SET balance="+bal1+" WHERE accno="+taccno+"";
				int i = st.executeUpdate(strQuery2);
				
				strQuery3="SELECT balance FROM master WHERE accno="+daccno+"";
				 rs=st.executeQuery(strQuery3);
				
					
								int balance2=0;
				while (rs.next()) {
					balance2=rs.getInt("balance");
					}
				int bal2=balance2+amt;
				strQuery4="UPDATE master SET balance="+bal2+" WHERE accno="+daccno+"";
				int i1 = st.executeUpdate(strQuery4);
				
				strQuery="INSERT INTO transfer (taccno,daccno,acctype,acctype2,amt,dname,transferdate)"+"VALUES('"+taccno+"','"+daccno+"','"+acctype+"','"+acctype2+"','"+amt+"','"+dname+"','"+d+"')";
				
			st.executeUpdate(strQuery);
			
					RequestDispatcher rd=this.getServletConfig().getServletContext().getRequestDispatcher("/transfer4.jsp");
					rd.forward(request, response);
			
			}
			conn.close();
			
		} catch (Exception e) {
		e.printStackTrace();
		}	
		
	}

}
