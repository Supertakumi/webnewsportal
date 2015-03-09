<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<!-- Set parameters to display abc.jsp -->
<portlet:renderURL var="signinURLMain">

    <portlet:param name="signinmain" value="/abc.jsp" />

</portlet:renderURL>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>singin</title>
</head>
<body>

<!--<div id="d1" class="mm" style="width:100px; height:100px; border:1px solid red"></div>

<input type="button" name="b" value="Register" onclick="f()" /> -->

<!--<center>-->

<table width="15%" cellspacing="10"  align="right" >


	
	<tr>
		<th align="right" id="t1">
			<a href="<%= signinURLMain %>" id="a1">
			Sign In</a>
		</th>
	</tr>
</table>
<!--</center>-->
</body>
</html>