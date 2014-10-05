<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salary Allocation</title>
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
<html:form action='payslip.do?action=savesalary&salary=<%=request.getParameter("ctc") %>' method="post">
<table>
<tr>
 <logic:notEmpty name="userinfo">
<td>Employee Name:</td>
<td>Employee Id:</td>
<td>Company Name:</td>
<td>CTC:<%=request.getParameter("ctc") %>
<input type="hidden" name="ctc"></input>
</td>
</tr>
<logic:iterate id="role" name="userinfo" indexId="index">
<tr>
<td><bean:write name="role" property="username"/><html:hidden property="username" name="role"></html:hidden></td>
<td><bean:write name="role" property="userId"/><html:hidden property="userId" name="role"></html:hidden></td>
<td><bean:write name="role" property="companyName"/><html:hidden property="companyName" name="role"></html:hidden></td>
</tr>
</logic:iterate>
</logic:notEmpty>
</table>
<table>
<tr>
<logic:iterate id="file1" name="componentList" indexId="index">
<th >&nbsp;&nbsp;<bean:write name="file1"  property="componentName"></bean:write></th></logic:iterate></tr>
<tr><td align="left"><logic:iterate id="file2" name="salarysave" indexId="index"></td>
<td ><bean:write name="file2"  property="basic"></bean:write><html:hidden property="basic" name="file2"></html:hidden></td>
<td><bean:write name="file2"  property="da"></bean:write><html:hidden property="da" name="file2"></html:hidden></td>
<td><bean:write name="file2"  property="pa"></bean:write><html:hidden property="pa" name="file2"></html:hidden></td>
<td><bean:write name="file2"  property="oa"></bean:write><html:hidden property="oa" name="file2"></html:hidden></td>
<td><bean:write name="file2"  property="lb"></bean:write><html:hidden property="lb" name="file2"></html:hidden></td>
<td><bean:write name="file2"  property="pt"></bean:write><html:hidden property="pt" name="file2"></html:hidden></td>
<td><bean:write name="file2"  property="salarypay"></bean:write><html:hidden property="salarypay" name="file2"></html:hidden></td></tr>
</logic:iterate>
<input type="submit" value="submit"/>
</table>
</html:form>
</div><!--cont1-->
</div><!--content-->
</div><!--main-->
</div>
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 itech Solutions. All rights reserved.</p>
</div>
</body>
</html>