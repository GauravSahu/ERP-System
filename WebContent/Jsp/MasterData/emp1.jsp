<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>: Employee  Master :</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="datepicker.css" /> 
<script type="text/javascript" src="datepicker.js"></script> 
<script type="text/javascript">
function edit1(countryid,countryname,lastname,email,Dateoj,contactno,aletno,Dateob,passno,bankaccno,presentaddr,permanentaddress)
{
	alert("hi");

	document.forms[0].action="Employee.do?action=update";
	document.forms[0].empNo.value=countryid;
	document.forms[0].firstName.value=countryname;
	document.forms[0].lastName.value=lastname;
	document.forms[0].email.value=email;
	document.forms[0].dayOfJoining.value=Dateoj;
	document.forms[0].mobile.value=contactno;
	document.forms[0].alternateNum.value=aletno;
	document.forms[0].dayOfBirth.value=Dateob;
	document.forms[0].passportNo.value=passno;
	document.forms[0].bankAccountNo.value=bankaccno;
	document.forms[0].persentAddress.value=presentaddr;
	document.forms[0].permanentAddress.value=permanentaddress;
	document.forms[0].btn.value="Update";
	
}

function validemail1(){
	re =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/; 
	if(document.forms[0].email.value.trim()!=""){
		if (document.forms[0].email.value.search(re)== -1) {
			alert("Please Enter valid Email Id");
			document.forms[0].email.value = "";
			document.forms[0].email.focus();
		}
	}	
}



function AllowAlphabet(){
    if (!document.forms[0].username.value.match(/^[a-zA-Z ]*$/) && document.forms[0].username.value !="")
    {
 	   document.forms[0].username.value="";
 	   document.forms[0].username.focus(); 
         alert("Please Enter only alphabets in text field");
         return false;   
    }
    if (!document.forms[0].firstname.value.match(/^[a-zA-Z ]*$/) && document.forms[0].firstname.value !="")
    {
 	   document.forms[0].firstname.value="";
 	   document.forms[0].firstname.focus(); 
         alert("Please Enter only alphabets in text field");
         return false;   
    }
    if (!document.forms[0].lastname.value.match(/^[a-zA-Z ]*$/) && document.forms[0].lastname.value !="")
    {
 	   document.forms[0].lastname.value="";
 	   document.forms[0].lastname.focus(); 
         alert("Please Enter only alphabets in text field");
         return false;   
    }
}

function AllowAlphabet(){
    if (!document.forms[0].firstName.value.match(/^[a-zA-Z ]*$/) && document.forms[0].firstName.value !="")
    {
       alert("Allow Alphabets");
 	   document.forms[0].firstName.value="";
 	   document.forms[0].firstName.focus(); 
         alert("Please Enter only alphabets in text field");
    }
} 

function validate()
{
	if(document.forms[0].firstName.value.trim()==""){
		alert("First Name cannot be empty");
		document.forms[0].firstName.focus();
		return false;
	}
	if(document.forms[0].lastName.value.trim()==""){
		alert("Last Name cannot be empty");
		document.forms[0].lastName.focus();
		return false;
	}
	
	if(document.forms[0].dayOfJoining.value==""){
		alert("Telephone Number cannot be empty");
		document.forms[0].dayOfJoining.focus();
		return false;
	}
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
<td align="center"><img src="images/employeemaster.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content" style="overflow:scroll;">
<div id="city_content">
  
 <table width="1000" cellpadding="5" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr>
 <td colspan="6">
   <html:form action="Employee.do?action=add">
    <logic:notEmpty name="status">
					<font color="blue"><bean:write name="status"></bean:write></font>
				</logic:notEmpty>
 	<table width="961">
    <tr>
    <td width="90" height="30" align="right">First Name:</td>
    <td width="130" align="left"><input type="text" name="firstName" onkeyup="AllowAlphabet()" style="width:100px;"/>
    <input type="hidden" name="empNo" id="textfield" />
    </td>
    
    <td width="90" height="30" align="right">lastName:</td>
    <td width="130" align="left"><input type="text" name="lastName" onkeyup="AllowAlphabet()" style="width:100px;"/>
    </td>
    <td width="125" align="right">Maritial Status:</td>
    <td width="127" align="left"><select name="maritalStatus" size="1">
<option>&minus;select status&minus;</option>
<option>Single</option>
<option>Married</option></select></td>
    <td width="104" align="right">Date of Birth:</td>
    <td width="140" align="left"> <input type="text" name="dayOfJoining" style="width:100px;" id="start_dt" class='datepicker'/></td>
   
    </tr>
    
    <tr>
     <td width="126" align="right">Gender :</td>
    <td width="148" align="left"><input type="radio" name="gender"/>Male&nbsp;&nbsp;<input type="radio" name="gender" />Female</td>
    <td height="29" align="right">Qualification:</td>
    <td align="left">
<html:select property="qualificationid"
						styleClass="select1" style="width:120px;">
						<html:option value="-1">--Select Qualification--</html:option>
						<html:options collection="qualificationList" property="qualificationid"
							labelProperty="qualificationname"/>
					</html:select></td>
    <td align="right">Contact No:</td>
    <td align="left"> <input type="text" name="mobile" maxlength="12"  style="width:100px;" /></td>
    <td align="right">Alternate No:</td>
    <td align="left"> <input type="text" name="alternateNum" maxlength="15" style="width:100px;"/></td>
    
    </tr>
    
    <tr>
    

</tr>

<tr>
<td align="right">Email:</td>
    <td align="left"><input type="text" name="email" onblur="validemail1();" style="width:100px;"/> </td>
<td align="right">Designation :</td>
<td align="left"><html:select property="desid"
						styleClass="select1"  style="width:120px;">
						<html:option value="-1">--Select Designation--</html:option>
						<html:options collection="roleList1" property="desid"
							labelProperty="desname"/>
					</html:select></td>
<td align="right">Date of Joining :</td>
<td align="left"><input type="text" name="dayOfBirth" style="width:100px;" id="end_dt" class='datepicker'/></td>
<td align="right">Passport No :</td>
<td align="left"><input type="text" name="passportNo" style="width:100px;"/></td>


</tr>


<tr>
<td align="right">Bank Name :</td>
<td align="left"><html:select property="bankId"
						styleClass="select1" >
						<html:option value="-1">--Select Bank--</html:option>
						<html:options collection="roleList" property="bankId"
							labelProperty="bankName"/>
					</html:select></td>
<td align="right">Bank A/c No :</td>
<td align="left"><input type="text" name="bankAccountNo" style="width:100px;"/></td>

<td height="43" align="right">Present Address:</td>
    <td  align="left"><textarea name="persentAddress" cols="10" rows="2" style="resize:none;"></textarea></td>
    <td align="right">Permanent Address:</td>
    <td align="left"><textarea name="permanentAddress" cols="10" rows="2" style="resize:none;"></textarea>
</td>
</tr>
<tr>
<td colspan="8	"><input type="submit"  value="Submit" onclick="return validate()" style="background:#666; color:#fff;"/>
 <input type="reset"  value="Reset" style="background:#666; color:#fff;"/></td>
</tr>
</html:form>
    </table>
   
 </td>
 </tr>
 <logic:notEmpty name="employeeList">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="74"><b> SL.No</b></td>
 <td width="346"><b>FIRST NAME</b></td>
 <td width="346"><b>LAST NAME</b></td>
 <td width="346"><b>EMAIL</b></td>
 <td width="227"><b>STATUS </b></td>
 <td width="293"><b>ACTION</b></td>
 </tr>
 <logic:iterate id="emp" name="employeeList" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="emp" property="firstName"/></td>
 <td><bean:write name="emp" property="lastName"/></td>
 <td><bean:write name="emp" property="email"/></td>

 <td><logic:equal name="emp" property="active" value="true">
	  <font color="green">Active</font>
	 </logic:equal> 
	 <logic:equal name="emp" property="active" value="false">
	 <font color="red">Inactive</font>
	 </logic:equal></td>
 <td><logic:equal name="emp" property="active" value="true">
							<a href='Employee.do?action=changestatus&amp;empNo=<bean:write name="emp" property="empNo"/>&amp;active=false' style="text-decoration:none;"  ><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
								&nbsp;&nbsp;     
<a href='#'	onclick='edit1("<bean:write name="emp" property="empNo"/>","<bean:write name="emp" property="firstName"/>","<bean:write name="emp" property="lastName"/>","<bean:write name="emp" property="email"/>","<bean:write name="emp" property="dayOfJoining"/>","<bean:write name="emp" property="mobile"/>","<bean:write name="emp" property="alternateNum"/>","<bean:write name="emp" property="dayOfBirth"/>","<bean:write name="emp" property="passportNo"/>","<bean:write name="emp" property="bankAccountNo"/>","<bean:write name="emp" property="permanentAddress"/>","<bean:write name="emp" property="persentAddress"/>")' style="text-decoration:none" ><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
						    
						     </logic:equal> 
						     <logic:equal name="emp" property="active" value="false">
							<a href='Employee.do?action=changestatus&amp;empNo=<bean:write name="emp" property="empNo"/>&amp;active=true' style="text-decoration:none;"><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
						</logic:equal></td>
 </tr>
 </logic:iterate>
</logic:notEmpty>
 
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