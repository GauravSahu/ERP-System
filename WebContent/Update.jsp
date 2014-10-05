<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-nested.tld" prefix="nested"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update:</title>
<script type="text/javascript">

function validate()
{

	if(document.forms[0].caldayid.value.trim()=="-1")
	{
		alert("Day Type cannot be empty");
		document.forms[0].caldayid.focus();
		return false;
	}
}

</script>
</head>
<body>
<logic:notEmpty name="status">
						<font color="blue"><bean:write name="status"></bean:write></font>
						
					</logic:notEmpty>
<html:form action="CalenderType.do?action=update">
<td style="background:#6e6b0d; color:#fff;">Select Day Type:</td>
<td><html:hidden property="dcompanyid"/>  
<html:select property="caldayid">
<html:option value="-1">--Select--</html:option>
<html:options collection="cstatusList" property="caldayid" labelProperty="calendername"/>
</html:select></td></tr>
<tr>
<td></td>
<td>
<html:submit value="submit" onclick="return validate()"></html:submit>
<input type="button" value="Close Window" onclick="window.opener.location.reload(true);self.close();" /></td>
</tr>
</html:form>
</body>
</html>