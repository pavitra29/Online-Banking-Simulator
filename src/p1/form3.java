package p1;

import p2.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.*;

/**
 * Servlet implementation class form3
 */
public class form3 extends HttpServlet {
	md5 a=new md5();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public form3() {
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
				Connection conn = null;
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	   String fname="";
	   String lname="";
	   String user="";
	   String occupation="";
	   String nationality="";
	   String gender="";
	   String emailid="";
	   String pass="";
	    String strQuery= ""; 
	    String strQuery1= ""; 
	    Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);
		

		try {
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection("jdbc:odbc:test","","");
			
				fname = request.getParameter("fname").toString();
				lname = request.getParameter("lname").toString();
				user = request.getParameter("user").toString();
				occupation = request.getParameter("occupation").toString();
				nationality = request.getParameter("nationality").toString();
				gender = request.getParameter("gender").toString();
				emailid = request.getParameter("emailid").toString();
				pass = request.getParameter("pass").toString();
				 StringBuffer encrypt=a.calc(pass);	
				String passc=encrypt.toString();
				
				strQuery="INSERT INTO register (fname,lname,user,occupation,nationality,gender,emailid,pass)"+"VALUES('"+fname+"','"+lname+"','"+user+"','"+occupation+"','"+nationality+"','"+gender+"','"+emailid+"','"+passc+"')";
				st = conn.createStatement();
				st.executeUpdate(strQuery);
				System.out.println("all queries executed1");
				
				strQuery1="INSERT INTO master (fname,lname,user,pass)"+"VALUES('"+fname+"','"+lname+"','"+user+"','"+passc+"')";
				st = conn.createStatement();
				st.executeUpdate(strQuery1);
				System.out.println("all queries executed2");
				
				String name=null;
				
				 strQuery="select * from master ";
					
					st = conn.createStatement();
					 System.out.println("Reached here 2");
					 
					rs=st.executeQuery(strQuery);
				
				while(rs.next())
				{   
				name=rs.getString(1);
					 
				}
				session.setAttribute("sname", name);
				
				
				RequestDispatcher rd=this.getServletConfig().getServletContext().getRequestDispatcher("/form4.jsp");
				rd.forward(request, response);
	
				
				conn.close();
		} catch (Exception e) {
					e.printStackTrace();
		}
		
		
	}

}
