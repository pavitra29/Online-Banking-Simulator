package p1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*
;/**
 * Servlet implementation class view3
 */
public class view3 extends HttpServlet {
	int count=0,count1=0,val=0,i=0;
	 String accno;
	  Connection con = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	   ResultSet rs1=null;
	   ResultSet rs2=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.print("<html><head>");
	    out.print("</head><body bgcolor=#D3D3D3 text=#8A2BE2>");

	    out.print("<code><pre>");
	        
	   out.print("<table border=1 width=100%><tr><td align=center><b>First Name</b></td><td align=center><b>Last Name</b></td><td align=center><b>Account Type</b></td><td align=center><b>Balance</b></td></tr>");
	 
	   System.out.println("in view3 page");

	    long time1 = System.currentTimeMillis();

	    // connecting to database

	  	    accno = request.getParameter("accno");
 

	    try {
	      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	      con = DriverManager.getConnection("jdbc:odbc:test","","");

	    //  stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE);
	      stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY );
	      rs = stmt.executeQuery("SELECT * FROM master");
	      System.out.println("step1");
	    
	     
	      // displaying records
//Display account Information
	      while(rs.next()) 
	      {
	    	    if(rs.getString(6).equals(accno))
	    	    {
	    	    	out.print("<tr><td align=center>");
	    	        out.print(rs.getString(1));
	    	      
	    	        out.print("</td><td align=center>");
	    	        out.print(rs.getString(2).toString());
	    	        
	    	        out.print("</td><td align=center>");
	    	        out.print(rs.getString(5).toString());
	    	       
	    	        out.print("</td><td align=center>");
	    	        out.print(rs.getString(7).toString());
	    	       
	    	        out.print("</td></tr></table>");
	    	        break;
	    	    }
	   
	      }
	      out.println("");
	      out.println("");
	      rs.close();
	      stmt.close();
	      stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	      rs1 = stmt.executeQuery("SELECT * FROM deposit");
	      System.out.println("step2");
	    Vector v=new Vector();
	    count=0;
	       while(rs1.next())
	    	      {
	    	    if(rs1.getString(1).equals(accno))
	    	    	{
	    	    	v.addElement(rs1.getString(5));
	    	    	v.addElement(rs1.getString(6));
	    	    	count++;
	    	    	}
	    	    }
	       
	       if(count>5)
	       {
	     	  val=5;
	       }
	       else
	    	   val=count;
	       System.out.println("Count"+count+"val"+val+ "size="+v.size());
	      	              
	       out.print("<table align=center border=1><tr><td align=center colspan=2><b>DEPOSIT</b></td></tr>");
	       out.print("<tr><td align=center><b>Amount</b></td><td align=center><b>Date</b></td></tr>");
	         for(int i=v.size()-1;val>0;i-=2,val--)
	       {
	          out.print("<tr><td align=center>");
	    	out.print(v.elementAt(i-1));
	    	  
	    	 out.print("</td>");
	    	 out.print("<td align=center>");
	    	out.print(v.elementAt(i));
	    	 
	    	 out.print("</td></tr>");
	   
	    	   }
	          
	         
	       out.print("</table>");
	       out.println("");
		      out.println("");
	       System.out.println("step4");
	  rs1.close();
	      // con.close();
	    }//end try 
	      
	    catch (SQLException e) {
	      throw new 
	      ServletException("Servlet Could not display records.", e);
	    } catch (ClassNotFoundException e) {
	      throw new 
	      ServletException("JDBC Driver not found.", e);
	    }
	 
	 
	  try{
	      stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	      rs2 = stmt.executeQuery("SELECT * FROM withdraw");
	      System.out.println("step2");
	    Vector v=new Vector();
	    count=0;
	       while(rs2.next())
	    	      {
	    	    if(rs2.getString(1).equals(accno))
	    	    	{
	    	    	v.addElement(rs2.getString(3));
	    	    	v.addElement(rs2.getString(4));
	    	    	count++;
	    	    	}
	    	    }
	       
	       if(count>5)
	       {
	     	  val=5;
	       }
	       else
	    	   val=count;
	       System.out.println("Count"+count+"val"+val+ "size="+v.size());
	      
	              
	       out.print("<table align=center border=1><tr><td align=center colspan=2><b>WITHDRAW</b></td></tr>");
	       out.print("<tr><td align=center><b>Amount</b></td><td align=center><b>Date</b></td></tr>");
	         for(int i=v.size()-1;val>0;i-=2,val--)
	       {
	          out.print("<tr><td align=center>");
	    	out.print(v.elementAt(i-1));
	    	  
	    	 out.print("</td>");
	    	 out.print("<td align=center>");
	    	out.print(v.elementAt(i));
	    	 
	    	 out.print("</td></tr>");
	   
	    	   }
	          
	         
	       out.print("</table>");
	       System.out.println("step4");
	  rs2.close();
	      
	    }//end try 
	      
	    catch (SQLException e) {
	      throw new   ServletException("Servlet Could not display records.", e);
	    } 
	    catch (Exception e) {
	      throw new  ServletException("JDBC Driver not found.", e);
	    }
	 
	  
	    // debugging info

	    long time2 = System.currentTimeMillis();

	    out.print("</pre></code>");

	    out.print("<p>Search took : ");
	    out.print( (time2 - time1) );
	    out.print(" ms.</p>");

	   
	    out.print("</body></html>");
	   // out.close();
		
	}	
	}
	
