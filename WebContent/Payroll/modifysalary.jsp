<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salary Calculation</title>
<script type="text/javascript">
function populateYearSelect()
{
    d = new Date();
    curr_year = d.getFullYear();
 
    for(i = 0; i < 4; i++)
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
<html:form action="payslip.do?action=savefinalsal">
<table>
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
<tr>UserId</tr>
&nbsp;
<tr>Basic</tr>
&nbsp;
<tr>Da</tr>
&nbsp;
<tr>Pa</tr>
&nbsp;
<tr>oa</tr>
&nbsp;
<tr>lb</tr>
&nbsp;
<tr>pt</tr>
&nbsp;
<tr>sp</tr>
&nbsp;
</table>
<table>
<logic:iterate id="file2" name="modsalary">
<tr>
<td><html:text property="userId" name="file2"></html:text></td>
<td><html:text property="basic" name="file2"></html:text><html:hidden property="basic" name="file2"></html:hidden></td>
<td><html:text property="da" name="file2"></html:text><html:hidden property="da" name="file2"></html:hidden></td>
<td><html:text property="pa" name="file2"></html:text><html:hidden property="pa" name="file2"></html:hidden></td>
<td><html:text property="oa" name="file2"></html:text><html:hidden property="oa" name="file2"></html:hidden></td>
<td><html:text property="lb" name="file2"></html:text><html:hidden property="lb" name="file2"></html:hidden></td>
<td><html:text property="pt" name="file2"></html:text><html:hidden property="pt" name="file2"></html:hidden></td>
<td><html:text property="salarypay" name="file2"></html:text><html:hidden property="salarypay" name="file2"></html:hidden></td>
</tr>
</logic:iterate>
</table>
<input type="submit" value="submit"></input>
</html:form>
</body>
</html>