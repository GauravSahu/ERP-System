<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>: Salary Master :</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function edit(countryid,countryname,net,tax)
{	
      
	    //document.getElementById("status").innerHTML="";
		document.SalaryForm.action="Salary.do?action=update&countryid="+countryid;
		document.SalaryForm.salaryId.value=countryid;
		document.SalaryForm.basic.value=countryname;
		document.SalaryForm.netSal.value=net;
		document.SalaryForm.tax.value=tax;
		document.SalaryForm.btn.value="Update";
 }
function validate()
{
	if(document.forms[0].basic.value.trim()==""){
		alert("Basic cannot be empty");
		document.forms[0].basic.focus();
		return false;
	}
	if(document.forms[0].netSal.value.trim()==""){
		alert("Set Salary cannot be empty");
		document.forms[0].netSal.focus();
		return false;
	}
	if(document.forms[0].tax.value.trim()==""){
		alert("Tax cannot be empty");
		document.forms[0].tax.focus();
		return false;
	}
	 
	    
}
</script>
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
</head>
<body>
<div id="main">

<div id="header">
<div id="header1">

<a href="Logout.do"><img src="images/MasterData_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/MasterData_home.png" alt="Home" border="0"  /></a>
</div><!--header1-->

<table width="1000" align="center" cellpadding="0" cellspacing="0" class="para">

<tr>
<td width="255" height="80"></td>
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
<td align="center"><img src="images/salarycomponentmaster.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content" style="overflow:scroll;">
<div id="city_content">
  
 <table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr height="50">
 <td colspan="6">
 <html:form action="/Salary.do?action=add">
 <logic:notEmpty name="status">
					<font color="blue"><bean:write name="status"></bean:write></font>
				</logic:notEmpty>
 &nbsp;&nbsp; Basic: <input type="hidden" name="salaryId" id="textfield" />
 <input type="text" name="basic" style="width:100px;"/>&nbsp;&nbsp;
 Net Salary:<input type="text" name="netSal" style="width:100px;"/>&nbsp;&nbsp;
Professional Tax:<input type="text" name="tax" style="width:100px;"/>&nbsp;&nbsp;


   &nbsp;&nbsp; <input type="submit"  name="btn"  value="Save" onclick="return validate()" style="background:#666; color:#fff;"/>
   <input type="reset"  value="Reset" style="background:#666; color:#fff;"/>
   </html:form>
   </td>
 </tr>
<logic:notEmpty name="salaryList">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="74"><b> SL.No</b></td>
 <td width="346"><b>BASIC</b></td>
 <td width="346"><b>NET SALARY</b></td>
 <td width="346"><b>PROFESSIONAL TAX</b></td>
 <td width="227"><b>STATUS </b></td>
 <td width="293"><b>ACTION</b></td>
 </tr>
 <logic:iterate id="salary" name="salaryList" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="salary" property="basic"/></td>
 <td><bean:write name="salary" property="netSal"/></td>
 <td><bean:write name="salary" property="tax"/></td>
 <td><logic:equal name="salary" property="active" value="true">
	  <font color="green">Active</font>
	 </logic:equal> 
	 
	 <logic:equal name="salary" property="active" value="false">
	 <font color="red">Inactive</font>
	 </logic:equal></td>
 <td><logic:equal name="salary" property="active" value="true">
							<a href='Salary.do?action=changestatus&amp;salaryId=<bean:write name="salary" property="salaryId"/>&amp;active=false' style="text-decoration:none;"  ><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
								&nbsp;&nbsp;
								<a href='#'	onclick='edit("<bean:write name="salary" property="salaryId"/>","<bean:write name="salary" property="basic"/>","<bean:write name="salary" property="netSal"/>","<bean:write name="salary" property="tax"/>")' style="text-decoration:none" ><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
						     </logic:equal> 
						     <logic:equal name="salary" property="active" value="false">
							<a
								href='Salary.do?action=changestatus&amp;salaryId=<bean:write name="salary" property="salaryId"/>&amp;active=true' style="text-decoration:none;"><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
						</logic:equal> </td>
 
 </tr>
 </logic:iterate>
</logic:notEmpty>
<logic:present name="salaryList">
			<logic:empty name="salaryList">
				No salary is added yet. 
			</logic:empty>
 </logic:present>
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