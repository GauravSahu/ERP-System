<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>: Account module :</title>
<link href="css/account_style.css" rel="stylesheet" type="text/css" />
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

<a href="Logout.do"><img src="images/account_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/account_home.png" alt="Home" border="0"  /></a>
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
		  <td><img src="images/account_receivable.png" /></td>
		  <td><img src="images/account_payable.png" /></td>
		  
		</tr>
		
		
		 <tr>
		  <td></td>
		  <td><a href =""><img src="images/cashbook.png" /></a></td>
		  <td><img src="images/general_ledger.png" /></td>
		</tr>
		
		
		
		<tr>
		  <td></td>
		  <td><a href=""><img src="images/account_Reports.png" /></a></td>
		  <td><img src="images/account_setting.png" /></td>		  
		</tr>
       
       <tr>
       <td>
       </td>
       <td><a href="payment.do">Payment Generation</a> </td>
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
<p align="left" class="style2">Copyright © 2013 itech Solutions. All rights reserved.</p>
</div><!--footer-->
</body>
</html>