<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave rejection</title>
</head>
<script type="text/javascript">
function validate()
{
	if(document.forms[0].rejection.value.trim()=="")
	{
		alert("Reason cannot be empty");
		document.forms[0].rejection.focus();
		return false;
	}
	 
}

function CloseAndRefresh()
{
opener.location.reload(true);
self.close();
}
</script>
<body bgcolor="#93D1A8">
<html:form action="leave.do?action=changestatus1">
<html:hidden property="id" value="<%=request.getParameter("id") %>" />
<table >
<tr>
<td style="font:12px Verdana;">Reason for Rejection :
<html:text property="rejection" maxlength="1000"></html:text>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="submit" onclick="return validate()" style="background: #ccc;"></input></td>
</tr>

</table>
</html:form>

</body>
</html>