<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>: Sales module : Add Enquiry</title>
<link href="css/sales_style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}
.style2 {
	color: #000;
	font-size: 12px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	line-height:20px;
}
-->
</style>
<script type="text/javascript">
function validateForm()
{
	var x=document.forms[0].firstname.value;
	if (x==null || x=="")
	  {
	  alert("name must not be empty");
	  return false;
	  }
	var mob=document.forms[0].mobilenumber.value;
	if (mob==null || mob=="")
	  {
	  alert("Contact no. must not be empty");
	  return false;
	  } 
	var z = document.forms[0].mobilenumber.value;
	if(!z.match(/^\d{10}$/))
    {
    alert("not valid contact no.");
    return false;
    }
	  if(document.forms[0].altmobilenumber.value != "null" && document.forms[0].altmobilenumber.value != "")
	  {
		  var y = document.forms[0].altmobilenumber.value;
			if(!y.match(/^\d{10}$/))
			    {
			    alert("not valid alt contact number.");
			    return false;
			    }
	  }

	  if(document.forms[0].landlinenumber.value != "null" && document.forms[0].landlinenumber.value != "")
	  {
		  var landLine = "^[0-9]\d{2,4}-\d{6,8}$";
		  if(landLine.Test(document.getElementById("landlinenumber").value))
			     alert("Landline number validate successfully")
			   else
			     alert("Landline number invalid")
	  }

     if(document.forms[0].emailid.value != "null" && document.forms[0].emailid.value != "")
     {
	  var x=document.forms[0].emailid.value;
	  var atpos=x.indexOf("@");
	  var dotpos=x.lastIndexOf(".");
	  if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	    {
	    alert("Not a valid e-mail address");
	    return false;
	    }
     }

     if(document.forms[0].altemailid.value != "null" && document.forms[0].altemailid.value != "")
     {
	  var x=document.forms[0].altemailid.value;
	  var atpos=x.indexOf("@");
	  var dotpos=x.lastIndexOf(".");
	  if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	    {
	    alert("Not a valid e-mail address");
	    return false;
	    }
     }
	  
}
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode != 46 && charCode > 31 
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

function isAlpha(evt)
{
   var keyCode = (evt.which) ? evt.which : evt.keyCode
     if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && keyCode != 32)

     return false;
         return true;
}

</script>
</head>
<body>
<div id="main">
<div id="header">

<div id="header1">

<a href="Logout.do"><img src="images/sales_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/sales_home.png" alt="Home" border="0"  /></a>

</div><!--header1-->
<table width="1000" align="center" cellpadding="0" cellspacing="0" class="para">


<tr>
<td align="left" style="padding-top:70px;"> Welcome to <%Object ob = (Object) session.getAttribute("username").toString();
      if(ob != null)
      {
    	  %><%=ob%><%
      }
%></td>
<td align="center"><img src="images/Enquiry.png" /></td>
<td align="right" style="padding-top:70px;"><%=new java.util.Date() %></td>
</tr>
</table>


  
</div><!--header-->



<div id="content">
<div id="login1" style="background-image:url(images/en_content.png);">
  
  
  <html:form action="salesmodule.do?action=addEnquiry" onsubmit="return validateForm();">
  <table align="center">
  
  <logic:notEmpty name="status">
<font color="blue"><bean:write name="status"/></font>
  </logic:notEmpty>
  </table>
  <table border="0" width="700"cellpadding="0" cellspacing="0" align="right" style="margin-right:50px; background-color:#D5E396; padding:12px; border-radius:40px; margin-top:15px;">
  <tr><td>

	 
		<tr>
	
		  <td width="150">First Name * :</td><td> <input type="text" style="border-radius:8px;" name="firstname" size="25"  maxlength="30"   onkeypress="return isAlpha(event);"/><input type="hidden"  name="enquiryid" /></td>
		  <td height="40" width="100">Last Name : </td><td><input type="text" style="border-radius:8px;" name="lastname" maxlength="30"  onkeypress="return isAlpha(event);" size="25" /></td>
		  
		</tr>
		
		
		<tr>
	
		  <td>E-mail id :  </td>    
		    <td><input type="text" style="border-radius:8px;" name="emailid" size="25" maxlength="50" /></td>
		  <td height="40" width="150">Alternative E-mail : </td>
          <td><input type="text" style="border-radius:8px;" name="altemailid" size="25"  maxlength="50"/></td>
		  
		</tr>
		
        <tr>
	
		  <td>Contact no * : </td><td><input type="text"  style="border-radius:8px;" name="mobilenumber" size="25" onkeypress="return isNumberKey(event)" maxlength="20" /></td>
		  
		  <td height="40" width="150">Alternative Mobile no:</td><td><input type="text"  style="border-radius:8px;" name="altmobilenumber" size="25" onkeypress="return isNumberKey(event)" maxlength="30" /></td>
		  
		</tr>
         <tr>
	
		  <td>Landline no: </td><td><input type="text"  style="border-radius:8px;" name="landlinenumber"  id="landlinenumber" size="25" onkeypress="return isNumberKey(event)" maxlength="20" /></td>
		  <td height="40">Reference: </td><td><input type="text" style="border-radius:8px;"name="reference" size="25" maxlength="200"/></td>
		  
		</tr>
        
        <tr>
	
		  <td>Company Name: </td><td><input type="text" style="border-radius:8px;" name="companyname" onkeypress="return isAlpha(event);" size="25" maxlength="30"/></td>
		  <td height="40" >Service type :</td>
		  
		  <td><select name="servicetype" id="servicetype">
        <option value="Website" >Website</option>
        <option value="">SEO</option>
        <option>HR service</option>
        
        </select></td>
		  
		</tr>
        
          <tr>
	
		  <td colspan="2"  height="40">Company Address: <textarea name="address" cols="30"  onkeypress="return isAlpha(event);" style=" resize:none;border-radius:10px;margin-left:40px; margin-top:10px;" rows="5"  ></textarea></td>
		  <td colspan="2"  height="40">Enquiry Description: <textarea name="requirements" onkeypress="return isAlpha(event);" cols="30"   style=" resize:none;border-radius:10px;margin-left:40px; margin-top:10px;" rows="5"></textarea></td>

		</tr>
        <tr>
        <td></td>
        
        
        
        </td>
        
        </tr>
        <tr>
        <td></td>
        <td></td>
        <td height="40" colspan="2"><input type="submit" value="submit" name="submit"/>&nbsp; &nbsp;<input type="reset" name="reset" /></td>
        </tr>
		
 </table>
	  </td>
</tr>
</table>
</html:form>
</div><!--login1-->
</div><!--content-->
</div><!--main-->
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 Itech Solutions. All rights reserved.</p>
</div><!--footer-->
</body>
</html>