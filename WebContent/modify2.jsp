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
<%! int b; %>
<%! String d=null; %>
<%a=request.getParameter("acctype"); %>
<%b=Integer.parseInt(request.getParameter("accno")); %>
<%d=request.getParameter("acctype1"); %>
<%if (!(a.equals("")  || b==0  || d.equals(""))){ %>
<%
RequestDispatcher rd=request.getRequestDispatcher("/modify3");
rd.forward(request, response);
%>
<% } %>
</body>
</html>