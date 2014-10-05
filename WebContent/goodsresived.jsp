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

		}

function edit(imasterid,catid,iname)
{	
	alert(iname);
	document.forms[0].action="Itemmaster.do?action=update"; 
	document.forms[0].itemmasterid.value=imasterid;
	document.forms[0].categoryid.value=catid;
	document.forms[0].itemname.value=iname;
	document.forms[0].btn.value="Update"; 	
}

function validateForm()
{		var alphaspace = /^[0-9a-zA-Z_\.\-,]+(\s{0,1}[0-9a-zA-Z_\.\-\&, ])*$/;
	if(document.forms[0].categoryid.value.trim()=="-1"){
		alert("Select the item  Category" );
		document.forms[0].categoryid.focus();
		return false;
	}
	if(document.forms[0].itemname.value.trim()==""||(!document.forms[0].itemname.value.match(alphaspace))){
		alert("Enter Item Name");
		document.forms[0].itemname.focus();
		return false;
	}
	
}
function reject(id) { 
	

	document.getElementById(id).value=imasterid;
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
 <td align="center">GOOD RESIVED FINAL SATELMENT </td>
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
 
 
   
 </tr>
 
 <tr>
 <td></td>
 <td></td>
 <td></td>
 <td></td></tr>
 
 <logic:notEmpty name="goodsresivedlist">
 <html:form action="GoodsResived.do?action=add">

 <tr bgcolor="#999999" height="30" align="center" >
 <td ><b>STOCK UPDATE ID</b></td>
 <td ><b>ITEM ID</b></td>
 <td><b>VENDOR ID</b></td>
  <td><b>PRICE</b></td>
   <td><b>ACCEPT QUANTITY</b></td>
   <td><b>REJECTED QUANTITY</b></td>
   <td><b>COMPANY ID</b></td>
    <td><b>REMARK</b></td>
   
 </tr>
 <logic:iterate id="goodsresivedform" name="goodsresivedlist" indexId="index">
 <tr align="center" height="25">
 <td><bean:write name="goodsresivedform" property="stockupdateid"/><html:hidden property="stockupdateid" name="goodsresivedform"/> </td>
 <td><bean:write name="goodsresivedform" property="itemname"/><html:hidden property="itemid" name="goodsresivedform"/> </td>
 <td><bean:write name="goodsresivedform" property="vendorname"/><html:hidden property="vendorid" name="goodsresivedform"/> </td>
  <td><bean:write name="goodsresivedform" property="price" /><html:hidden property="price" name="goodsresivedform"/> </td>
 <td><html:text property="acceptqty" name="goodsresivedform" /> </td>
 <td><html:text property="rejectqty" name="goodsresivedform" /> </td>
 <td><bean:write name="goodsresivedform" property="compid"/><html:hidden property="compid" name="goodsresivedform"/> </td>
 <td><bean:write name="goodsresivedform" property="remark"/><html:hidden property="remark" name="goodsresivedform"/> </td>

</tr>
 </logic:iterate>
  <input type="submit"  value="submit" style="background:#666; color:#fff;"/>
</html:form>
</logic:notEmpty> 
 <logic:present name="goodsresivedlist">
 
			<logic:empty name="goodsresivedlist">
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