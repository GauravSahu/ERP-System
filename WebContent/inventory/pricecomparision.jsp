<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>s
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html:form action="Order.do?action=pricecomparision">
 <logic:notEmpty name="pricedetails">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="134"><b> SL.No</b></td>
 <td width="286"><b>Item Name</b></td>
 <td width="227"><b>Vendor Name</b></td>
 <td width="227"><b>Price</b></td>
 <logic:iterate id="role" name="pricedetails" indexId="index">
 </tr>
 <tr align="center" height="25">
 <td><%=index+1 %></td>
 <td><bean:write name="role" property="itemname" /></td>
 <td><bean:write name="role" property="vendorname"/></td>
 <td><bean:write name="role" property="price"/> </td>

</logic:iterate>


 </tr>

</logic:notEmpty> 
<logic:present name="pricedetails">
			<logic:empty name="pricedetails">
				No Records are added yet. 
			</logic:empty>
 </logic:present>

 
</html:form>
</body>
</html>