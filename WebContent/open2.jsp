<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% try { %>
<%! String a=null; %>
<%! String f=null; %>
<%! String b=null; %>
<%! String c=null; %>
<%! String d=null; %>
<%! int e; %>
<%a=request.getParameter("fname"); %>
<%f=request.getParameter("user"); %>
<%b=request.getParameter("lname"); %>
<%c=request.getParameter("acctype"); %>
<%d=request.getParameter("occupation"); %>
<%e=Integer.parseInt(request.getParameter("age")); %>
<%if (a.equals("")  || b.equals("") || c.equals("") || d.equals("")  || e==0){ %>
<%="Please Enter All Details" %>
<% } else{ %>
<%
 RequestDispatcher rd=request.getRequestDispatcher("/open3");
 rd.forward(request, response);
%>
<%} %>
<%} catch(Exception g) { %>
<%="Please Enter All Details"%>
<%} %>
</body>
</html>