<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Master</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}
.style2 {
	color: #FFFFFF;
	font-size: 12px; 
	font-family: Verdana, Arial, Helvetica, sans-serif;
	line-height:20px;
}
-->
</style>
<script type="text/javascript">
function noBack() { 
	window.history.forward(); 
		document.forms[0].bookcatid.value="-1";
		}
function edit(Ubookcatid,Ucatname)
{	
	alert(Ucatname);
	document.forms[0].action="Librarycat.do?action=update"; 
	document.forms[0].bookcatid.value=Ubookcatid;
	document.forms[0].catname.value=Ucatname;
	document.forms[0].btn.value="Update"; 	
}

function validateForm()
{		var alphaspace = /^[0-9a-zA-Z_\.\-,]+(\s{0,1}[0-9a-zA-Z_\.\-\&, ])*$/;
	if(document.forms[0].catname.value.trim()==""){
		alert("Enter The Book Category");
		document.forms[0].catname.focus();
		return false;
	}
	if(!document.forms[0].catname.value.match(alphaspace)){
		alert("Enter Category Name in Character only");
		document.forms[0].catname.focus();
		return false;
	}
	
}
</script>
</head>
<body onload="noBack()">
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
 <td align="center">BOOK CATEGORY MASTER </td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content">

<table align="center">
			 	<tr><td><logic:notEmpty name="result">
					<font color="red"><bean:write name="result"></bean:write></font>
				</logic:notEmpty> </td></tr></table> 
  
<table width="1000" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr height="50">
 
 <td colspan="15">
 
<logic:notEmpty name="status">
<font color="blue"><bean:write name="status"></bean:write></font>
</logic:notEmpty>

<html:form action="Librarycat.do?action=add" onsubmit="return validateForm()">
<table>
<tr>
<input type="hidden" name="bookcatid"/>
<td>
Category Name:</td>
<td><input type="text" name="catname"/></td>

<td colspan="15">
 
 &nbsp;&nbsp; 
   &nbsp;&nbsp; <input type="submit"  name="btn"  value="Save" style="background:#666; color:#fff;"/>
   <input type="reset"  value="Reset" style="background:#666; color:#fff;"/>
   </td>
   </tr>
   </table>
   </html:form>
 </td>
   
 </tr>
 
 <tr>
 <td></td>
 <td></td>
 <td></td>
 <td></td></tr>
 
 <logic:notEmpty name="bookcatlist">
 <tr bgcolor="#999999" height="30" align="center" >
 <td ><b>SL No</b></td>
 <td ><b>BOOK CATEGORY ID</b></td>
 <td><b>CATEGORY</b></td>
  <td><b>STATUS</b></td>
   <td><b>ACTION</b></td>
 </tr>
 <logic:iterate id="BookCatForm" name="bookcatlist" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td> 
 <td><bean:write name="BookCatForm" property="bookcatid"/></td>
 <td><bean:write name="BookCatForm" property="catname"/></td>

  <td><logic:equal name="BookCatForm" property="active" value="true">
	  <font color="green">Active</font>
	 </logic:equal> 
	 <logic:equal name="BookCatForm" property="active" value="false">
	 <font color="red">InActive</font>
	 </logic:equal></td>
	 
<td>
 <logic:equal name="BookCatForm" property="active" value="true">
<a href='Librarycat.do?action=changestatus&amp;bookcatid=<bean:write name="BookCatForm" property="bookcatid"/>&amp;active=false' style="text-decoration:none;"  ><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
								&nbsp;&nbsp;
<td><a href='#'	onclick='edit("<bean:write name="BookCatForm" property="bookcatid"/>","<bean:write name="BookCatForm" property="catname"/>")' style="text-decoration:none" ><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a></td>
</logic:equal> 
<logic:equal name="BookCatForm" property="active" value="false">
<a href='Librarycat.do?action=changestatus&amp;bookcatid=<bean:write name="BookCatForm" property="bookcatid"/>&amp;active=true' style="text-decoration:none;"><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
</logic:equal> 
 </logic:iterate>
 </logic:notEmpty> 


 <logic:present name="bookcatlist">
 
			<logic:empty name="bookcatlist">
				No data added yet. 
			</logic:empty>
 </logic:present> 
 <tr>
 <td></td>
 <td></td>
 <td></td>
 <td></td></tr>
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