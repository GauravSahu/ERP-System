<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Time sheet Module</title>
<link href="../css/Payroll_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
function validate()
{
	if(document.forms[0].timesheet.value.trim()=="")
	{
		alert("Task List cannot be empty");
		document.forms[0].timesheet.focus();
		return false;
	}
	
}
</script>
</head>
<body>

<div id="main">

<div id="header">
<div id="header1">

<a href="../Logout.do"><img src="../images/MasterData_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../admhome.jsp"><img src="../images/MasterData_home.png" alt="Home" border="0"  /></a>
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
<td align="center"><img src="../images/timesheetModule.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>
</div><!--header-->
<div id="content">
<div id="cont2">
<br/>
<br/>


<table cellpadding="0" cellspacing="0" width="461" align="center" class="para">
<html:form action="timesheet.do?action=timeSheet">
<tr>
<td height="46" colspan="2" align="right" style="vertical-align:middle;padding:0;">Enter Task's for the day :</td>
<td><html:textarea rows="7" cols="30" style="resize:none" property="timesheet" ></html:textarea></td>
</tr>
<tr>
<td height="46" colspan="2" align="right" ><input type="submit" img src="../images/submit.png" style="padding-left: 10px;" align="right" width="233" height="70" border="0" onclick="return validate();" /></td>
 <td align="left"> <input type ="reset" img src="images/reset.png" border="0" width="233" height="70" /></td>
</tr>
</table>
</html:form>
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