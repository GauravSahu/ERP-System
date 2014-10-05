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
	document.forms[0].bookid.value="-1";
	document.forms[0].employeeid.value="-1";

}
function validateForm()
{		
		if(document.forms[0].bookid.value.trim()=="-1"){
		alert("Select Book");
		document.forms[0].bookid.value=='-1';
		document.forms[0].bookid.focus();
		return false;
	}
	if(document.forms[0].employeeid.value.trim()=="-1"){
		alert("Select Employee Name");
		document.forms[0].employeeid.value=='-1';
		document.forms[0].employeeid.focus();
		return false;
	}

	
	
}
function onreset()
{	document.forms[0].bookid.value='-1';
document.forms[0].employeeid.value='-1';
	
}
</script>
</head>
<body onload="noBack();">
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
 <td align="center">LIBARY </td>
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

<html:form action="LibraryModule.do?action=addbookrequest" onsubmit="return validateForm()">
<table>
<tr>
<td>Book Title:</td>
<td><html:select property="bookid"	styleClass="select1" >
						<html:option value="-1">--Select Book--</html:option>
						<html:options collection="bookcatList" property="bookid"	labelProperty="booktitle"/>
					</html:select></td>

<td>
Employee</td><td>
<html:select property="employeeid"	styleClass="select1"  >
						<html:option value="-1">--Select Book--</html:option>
						<html:options collection="employeelist" property="employeeid"	labelProperty="employeename"/>
					</html:select></td>

<td>
Remark</td>
<td><input type="text" name = "remark"/></td>


<td colspan="15">
 
 &nbsp;&nbsp; 
   &nbsp;&nbsp; <input type="submit"  name="btn"  value="Save" style="background:#666; color:#fff;"/>
   <input type="reset"  value="Reset"  style="background:#666; color:#fff;"/>
   </td>
   </tr>
   </table>
   </html:form>
 </td>
   
 </tr>

 <logic:notEmpty name="bookrequestlist">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b> SL .No</b></td>
 <td width="286"><b>BOOK</b></td>
 <td width="286"><b>EMPLOYEE NAME</b></td>
 <td width="227"><b>TAKEN DATE </b></td>
 <td width="293"><b>RETURN DATE</b></td>
 <td width="293"><b>REMARKS</b></td>
 </tr>
 <logic:iterate id="reqfom" name="bookrequestlist" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="reqfom" property="booktitle"/></td>
 <td><bean:write  name="reqfom" property="employeename" /></td>
 <td><bean:write  name="reqfom" property="takendate" /></td>
 <td><bean:write  name="reqfom" property="returndate"/></td>
 <td><bean:write  name="reqfom" property="remark" /></td>
 </tr>
  </logic:iterate>
 </logic:notEmpty> 
 <logic:present name="bookrequestlist">
			<logic:empty name="bookrequestlist">
				NO RECORDS FOUND. 
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