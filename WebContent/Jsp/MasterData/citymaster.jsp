<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head profile="<%=request.getContextPath() %>">
<link rel="icon" 
      type="image/png" 
      href="<%=request.getContextPath() %>/images/logo.png"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City Master</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/homecalender.js"></script>
<script type="text/javascript" src="js/city.js"></script>

<script type="text/javascript">

window.history.forward();
function noBack() { window.history.forward(); }

function fetch(){

	if(document.forms[0].countryid.options[document.forms[0].countryid.selectedIndex].value==-1)
		document.forms[0].action="City.do?action=reset";
		
	else
		{
		document.forms[0].action="City.do?action=reset";
		document.forms[0].submit();
	//	document.forms[0].action="City.do?action=state";
	//	document.forms[0].submit();
		}
	document.forms[0].submit();
	document.forms[0].stateid.disabled=false;
}
function fetch2(){
	if(document.forms[0].stateid.options[document.forms[0].stateid.selectedIndex].value==-1)
	   document.forms[0].action="City.do?action=reset";
			else			
			document.forms[0].action="City.do?action=list";
			document.forms[0].submit();
			
		}

function edit(id,name,id1){
	//document.getElementById('status').innerHTML="";
	document.forms[0].action="City.do?action=update";
	
	document.forms[0].cityid.value=id;

	document.forms[0].cityname.value=name;

	document.forms[0].stateid.value=id1;

	document.forms[0].btn1.value="Update";
}

function validate()
{
	if(document.forms[0].cityname.value.trim()==""){
		alert("City Name cannot be empty");
		document.forms[0].cityname.focus();
		return false;
	}
	if (!document.forms[0].cityname.value.match(/^[a-zA-Z ]*$/) && document.forms[0].cityname.value !="")
    {
 	   document.forms[0].cityname.value="";
 	   document.forms[0].cityname.focus(); 
       alert("Please Enter only alphabets in the City Name text field");
       return false;   
    }
	else if(document.forms[0].stateid.value.trim()=="-1"){
		alert("please select state");
		document.forms[0].stateid.focus();
		return false;
	}

	else if(document.forms[0].countryid.value.trim()=="-1"){
		alert("please select country");
		document.forms[0].countryid.focus();
		return false;
	}
	else
	{
		return true;
}
}
function changeStatus(cityid , stateid, val) 
{

	//document.getElementById('status').innerHTML="";
	var countryid=document.forms[0].countryid.value;
	//var cityid =document.forms[0].cityid.value;
	//var statid= document.forms[0].stateid.value;
//var query = "&cityid="+cityid+"&stateid="+stateid+"&countryid="+countryid+"&Active="+ val; 
//alert("City.do?action=changestatus"+query);
//var string = "City.do?action=changestatus"+query;
document.forms[0].action="City.do?action=changestatus"+"&cityid="+cityid+"&stateid="+stateid+"&countryid="+countryid+"&Active="+ val;
//alert(document.forms[0].action="City.do?action=changestatus"+"&cityid="+cityid+"&stateid="+stateid+"&countryid="+countryid+"&Active="+ val)

document.forms[0].submit();

}

function focus2()
{document.getElementById('status').innerHTML="";
document.forms[0].action="City.do?action=add";
document.forms[0].btn1.value="Save";
document.forms[0].cityname.focus();
document.getElementById('status').innerHTML="";
}

</script>
</head>
<body>
<div id="header">
<div id="header1">
<a href="Logout.do"><img src="images/MasterData_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/MasterData_home.png" alt="Home" border="0"  /></a>
</div>

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
<td align="center"><img src="images/citymaster.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>
</div>

<div id="content">

<table border="0" cellpadding="0" cellspacing="0" align="center" width="880" height="auto">
	
    <tr>
	<td align="center" width="800" height="500"  valign="top">
	<div id="content">
	<fieldset style="width: 90%;"><legend><strong>City</strong></legend>
	<html:form action="/City.do?action=add" >
		<table border="0" width="100%" align="center" class="para">
						
			
			 				<logic:notEmpty name="status">
					<font color="blue"><bean:write name="status"></bean:write></font>
				</logic:notEmpty>  </div>
			<tr>
				<td width="30%" align="left"><label>Select a Country</label></td>
				<td width="20%" align="left" >
				<html:select property="countryid" styleClass="select1" onchange="fetch()" >
					<html:option value="-1" >--Select country--</html:option>
					<html:options collection="countryList" property="countryid" labelProperty="countryname" />
				</html:select></td>				
					<td width="30%" align="left"><label>Select a State</label></td>
					<td width="40%" align="left" colspan="2">
				<html:select property="stateid" styleClass="select1"  onchange="fetch2(this.value)">
					<html:option value="-1" >--Select State--</html:option>
					<html:options collection="stateList" property="stateid" labelProperty="statename" />
				</html:select>
				</td>
			
				<td width="40%" align="left"><label>City Name</label></td>
				<td width="40%" align="left"><input type="hidden" name="cityid" />
				<input type="text" name="cityname" id="cityname"/></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td width="20%" align="right">
				<input type="submit" name="btn1" value="Save" class="but"  onclick="return validate()"/></td>
				<td> <input type="reset" value="Reset"  onclick="focus2(document.forms[0].cityname)" /> </td>
			</tr>
			
		</table>
	</html:form>
	<hr/>
	<logic:notEmpty name="cityList">
		<table cellpadding="2" border="1" rules="all" width="100%"
			style="table-layout: fixed;" align="center">
			<tr class="tdheader">
				<th width="10%">Sl. No.</th>
				<th width="60%">City Name</th>
				<th width="15%">Status</th>
				<th width="15%">Action</th>
			</tr>
			<logic:iterate id="city" name="cityList" indexId="index">
				<tr class="tdContent2">
					<td align="center" style="color: black"><%=index + 1%></td>
					<td align="left" style="color: black"><bean:write name="city" property="cityname" /></td>
					<td align="center"><logic:equal name="city" property="active"
						value="true">
						<font color="green">Active</font>
					</logic:equal> <logic:equal name="city" property="active" value="false">
						<font color="red">Inactive</font>
					</logic:equal></td>
					<td align="center"><logic:equal name="city" property="active"
						value="true">
						<a	href="#" onclick='changeStatus("<bean:write name="city" property="cityid"/>","<bean:write name="city" property="stateid"/>",false)'><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
								<a href='#'
							onclick='edit("<bean:write name="city" property="cityid"/>","<bean:write name="city" property="cityname"/>","<bean:write name="city" property="stateid"/>")'><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
							</logic:equal> <logic:equal name="city" property="active" value="false">
								<a	href="#" onclick='changeStatus("<bean:write name="city" property="cityid"/>","<bean:write name="city" property="stateid"/>",true)'><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
					</logic:equal>&nbsp;</td>
				</tr>
			</logic:iterate>
		</table>
	</logic:notEmpty> <logic:present name="cityList">
		<logic:empty name="cityList">
                		No City is added yet.
                	</logic:empty>
	</logic:present></fieldset></div>
	</td>
    </tr>
    </table>
    </div>



<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 Itech Solutions. All rights Reserved.</p>
</div>
</body>
</html>