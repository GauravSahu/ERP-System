<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Data </title>
</head>
<body>
<a href="state.do?action=list">State Master</a><br />
<tr>
   <html:link action="state.do?action=list"><bean:message key="iERP.state"/></html:link><br></br>
   <html:link action="state.do?action=list"><bean:message key="iERP.city"/></html:link>              
</tr>
</body>
</html>