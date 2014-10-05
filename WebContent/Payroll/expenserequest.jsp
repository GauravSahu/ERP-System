<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Expense Request</title>
<link href="css/Payroll_style.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/DateTime/jquery.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath() %>/DateTime/jquery-calendar.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/DateTime/jquery-calendar.css" />

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/DateTime/styles.css" />

<script type="text/javascript">

		//<![CDATA[

			$(document).ready(function (){ 

				$("#calendar1, #calendar2").calendar();

				$("#calendar1_alert").click(function(){alert(popUpCal.parseDate($('#calendar1').val()))});

			});

		//]]>
			</script>
			<script type="text/javascript">
			function validate()
			{
				if(document.forms[0].fDate.value.trim()==""){
					alert("Please enter the from date");
					document.forms[0].fDate.focus();
					return false;
				}
				else if(document.forms[0].amount.value.trim()==""){
					alert("Please enter the amount");
					document.forms[0].amount.focus();
					return false;
				}
				else if(document.forms[0].reason.value.trim()==""){
					alert("Please enter the reason");
					document.forms[0].reason.focus();
					return false;
				}
				else
				{
				return true;
				}
			}
			function isNumberKey(evt)
			{
			   var charCode = (evt.which) ? evt.which : event.keyCode
			   if (charCode > 31 && ((charCode < 48) || (charCode > 57)))
			      return false;

			   return true;
			}
			</script>
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
<td align="left" style="padding-left:20px;"> Welcome <%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %></td>
<td align="center"><img src="images/expenses_req.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content">

<div id="cont2">

<br />

<table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">


<logic:notEmpty name="status">
					<font color="blue"><bean:write name="status"></bean:write></font>
				</logic:notEmpty>
 <tr height="50">
 <td colspan="6">
 
 <br />
 <html:form action="expenseModule.do?action=expreq" method="post" enctype="multipart/form-data">
  Expense Date:
  <input type="text" name="fDate" value="" id="calendar1" class="calendarFocus"/>

  <br /><br />
 Expense Type: 
 <html:select property="expenseid1"
						styleClass="select1" >
						<html:option value="-1">--Select Expense Type--</html:option>
						<html:options collection="expenseList" property="expenseid1"
							labelProperty="expensename"/>
					</html:select>
  &nbsp;&nbsp;
 Approval Name:
  <logic:notEmpty name="approver" scope="request">
					<input type="text" name="firstName" id="firstName" value="<bean:write name="approver" scope="request" />"  readonly="readonly"/>
				</logic:notEmpty>	
<br /><br />
Amount: <input type="text" name="amount" onkeypress="return isNumberKey(event)"/>
 <span style="vertical-align:center;">Reason:</span> 
 <textarea name="reason" rows="2" cols="20" style="resize:none;"></textarea> &nbsp;&nbsp;
 <br /><br />
 
 <tr>
<td>Upload Document 1</td>
<td><input type ="file" name ="doc1" value="choose file" /></td>
</tr>

<tr>
<td>Upload Document 2</td>
<td><input type = "file" name ="doc2" value="choosefile"/></td>
</tr>

<tr>
<td>Upload Document 3</td>
<td><input type="file" name = "doc3" value="choose file"/></td>
</tr>

<tr>
<td>Upload Document 4</td>
<td><input type = "file" name="doc4" value = "choose file"/></td>
</tr>

<tr>
<td>Upload Document 5</td>
<td><input type = "file" name="doc5" value="choose file" /></td>
</tr>

<tr>
<td>Upload Document 6</td>
<td><input type="file" name="doc6" value="choose file" /></td>
</tr>


 <br /><br />
   </td>
  
 </tr>
  <input type="submit"  value="Submit" style="background:#666; color:#fff;" onclick="return validate();"/>
 
  </html:form>
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