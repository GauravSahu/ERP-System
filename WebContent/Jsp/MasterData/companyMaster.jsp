<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>: Company master :</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function edit(compId,compName,compemail,compCoNo,cutOff,email2)
{	
	alert(email2);
	document.forms[0].action="Company.do?action=update"; 
	document.forms[0].companyId.value=compId;
	document.forms[0].companyName.value=compName;
	document.forms[0].emailId1.value=compemail;
	document.forms[0].contactNo.value=compCoNo;
	document.forms[0].ALCutOff.value=cutOff;
	document.forms[0].emailId2.value=email2;
	document.forms[0].btn.value="Update"; 	
}
function validateFileUpload(obj){  
	

    var fileName = new String();  
    var fileExtension = new String();  
      
    // store the file name into the variable  
    fileName = obj.value;  
      
    // extract and store the file extension into another variable  
    fileExtension = fileName.substr(fileName.length - 3, 3);  
      
    // array of allowed file type extensions  
    var validFileExtensions = new Array("png", "gif", "jpg","peg");  
      
    var flag = false;  
      
    // loop over the valid file extensions to compare them with uploaded file  
    for(var index = 0; index < validFileExtensions.length; index++){  
        if(fileExtension.toLowerCase() == validFileExtensions[index].toString().toLowerCase()){  
            flag = true;  
        }  
    }  
    // display the alert message box according to the flag value  
    if(flag == false){  
        document.forms[0].fileName.value="";
		document.getElementById('status').innerHTML='Files with extension ".' + fileExtension.toUpperCase() + '" are not allowed. You can upload the files with following extensions only:.png,.gif,.jpg,.jpeg';
		document.getElementById('status').style.color="red";
	       //  alert('Files with extension ".' + fileExtension.toUpperCase() + '" are not allowed.\n\nYou can upload the files with following extensions only:\n.mp3\n.wav\n.mp4\n.wma\n');  
        return false;  
    }  
    else         
        return true;  
      
} 
function validateForm()
{
	if(document.forms[0].companyName.value.trim()==""){
		alert("Company Name cannot be empty");
		document.forms[0].companyName.focus();
		return false;
	}
	if(document.forms[0].emailId1.value.trim()==""){
		alert("EmailId1 cannot be empty");
		document.forms[0].emailId1.focus();
		return false;
	}
	if(document.forms[0].emailId2.value.trim()==""){
		alert("EmailId2 cannot be empty");
		document.forms[0].emailId2.focus();
		return false;
	}
	if(document.forms[0].contactNo.value.trim()==""){
		alert("Contact Number cannot be empty");
		document.forms[0].contactNo.focus();
		return false;
	}
	if(document.forms[0].ALCutOff.value.trim()==""){
		alert("Att Cut Off Time cannot be empty");
		document.forms[0].ALCutOff.focus();
		return false;
	}

	 if (!document.forms[0].companyName.value.match(/^[a-zA-Z ]*$/) && document.forms[0].companyName.value !="")
	    {
	 	   document.forms[0].companyName.value="";
	 	   document.forms[0].companyName.focus(); 
	       alert("Please Enter only alphabets in Company Name text field");
	       return false;   
	    }
	var p1 = document.forms[0].contactNo.value;
	if(!p1.match(/^\d+/))
	    {
	    alert("Please enter only numerics for Mobile no.");
	    return false;
	    }
	var x=document.forms[0].emailId1.value;
	var atpos=x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	  {
	  alert("Not a valid e-mail address");
	  return false;
	  }

	var x=document.forms[0].emailId2.value;
	var atpos=x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	  {
	  alert("Not a valid e-mail address");
	  return false;
	  }

	  var t1 = document.forms[0].ALCutOff.value;
      if(!t1.match(/^\d{1,2}:\d{2}([ap]m)?$/))
      {
          alert("enter time like 09:45am or pm");
      }
	  
	else if(!document.forms[0].fileName.value=="")
		{
		//document.forms[0].action="Company.do?action=add";
		document.forms[0].submit();
		}
	
	else
	{
		alert("select File from C Drive");
		
		return false;	
	}		
	return false;
		
}
function validemail1(){
	re =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/; 
	if(document.forms[0].emailid1.value.trim()!=""){
		if (document.forms[0].emailid1.value.search(re)== -1) {
			alert("Please Enter valid Email Id");
			document.forms[0].emailid1.value = "";
			document.forms[0].emailid1.focus();
		}
	}	
}

function validemail2(){
	re =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/; 
	if(document.forms[0].emailid2.value.trim()!=""){
		if (document.forms[0].emailid2.value.search(re)== -1) {
			alert("Please Enter valid Email Id");
			document.forms[0].emailid2.value = "";
			document.forms[0].emailid2.focus();
		}
	}	
}

function mob()
{
	var y = document.forms[0].contactNo.value;
	if(!y.match(/^\d{10}$/))
	    {
	    alert("not valid mobile no.");
	    return false;
	    }
	var mob=document.forms[0].contactNo.value;
	if (mob==null || mob=="")
	  {
	  alert("mobile no. must not be empty");
	  return false;
	  } 
}
function mes()
{
	alert("Select image from C Drive only");
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
<td align="center"><img src="images/companymaster.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content" style="overflow:scroll;">
<div id="city_content" >
  
 <table width="1000" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr height="50">
 <td colspan="7">
 <br />
 <html:form action="Company.do?action=add" onsubmit="return false;" enctype="multipart/form-data" method="post">
  <logic:notEmpty name="status">
					<font color="blue"><bean:write name="status"></bean:write></font>
				</logic:notEmpty><br/><br/>
 Company Name:<input type="text" name="companyName" maxlength="50" value="" />
              <input type="hidden" name="companyId" id="textfield" />
 &nbsp;&nbsp;
 Company Logo :<input  type="file" name="fileName" onclick = "mes();" size="70" onchange="validateFileUpload(this)"  id="txtFile">
 &nbsp;&nbsp;
 Email ID1 : <input type="text" name="emailId1" onblur="validemail1();" value="" /> <br/><br/> 
 Email ID2 : <input type="text" name="emailId2" onblur="validemail2();" value="" /> &nbsp;&nbsp;
 
 
 
 Contact No : <input type="text" name="contactNo" value="" maxlength="12" />  
 AttCutOffTime : <input type="text" name="ALCutOff" value="" />&nbsp;&nbsp;
 <input type="submit"  value="Submit" onclick="validateForm(this)" style="background:#666; color:#fff;"/>&nbsp;&nbsp;<input type="reset"  value="Reset" style="background:#666; color:#fff;"/>
</html:form>
   <br /><br /></td>
 </tr>
 <logic:notEmpty name="compList">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b> SL.No</b></td>
 <td width="286"><b>COMPANY NAME</b></td>
 <td width="227"><b>EMAIL ID </b></td>

 <td width="150"><b>PHONE No </b></td>
  <td width="100"><b>ATTCUTOFFTIME</b></td>
 <td width="227"><b>STATUS </b></td>
 <td width="293"><b>ACTION</b></td>
 </tr>
 <logic:iterate id="comp" name="compList" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="comp" property="companyName"/></td>
 <td><bean:write name="comp" property="emailId1"/></td>

 <td><bean:write name="comp" property="contactNo"/></td> 
  <td><bean:write name="comp" property="ALCutOff"/></td> 
 <td><logic:equal name="comp" property="active" value="true">
	  <font color="green">Active</font>
	 </logic:equal> 
	 <logic:equal name="comp" property="active" value="false">
	 <font color="red">Inactive</font>
	 </logic:equal></td>
 <td>
 <logic:equal name="comp" property="active" value="true">
<a href='Company.do?action=changestatus&amp;companyId=<bean:write name="comp" property="companyId"/>&amp;active=false' style="text-decoration:none;"  ><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
								&nbsp;&nbsp;
<a href='#'	onclick='edit("<bean:write name="comp" property="companyId"/>","<bean:write name="comp" property="companyName"/>","<bean:write name="comp" property="emailId1"/>","<bean:write name="comp" property="contactNo"/>","<bean:write name="comp" property="ALCutOff"/>","<bean:write name="comp" property="emailId2"/>")' style="text-decoration:none" ><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
</logic:equal> 
<logic:equal name="comp" property="active" value="false">
<a href='Company.do?action=changestatus&amp;companyId=<bean:write name="comp" property="companyId"/>&amp;active=true' style="text-decoration:none;"><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
</logic:equal> 
 </logic:iterate>
 </logic:notEmpty> 
 <logic:present name="compList">
			<logic:empty name="compList">
				No Company is added yet. 
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