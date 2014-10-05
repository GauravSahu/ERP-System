<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/TLD/struts-html.tld"  prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Transaction page</title>
</head>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/DateTime/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/DateTime/jquery-calendar.js"></script>
<link rel="stylesheet" type="text/css"                 
	href="<%=request.getContextPath() %>/DateTime/jquery-calendar.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/DateTime/styles.css" />
<script type="text/javascript">
		//<![CDATA[

			$(document).ready(function (){  

				$("#calendar1, #calendar2").calendar();

				$("#calendar1_alert").click(function(){alert(popUpCal.parseDate($('#calendar1').val()))});

			});

		//]]>
			</script>
<body>
<table>
<html:form action="payment.do?action=PaymentTransAdd">
Date : 
<input type="text" name="fdate" value="" id="calendar1" class="calendarFocus"/>

Vendor Name :
<input type="text" name="vendorid" id="textfield" />

Amount :
<input type="text" name="amount" id="textfield" />

Payment Mode :
<input type="radio" value="Cash" name="trans"/>
<input type="radio" value="Cheque" name="trans" />
<input type="radio" value="Bank transfer" name="trans" />


</html:form>
</table>
</body>
</html>