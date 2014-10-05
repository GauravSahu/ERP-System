<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Attendance Module</title>
<link href="css/Payroll_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
<script type="text/javascript">
function test()
{
	alert("Click on sign in and signout only one time per day ");
}

function validate()
{
	if(document.forms[0].reason.value.trim()==""){
		alert("Please enter the reason");
		document.forms[0].reason.focus();
		return false;
	}
}
</script>

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
<td align="left" style="padding-left:20px;"> Welcome <%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %></td>
<td align="center"><img src="images/AttendanceModule.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>
</div><!--header-->
<div id="content">
<div id="cont2">
<table cellpadding="0" cellspacing="0" width="400" align="center" class="para">
<logic:notEmpty name="status">
 <font color="blue"><bean:write name="status"></bean:write></font>
  </logic:notEmpty>
<tr>
<td height="50"></td>
</tr>
<tr>
<td><a href="attendance.do?action=login" onclick="test()"><img src="images/sign_in.png" border="0" /></a>
</td>
<td><a href="attendance.do?action=logout" onclick="test()"><img src="images/sign_out.png" border="0" /></a></td>
</tr>
<html:form action="/attendance.do?action=login1">
<tr>
<td style="vertical-align:middle;" colspan="2">Reason for Coming Late :<input type="text" name="reason" value="" style="height:30px; width:180px;"/></textarea> </td>
</tr>
<tr>
<td colspan="2" height="39" align="center"><input type="submit" name="submit" value="" onclick="return validate()" style="background:url(images/submit.png) no-repeat; width:420px; height:130px; border:none;" /></td>
</tr>
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
