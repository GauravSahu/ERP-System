<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>: Master Data :</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="main">
<div id="header">
<div id="header1">
<a href="Logout.do"><img src="images/MasterData_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/MasterData_home.png" alt="Home" border="0"  /></a>
</div><!--header1-->
      
<div id="master"></div>

</div><!--header-->
<div id="content_master" style="overflow:scroll;">
<div id="login1">
  <table border="0" cellpadding="0" cellspacing="0" align="right" style="margin-right:50px;"><tr><td><table border="0" cellpadding="0" cellspacing="0" align="right">
  
  <tr>
  <td colspan="3" height="50"></td>
  </tr>
    <tr>
      <td width="150">&nbsp;</td>
      <td><a href="Country.do"><img src="images/country_master.png" /></a></td>
      <td><a href="State.do"><img src="images/state_master.png" /></a></td>
      <td><a href="City.do"><img src="images/city_master.png" /></a></td>
    </tr>
    
    
    
     <tr>
      <td></td>
      <td><a href="Role.do"><img src="images/role_master.png" /></a></td>
      <td><a href="Company.do"><img src="images/company_master.png" /></a></td>
      <td><a href="accounttype.do">Account Type Master</a></td> 
     <!--<td><a href="Salary.do"><img src="images/salary_master.png" /></a></td> -->
     </tr>
    
     <tr>
      <td></td>
      <td><a href="Desi.do"><img src="images/Designation_master.png" /></a></td>
      <td><a href="Bank.do"><img src="images/Bank_master.png" /></a></td>
     <td><a href="Qualification.do"><img src="images/Qualification_master.png" /></a></td>
    </tr>
    <tr>
      <td></td>
   
      <td><a href="Itemcategory.do">Item Category Master</a></td>
  
      <td><a href="Leavetype.do"><img src="images/Leavetype_master.png" /></a></td>
      <td><a href="Customer.do"><img src="images/customer_master.png" /></a></td>
      <td></td>
     <td></td>
    </tr>
    
    
    <tr>
      <td></td>
      <td><a href="User.do"><img src="images/user_master.png" /></a></td>
      <td><a href="Vendor.do"><img src="images/vendor_master.png" /></a></td>
      <td><a href="Employee.do"><img src="images/employee_master.png" /></a></td>
    </tr>
    
    <tr>
      <td></td>
      <td><a href="Template.do"><img src="images/template_masterdata.png" /></a></td>
      <td><a href="Status.do"><img src="images/AttendanceStatus_masterdata.png" /></a></td>
      <td><a href="Calender.do"><img src="images/CalenderDayType_masterdata.png" /></a></td>
    </tr>
    <tr>
      <td></td>
      <td><a href="expense.do"><img src="images/expensetype_master.png" /></a></td>
      <td><a href="CalenderType.do"><img src="images/calendar_master.png" /></a></td>
      <td><a href="Component.do"><img src="images/component_master.png" /></a></td>
    </tr>
    
    <tr>
    <td>
    <a href=""> </a>
    </td>
    <td>
    
    <a href="uploaddoc.jsp">Upload Documents</a>
    <a href="DownloadDocc.do?action=filedownload">download documents</a>
    <a href="Warehouse.do">WareHouse Master</a>
     <a href=Itemmaster.do>item Master</a> <br></br>
       <a href=Pricemaster.do>Price Master</a><br></br>
    </td>
    </tr>
    <td><a href="LibraryMadule.jsp">LIBRARY MADULE</a> </td>
    <tr>
    <td>
   
    </td>
    </tr>
  </table></td>
</tr>
</table>


</div><!--login1-->
</div><!--content-->

</div><!--main-->

<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 Itech Solutions. All rights Reserved.</p>
</div><!--footer-->
</body>
</html>