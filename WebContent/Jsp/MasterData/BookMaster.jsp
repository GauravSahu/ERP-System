<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Master</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
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
<script type="text/javascript">

function noBack() { 
	window.history.forward(); 
	
	document.forms[0].bookcatid.value="-1";
	
	}

function edit(BookMId,BookMTitle,BookMAuthor,BookMAccessionno,BookMBookCid)
{	
	alert(BookMTitle);
	document.forms[0].action="Library.do?action=update"; 
	document.forms[0].bookid.value=BookMId;
	document.forms[0].booktitle.value=BookMTitle;
	document.forms[0].author.value=BookMAuthor;
	document.forms[0].accessionno.value=BookMAccessionno;
	document.forms[0].bookcatid.value=BookMBookCid;
	document.forms[0].btn.value="Update"; 	
	
	
}
function validateno(){
	var numbers = /^[0-9\b]+$/;
if(document.forms[0].accessionno.value.trim()==""||(!document.forms[0].accessionno.value.match(numbers))){
	alert("Enter Accession No in numbers");
	document.forms[0].accessionno.value="";
	document.forms[0].accessionno.focus();
	return false;
}
}
function validateForm()
{		

	var alphaspace = /^[a-zA-Z_\.\-,]+(\s{0,1}[a-zA-Z_\.\-, ])*$/;

	if(document.forms[0].booktitle.value.trim()==""){
		alert("Enter The Book Title");
		document.forms[0].booktitle.focus();
		return false;
	}
	if(document.forms[0].author.value.trim()==""){
		alert("Enter Author Names");
		document.forms[0].author.focus();
		return false;
	}
	if(!document.forms[0].author.value.match(alphaspace)){
			alert("Enter Author Names in Charecters only");
			document.forms[0].author.focus();
			return false;
				
		}
	if(document.forms[0].accessionno.value.trim()==""){
		alert("Enter Accession No");
		document.forms[0].accessionno.focus();
		return false;
	}
	

	if(document.forms[0].bookcatid.value.trim()=="-1"){
		alert("Select Book Category");
		document.forms[0].bookcatid.value=='-1';
		document.forms[0].bookcatid.focus();
		return false;
	}
	
	
}
</script>
</head>
<body onload="noBack()">
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
 <td align="center">LIBARY BOOK MASTER </td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content">

<table align="center">
			 	<tr><td><logic:notEmpty  name="result">
					<font color="red"><bean:write name="result" ></bean:write></font>
				</logic:notEmpty> </td></tr></table> 
  
<table width="1000" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr height="50">
 
 <td colspan="15">
 
<logic:notEmpty name="status">
<font color="blue"><bean:write name="status"></bean:write></font>
</logic:notEmpty>

<html:form action="Library.do?action=add" onsubmit="return validateForm()">
<table>
<tr>
<input type="hidden" name="bookid"/>
<td>
Book Title:</td>
<td><input type="text" name="booktitle"/></td>

<td>
Author:</td>
<td><input type="text" name="author"/></td>

<td>
Accession No:</td>
<td><input type="text" name = "accessionno" onkeyup="validateno()"/></td>
<td align="center">
<label>Book Category:</label>
					<html:select  property="bookcatid"  styleId="bookcatid" styleClass="select1" onchange="fetch2()">
						<html:option value="-1">--Book Category--</html:option>
						<html:options collection="bookcatList" property="bookcatid"	labelProperty="bookcatname" />
					</html:select></td></tr>

<tr>
<td colspan="15">
 
 &nbsp;&nbsp; 
   &nbsp;&nbsp; <input type="submit"  name="btn"  value="Save" style="background:#666; color:#fff;"/>
   <input type="reset"  value="Reset" style="background:#666; color:#fff;"/>
   </td>
   </tr>
   </table>
   </html:form>
 </td>
   
 </tr>
 
 <tr>
 <td></td>
 <td></td>
 <td></td>
 <td></td></tr>
 
  <logic:notEmpty name="bookmasterlist">
 <tr bgcolor="#999999" height="30" align="center" >
 <td ><b>SL No</b></td>
 <td><b>Book Title</b></td>
 <td><b>Authors</b></td>
 <td><b>Accession no</b></td>
 <td><b>ACTION</b></td>
 </tr>
 <logic:iterate id="bookmater" name="bookmasterlist" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td> 
  <td><bean:write name="bookmater" property="booktitle"/></td>
 <td><bean:write name="bookmater" property="author"/></td>
 <td><bean:write name="bookmater" property="accessionno"/></td>
<td><a href='#'	onclick='edit("<bean:write name="bookmater" property="bookid"/>","<bean:write name="bookmater" property="booktitle"/>","<bean:write name="bookmater" property="author"/>","<bean:write name="bookmater" property="accessionno"/>","<bean:write name="bookmater" property="bookcatid"/>")' style="text-decoration:none" ><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a></td>
						   
						    
 </logic:iterate>
 </logic:notEmpty> 
 <logic:present name="bookmasterlist">
			<logic:empty name="bookmasterlist">
				No data added yet. 
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