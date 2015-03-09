<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<!-- Set parameters to display abc.jsp -->
<portlet:renderURL var="signinURL">

    <portlet:param name="signin" value="/abc.jsp" />

</portlet:renderURL>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>


</head>
<body  onload="regload()" id="body2">

<form name="regForm" method="post"  onsubmit="return reg(this)">
<div id="reg1" class="regclass">
<center>
<table width="65%" cellspacing="1" >

<tr>
	<td colspan="2"><p id="p1"></p></td>
</tr>

<tr>
	<td colspan="2" id="rf"><b>Registration-Form</b></td>
</tr>

<tr>
	<td colspan="2"><p id="p1"></p></td>
</tr>

<tr id="tr1">
<!--  	<td> 
		<label for="fName" id="l11">First Name</label>
	</td>
-->
	<td>
		<input type="text" name="fName" id="fName" size="17" placeholder="First Name"  />
		<p id="fname" /></p>
	</td>
	
<!-- <td> 
		<label for="lName" id="l12">Last Name</label>
	</td>
-->
	
	<td>
		<input type="text" name="lName" id="lName" size="17" placeholder="Last Name"  />
		<p id="lname" /></p>
	</td>
	
</tr>

<tr id="tr2">
<!--  	<td> 
		<label for="email" id="l1">Email:</label>
	</td>
-->
	<td colspan="2">
		<input type="text" name="email" id="email" size="41"  placeholder="Email"  />
		<p id="email1" /></p>
	</td>
</tr>

<tr id="tr3">
<!--  	<td>
		<label for="password" id="l2">Password:</label>
	</td>
-->	
	<td colspan="2">
		<input type="password" name="password" id="password" size="41" placeholder="Password"/>
		<p id="pass"></p>
	</td>
</tr>

<tr id="tr4">
<!--  	<td>
		<label for="repassword">Re-Password:</label>
	</td>
-->
	<td colspan="2">
		<input type="password" name="repassword" id="repassword" size="41" placeholder="Repassword" />
		<p id="repass"></p>
	</td>
</tr>

<tr>
<!--  	<td>
		<label for="gender">Gender:</label>
	</td>

	<td>
		<select name="gender" class="gender1" id="gender" onchange="check()">
			<option value="" disabled="disabled" selected="selected" id="s1" >Gender</option>
			<option>Male</option>
			<option>Female</option>
		</select>
		<p id="gender1"></p>
	</td>
--> 
</tr>
</table>
</center>

<center>
<table width="65%">
<tr id="tr5">
	<td colspan="4"><label for="dob"><font size="3"><b>Birthday:</b></font></label></td> 
</tr>
<tr id="tr6">
<!--  	<td><label for="dob" >Date Of Birth:</label></td> -->
	<td colspan="2">	
		<select name="dob" id="dob"  onchange="checkD()">
			<option value="" disabled="disabled" selected="selected" id="s2" >Day</option>          
			<option>01</option>
			<option>02</option>
			<option>03</option>
			<option>04</option>
			<option>05</option>
			<option>06</option>
			<option>07</option>
			<option>08</option>
			<option>09</option>
			<option>10</option>
			<option>11</option>
			<option>12</option>
			<option>13</option>
			<option>14</option>
			<option>15</option>
			<option>16</option>
			<option>17</option>
			<option>18</option>
			<option>19</option>
			<option>20</option>
			<option>21</option>
			<option>22</option>
			<option>23</option>
			<option>24</option>
			<option>25</option>
			<option>26</option>
			<option>27</option>
			<option>28</option>
			<option>29</option>
			<option>30</option>
			<option>31</option>
		</select>
	</td>
	<td colspan="2">
		<select name="month" id="month"  onchange="checkM()" >
			<option value="" disabled="disabled" selected="selected" id="s3">Month</option>
			<option value="1">Jan</option>
			<option value="2">Feb</option>
			<option value="3">Mar</option>
			<option value="4">Apr</option>
			<option value="5">May</option>
			<option value="6">Jun</option>
			<option value="7">Jul</option>
			<option value="8">Aug</option>
			<option value="9">Sep</option>
			<option value="10">Oct</option>
			<option value="11">Nov</option>
			<option value="12">Dec</option>
		</select>
	</td>
	<td>
		<select name="year" id="year"  onchange="checkY()">
			<option value="" disabled="disabled" selected="selected" id="s4">Year</option>
			<option value="2013">2013</option>
			<option value="2012">2012</option>
			<option value="2011">2011</option>
			<option value="2010">2010</option>
			<option value="2009">2009</option>
			<option value="2008">2008</option>
			<option value="2007">2007</option>
			<option value="2006">2006</option>
			<option value="2005">2005</option>
			<option value="2004">2004</option>
			<option value="2003">2003</option>
			<option value="2002">2002</option>
			<option value="2001">2001</option>
			<option value="2000">2000</option>
			<option value="1999">1999</option>
			<option value="1998">1998</option>
			<option value="1997">1997</option>
			<option value="1996">1996</option>
			<option value="1995">1995</option>
			<option value="1994">1994</option>
			<option value="1993">1993</option>
			<option value="1992">1992</option>
			<option value="1991">1991</option>
			<option value="1990">1990</option>
			<option value="1989">1989</option>
			<option value="1988">1988</option>
			<option value="1987">1987</option>
			<option value="1986">1986</option>
			<option value="1985">1985</option>
			<option value="1984">1984</option>
			<option value="1983">1983</option>
			<option value="1982">1982</option>
			<option value="1981">1981</option>
			<option value="1980">1980</option>
			<option value="1979">1979</option>
			<option value="1978">1978</option>
			<option value="1977">1977</option>
			<option value="1976">1976</option>
			<option value="1975">1975</option>
			<option value="1974">1974</option>
			<option value="1973">1973</option>
			<option value="1972">1972</option>
			<option value="1971">1971</option>
			<option value="1970">1970</option>
			<option value="1969">1969</option>
			<option value="1968">1968</option>
			<option value="1967">1967</option>
			<option value="1966">1966</option>
			<option value="1965">1965</option>
			<option value="1964">1964</option>
			<option value="1963">1963</option>
			<option value="1962">1962</option>
			<option value="1961">1961</option>
			<option value="1960">1960</option>
			<option value="1959">1959</option>
			<option value="1958">1958</option>
			<option value="1957">1957</option>
			<option value="1956">1956</option>
			<option value="1955">1955</option>
			<option value="1954">1954</option>
			<option value="1953">1953</option>
			<option value="1952">1952</option>
			<option value="1951">1951</option>
			<option value="1950">1950</option>
			<option value="1949">1949</option>
			<option value="1948">1948</option>
			<option value="1947">1947</option>
			<option value="1946">1946</option>
			<option value="1945">1945</option>
			<option value="1944">1944</option>
			<option value="1943">1943</option>
			<option value="1942">1942</option>
			<option value="1941">1941</option>
			<option value="1940">1940</option>
			<option value="1939">1939</option>
			<option value="1938">1938</option>
			<option value="1937">1937</option>
			<option value="1936">1936</option>
			<option value="1935">1935</option>
			<option value="1934">1934</option>
			<option value="1933">1933</option>
			<option value="1932">1932</option>
			<option value="1931">1931</option>
			<option value="1930">1930</option>
			<option value="1929">1929</option>
			<option value="1928">1928</option>
			<option value="1927">1927</option>
			<option value="1926">1926</option>
			<option value="1925">1925</option>
			<option value="1924">1924</option>
			<option value="1923">1923</option>
			<option value="1922">1922</option>
			<option value="1921">1921</option>
			<option value="1920">1920</option>
			<option value="1919">1919</option>
			<option value="1918">1918</option>
			<option value="1917">1917</option>
			<option value="1916">1916</option>
			<option value="1915">1915</option>
			<option value="1914">1914</option>
			<option value="1913">1913</option>
			<option value="1912">1912</option>
			<option value="1911">1911</option>
			<option value="1910">1910</option>
			<option value="1909">1909</option>
			<option value="1908">1908</option>
			<option value="1907">1907</option>
			<option value="1906">1906</option>
			<option value="1905">1905</option>
		</select>
		
	</td>
	
	
</tr>

<tr>

	<td colspan="2"><p class=p1></p></td>
	<td colspan="2"><p class=p1></p></td>
	<td><p class=p1></p></td>
	
</tr>

<tr id="tr7">
	<td align="center">
		<div id="d1" style="width:12px; height:13px; background:#f9f9f9;">
			<input type="radio" name="gender" id="gender0" value="Male"   />
		</div>
	</td>
	<td>	
		<label for="gender">Male</label>
		
	</td>
	<td align="center">
		<div id="d2" style="width:12px; height:13px; background:#f9f9f9;" >	
			<input type="radio" name="gender" id="gender1" value="Female"  />
		</div>
	</td>
	<td>		
		<label for="gender1" id="f1">Female</label>
		
	</td>
</tr>


<tr><td colspan="2" ><p class=p2></p></td></tr>
<tr id="tr8">
	<td colspan="2"> 
		<input type="submit" name="submit" value="Register">
	</td>
	<td></td>
	<td></td>
	<td align="left"><a href="<%= signinURL %>">Already a member?</a></td>
</tr>
</table>

</center>
</div>
</form>
</body>
</html>