<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"  prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounting Module :: Account Type Master</title>
</head>
<body>
<table>
<html:form action="accounttype.do?action=add">
Account Number : 
<input type = "text" name = "accountno" id="textfield" />
&nbsp;&nbsp;
Account Name :
<input type="text" name="accountname" id="textfield" />
&nbsp&nbsp
Account Type :
<input type = "text" name="accounttype" id="textfield" />
&nbsp;&nbsp;
<input type = "submit" name="btn" onclick="return validate()" value="save"></input>
<input type = "reset" value="reset"></input>
</html:form>
<logic:notEmpty name="accounttype">
<tr bgcolor="#999999" height="30" align="center">
<td width="100">Sl No</td>
<td width="100">Account Number</td>
<td width="100">Account Name</td>
<td width="100">Account Type</td>
<td width="100">Status</td>
<td width="100">Action</td>
</tr>
<logic:iterate id="account" name="accounttype" indexId="index">
<tr align="center" height="25">
<td><%=index+1 %></td>
<td><bean:write name="account" property="accountno"/></td>
<td><bean:write name="account" property="accountname"/></td>
<td><bean:write name="account" property="accounttype"/></td>
<td>
<logic:equal name="account" property="active" value="true">
  <font color = "green">Active</font>
</logic:equal>
<logic:equal name="account" property="active" value="false">
<font color="red">Inactive</font>
</logic:equal>
 </td>
 
 <td>
 <logic:equal name="account" property="active" value="true">
 <a href='accounttype.do?action=changestatus&amp;accountno=<bean:write name="account" property="accountno"/>&amp;active=false'><input type ="submit" value="Remove"/></a>
 &nbsp;&nbsp;
 <!--   <a href='#' onclick='edit("<bean:write name="account" property="accountno"/>","<bean:write name="account" property="accountname"/>","<bean:write name="account" property="accounttype"/>")'><input type="submit" value="edit" /></a>
 -->
 </logic:equal>
 <logic:equal name="account" property="active" value="false">
 <a href='accounttype.do?action=changestatus&amp;accountno=<bean:write name="account" property="accountno"/>&amp;active=true'><input type="submit" value="activate"></input></a> 
 </logic:equal>
 </td>
</tr> 
</logic:iterate>
</logic:notEmpty>
</table>
</body>
</html>