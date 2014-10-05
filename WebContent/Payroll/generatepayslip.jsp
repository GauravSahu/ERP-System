<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<%
out.println(session.getAttribute("compid"));
%>
<html:form action="payslip.do?action=viewPayslip">
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
<label>From</label><input type="text" name="startrange" />
<label>To</label><input type="text" name="endrange" />
<input type="submit" value="submit"></input>
</html:form>
</body>
</html>