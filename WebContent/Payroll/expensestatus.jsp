<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Leave Status</title>
<link href="css/Payroll_style.css" rel="stylesheet" type="text/css" />
</head>
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
<td align="center"><img src="images/expense_status.png" border="0" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content">

<div id="cont2">

<br />

<table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 
  
 </tr>
 <logic:notEmpty name="ExpenseApproval1" scope="request">

 <tr bgcolor="#999999" height="30" align="center" >
 <td width="137"><b> Employee Name</b></td>
 <td width="161"><b>Expense Date</b></td>
  <td width="161"><b>Applied Date</b></td>
 <td width="159"><b>Reason</b></td>
 <td width="160"><b>Amount</b></td>
 <td width="157"><b>Status</b></td>
 <td width="162"><b>Reason for Rejection</b></td>
 </tr>
 <tr align="center" height="25">
 <logic:iterate id="leave" name="ExpenseApproval1" indexId="index"  >
 <td><logic:notEmpty name="name" scope="request">
					<input type="text" name="firstName" id="firstName" value="<bean:write name="name" scope="request" />" readonly="readonly" style="background:#93d1a8; border:none; "/>
				</logic:notEmpty>	</td>
 <td><bean:write name="leave" property="fDate"/></td>
  <td><bean:write name="leave" property="tDate"/></td>
 <td><bean:write name="leave" property="reason"/></td>
 <td><bean:write name="leave" property="amount"/></td>
 <td><bean:write name="leave" property="status"/></td>
  <td><bean:write name="leave" property="rejection"/></td>

 </tr>
</logic:iterate>
								
</logic:notEmpty>
		<logic:present name="ExpenseApproval1">
								<logic:empty name="ExpenseApproval1">
							                		No expense Requests yet.
							                	</logic:empty>
							</logic:present>			
 
 

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