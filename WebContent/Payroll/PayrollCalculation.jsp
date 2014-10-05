<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<script>
function calculate(){   
     var a = frmMain.name.value;
     var b = frmMain.Salary.value;
     var c = parseFloat(frmMain.taxrate.value);

 	var monthly = b/12;
 	
	var basic = (monthly/100)*52;

	document.getElementById("basic").innerHTML=basic;
	document.getElementById("da").innerHTML=(monthly/100)*2.6 ;
	document.getElementById("pa").innerHTML= (monthly/100)*30 ;
	document.getElementById("oa").innerHTML= (monthly/100)*11.6 ;
	document.getElementById("lb").innerHTML= (monthly/100)*5 ;
var area = document.getElementById("text");
area.innerHTML='Name : '+a+'\nSalary : '+b+'\nTax Rate : '+c;
}
</script>
</head>
<body><html:form action="payslip.do?action=savesalary" styleId="frmMain">
    
       Employee ID:<input type ="text" id="name" /><br />
       Enter CTC: <input type ="text" id="Salary" /><br />
       tax rate <input type ="text" id="taxrate" /><br />
       <input type="button" value="calculate" onclick="calculate()" />
       <input type="reset" value="Clear" /><br /><!--
       Sammary<textarea cols="20" rows="5" id="text"></textarea>
       
              -->
              <br/>
              <br/>
              <div id="payroll">
              
           <table width="100%" border="1">
             <tr><th>Earnings</th>
             <th>Rs</th>
             <th> Deductions</th>
            <th>Rs</th>
              <th>Other Details</th>
             <th>Details</th>
            </tr> 
       <tr><td>Basic:</td><td><label id="basic"></label></td><td>Profession Tax:</td> <td><input type="text" id="pt" value=""/></td><td>Date of Joining:</td></tr>
       <tr> <td>Dearness Allowance:</td><td> <label id="da"></label></td><td>Income Tax:</td><td><input type="text" id="it" value=""/></td> <td>Present Days:</td></tr>
       <tr> <td>Performance Allowance:</td> <td><label id="pa"></label></td><td>Lop:</td><td><input type="text" id="lop" value=""/></td> <td>Working Days:</td></tr>
     <tr>   <td>Other Allowance:</td> <td><label id="oa"></label></td><td>Other Deductions:</td><td><input type="text" id="od" value=""/></td><td>Calendar Days:</td> </tr>
       <tr> <td>Special Pay:</td> <td><label id="sp"></label></td><td></td><td></td><td>Location:</td></tr>
       <tr> <td>Loyality Bonus:</td> <td><label id="lb"></label></td><td></td><td></td><td>Pan:</td></tr>
       <tr> <td></td> <td></td><td></td><td></td><td>Leave For Month:</td></tr>
       <tr> <td></td> <td></td><td></td><td></td><td>Actual Performance %:</td></tr>
       <tr> <td><strong>Total Earnings</strong></td> <td><strong><label id="total"></label></strong></td><td><strong>Total Deductions</strong></td><td><strong><input type="text" id="td" value=""/></strong></td><td><strong>Net Salary Rupees:</strong></td></tr>
    <td> <input type="submit" value="submit"/></td>
      </table>  
    
      </div>  
 
  </html:form>
<div style="clear:both"></div>
<div id="footer">
Copyright&copy;2013, All Right Reserved, Franchise Management System, Design and Developed By : Itech Solutions
</div><!--footer-->
<!--footer-->
</body>
</html>
