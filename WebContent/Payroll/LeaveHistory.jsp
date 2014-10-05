<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Leave History</title>
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
<td align="center"><img src="images/leavehistory_payroll.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content">

<div id="cont2" style="overflow: scroll;">

<br />

<table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 
  
 </tr>
  <logic:notEmpty name="AttList">
 <tr bgcolor="#999999" height="30" align="center"  >
 <td width="158"><b> Sl No</b></td>
 <td width="158"><b> Name</b></td>
 <td width="158"><b>From Date</b></td>
 <td width="158"><b>To Date</b></td>
<!-- <td width="158"><strong>Leave Type</strong></td>-->
  <td width="160"><b>Status</b></td>
 <td width="158"><b>Reason for Rejection</b></td>

  <logic:iterate id="role" name="AttList" indexId="index">
 
 </tr>
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="role" property="username"/></td>
 <td><bean:write name="role" property="fDate"/></td>
 <td><bean:write name="role" property="tDate"/></td>

<!--  <td><bean:write name="role" property="leaveType"/></td>-->
<td><bean:write name="role" property="status"/></td>
<td><bean:write name="role" property="rejection"/></td>

  </logic:iterate>
 </logic:notEmpty> 

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