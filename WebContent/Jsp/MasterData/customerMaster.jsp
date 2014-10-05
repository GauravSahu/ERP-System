<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Master</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function edit(customerid,customername,customer_accno,address1,address2,countryid,stateid,cityid,phone1,phone2,emailid,zip,fax)
{	
       // alert(userid);
      //  alert(username);
	 // document.getElementById("status").innerHTML="";
	 alert(countryid+cityid+stateid);
		document.forms[0].action="Customer.do?action=update";
		document.forms[0].customerid.value=customerid;
		document.forms[0].customername.value=customername;
		document.forms[0].customer_accno.value=customer_accno;
	//	document.forms[0].userid.value=userid;
		document.forms[0].address1.value=address1;
		document.forms[0].address2.value=address2;
		document.forms[0].countryid.value=countryid;
		document.forms[0].stateid.value=stateid;
		document.forms[0].cityid.value=cityid;
		document.forms[0].phone1.value=phone1;
		document.forms[0].phone2.value=phone2;
		document.forms[0].emailid.value=emailid;
		document.forms[0].zip.value=zip;
		document.forms[0].fax.value=fax;
		document.forms[0].btn.value="Update";
		
 }
function slctstate()
{
	document.forms[0].action="Customer.do?action=list";
		document.forms[0].submit();
}
function slctcity()
{
	document.forms[0].action="Customer.do?action=list";
		document.forms[0].submit();
}
</script>
<script type="text/javascript">

function validateForm()
{
	var cname=document.forms[0].customername.value;
	if (cname==null || cname=="")
	  {
	  alert("customer name must not be empty");
	  return false;
	  }
	var ca=document.forms[0].customer_accno.value;
	if (ca==null || ca=="")
	  {
	  alert("customer acc no. name must not be empty");
	  return false;
	  }
	var add1=document.forms[0].address1.value;
	if (add1==null || add1=="")
	  {
	  alert("address1 name must not be empty");
	  return false;
	  }
	var add2=document.forms[0].address2.value;
	if (add2==null || add2=="")
	  {
	  alert("address2 name must not be empty");
	  return false;
	  }
	var contry=document.forms[0].countryid.value;
	if (contry==-1 || contry=="")
	  {
	  alert("contry Id name must not be empty");
	  return false;
	  }
	var state=document.forms[0].stateid.value;
	if (state==-1 || state=="")
	  {
	  alert("state Id name must not be empty");
	  return false;
	  }
	var city=document.forms[0].cityid.value;
	if (city==-1 || city=="")
	  {
	  alert("city Id name must not be empty");
	  return false;
	  }
	var tele=document.forms[0].phone1.value;
	if (tele==null || tele=="")
	  {
	  alert("telephone no. must not be empty");
	  return false;
	  } 
	var mob=document.forms[0].phone2.value;
	if (mob==null || mob=="")
	  {
	  alert("mobile no. must not be empty");
	  return false;
	  } 
	var em=document.forms[0].emailid.value;
	if (em==null || em=="")
	  {
	  alert("email Id must not be empty");
	  return false;
	  } 
	var zp=document.forms[0].zip.value;
	if (zp==null || zp=="")
	  {
	  alert("ZIP must not be empty");
	  return false;
	  } 
	var fx=document.forms[0].fax.value;
	if (fx==null || fx=="")
	  {
	  alert("FAX must not be empty");
	  return false;
	  } 
	var acc = document.forms[0].customer_accno.value;
	if(!acc.match(/^[a-zA-Z0-9 ]*$/))
	{
		alert("Please enter only numerics and alphabets for acc no.");
		return false;
	}
	var p1 = document.forms[0].phone1.value;
	if(p1.match(/^\d+([0-9-()])$/))
	    {
	    alert("not valid telephone no.");
	    return false;
	    }
	var p2 = document.forms[0].phone2.value;
	if(!p2.match(/^\d{10}$/))
	    {
	    alert("not valid mobile no.");
	    return false;
	    }
var x=document.forms[0].emailid.value;
var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Not a valid e-mail address");
  return false;
  }

var z = document.forms[0].zip.value;
if(!z.match(/^\d+/))
    {
    alert("Please enter only numerics for zip code");
    return false;
    }
var f = document.forms[0].fax.value;
if(!f.match(/^\d+/))
    {
    alert("Please enter only numerics for fax");
    return false;
    }
}
function AllowAlphabet(){
               if (!document.forms[0].customername.value.match(/^[a-zA-Z ]*$/) && document.forms[0].customername.value !="")
               {
            	   document.forms[0].customername.value="";
            	   document.forms[0].customername.focus(); 
                    alert("Please Enter only alphabets in text field");
               }
} 
function fmtphone1(){
	re = /\D/g; // remove any characters that are not numbers
	socnum=document.forms[0].phone1.value.replace(re,"");
	sslen=socnum.length;
	if(sslen>3&&sslen<7){
		ssa=socnum.slice(0,3);
		ssb=socnum.slice(3,6);
		document.forms[0].phone1.value="("+ssa+")"+ssb;
	}else{
		if(sslen>6){
			ssa=socnum.slice(0,3);
			ssb=socnum.slice(3,6);
			ssc=socnum.slice(6,9);
			ssd=socnum.slice(9,10);
			document.forms[0].phone1.value="("+ssa+")"+ssb+"-"+ssc+ssd;
		}else{
			document.forms[0].phone1.value=socnum;
		}
	}
}

</script>
<style type="text/css">
<!--
.style1 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}
.style2 {
	color: #FFFFFF;
	font-size: 12px; 
	font-family: Verdana, Arial, Helvetica, sans-serif;
	line-height:20px;
}
-->
</style>
</head>
<body>
<div id="main">

<div id="header">
<div id="header1">

<a href="Logout.do"><img src="images/MasterData_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/MasterData_home.png" alt="Home" border="0"  /></a>
</div><!--header1-->

<table width="1000" align="center" cellpadding="0" cellspacing="0" class="para">

<tr>
<td width="255" height="70"></td>
<td width="402"></td>
<td width="341"></td>
</tr>
<tr>
<td align="left" style="padding-left:20px;"> Welcome <%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %></td>
 <td align="center"><img src="images/customermaster.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>


</div><!--header-->


<div id="content">

<table align="center">
			 	<tr><td><logic:notEmpty name="result">
					<font color="red"><bean:write name="result"></bean:write></font>
				</logic:notEmpty> </td></tr></table> 
  
 <table width="1000" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <tr height="50">
 
 <td colspan="15">
 <html:form action="/Customer.do?action=add" onsubmit="return validateForm();">
 <logic:notEmpty name="status">
<font color="blue"><bean:write name="status"></bean:write></font>
</logic:notEmpty>
<table>
<tr>
<td>
Customer Name:</td>
<td><html:text property="customername" onkeyup="AllowAlphabet()"></html:text> <html:hidden property="customerid" ></html:hidden></td>
<td>
Customer Acc No.:</td>
<td><html:text property="customer_accno"></html:text></td>

<td>
Address1:</td>
<td><html:text property="address1"></html:text></td>


<td>
Address2:</td>
<td><html:text property="address2"></html:text></td>
</tr>
<tr>
<td>
Country :</td>
<td>
<html:select property="countryid" onchange="slctstate()"  >
<html:option value="-1">--Select--</html:option>
<html:options collection="countryList" property="countryid" labelProperty="countryname" />
</html:select>
</td>
<td>
State :</td>
<td>
<html:select property="stateid" onchange="slctcity()" >
<html:option value="-1">--Select--</html:option>
<html:options collection="stateList" property="stateid" labelProperty="statename" />
</html:select>
</td>
<td>
City :</td>
<td>
<html:select property="cityid" >
<html:option value="-1">--Select--</html:option>
<html:options collection="cityList" property="cityid" labelProperty="cityname" />
</html:select>
</td>

<td>
Telephone No:</td>
<td><html:text property="phone1" onkeypress="fmtphone1();"></html:text></td>
</tr>
<tr>
<td>
Mobile No:</td>
<td><html:text property="phone2" maxlength="10"></html:text></td>
<td>
Email Id:</td>
<td><html:text property="emailid" ></html:text></td>
<td>
Zip:</td>
<td><html:text property="zip" maxlength="10"></html:text></td>


<td>
Fax:</td>
<td><html:text property="fax" maxlength="15"></html:text></td>
</tr>
<tr>
<td colspan="15">
 <input type="hidden" name="customer" id="textfield" />
 &nbsp;&nbsp; 
   &nbsp;&nbsp; <input type="submit"  name="btn"  value="Save" style="background:#666; color:#fff;"/>
   <input type="reset"  value="Reset" style="background:#666; color:#fff;"/>
   </td>
   </tr>
   </table>
 </td>
   
 </tr>
 
 </html:form>

 <logic:notEmpty name="customerList">
 <tr bgcolor="#999999" height="30" align="center" >
 <td ><b>Customer ID</b></td>
 <td><b>Customer Name</b></td>
 <td><b>Customer Acc No.</b></td>
<!--   <td><b>Address1</b></td>
 <td><b>Address1</b></td>
 <td><b>Country</b></td>
 <td><b>State</b></td> 
 <td><b>City</b></td>-->
 <td><b>Telephone No.</b></td>
 <td><b>Mobile No.</b></td>
 <td><b>Email Id </b></td>
 <!--<td><b>Zip</b></td>
 <td><b>Fax</b></td>-->
 <td><b>STATUS </b></td>
 <td><b>ACTION</b></td>
 </tr>
 <logic:iterate id="customer" name="customerList" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td> 

 <td><bean:write name="customer" property="customername"/></td>
 <td><bean:write name="customer" property="customer_accno"/></td>
  <!--<td><bean:write name="customer" property="address1"/></td>
 <td><bean:write name="customer" property="address2"/></td>
 <td><bean:write name="customer" property="countryid"/></td>
 <td><bean:write name="customer" property="stateid"/></td>   
 <td><bean:write name="customer" property="cityid"/></td>-->
 <td><bean:write name="customer" property="phone1"/>
 <td><bean:write name="customer" property="phone2"/></td>
 <td><bean:write name="customer" property="emailid"/>
  <!-- <td><bean:write name="customer" property="zip"/></td>
 <td><bean:write name="customer" property="fax"/>-->

 <td><logic:equal name="customer" property="active" value="true">
	  <font color="white">Active</font>
	 </logic:equal> 
	 
	 <logic:equal name="customer" property="active" value="false">
	 <font color="red">Inactive</font>
	 </logic:equal>
 </td>
 
 <td>
 <logic:equal name="customer" property="active" value="true">
							<a href='Customer.do?action=changestatus&amp;customerid=<bean:write name="customer" property="customerid"/>&amp;active=false' style="text-decoration:none;"  ><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
								&nbsp;&nbsp;
								<a href='#'	onclick='edit("<bean:write name="customer" property="customerid"/>","<bean:write name="customer" property="customername"/>","<bean:write name="customer" property="customer_accno"/>","<bean:write name="customer" property="address1"/>","<bean:write name="customer" property="address2"/>","<bean:write name="customer" property="countryid"/>","<bean:write name="customer" property="stateid"/>","<bean:write name="customer" property="cityid"/>","<bean:write name="customer" property="phone1"/>","<bean:write name="customer" property="phone2"/>","<bean:write name="customer" property="emailid"/>","<bean:write name="customer" property="zip"/>","<bean:write name="customer" property="fax"/>")' style="text-decoration:none" ><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
						     </logic:equal> 
						     <logic:equal name="customer" property="active" value="false">
							<a
								href='Customer.do?action=changestatus&amp;customerid=<bean:write name="customer" property="customerid"/>&amp;active=true' style="text-decoration:none;"><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
						</logic:equal> 
 </logic:iterate>
 </logic:notEmpty> 
 <logic:present name="customerList">
			<logic:empty name="customerList">
				No data added yet. 
			</logic:empty>
 </logic:present>

 
 <tr>
 <td></td>
 <td></td>
 <td></td>
 <td></td></tr>
 </table> 
  

</div><!--login1-->
</div><!--content-->

</div><!--main-->
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 Itech Solutions. All rights Reserved.</p>
</div><!--footer-->

</body>
</html>