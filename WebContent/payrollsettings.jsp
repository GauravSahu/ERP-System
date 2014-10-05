<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Payroll</title>
<link href="css/Payroll_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main"> 
<div id="header">
<div id="header1">
<a href="Logout.do"><img src="images/Payroll_logout.png" alt="logout" border="0" /></a>
<a href="admhome.jsp"><img src="images/Payroll_home.png" alt="Home" border="0"  /></a>
</div><!--header1-->
<div id="account"></div>
</div><!--header-->
<div id="content">
<div id="cont1">
<table cellpadding="0" cellspacing="0" width="350" align="right" style="margin:50px 100px 0px 0px;">
<tr>
<td><a href="payslip.do?action=jsalset"><img src="images/set_sal_det.png" /></a></td>
<td><a href="payslip.do?action=updateEmployeeSalary"><img src="images/salary_modifica.png" /></a></td>
</tr>
</table>
</div><!--cont1-->
</div><!--content-->
</div><!--main-->
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 itech Solutions. All rights reserved.</p>
</div>
<!--footer-->
</body>
</html>