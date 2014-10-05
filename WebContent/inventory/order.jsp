<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Requition</title>
</head>
<script type="text/javascript">
function popuponclick()
{

	   my_window = window.open("Order.do?action=pricecomparision", "myWindow", 
			"status = 1, height = 150, width = 400, resizable = 1,menubar=1" );
}
</script>
<body>
<input type="submit" onclick="popuponclick();"  value="compare price"/>
<html:form action="Order.do?action=add" onsubmit="return validateForm()">
<table>
<tr>
<td align="center">
<label>Item Name:</label>
					<html:select property="itemtid"
						styleClass="select1" >
						<html:option value="-1">--Select Item Name--</html:option>
						<html:options collection="itemmasterlist" property="itemtid"
							labelProperty="itemname"/>
					</html:select></td>
					<html:hidden property="itemtid" />
				
					
<td align="center">					
<label>Vendor Name:</label>
					<html:select property="vendorid"
						styleClass="select1" >
						<html:option value="-1">--Select Vendor Name--</html:option>
						<html:options collection="venderList" property="vendorid"
							labelProperty="vendorname"/>
					</html:select>
					</td>
 <td>Quantity: <input type="text" name="qty" /> </td>
 
 

<td> <input type="submit"  name="btn"  value="Save" style="background:#666; color:#fff;"/>
   <input type="reset"  value="Reset" style="background:#666; color:#fff;"/>
   </td>
   </tr>
   </table>
   </html:form>
</body>
</html>