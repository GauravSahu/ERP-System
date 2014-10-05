<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html:html>
<head profile="<%=request.getContextPath()%>">
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/homecalender.js"></script>
<script type="text/javascript" src="js/clinic.js"></script>
<title>Vendor_master</title>
<script type="text/javascript">

function edit(id,fname,lname,add,tno,mono,eid1,eid2,web,discount,tax){
	//alert("HI");
	//alert(id);
	//alert(fname);
	//alert(lname);
	//alert(add);
	//alert(tno);
	//alert(mono);
	//alert(eid1);
	//alert(eid2);
	//alert(web);
	//document.getElementById("status").innerHTML="";
	document.forms[0].action="Vendor.do?action=update";
	document.forms[0].vendorid.value=id;
	document.forms[0].firstname.value=fname;
	document.forms[0].lastname.value=lname;
	document.forms[0].address.value=add;
	document.forms[0].teleno.value=tno;
	document.forms[0].mobileno.value=mono;
	document.forms[0].emailid1.value=eid1;
	document.forms[0].emailid2.value=eid2;
	document.forms[0].website.value=web;	
	document.forms[0].discount.value=discount;	
	document.forms[0].tax.value=tax;	
	document.forms[0].btn1.value="Update";
	
}

function fmtphone1(){
	re = /\D/g; // remove any characters that are not numbers
	socnum=document.forms[0].teleno.value.replace(re,"");
	sslen=socnum.length;
	if(sslen>3&&sslen<7){
		ssa=socnum.slice(0,3);
		ssb=socnum.slice(3,6);
		document.forms[0].teleno.value="("+ssa+")"+ssb;
	}else{
		if(sslen>6){
			ssa=socnum.slice(0,3);
			ssb=socnum.slice(3,6);
			ssc=socnum.slice(6,9);
			ssd=socnum.slice(9,10);
			document.forms[0].teleno.value="("+ssa+")"+ssb+"-"+ssc+ssd;
		}else{
			document.forms[0].teleno.value=socnum;
		}
	}
}

function validemail1(){
	re =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/; 
	if(document.forms[0].emailid1.value.trim()!=""){
		if (document.forms[0].emailid1.value.search(re)== -1) {
			alert("Please Enter valid Email Id");
			document.forms[0].emailid1.value = "";
			document.forms[0].emailid1.focus();
		}
	}	
}

function validemail2(){
	re =/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/; 
	if(document.forms[0].emailid2.value.trim()!=""){
		if (document.forms[0].emailid2.value.search(re)== -1) {
			alert("Please Enter valid Email Id");
			document.forms[0].emailid2.value = "";
			document.forms[0].emailid2.focus();
		}
	}	
}

function focus2()
{
document.getElementById('status').innerHTML="";
document.forms[0].clinicid.value="";
document.forms[0].action="Vendor.do?action=add";
document.forms[0].btn1.value="Save";
document.forms[0].clinicname.focus();
document.getElementById('status').innerHTML="";
}

function slctcity()
{
	document.forms[0].action="Vendor.do?action=list";
	document.forms[0].submit();
}


/*Ajax script start for saving 
error to database
*/
var request;
   
  function slctcity1111(obj) {
	alert(obj);
	
	var url="http://192.168.1.9:8080/FMS/Vendor.do?action=list&cityid="+obj;
	alert(url);
    // Perform the AJAX request using a non-IE browser.
    if (window.XMLHttpRequest) {
        alert("sdfvsd");
      request = new XMLHttpRequest();
      // Register callback function that will be called when
      // the response is generated from the server.
      request.onreadystatechange = updateCount;
      try {
          	alert("try");
      		request.open("POST", url,true);
      } catch (e) {
         alert("Unable to connect to server to retrieve count.");
      }
   
      request.send(null);
    // Perform the AJAX request using an IE browser.
    } else if (window.ActiveXObject) {
      request = new ActiveXObject("Microsoft.XMLHTTP");
      if (request) {
        // Register callback function that will be called when
        // the response is generated from the server.
        request.onreadystatechange = updateCount;
        request.open("GET", url, true);
        request.send();
      }
    }
  
 }
  
   
  // Callback function to update page with count retrieved from server.
  function updateCount() {
    if (request.readyState == 4) {
      if (request.status == 200) {
        var count = request.responseText;
   
        document.getElementById('employeeCount').innerHTML = count;
      } else {
        alert("Unable to retrieve count from server.");
      }
    }
  }



function slctarea()
{
	document.forms[0].action="Vendor.do?action=list";
	document.forms[0].submit();
}

function validate(){
	if(document.forms[0].firstname.value.trim()==""){
		alert("First Name cannot be empty");
		document.forms[0].firstname.focus();
		return false;
	}
	if(document.forms[0].lastname.value.trim()==""){
		alert("Last Name cannot be empty");
		document.forms[0].lastname.focus();
		return false;
	}
	
	if(document.forms[0].teleno.value==""){
		alert("Telephone Number cannot be empty");
		document.forms[0].teleno.focus();
		return false;
	}
	if(document.forms[0].mobileno.value.trim()==""){
		alert("Mobile Number cannot be empty");
		document.forms[0].mobileno.focus();
		return false;
	}
	if(document.forms[0].emailid1.value.trim()==""){
		alert("EmailID1 cannot be empty");
		document.forms[0].emailid1.focus();
		return false;
	}
	if(document.forms[0].emailid2.value.trim()==""){
		alert("EmailID2 cannot be empty");
		document.forms[0].emailid2.focus();
		return false;
	}
	if(document.forms[0].website.value.trim()==""){
		alert("Website cannot be empty");
		document.forms[0].website.focus();
		return false;
	}
	
	if(document.forms[0].address.value==""){
		alert("Address cannot be empty");
		document.forms[0].address.focus();
	    return false;
	}
	 if (!document.forms[0].firstname.value.match(/^[a-zA-Z ]*$/) && document.forms[0].firstname.value !="")
	    {
	 	   document.forms[0].firstname.value="";
	 	   document.forms[0].firstname.focus(); 
	         alert("Please Enter only alphabets in first name text field");
	         return false;   
	    }
	    
	 if (!document.forms[0].lastname.value.match(/^[a-zA-Z ]*$/) && document.forms[0].lastname.value !="")
	    {
	 	   document.forms[0].lastname.value="";
	 	   document.forms[0].lastname.focus(); 
	         alert("Please Enter only alphabets in last name text field");
	         return false;   
	    }
	 var z = document.forms[0].teleno.value;
	 if(!y.match(/^\d{10}$/))
		    {
		    alert("not valid telephone no.");
		    return false;
		    }
		var y = document.forms[0].mobileno.value;
		if(!y.match(/^\d{10}$/))
		    {
		    alert("not valid mobile no.");
		    return false;
		    }
	return true;
}
</script>
</head>
<body onload="goforit(); focus1(document.forms[0].clinicname)"
	onpageshow="if (event.persisted) noBack();">
	
<div id="wraper">
<div id="header">

<div id="header1">
  	
 <a href="Logout.do"><img src="images/MasterData_logout.png" alt="logout" border="0" /></a>&nbsp;<a href="admhome.jsp"><img src="images/MasterData_home.png" alt="Home" border="0"  /></a>   

 </div><!--header1-->  	
 
  <table width="1000" align="center" cellpadding="0" cellspacing="0" class="para">

<tr>
<td width="255" height="70"></td>
<td width="402"></td>
<td width="341"></td>
</tr>
<tr>
<td align="left" style="padding-left:20px;"> Welcome  <%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %></td>
<td align="center"><img src="images/vendormaster.png" /></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>
</div><!--header-->

   
	
 <div id="content" style="overflow:scroll;">
<div id="vendor_content">
<html:form action="/Vendor.do?action=add">
<logic:notEmpty name="status">
					<font color="blue"><bean:write name="status"></bean:write></font>
				</logic:notEmpty>
<table width="950" border="0" cellspacing="0" cellpadding="0" align="center" class="para">
  <tr>
    
        <td height="39" align="right">State</td>
        <td>:</td>
        <td align="left"><html:select property="stateid"
						styleClass="select1" onchange="slctcity()" style="width:120px;">
						<html:option value="-1">--Select State--</html:option>
						<html:options collection="stateList" property="stateid"
							labelProperty="statename"/>
					</html:select></td>
    
    
        <td width="98" align="right">City</td>
        <td width="10">:</td>
        <td  align="left"><html:select property="cityid"
						styleClass="select1" onchange="slctarea()" style="width:120px;">
						<html:option value="-1">--Select City--</html:option>
						<html:options collection="cityList" property="cityid"
							labelProperty="cityname"/>
					</html:select></td>
     
    
     
    

        <td>First Name</td>
        <td>:</td>
        <td><input type="text" name="firstname" id="textfield" style="width:120px;"/>  <input type="hidden" name="vendorid" /></td>
       
        
         <td>Last Name</td>
        <td>:</td>
        <td align="left"><input type="text" name="lastname" style="width:120px;"/></td>
   </tr>
   <tr>
       
      
        <td>Telephone No</td>
        <td>:</td>
        <td align="left"><input type="text" name="teleno" id="teleno" style="width:120px;"/></td>
   
        <td align="right">Mobile No</td>
        <td>:</td>
        <td align="left"><input type="text" name="mobileno" id="mobileno"
						onkeypress="return isNumberKey(event)" maxlength="12" style="width:120px;" /></td>
		<td>Email ID 1</td>
        <td>:</td>
        <td><input type="text" name="emailid1" id="emailid1" onblur="validemail1();" style="width:120px;"/></td>
        
        <td height="39">Email ID 2</td>
        <td>:</td>
        <td align="left"><input type="text" name="emailid2" id="emailid2" onblur="validemail2();" style="width:120px;"/></td>				
      </tr>
   
      <tr>
        
        <td>Website</td>
        <td>:</td>
        <td align="left"><input type="text" name="website" id="website" style="width:120px;" /></td>
         <td align="right">Address</td>
        <td>:</td>
        <td align="left"><input type="text" name="address" id="address" style="width:120px;"/></textarea></td>
        
        <td>Discount</td>
        <td>:</td>
        <td align="left"><input type="text" name="discount" id="discount" style="width:120px;"/>
        </td>
        
        <td>Tax %</td>
        <td>:</td>
        <td align="left"><input type="text" name="tax" id="tax" style="width:120px;"/> 
        </td>
        
      <tr align="center" colspan="100">
      <td>
      <input type="submit" name="btn1" id="button" value="Submit" onclick="return validate()" style="background:#666; color:#fff;"/>
      <input type="reset" value="Reset" onclick="focus2()" style="background:#666; color:#fff;"/> 
   </td>
   </tr>
</table>
</html:form>
		<hr />
		<logic:notEmpty name="vendorList">
			<table cellpadding="2" border="1" rules="all" width="100%"	style="table-layout: fixed;" align="center" >
					<tr class="para" bgcolor="#999999">
					<th width="10%">Sl. No.</th>
					<th width="30%">Name</th>
					<th width="30%">Mobile Number</th>
					<th width="30%">Email id</th>
					<th width="10%">Status</th>
					<th width="15%">Action</th>
				</tr>
				<logic:iterate id="vendor" name="vendorList" indexId="index">
					<tr class="para" >
						<td align="center" style="color: black"><%=index + 1%></td>
						<td align="left" style="color: black"><bean:write
							name="vendor" property="vendorname" /></td>
							<td align="left" style="color: black"><bean:write
							name="vendor" property="mobileno" /></td>
							<td align="left" style="color: black"><bean:write
							name="vendor" property="emailid1" /></td>
						<td align="center"><logic:equal name="vendor"
							property="active" value="true">
							<font color="green">Active</font>
						</logic:equal> <logic:equal name="vendor" property="active" value="false">
							<font color="red">Inactive</font>
						</logic:equal></td>
						<td align="center"><logic:equal name="vendor"
							property="active" value="true">
							<a
								href='Vendor.do?action=changestatus&amp;vendorid=<bean:write name="vendor" property="vendorid"/>&amp;active=false'><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
							<a href='#'
								onclick='edit("<bean:write name="vendor" property="vendorid"/>","<bean:write name="vendor" property="firstname"/>","<bean:write name="vendor" property="lastname"/>","<bean:write name="vendor" property="address"/>","<bean:write name="vendor" property="teleno"/>","<bean:write name="vendor" property="mobileno"/>","<bean:write name="vendor" property="emailid1"/>","<bean:write name="vendor" property="emailid2"/>","<bean:write name="vendor" property="website"/>" ,"<bean:write name="vendor" property="discount"/>" ,"<bean:write name="vendor" property="tax"/>")'><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
						</logic:equal> <logic:equal name="vendor" property="active" value="false">
							<a
								href='Vendor.do?action=changestatus&amp;vendorid=<bean:write name="vendor" property="vendorid"/>&amp;active=true'><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
						</logic:equal>&nbsp;</td>
					</tr>
				</logic:iterate>
			</table>
		</logic:notEmpty> <logic:present name="vendorList">
			<logic:empty name="vendorList">
				No Vendor is added yet. 
			</logic:empty>
		</logic:present>
		</div>
</div><!--content-->
</div><!--wraper-->

    <div style="clear:both;"> </div>

<div id="footer" >
<p align="left" class="style2">Copyright © 2013 Itech Solutions. All rights Reserved.</p>
</div><!--footer-->

</body>
</html:html>