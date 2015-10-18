<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Z:\final\bankfinal\WebContent\WEB-INF\lib\default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr align="top">
<table width="100%" cellpadding="5">
        <td width="10%" height="34" bgcolor="#000000"><a href="home.html" title="Home" target="_top" class="link">Home</a></td>
        <td width="19%" bgcolor="#000000" class="link"><a href="personal.html" target="_top" class="link">Personal Banking</a></td>
        <td width="19%" bgcolor="#000000"><a href="corporate.html" class="link">Corporate Banking</a></td>
        <td width="15%" bgcolor="#000000"><a href="loan.html" class="link">Loans</a></td>
        
        <td width="18%" align="center" bgcolor="#000000"><a href="other.html" target="_top" class="link">Other Service</a></td>
        <td width="18%" align="center" bgcolor="#000000"><a href="logout1.jsp" target="_top" class="link">Logout</a></td>
</table>
</tr>
<tr align="center">  <img src="Z:\final\bankfinal\WebContent\WEB-INF\lib\img02.jpg" width="100%" height="286" alt="mainimage"></tr>
     

   <td width="75%" class="w"><p style="font-size: 36px">Welcome <%=session.getAttribute("sname")%></h2>
        </p></td>
</table>
 <hr>
      <p size="9">PNR© 2011.All rights reserved</p>
</table>
</body>
</html>