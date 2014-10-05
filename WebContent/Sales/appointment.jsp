<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales:: Appointment</title>
<link href="css/sales_style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
</style>
</head>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/DateTime/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/DateTime/jquery-calendar.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/DateTime/jquery-calendar.css" />

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/DateTime/styles.css" />
	<script language="JavaScript" type="text/javascript">
	$(document).ready(function (){ 

		$("#calendar1, #calendar2").calendar();

		$("#calendar1_alert").click(function(){alert(popUpCal.parseDate($('#calendar1').val()))});

	});
	</script>
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
<html:form action="salesmodule.do?action=addappointment" onsubmit="return validateForm();">
<table align="center">
  <logic:notEmpty name="status">
<font color="blue"><bean:write name="status"/></font>
  </logic:notEmpty>
  </table>
  <table border="0" width="700"cellpadding="0" cellspacing="0" align="right" style="margin-right:50px; background-color:#D5E396; padding:12px; border-radius:40px; margin-top:15px;">
   <tr></tr>

	 
		<tr>
	
		    <td width="150">Select Enquiry Name* :</td><td> <html:select property="enquiryid" styleClass="select1">
					<html:option value="-1" >--Select Enquiry--</html:option>
					<html:options collection="enquiryList" property="enquiryid" labelProperty="enquiryname" />
				</html:select>
		   </td>
		   
		  <td height="40" width="100">Date and Time* :</td>
		  
          <td><input type="text" name="fdate" value="" id="calendar1" class="calendarFocus"/></td>
		</tr>
		
		<tr>
		 <td width="150">Assigned To * :</td><td> <html:select property="userid" styleClass="select1">
					<html:option value="-1" >--Select User--</html:option>
					<html:options collection="userList" property="userid" labelProperty="username" />
				</html:select>
		   </td>
		  <td colspan="2"  height="40">Details : <textarea name="appdetails" cols="30"  onkeypress="return isAlpha(event);" style=" resize:none;border-radius:10px;margin-left:40px; margin-top:10px;" rows="5"  >
		  </textarea>
		  </td>
		  </tr>
		  
		  <tr>
		   <td colspan="2"  height="40">Address : <textarea name="address" cols="30"  onkeypress="return isAlpha(event);" style=" resize:none;border-radius:10px;margin-left:40px; margin-top:10px;" rows="5"  >
		  </textarea>
		  </tr>
		  
		 <tr>
        <td></td>
        <td></td>
        <td height="40" colspan="2"><input type="submit" value="submit" name="submit"/>&nbsp; &nbsp;<input type="reset" name="reset" /></td>
        </tr>
		  
   </table>
</html:form>
</body>
</html>