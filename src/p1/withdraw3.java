package p1;

import p2.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class withdraw3
 */
public class withdraw3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public withdraw3() {
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
		int accno;
	   String acctype="";
	   int amt;
	   String strQuery= ""; 
	   String strQuery1= "";
	   String strQuery2= "";
           
		Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);
		

		try {
			Class.forName(driver);
		
			conn = DriverManager.getConnection("jdbc:odbc:test","","");
			
				accno = Integer.parseInt(request.getParameter("accno"));
				acctype=request.getParameter("acctype").toString();
				amt = Integer.parseInt(request.getParameter("amt"));
                
				st = conn.createStatement();
		
				strQuery1="SELECT balance FROM master WHERE accno="+accno+"";
 rs=st.executeQuery(strQuery1);
	
int balance=0;
while (rs.next()) {
balance=rs.getInt("balance");
}

if(amt<=balance)
{
int bal1=balance-amt;
strQuery2="UPDATE master SET balance="+bal1+" WHERE accno="+accno+"";
int i = st.executeUpdate(strQuery2);
strQuery="INSERT INTO withdraw(accno,acctype,amt,withdrawdate)"+"VALUES('"+accno+"','"+acctype+"','"+amt+"','"+d+"')";

st.executeUpdate(strQuery);

				
				 					
						RequestDispatcher rd=request.getRequestDispatcher("/withdraw4.jsp");
						rd.forward(request, response);
}
else 
{
	response.sendRedirect("withdrawfailed.jsp");
}
					
			
			 	
			conn.close();

		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
	}

}
