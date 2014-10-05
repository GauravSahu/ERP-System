<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Expense Approval</title>
<link href="css/Payroll_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

function update(id)
{

	document.forms[0].action="expenseModule.do?action=changestatus&expenseid="+id;
	document.forms[0].submit();	 
}

function popuponclick(id)
{
	//alert(id);
   my_window = window.open("Payroll/expensedetails.jsp?id="+id, "myWindow", 
		"status = 1, height = 150, width = 400, resizable = 1,menubar=1" );
  
}

</script>
</head>

<body>
<html:form action="expenseModule.do?action=changestatus">
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
<td align="center"><img src="images/expense_app.png" border="0" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content">

<div id="cont2">

<br />

<table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 
  
 </tr>
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="45"><b> Sl. No.</b></td>
 <td width="144"><b>Employee Name</b></td>
 <td width="144"><b>Applied Date</b></td>
  <td width="156"><b>Expense Date</b></td>
    <td width="144"><b>Reason</b></td>
  <td width="144"><b>amount</b></td>
   <td width="150"><b>View Documents</b></td>
 <td width="157"><b>Action Item</b></td>

 
 
 </tr>
 <logic:notEmpty name="ExpenseApproval" scope="request">
<logic:iterate id="leave" name="ExpenseApproval" indexId="index"  >
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <input type="hidden" name="expenseid" id="textfield" />
 <td><bean:write name="leave" property="username"/></td>
 <td><bean:write name="leave" property="applieddate"/></td>
 <td><bean:write name="leave" property="fDate"/></td>
 <td><bean:write name="leave" property="reason"/></td>

  <td><bean:write name="leave" property="amount"/></td>
  <td>
 <a href='expenseModule.do?action=download1&amp;docname1=<bean:write name="leave" property="docname1"/>'><bean:write name="leave" property="docname1" /></a>
 <a href='expenseModule.do?action=download2&amp;docname2=<bean:write name="leave" property="docname2"/>'><bean:write name="leave" property="docname2" /></a>
 <a href='expenseModule.do?action=download3&amp;docname3=<bean:write name="leave" property="docname3"/>'><bean:write name="leave" property="docname3" /></a>
 <a href='expenseModule.do?action=download4&amp;docname4=<bean:write name="leave" property="docname4"/>'><bean:write name="leave" property="docname4" /></a>
 <a href='expenseModule.do?action=download5&amp;docname5=<bean:write name="leave" property="docname5"/>'><bean:write name="leave" property="docname5" /></a>
 <a href='expenseModule.do?action=download6&amp;docname6=<bean:write name="leave" property="docname6"/>'><bean:write name="leave" property="docname6" /></a>

 </td>
 
 <td><input type="submit"  onclick="update('<bean:write name="leave" property="expenseid"/>')"  value="Approval" style="background:#666; color:#fff;"/>&nbsp;
 <input type="button" onclick="popuponclick('<bean:write name="leave" property="expenseid"/>')"  value="Reject" style="background:#666; color:#fff;"/></td>
 
</logic:iterate>
								
</logic:notEmpty>
		<logic:present name="ExpenseApproval">
								<logic:empty name="ExpenseApproval">
							                		No Expense Requests yet.
							                	</logic:empty>
							</logic:present>					
 </tr>

 
 

 </table>
</div><!--cont1-->
</div><!--content-->
</div><!--main-->

<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 itech Solutions. All rights reserved.</p>
</div>
</html:form>
<!--footer-->
</body>
</html>