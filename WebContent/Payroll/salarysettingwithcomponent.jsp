<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salary Settings</title>
</head>
<body>
<html:form action="payslip.do?action=postfinalsalary">
<div id="wrapper">
<h2>Salary Setting</h2>

<div id="sellect_user">
<label>Select User Name</label>
</div>

<div id="tabledoc">
<table cellpadding="1" cellspacing="0" border="1" style=" width:650px;">
<logic:notEmpty name="complist">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b> Sl No</b></td>
 <td>USER ID</td>
 <td width="286"><b>COMPONENT Name</b></td>
 <td width="286"><b>Component Type</b></td>
 <td width="227"><b>Component Value</b></td>
 </tr>
 <logic:iterate id="role" name="componentwithvalues" indexId="index">
 

 <tr align="center" height="25">
 <td><%=index+1 %></td>
 

 <td><bean:write name="role" property="userId"/><html:hidden property="userId" name="role"/> </td>
 <td><bean:write name="role" property="componentName"/><html:hidden property="componentName" name="role"></html:hidden></td>
 <td><bean:write name="role" property="componenttype" /><html:hidden property="componenttype" name="role"></html:hidden>
 <td><bean:write name="role" property="value" /><html:hidden property="value" name="role"></html:hidden></td>
 <input type="hidden" name="componentid"  value="<bean:write name="role" property="componentid"/>" ></input>
 </td>
 </logic:iterate>
 </logic:notEmpty> 
 <logic:present name="componentwithvalues">
			<logic:empty name="componentwithvalues">
				No Role is added yet. 
			</logic:empty>
 </logic:present>

</table>
</div>
<div id="submitbtn1"><p><input class="searchbutton" value="Submit" type="submit"/></p></div>
</div>
</html:form>
</body>
</html>