<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>: Account module :</title>
<link href="css/sales_style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}
.style2 {
	color: #000;
	font-size: 12px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	line-height:20px;
}
-->
</style>
</head>
<body>
<div id="main">

<div id="header">
<div id="header1">

<a href="Logout.do"><img src="images/sales_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/sales_home.png" alt="Home" border="0"  /></a>
</div><!--header1-->

<div id="account">

</div>

</div><!--header-->



<div id="content">
<div id="login1">
  
  
  
  <table border="0" cellpadding="0" cellspacing="0" align="right" style="margin-right:50px;">
  <tr><td>
	  <table border="0" cellpadding="0" cellspacing="0" align="right">  
	  <tr>
		<td height="90" colspan="3" ></td>
		</tr>
		<tr>
		  <td width="150">&nbsp;</td>
		  <td><html:link action="addenquiry.do"><img src="images/sales_Enquiries.png" /></html:link></td>
		  <td><html:link action="salesmodule.do?action=quotation"><img src="images/Quotation.png" /></html:link></td>
		  
		</tr>
		
		
		 <tr>
		  <td></td>
		  <td><img src="images/purchase_order.png" /></td>
		  <td><img src="images/sales_order.png" /></td>
		
		</tr>
		
		
		
		<tr>
		  <td></td>
		  <td><html:link action="reports.do"><img src="images/sales_reports.png" /></html:link></td>
		  <td><img src="images/sales_settings.png" /></td>		  
		</tr>
		
		<tr>
		<td><html:link action="salesmodule.do?action=Followup"><img src="images/fp.png" /></html:link></td>
		<td> <html:link action="salesmodule.do?action=appointment"><img src="images/app.png" /></html:link></td>
		<td></td>
		</tr>
	  </table>
	  </td>
</tr>
</table>


</div><!--login1-->
</div><!--content-->

</div><!--main-->
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 Itech Solutions. All rights reserved.</p>
</div><!--footer-->

</body>
</html>