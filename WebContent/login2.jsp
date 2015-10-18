<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String x=null; %>
<%! String y=null; %>
<%x=request.getParameter("user"); %>
<%y=request.getParameter("userpass"); %>
<%if (x.equals("")  || y.equals("")){ %>
<%="invalid login"%>

<% } else { %>
<%="Entered Else"%> 
 <%
 RequestDispatcher rd=request.getRequestDispatcher("login3");
 rd.forward(request, response);
 %>
 
<%} %>
</body>
</html>