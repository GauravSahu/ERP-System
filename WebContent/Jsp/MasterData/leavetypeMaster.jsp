<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LeaveType Master</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function edit(leavetypeid,leavename,entitlement)
{	
     //   alert(leavetypeid);
     //   alert(leavename);
	 // document.getElementById("status").innerHTML="";
		document.forms[0].action="Leavetype.do?action=update";
		document.forms[0].leavetypeid.value=leavetypeid;
		document.forms[0].leavename.value=leavename;
		document.forms[0].entitlement.value=entitlement;
		document.forms[0].btn.value="Update";
 }

</script>
<script type="text/javascript">
function AllowAlphabet(){
               if (!document.forms[0].leavename.value.match(/^[a-zA-Z ]*$/) && document.forms[0].leavename.value !="")
               {
            	   document.forms[0].leavename.value="";
            	   document.forms[0].leavename.focus(); 
                    alert("Please Enter only alphabets in text field");
               }
}      

function validate()
{

	if(document.forms[0].leavename.value.trim()=="")
	{
		alert("Leave Name cannot be empty");
		document.forms[0].leavename.focus();
		return false;
	}

	if(document.forms[0].entitlement.value.trim()=="")
	{
		alert("Entitlement cannot be empty");
		document.forms[0].entitlement.focus();
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

<!-- <td align="left" style="padding-left:20px;"> Welcome to iERP</td>
<td align="center"><img src="" /></td>
<td align="right">Thursday, May 23, 2013, 12:00:00 PM</td> -->
<td align="left" style="padding-left:20px;"> Welcome <%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %></td>
 <td align="center"><img src="images/leave.png" /></td>
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
 
 <td colspan="5">
 <html:form action="/Leavetype.do?action=add">
 <logic:notEmpty name="status">
					<font color="blue"><bean:write name="status"></bean:write></font>
				</logic:notEmpty>
 LeaveType Name :

 <html:text property="leavename" onkeyup="AllowAlphabet()"></html:text>
 Entitlement:
 <html:text property="entitlement" value=""></html:text>
 
 <input type="hidden" name="leavetypeid" id="textfield" />
 &nbsp;&nbsp; 
   &nbsp;&nbsp; <input type="submit"  name="btn"  value="Save" onclick="return validate()"  style="background:#666; color:#fff;"/>
   <input type="reset"  value="Reset" style="background:#666; color:#fff;"/></td>
   
 </tr>
 </html:form>

 <logic:notEmpty name="leavetypeList">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b>LeaveType ID</b></td>
 <td width="286"><b>LeaveType Name</b></td>
 <td width="100"><b>Entitlement </b></td>
 <td width="227"><b>STATUS </b></td>
 <td width="293"><b>ACTION</b></td>
 </tr>
 <logic:iterate id="leavetype" name="leavetypeList" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td> 
 <td><bean:write name="leavetype" property="leavename"/></td>
 <td><bean:write name="leavetype" property="entitlement"/>
 <td><logic:equal name="leavetype" property="active" value="true">
	  <font color="green">Active</font>
	 </logic:equal> 
	 
	 <logic:equal name="leavetype" property="active" value="false">
	 <font color="red">Inactive</font>
	 </logic:equal>
 </td>
 
 <td>
 <logic:equal name="leavetype" property="active" value="true">
							<a href='Leavetype.do?action=changestatus&amp;leavetypeid=<bean:write name="leavetype" property="leavetypeid"/>&amp;active=false' style="text-decoration:none;"  ><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
								&nbsp;&nbsp;
								<a href='#'	onclick='edit("<bean:write name="leavetype" property="leavetypeid"/>","<bean:write name="leavetype" property="leavename"/>","<bean:write name="leavetype" property="entitlement"/>")' style="text-decoration:none" ><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
						     </logic:equal> 
						     <logic:equal name="leavetype" property="active" value="false">
							<a
								href='Leavetype.do?action=changestatus&amp;leavetypeid=<bean:write name="leavetype" property="leavetypeid"/>&amp;active=true' style="text-decoration:none;"><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
						</logic:equal> 
 </logic:iterate>
 </logic:notEmpty> 
 <logic:present name="leavetypeList">
			<logic:empty name="leavetypeList">
				No Leave type added yet. 
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