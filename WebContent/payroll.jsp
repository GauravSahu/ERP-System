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
<td><a href="Attendance.jsp"><img src="images/Payroll_attendance.png" /></a></td>
<td><a href="Payroll/LeaveModule.jsp"><img src="images/Payroll_leave.png" /></a></td>
</tr>
<tr>
<td colspan="2" height="15px;"></td>
</tr>
<tr>
<td><a href="Payroll/payrep.jsp"><img src="images/Payroll_reports.png" /></a></td>
<td><a href="payrollsettings.jsp"><img src="images/Payroll_settings.png" /></a></td>
</tr>
<tr>
<td colspan="2" height="15px;"></td>
</tr>
<tr>
<td><a href="payslip.do?action=setsalary"><img src="images/runpayroll.png" /></a></td>
<td><a href="Payroll/expenseModule.jsp"><img src="images/expense_module.png" /></a></td>
<td></td>
</tr>
<tr>
<td colspan="2" height="15px;"></td>
</tr>
<tr>
<td><a href="Payroll/timesheetModule.jsp"><img src="images/timesheet_module.png" /></a></td>
<td><a href="Payroll/fileupload.jsp"></a> </td>
<td><a href="LibraryMadule.jsp">LIBRARY MADULE</a> </td>
<td></td>
<td></td>
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