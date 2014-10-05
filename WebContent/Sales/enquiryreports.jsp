<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales :: Enquiry Reports</title>
<link href="css/sales_style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
</style>
</head>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/DateTime/jquery.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath() %>/DateTime/jquery-calendar.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/DateTime/jquery-calendar.css" />

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/DateTime/styles.css" />
<script type="text/javascript">

		//<![CDATA[

			$(document).ready(function (){ 

				$("#calendar1, #calendar2").calendar();

				$("#calendar1_alert").click(function(){alert(popUpCal.parseDate($('#calendar1').val()))});

			});

		//]]>
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



<br />

<table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr height="50">
 <html:form action="salesmodule.do?action=enquiryRepResults">
 <td colspan="6">
 
 <br />

 From Date:
 <input type="text" name="fDate" value="" id="calendar1" class="calendarFocus"/>
 &nbsp;&nbsp;
 To Date:
  <input type="text" name="tDate" value="" id="calendar2" class="calendarFocus"/>
  &nbsp;&nbsp;
 From Enquiry: 
 <html:select property="enquiryid"
						styleClass="select1" >
						<html:option value="-1">--Select Employee--</html:option>
						<html:options collection="enquiryList" property="enquiryid"
							labelProperty="enquiryname"/>
					</html:select>
<br /><br />
 To Enquiry : <html:select property="enqid2"
						styleClass="select1" >
						<html:option value="-1">--Select Employee--</html:option>
						<html:options collection="enquiryList1" property="enqid2"
							labelProperty="enquiryname"/>
					</html:select> &nbsp;&nbsp;<input type="submit"  value="Generate Report" style="background:#666; color:#fff;"/>
 <br /><br />
   </td>
  </html:form>
 
 

 </table>
 <table>
</tr>
 <logic:notEmpty name="enquiryreports">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b> SL.No</b></td>
 <td width="286"><b>Date</b></td>
 <td width="227"><b> Enquiry Name</b></td>
 <td width="227"><b>Requirements</b></td>
 <td width="227"><b>Username</b></td>
  <td width="227"><b>Service Type </b></td>
 <logic:iterate id="role" name="enquiryreports" indexId="index">
 </tr>
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="role" property="dated" /></td>
 <td><bean:write name="role" property="enquiryname"/></td>
 <td><bean:write name="role" property="requirements"/> </td>
  <td><bean:write name="role" property="username"/></td>
    <td><bean:write name="role" property="servicetype"/></td>
</logic:iterate>


 </tr>

</logic:notEmpty> 
<logic:present name="enquiryreports">
			<logic:empty name="enquiryreports">
				No Records are added yet. 
			</logic:empty>
 </logic:present> 
 </table>

</div>
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 itech Solutions. All rights reserved.</p>
</div>
<!--footer-->
</body>
</html>