<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales :: Reports</title>
</head>
<body>
<table>
<tr>
<td><html:link action="salesmodule.do?action=enquiryReports">Enquiry Reports</html:link></td>
<td><html:link action="salesmodule.do?action=followupreports">Follow up reports</html:link></td>
<td><html:link action="salesmodule.do?action=quotationreports">Quotation reports</html:link></td>
<td><html:link action="salesmodule.do?action=appointmentreports">Appointment reports</html:link></td>
</tr>
</table>
</body>
</html>           