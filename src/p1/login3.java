package p1;

import p2.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 * Servlet implementation class login3
 */
public class login3 extends HttpServlet {

int count;
	md5 pack=new md5();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login3() {
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
		
		
		Connection conn = null;
		System.out.println("Reached here 1");
	   String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	   String user="";
	   String userpass="";
	   String strQuery= ""; 
	         
		Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);
		

		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection("jdbc:odbc:test","","");
			
			if(request.getParameter("user")!=null && request.getParameter("user")!="" && request.getParameter("userpass")!=null && request.getParameter("userpass")!="")
			{
				user = request.getParameter("user").toString();
				userpass = request.getParameter("userpass").toString();
                strQuery="select * from register ";
				
				st = conn.createStatement();
				 System.out.println("Reached here 2");
				 
				rs=st.executeQuery(strQuery);
				
				System.out.println("Reached here 3");
				String cpass=null;
				String name=null;
				while(rs.next())
				{   if(rs.getString(3).equals(user))
				{
					name=rs.getString(1);
					 cpass=rs.getString("pass"); break;}
				}
				session.setAttribute("sname", name);
				
			System.out.println("Reached Here 4");
			
			StringBuffer q=pack.calc(userpass);
			String q1=q.toString();
			System.out.println("Reached Here 5");
			if(cpass.equals(q1))
			{
			
				RequestDispatcher rd=this.getServletConfig().getServletContext().getRequestDispatcher("/home.jsp");
				rd.forward(request, response);
	
			}
			else
			{
				RequestDispatcher rd=this.getServletConfig().getServletContext().getRequestDispatcher("/login5.jsp");
				rd.forward(request, response);
			}
			
		}
				
    conn.close();
			
		} catch (Exception e) 
		{
		e.printStackTrace();
		}
	}
}

