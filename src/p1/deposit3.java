package p1;

import p2.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class deposit3
 */
public class deposit3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deposit3() {
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
		String accname="";
		String strQuery= ""; 
		   String strQuery1= "";
		   String strQuery2= "";
	   String acctype="";
	   int accno;
	   int amt;
	   String dname="";
	     		Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);
		try {
			Class.forName(driver);

			conn = DriverManager.getConnection("jdbc:odbc:test","","");
			
			if(request.getParameter("accname")!=null && request.getParameter("accname")!="" 
				&& request.getParameter("acctype")!=null && request.getParameter("acctype")!=""
					&& request.getParameter("dname")!=null && request.getParameter("dname")!="")
			{
				accname = request.getParameter("accname").toString();
				acctype = request.getParameter("acctype").toString();
				accno=Integer.parseInt(request.getParameter("accno")); 
				amt=Integer.parseInt(request.getParameter("amt"));
				dname = request.getParameter("dname").toString();
				
				/*new code */
				       
				st = conn.createStatement();

				strQuery1="SELECT balance FROM master WHERE accno="+accno+"";
 rs=st.executeQuery(strQuery1);

int balance=0;
while (rs.next()) {
balance=rs.getInt("balance");
}


int bal1=balance+amt;
strQuery2="UPDATE master SET balance="+bal1+" WHERE accno="+accno+"";
int i = st.executeUpdate(strQuery2);


strQuery="INSERT INTO deposit (accno,accname,acctype,dname,amt,depositdate)"+"VALUES('"+accno+"','"+accname+"','"+acctype+"','"+dname+"','"+amt+"','"+d+"')";
 st.executeUpdate(strQuery);	
 
 System.out.println("all queries executed");
	
	RequestDispatcher rd=this.getServletConfig().getServletContext().getRequestDispatcher("/deposit4.jsp");
	rd.forward(request, response);
 
			}
			conn.close();
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
	}

}
