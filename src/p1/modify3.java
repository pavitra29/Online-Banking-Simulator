package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;


/**
 * Servlet implementation class modify3
 */
public class modify3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modify3() {
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
		int accno;
		String acctype="";
	   String acctype1="";
	   String strQuery= ""; 
          		Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);


		try {
			Class.forName(driver);

			conn = DriverManager.getConnection("jdbc:odbc:test","","");
			
			
				accno=Integer.parseInt(request.getParameter("accno"));
				acctype = request.getParameter("acctype").toString();
				acctype1 = request.getParameter("acctype1").toString();
                strQuery="INSERT INTO modify (accno,acctype,acctype1)"+"VALUES('"+accno+"','"+acctype+"','"+acctype1+"')";

				st = conn.createStatement();
				st.executeUpdate(strQuery);
				
					RequestDispatcher rd=request.getRequestDispatcher("/modify4.jsp");
					rd.forward(request, response);
							
			
			conn.close();
		}
		 catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	}
