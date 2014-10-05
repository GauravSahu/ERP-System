<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Update</title>
 

<script src="js/jquery.js"></script>
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
	
	document.forms[0].itemid.value="-1";
	document.forms[0].vendorid.value="-1";
	
	}
function edit(siid,svid,sprice,sqty,sremark,supid)
{	
	alert("You want to edit Item");
	document.forms[0].action="StockUpdate.do?action=update"; 
	document.forms[0].stockupdateid.value=supid;
	document.forms[0].itemid.value=siid;
	document.forms[0].vendorid.value=svid;
	document.forms[0].price.value=sprice;
	document.forms[0].qty.value=sqty;
	document.forms[0].remark.value=sremark;
	document.forms[0].btn.value="Update"; 	
}

function validateForm()
{		
	if(document.forms[0].itemid.value.trim()=="-1"){
		alert("Select the Item" );
		document.forms[0].itemid.focus();
		return false;
	}
	if(document.forms[0].vendorid.value.trim()=="-1"){
		alert("Select the Vendor");
		document.forms[0].vendorid.focus();
		return false;
	}
	if(document.forms[0].price.value.trim()==""){
		alert("Enter Item Price");
		document.forms[0].price.focus();
		return false;
	}
	if(document.forms[0].qty.value.trim()==""){
		alert("Enter Qty");
		document.forms[0].qty.focus();
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
 <td align="center">STOCK UPDATE </td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content">

<table align="center">
			 	<tr><td><logic:notEmpty name="result">
					<font color="red"><bean:write name="result"></bean:write></font>
				</logic:notEmpty> </td></tr></table> 
 <html:form action="StockUpdate.do?action=add" onsubmit="return validateForm()"> 
<table width="1000" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr>
 <td></td>
 <td></td>
 <td></td>
 <td></td></tr>
 
 <logic:notEmpty name="stockupdatelist">
 <tr bgcolor="#999999" height="30" align="center" >
 <td ><b>Stock No</b></td>
 <td ><b>Purchase ID</b></td>
  <td ><b>Item Name</b></td>
 <td><b>Vender ID </b></td>
 <td><b>Price</b></td>
 <td><b>Qty</b></td>
 <td><b>Remarks</b></td>
 <td><b>ACTION</b></td>
 </tr>
 <logic:iterate id="stockupdateform" name="stockupdatelist" indexId="index">
 <tr align="center" height="25">
 <td><bean:write name="stockupdateform" property="stockupdateid"/></td> 
 <td><bean:write name="stockupdateform" property="purchaseOrderID"/></td>
  <td><bean:write name="stockupdateform" property="price"/></td>
 <td><bean:write name="stockupdateform" property="price"/></td>
 <td><bean:write name="stockupdateform" property="price"/></td>
 <td><input type="text" value="<bean:write name="stockupdateform" property="price"/>"></td>
 <td><bean:write name="stockupdateform" property="price"/></td>
<td><input type="submit"  value="Update" style="background:#666; color:#fff;"/><input type="button" id="reject"  value="Reject" style="background:#666; color:#fff;"/>
<table>
<tr><td><div id="remark" style="display:none;">
<table >
<tr><td><textarea name="remark"><bean:write name="stockupdateform" property="remark"/></textarea></td></tr>
<tr><td align="center"><button id="reset" style="background:#666; color:#fff;">Reset</button><input type="submit" id="save" style="background:#666; color:#fff;"></td></tr>
</table>
</div></td></tr>
</table>
</td>
</tr>
 </logic:iterate>
 </logic:notEmpty> 


 <logic:present name="stockupdatelist">
 
			<logic:empty name="stockupdatelist">
				No data added yet. 
			</logic:empty>
 </logic:present> 
 <tr>
 <td></td>
 <td></td>
 <td></td>
 <td></td></tr>
 </table> 
  </html:form>

</div><!--login1-->
</div><!--content-->

</div><!--main-->
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 Itech Solutions. All rights Reserved.</p>
</div><!--footer-->
<script>
$("#reject").click(function(){
	$("#remark").show();
});
$("#reset").click(function(){
	$("#remark").hide();
});


</script>
</body>

</html>