<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>





<portlet:actionURL var="signinAction" name="signinAction">
</portlet:actionURL>
<portlet:defineObjects /> 
<liferay-theme:defineObjects />



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<body onload="load()" id="body1">
<div class="maindiv">
<div class="ribbon" onmouseover="showDiv()" onmouseout="hideDiv()">	
		<img src="<%=request.getContextPath()%>/images/r1.gif"/>
	</div>
	<div class="pp">
		<p>Login</p>
	</div>

<form action="<%=signinAction.toString() %>" name="signinForm" method="post" onsubmit="return signin(this)">

<center>

<div class="div-upside-down1" id="div-style">	

<table  width="95%">
<tr>
	<td colspan="3"><p class="pp"></p>
	</td>
</tr>
<tr>
	<td id="td1">
		<input type="text"  id="email" name="email"  placeholder="Email" />
		<p id="one"></p>
	</td>
	
	<td id="td2">
		<input type="password"  id="password" name="password"  placeholder="Password" />
		<p id="one"></p>
	</td>
	
	<td id="td3">
		<input type= "submit" name= "submit" value="Login"/>
		<p id="one"></p>
	</td>
</tr>

<tr>
	
	<td></td>	
	
	
</tr>

</table>
</div>
</center>
</form>
</div>
</body>