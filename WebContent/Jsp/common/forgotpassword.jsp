<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.servlet.ServletConfig"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FORGOT PASSWORD</title>
<script type="text/javascript">
function show_alert() {
	var msg = "Please Check your Email..";
	alert(msg);
	}

	function validate(str){
		
		if(str.value.trim()==""){
			alert(" Please enter " +str.name+"!.");
			str.focus();
			return false;
		}

		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
		 if(str.value.match(mailformat)){  	  
			str.focus();    
		}  
		 else  
		{  
			var userInput = "Enter correct values";
			//document.getElementById('login-header1').innerHTML = userInput;
			alert("You have entered an invalid email address!");  
			str.focus();  
			return false;  
		} 
		
		return true;
	}
</script>
</head>
<body>
<html:form action="ForgotPassword.do?action=sendmail">
<table>
<logic:present name="loginfailure">
<bean:write name="loginfailure"/>
</logic:present>

<tr>
<td><label>Enter Email Id : </label><input type="text" name="email"></td>
</tr>				
<tr align="center"><td>
<html:submit value="Submit"></html:submit>
</td></tr>		
</table>

</html:form>  
</body>
</html:html>