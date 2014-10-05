<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head profile="<%=request.getContextPath() %>">
<link rel="icon" 
      type="image/png" 
      href="<%=request.getContextPath() %>/images/company_logo.png"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::iERP::</title>
</head>
<body>
<h1>Your Session has Expired !</h1>
<a href="http://localhost:8080/iERP/">Re-Login</a>
</body>
</html:html>