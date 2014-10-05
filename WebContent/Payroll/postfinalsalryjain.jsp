<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Final Salary</title>
<script type="text/javascript">
function populateYearSelect()
{
    d = new Date();
    curr_year = d.getFullYear();
 
    for(i = 0; i < 5; i++)
    {
        document.getElementById('year1').options[i] = new Option(curr_year-i,curr_year-i);
    }
}
function setMonth(d)
{
	alert(d);
	curr_month = d.getMonth;
	document.month.options[curr_month].selected=true;
}
</script>
</head>
<body onLoad="populateYearSelect(),setMonth(value);">
   <html:form action="payslip.do?action=postfinalsalary">
<table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
<select name="year1" id="year1">
</select>
<select name=month1>
<option value=JAN>JAN</option>
<option value=FEB>FEB</option>
<option value=MAR>MAR</option>
<option value=APR>APR</option>
<option value=MAY>MAY</option> 
<option value=JUN>JUN</option>
<option value=JUL>JUL</option>
<option value=AUG>AUG</option>
<option value=SEP>SEP</option>
<option value=OCT>OCT</option>
<option value=NOV>NOV</option>
<option value=DEC>DEC</option>
</select>
From Employee:
<html:select property="userId1">
<html:option value="-1">--Select Employee--</html:option>
<html:options collection="userList1" property="userId1" labelProperty="username"/>
</html:select>
<br></br><!--
To Employee:
<html:select property="userId2">
<html:option value="-1">--Select Employee--</html:option>
<html:options collection="userList2" property="userId2" labelProperty="username"/>
</html:select>
  --></table>
 <input type="submit" value="submit"></input>
</html:form>
<html:form action="payslip.do?action=postsalry">
<logic:notEmpty name="componentwithvalues">
<table cellpadding="1" cellspacing="0" border="1" style=" width:650px;">

 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b> Sl No</b></td>
 <td>USER ID</td>
 <td>Month</td>
 <td>Year</td>
 <td width="286"><b>COMPONENT Name</b></td>
 <td width="286"><b>Component Type</b></td>
 <td width="227"><b>Component Value</b></td>
 </tr>
 <logic:iterate id="role" name="componentwithvalues" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="role" property="userId"/><html:hidden property="userId" name="role"/> </td>
  <td><bean:write name="role" property="month"/><html:hidden property="month" name="role"></html:hidden></td>
  <td><bean:write name="role" property="year1"/><html:hidden property="year1" name="role"></html:hidden></td>
 <td><bean:write name="role" property="componentName"/><html:hidden property="componentName" name="role"></html:hidden></td>
 <td><bean:write name="role" property="componenttype" /><html:hidden property="componenttype" name="role"></html:hidden>
 <td><html:text property="value" name="role"></html:text><html:hidden property="value" name="role"></html:hidden></td>
 <input type="hidden" name="componentid"  value="<bean:write name="role" property="componentid"/>" ></input>
 </td>
 </logic:iterate>
 </logic:notEmpty> 
</table>
<input type="submit" value="submit"></input>
</html:form>
</table> 
</body>
</html>