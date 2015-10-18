<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%try { %>
<%! String a=null; %>
<%! int b; %>
<%! int c; %>
<%! String d=null; %>
<%a=request.getParameter("accname"); %>
<%b=Integer.parseInt(request.getParameter("accno")); %>
<%c=Integer.parseInt(request.getParameter("amt")); %>
<%d=request.getParameter("dname"); %>
<%if (!(a.equals("")  || b==0 || c==0  || d.equals(""))){ %>
<%
RequestDispatcher rd=request.getRequestDispatcher("/deposit3");
rd.forward(request, response);
%>
<% } else {%>
<%="Please Enter All Details" %>
<%} %>
<%} catch(Exception e) {%>
<%="Please Enter All Details" %>
<%} %>
</body>
</html>