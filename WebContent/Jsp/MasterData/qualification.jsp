<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Qualification Master</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function edit(qualificationid,qualificationname)
{	
        //alert(qualificationid);
        //alert(qualificationname);
	 // document.getElementById("status").innerHTML="";
		document.forms[0].action="Qualification.do?action=update";
		document.forms[0].qualificationid.value=qualificationid;
		document.forms[0].qualificationname.value=qualificationname;
		document.forms[0].btn.value="Update";
 }
function validate()
{

	if(document.forms[0].qualificationname.value.trim()==""){
		alert("Qualification cannot be empty");
		document.forms[0].qualificationname.focus();
		return false;
	}

	if (!document.forms[0].qualificationname.value.match(/^[a-zA-Z ]*$/) && document.forms[0].qualificationname.value !="")
    {
 	   document.forms[0].qualificationname.value="";
 	   document.forms[0].qualificationname.focus(); 
       alert("Please Enter only alphabets in the Qualification Name text field");
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
<td align="center"><img src="images/qualification.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content" style="overflow:scroll;">
<div id="city_content">
 <table align="center">
			 	<tr><td><logic:notEmpty name="result">
					<font color="red"><bean:write name="result"></bean:write></font>
				</logic:notEmpty> </td></tr></table> 
 <table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr height="50">
 
 <td colspan="4">
 <html:form action="/Qualification.do?action=add">
 <logic:notEmpty name="status">
					<font color="blue"><bean:write name="status"></bean:write></font>
				</logic:notEmpty>
 Qualification Name :

 <input type="text" name="qualificationname" id="textfield" />
 <input type="hidden" name="qualificationid" id="textfield" />
 &nbsp;&nbsp; 
   &nbsp;&nbsp; <input type="submit"  name="btn"  value="Save" onclick="return validate()"  style="background:#666; color:#fff;"/>
   <input type="reset"  value="Reset" style="background:#666; color:#fff;"/></td>
   
 </tr>
 </html:form>
 <logic:notEmpty name="qualificationList">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b> QUALIFICATION ID</b></td>
 <td width="286"><b>QUALIFICATION NAME</b></td>
 <td width="227"><b>STATUS </b></td>
 <td width="293"><b>ACTION</b></td>
 </tr>
 <logic:iterate id="qualification" name="qualificationList" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="qualification" property="qualificationname"/></td>
 <td><logic:equal name="qualification" property="active" value="true">
	  <font color="green">Active</font>
	 </logic:equal> 
	 
	 <logic:equal name="qualification" property="active" value="false">
	 <font color="red">Inactive</font>
	 </logic:equal>
 </td>
 
 <td>
 <logic:equal name="qualification" property="active" value="true">
							<a href='Qualification.do?action=changestatus&amp;qualificationid=<bean:write name="qualification" property="qualificationid"/>&amp;active=false' style="text-decoration:none;"  ><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
								&nbsp;&nbsp;
								<a href='#'	onclick='edit("<bean:write name="qualification" property="qualificationid"/>","<bean:write name="qualification" property="qualificationname"/>")' style="text-decoration:none" ><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
						     </logic:equal> 
						     <logic:equal name="qualification" property="active" value="false">
							<a
								href='Qualification.do?action=changestatus&amp;qualificationid=<bean:write name="qualification" property="qualificationid"/>&amp;active=true' style="text-decoration:none;"><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
						</logic:equal> 
 </logic:iterate>
 </logic:notEmpty> 
 <logic:present name="qualificationList">
			<logic:empty name="qualificationList">
				No qualification is added yet. 
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