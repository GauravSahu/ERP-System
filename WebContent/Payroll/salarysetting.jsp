<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salary Settings</title>
<link href="css/Payroll_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main">
<div id="header">
<div id="header1">

<a href="Logout.do"><img src="images/MasterData_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/MasterData_home.png" alt="Home" border="0"  /></a>
</div><!--header1-->

<table width="1000" align="center" cellpadding="0" cellspacing="0" class="para">

<tr>
<td width="255" height="70"></td>
<td width="402"></td>
<td width="341"></td>
</tr>
<tr>
<td align="left" style="padding-left:20px;"> Welcome to <%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %></td>
<td align="center"><img src="images/attendancereports_payroll.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>

<div id="content" style="overflow:scroll;">
<div id="content">

<div id="cont2" style="overflow:scroll;">

<br />

<table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr height="50">
<html:form action="payslip.do?action=jsalset">
 <td colspan="6">
  
 <br />
Employee: <html:select property="userId"
						styleClass="select1" >
						<html:option value="-1">--Select Employee--</html:option>
						<html:options collection="userList" property="userId"
							labelProperty="username"/>
		  </html:select>	
		  Enter your CTC:<input type="text" name="ctc" id="textfield" />
		  <input type="hidden" name="ctc"></input>
		  <input type="submit" value="submit"/> 
</html:form>
 <br /><br />
   </td>
</table>
</div><!--cont1-->
</div><!--content-->
</div><!--main-->
</div>
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 itech Solutions. All rights reserved.</p>
</div>
<!--footer-->
</body>
</html>