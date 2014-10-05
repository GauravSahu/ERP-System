<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
<link href="css/Payroll_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<html:form action="payslip.do?action=updatesalaries">
<div id="main">

<div id="header">
<div id="header1" >

<a href="Logout.do"><img src="images/MasterData_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/MasterData_home.png" alt="Home" border="0"  /></a>
</div><!--header1-->

<table width="100%" align="center" cellpadding="0" cellspacing="0" class="para">
<tr>
<td width="255" height="110"></td>
<td width="402"></td>
<td width="341"></td>
</tr>
<tr>
<td align="left" style="padding-left:20px;"> Welcome to <%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %>
</td>
<td align="center"><img src="images/update_salary.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>
</div><!--header-->
From Employee:
<html:select property="userId1">
<html:option value="-1">--Select Employee--</html:option>
<html:options collection="userList1" property="userId1" labelProperty="username"/>
</html:select>
<input type="submit" value="submit"></input>
</html:form>
<html:form action="payslip.do?action=updateSalary">
<logic:notEmpty name="componentwithvalues">
<table cellpadding="1" cellspacing="0" border="1" style=" width:650px;">

 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b> Sl No</b></td>
 <td>USER ID</td>
 <td width="286"><b>COMPONENT Name</b></td>
 <td width="286"><b>Component Type</b></td>
 <td width="227"><b>Component Value</b></td>
 </tr>
 <logic:iterate id="role" name="componentwithvalues" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="role" property="userId"/><html:hidden property="userId" name="role"/> </td>
 <td><bean:write name="role" property="componentName"/><html:hidden property="componentName" name="role"></html:hidden></td>
 <td><bean:write name="role" property="componenttype" /><html:hidden property="componenttype" name="role"></html:hidden>
 <td><html:text property="value" name="role"></html:text><html:hidden property="value" name="role"></html:hidden></td>
 <input type="hidden" name="componentid"  value="<bean:write name="role" property="componentid"/>" ></input>
 </td>
 </logic:iterate>
 </logic:notEmpty> 
</table>
<input type="submit" value="submit"></input>
</html:form>
</body>
</html>