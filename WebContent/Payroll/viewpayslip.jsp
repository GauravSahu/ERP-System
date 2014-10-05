<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Payslip</title>
<style type="text/css">
#wrapper{width:900px; height:auto; font-family:Arial, Helvetica, sans-serif; font-style:normal; font-weight:bold; margin-top:20px;}
#header{ text-align:center; padding-top:30px;}
#info{ margin-left:50px;}
#header h1{font-size:24px; font-family:Arial, Helvetica, sans-serif; font-style:normal;}

.content{margin-left:50px; width:750px;}
.content span{float:right; padding-left:10px;}
.content th,td{ border:1px solid black; padding-left:5px; font-weight:bold;}
#info td{ border:none; padding-top:10px;}
#footer{ font-size:14px; font-weight:bold;}
.content label{font-weight:normal;}
</style>
</head>
<script type="text/javascript">
function printdiv(printpage)
{
var headstr = "<title></title><body>";
var footstr = "</body>";
var newstr = document.all.item(printpage).innerHTML;
var oldstr = document.body.innerHTML;
document.body.innerHTML = headstr+newstr+footstr;
window.print();
document.body.innerHTML = oldstr;
return false;
}
</script>

<body>
<h1>Send SucessFully</h1>
	
</body>
</html>