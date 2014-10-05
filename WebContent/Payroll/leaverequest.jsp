<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Leave Request</title>
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
	
	
	
	<script language="JavaScript" type="text/javascript">
<!--

function days_between(date1, date2) {

    // The number of milliseconds in one day
    var ONE_DAY = 1000 * 60 * 60 * 24

    // Convert both dates to milliseconds
    var date1_ms = date1.getTime()
    var date2_ms = date2.getTime()

    // Calculate the difference in milliseconds
    var difference_ms = Math.abs(date1_ms - date2_ms)
    
    // Convert back to days and return
    return Math.round(difference_ms/ONE_DAY)

}

//-->
</script>

<script type="text/javascript">

function getNoofDays()
{
	
	var d = new Date();
	var fdat = document.getElementById('calendar1').value;
	var tdat = document.getElementById('calendar2').value;
//alert(fdat);
//alert(tdat);
var splitfdat =  fdat.split(" ");
var splittdat =  tdat.split(" ");

//alert(splitfdat[0]);
var fmyDateParts = splitfdat[0].split("/");
	var tmyDateParts = splittdat[0].split("/");

	fmyNewDate = new Date(fmyDateParts[2], fmyDateParts[1]-1, fmyDateParts[0]).getTime();
	tmyNewDate = new Date(tmyDateParts[2], tmyDateParts[1]-1, tmyDateParts[0]).getTime();
	//alert(fmyNewDate);
	//alert(tmyNewDate);
	
	var one_day=1000*60*60*24; 

	  var difference_ms = Math.abs(tmyNewDate - fmyNewDate) ;
	  var diff =difference_ms/86400000 + 1;
	//alert(diff);
		document.getElementById('adds').value=diff;
}


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
				else if(document.forms[0].tDate.value.trim()==""){
					alert("Please enter the to date");
					document.forms[0].tDate.focus();
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
<td align="left" style="padding-left:20px;"> Welcome to <%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %></td>
<td align="center"><img src="images/leaverequest_payroll.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content">

<div id="cont2">

<br />
 <logic:notEmpty name="status">
<font color="blue"><bean:write name="status"></bean:write></font>
</logic:notEmpty>
<table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr height="50">
 <td colspan="6">
 <br />
 <html:form action="/leave.do?action=leaveRequest1" method="post" enctype="multipart/form-data">
 From Date:
 <input type="text" name="fDate" value="" id="calendar1" class="calendarFocus"/>
 &nbsp;&nbsp;
 To Date:
 <input type="text" name="tDate" value="" id="calendar2" class="calendarFocus" onfocus="getNoofDays();" />
  <br /><br />
 No of Days: 
 <input type="text" name="adds" value="" id="adds" />			
  &nbsp;&nbsp;
 Approver Name:
  <logic:notEmpty name="approver" scope="request">
					<input type="text" name="firstName" id="firstName" value="<bean:write name="approver" scope="request" />"  readonly="readonly"/>
				</logic:notEmpty>	
<br /><br />
 <span style="vertical-align:center;">Reason for Leave:</span> 
 <textarea name="reason" rows="2" cols="20" onfocus="getNoofDays();" style="resize:none;"></textarea> &nbsp;&nbsp;
 Notify another Employee :
 <html:select property="userId1"
						styleClass="select1" >
						<html:option value="-1">--Select Employee--</html:option>
						<html:options collection="userList" property="userId1"
							labelProperty="username"/>
					</html:select><br /><br />
		 <br /><br />
   </td>
  
 </tr>			
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


 
 </table>
 <input type="submit"  value="Submit"  style="background:#666; color:#fff;" onclick="return validate();"/>
 
 </html:form>

</div><!--cont2-->
</div><!--content-->
</div><!--main-->

<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 itech Solutions. All rights reserved.</p>
</div>
<!--footer-->

</body>
</html>