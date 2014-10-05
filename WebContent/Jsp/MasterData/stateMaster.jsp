<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>: State master :</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function fetch()
{

	if(document.StateForm.countryid.options[document.StateForm.countryid.selectedIndex]){
	   document.StateForm.action="State.do?action=list";	  
	   document.StateForm.submit();
	}
	else
	 alert("Country list empty");			
 }
function edit(id,name,id1)
{ 
	//document.getElementById("status").innerHTML="";
	document.StateForm.action="State.do?action=update";
	document.StateForm.stateid.value=id;
	document.StateForm.statename.value=name;
	document.StateForm.countryid.value=id1;
	document.StateForm.btn1.value="Update";
	
}
function focus2()
{
document.getElementById('status').innerHTML="";
document.stateForm.countryid.value="";
document.stateForm.action="State.do?action=add";
document.stateForm.btn1.value="Save";
document.stateForm.statename.focus();
}
function validate()
{
	
	if(document.forms[0].statename.value.trim()==""){
		alert("State Name cannot be empty");
		document.forms[0].statename.focus();
		return false;
	}
	if (!document.forms[0].statename.value.match(/^[a-zA-Z ]*$/) && document.forms[0].statename.value !="")
    {
 	   document.forms[0].statename.value="";
 	   document.forms[0].statename.focus(); 
       alert("Please Enter only alphabets in the State Name text field");
       return false;   
    }
	else if(document.forms[0].countryid.value.trim()=="-1"){
		alert("Please select country name");
		document.forms[0].countryid.focus();
		return false;
	}
	
	else
		return true;
	
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
<td align="center"><img src="images/statemaster.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>
</div><!--header-->
<div id="content" style="overflow:scroll;	">
<div id="city_content">
  
 <table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
  <html:form action="State.do?action=add">
 <tr height="50">
 <td colspan="4">
 <logic:notEmpty name="status">
 <font color="blue"><bean:write name="status"></bean:write></font>
  </logic:notEmpty>
 &nbsp;&nbsp; Country Name :
 <html:select property="countryid" onchange="fetch()" style="width:150px;">
 <html:option value="-1">--Select Country--</html:option>
 <html:options collection="countryList" property="countryid" labelProperty="countryname" /> 
 </html:select>
 
  &nbsp;&nbsp; State Name :
  <input type="hidden" name="stateid">
  <input type ="text" name="statename" id="statename">

   &nbsp;&nbsp; <input type="submit" name="btn1" value="Save" onclick="return validate()" style="background:#666; color:#fff;"/>
   <input type="reset" value="Reset"   onclick="focus2();" style="background:#666; color:#fff;"/>
   </td>
 
 </tr>
 </html:form>
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b> SL.No</b></td>
 <td width="286"><b>STATE NAME</b></td>
 <td width="227"><b>STATUS </b></td>
 <td width="293"><b>ACTION</b></td>
 </tr>
 <logic:notEmpty name="stateList">
 <logic:iterate id="state" name="stateList" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="state" property="statename"/></td>
 <td><logic:equal name="state" property="active" value="true">
 <font color="green">Active</font>
 </logic:equal>
  <logic:equal name="state" property="active" value="false">
 <font color="red">Inactive</font>
 </logic:equal>
</td>
 <td>
 <logic:equal name="state" property="active" value="true">
 <a href='State.do?action=changestatus&amp;stateid=<bean:write name="state" property="stateid"/>&amp;countryid=<bean:write name="state" property="countryid"/>&amp;active=false' style="text-decoration:none;"><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
 <a href='#' onclick='edit("<bean:write name="state" property="stateid"/>","<bean:write name="state" property="statename"/>","<bean:write name="state" property="countryid"/>")'><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
  </logic:equal>
<logic:equal name="state" property="active" value="false">
<a href='State.do?action=changestatus&amp;stateid=<bean:write name="state" property="stateid"/>&amp;countryid=<bean:write name="state" property="countryid"/>&amp;active=true' style="text-decoration:none;"><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
</logic:equal>
 &nbsp;
 </tr>
  </logic:iterate>
 </logic:notEmpty>
 <logic:present name="stateList">
			<logic:empty name="stateList">
				No State is added yet. 
			</logic:empty>
 </logic:present>
 </table>   
</div><!--login1-->
</div><!--content-->
</div><!--main-->
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 Itech Solutions. All rights Reserved.</p>
</div>
</body>
</html>