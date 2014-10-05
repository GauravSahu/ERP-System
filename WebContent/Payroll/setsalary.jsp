<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Run Payroll</title>
</head>
<body>
<!--<td width="227" align="center">-->
<!--<html:link action="payslip.do?action=salarymod">Salary Modification</html:link>-->
<!--</td>-->
<td width="227" align="center">
<html:link action="payslip.do?action=postfinalsalary">Salary Modification</html:link>
</td>

<br></br>
<td><html:link action="payslip.do?action=postsalary">Post Salary</html:link></td>

<br></br>
<td>
<html:link action="payslip.do?action=generatepayslip">Generate Payslip</html:link>
</td>
<br></br>

<td>
<html:link action="payslip.do?action=salacknowledgement">Salary Acknowledgement</html:link>
</td>

<td>
<html:link action="payslip.do?action=updateEmployeeSalary">Update Employee Salary</html:link><br></br>
</td>

<td>
<html:link action = "payslip.do?action=updategeneratesalary">update and generate salary</html:link>
</td>

</body>
</html>