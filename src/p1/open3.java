package p1;

import p2.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class open3
 */
public class open3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public open3() {
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
		String fname="";
	   String lname="";
	   String user="";
	   String acctype="";
	   String occupation="";
	   String age="";
	   String strQuery= ""; 
	   String strQuery1= "";
	   String strQuery2= "";
	   	     		Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);
		

		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection("jdbc:odbc:test","","");
			
			if(request.getParameter("fname")!=null && request.getParameter("fname")!="" 
				&& request.getParameter("lname")!=null && request.getParameter("lname")!=""
					&& request.getParameter("occupation")!=null && request.getParameter("occupation")!=""
					&& request.getParameter("age")!=null && request.getParameter("age")!="")
			{
				fname = request.getParameter("fname").toString();
				user = request.getParameter("user").toString();
				lname = request.getParameter("lname").toString();
				acctype = request.getParameter("acctype").toString();
				occupation = request.getParameter("occupation").toString();
				age = request.getParameter("age").toString();
                strQuery="INSERT INTO open (fname,lname,acctype,occupation,age,opendate,user)"+"VALUES('"+fname+"','"+lname+"','"+acctype+"','"+occupation+"','"+age+"','"+d+"','"+user+"')"; 
				 st = conn.createStatement();
				st.executeUpdate(strQuery);
				System.out.println("all queries executed 1");
				
				
				strQuery2="UPDATE master SET acctype='"+acctype+"' where user='"+user+"'"; 
			st.executeUpdate(strQuery2);
			
			System.out.println("all queries executed 2");
			
						rs =st.executeQuery("select * from master where user='"+user+"'");
						System.out.println("all queries executed 3");
						String ano=null;
						while(rs.next())
						{ 
							ano=rs.getString(6);
												
						}
			
			System.out.println("all queries executed 4");
			session.setAttribute("sano", ano);
			
				System.out.println("all queries executed 5");
				
				RequestDispatcher rd=this.getServletConfig().getServletContext().getRequestDispatcher("/open4.jsp");
				rd.forward(request, response);
								  
			}
						
			conn.close();
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
	}

}
