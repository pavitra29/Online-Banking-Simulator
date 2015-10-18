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
<%! int a; %>
<%! int b; %>
<%! int c; %>
<%a=Integer.parseInt(request.getParameter("taccno")); %>
<%b=Integer.parseInt(request.getParameter("daccno")); %>
<%c=Integer.parseInt(request.getParameter("amt")); %>
<% } catch(Exception e) { %>
<%="Please Enter Full " %>
<%} %>
<%! String d=null; %>
<%d=request.getParameter("dname"); %>
<%if (a==0 || b==0 || c==0 || d.equals("") ){ %>
<%="Details" %>
<%} else{ %>
<%
RequestDispatcher rd=request.getRequestDispatcher("/transfer3");
rd.forward(request, response);
%>
<%} %>
</body>
</html>