<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String a=null; %>
<%! String b=null; %>
<%! String c=null; %>
<%! String d=null; %>
<%! String e=null; %>
<%! String f=null; %>
<%! String g=null; %>
<%a=request.getParameter("fname"); %>
<%b=request.getParameter("lname"); %>
<%c=request.getParameter("user"); %>
<%d=request.getParameter("occupation"); %>
<%e=request.getParameter("nationality"); %>
<%e=request.getParameter("gender"); %>
<%f=request.getParameter("emailid"); %>
<%f=request.getParameter("pass"); %>
<%g=request.getParameter("cpass"); %>
<%
if((!(a.equals("")  || b.equals("") || c.equals("") || d.equals("") || e.equals("") || f.equals("") || g.equals(""))) && (f.equals(g)) ){ 
%>
 <%
 RequestDispatcher rd=request.getRequestDispatcher("/form3");
 rd.forward(request, response);
 %>
<%} else {%>
<%="Invalid...Please enter all details"%>
<%} %>
</body>
</html>