<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Master</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function edit(userid,username,password,firstname,lastname,phone1,phone2,emailid,ssn,roleid,companyid,myDate,age1,fathername,mothername,doj,salaryaccountnumber,bankid,emercontnumber,presentadd,permadd,spousename,spouseage,spouseeducadet,spousejobdetails,childdetails,depeparentdetails)
{	
      //  alert(userid);    
      //  alert(username);
      alert(presentadd);
	 // document.getElementById("status").innerHTML="";
		document.forms[0].action="User.do?action=update";
		document.forms[0].depeparentdetails.value=depeparentdetails;
		document.forms[0].spousename.value=spousename;
		document.forms[0].spouseage.value=spouseage;
		document.forms[0].spouseeducadet.value=spouseeducadet;   
		document.forms[0].spousejobdetails.value=spousejobdetails;
		document.forms[0].childdetails.value=childdetails;
		document.forms[0].presentadd.value=presentadd;
		document.forms[0].permadd.value=permadd;
		document.forms[0].bankid.value=bankid;
		document.forms[0].emercontnumber.value=emercontnumber;
		document.forms[0].doj.value=doj;
		document.forms[0].salaryaccountnumber.value=salaryaccountnumber;   
		document.forms[0].age1.value=age1;
		document.forms[0].fathername.value=fathername;
		document.forms[0].mothername.value=mothername;
		document.forms[0].userid.value=userid;
		document.forms[0].username.value=username;
		document.forms[0].password.value=password;
		document.forms[0].firstname.value=firstname;
		document.forms[0].lastname.value=lastname;
		document.forms[0].phone1.value=phone1;   
		document.forms[0].phone2.value=phone2;
		document.forms[0].emailid.value=emailid;
		document.forms[0].ssn.value=ssn;
		document.forms[0].roleid.value=roleid;
		document.forms[0].companyid.value=companyid;
		document.forms[0].myDate.value=myDate;
		document.forms[0].btn.value="Update";
 }
</script>
<script type="text/javascript">
function validateForm()
{
	var x=document.forms[0].username.value;
	if (x==null || x=="")
	  {
	  alert("user name must not be empty");
	  return false;
	  }

	var salacc=document.forms[0].salaryaccountnumber.value;
	alert(salacc);
	if (salacc==null || salacc=="")
	  {
	  alert("salary account number must not be empty");
	  return false;
	  } 
  
	var pwd=document.forms[0].password.value;
	if (pwd==null || pwd=="")
	  {
	  alert("password must not be empty");
	  return false;
	  }
	  
	var fname=document.forms[0].firstname.value;
	if (fname==null || fname=="")
	  {
	  alert("first name must not be empty");
	  return false;
	  } 
	  
	var lname=document.forms[0].lastname.value;
	if (lname==null || lname=="")
	  {
	  alert("last name must not be empty");
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
	
	var role=document.forms[0].roleid.value;
	if (role==-1 || role=="")
	  {
	  alert("Role must not be empty");
	  return false;
	  } 

	  var designation = document.forms[0].desiid.value;
	  if(designation==-1 || designation=="")
	  {
		  alert("designation must not be empty");
		  return false;
	  }

	  var doj = document.forms[0].doj.value;
	  if(doj==null || doj=="")
	  {
		  alert("date of joing must not be empty");
		  return false;
	  }
	  
     // var status = document.forms[0].gender.value;
     var status = document.getElementById("gender").checked;
      alert(status);
      if(status==null)
      {
          alert("please select the maritial status");
          return false;
      }
	  
	var company=document.forms[0].companyid.value;
	if (company==-1 || company=="")
	  {
	  alert("company must not be empty");
	  return false;
	  } 

	  var approver = document.forms[0].appId,value;
	  if(approver==-1 || approver=="")
	  {
		  alert("please select approver name ");
	  }

	var bank = document.forms[0].bankid.value;
	if(bank==-1 || bank=="")
	{
		alert("please select bank name");
	}
	  
	var z = document.forms[0].phone1.value;
	if(z.match(/^\d+([0-9-()])$/))
	    {
	    alert("not valid telephone no.");
	    return false;
	    }
	var y = document.forms[0].phone2.value;
	if(!y.match(/^\d{10}$/))
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

}      

function validDOB(){

	
	String.prototype.trim = function() {
	    return this.replace(/^\s+|\s+$/g,"");
	};
	var dateId=document.forms[0].dob.value;
	
	if(dateId.trim()!=""){ 
		
		var datestr=dateId;
		var dstr=datestr.substring (0,2);  
		var mstr=datestr.substring (3,5);
		var ystr=datestr.substring (6,10);
		var ystr1 = Number(ystr)+ Number(16);
		var dstr1 = Number(dstr)+ Number(1);
		var dt = new Date(mstr+"/"+dstr1+"/"+ystr1);
		var crtdate= new Date();
	       
		alert("dfjjkjg"+dt);
		
	}
}


function validatedate(inputText)  
{  
var dateformat = /^(0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])[\/\-]\d{4}$/;  
// Match the date format through regular expression  
if(inputText.value.match(dateformat))  
{  
document.form1.text1.focus();  
//Test which seperator is used '/' or '-'  
var opera1 = inputText.value.split('/');  
var opera2 = inputText.value.split('-');  
lopera1 = opera1.length;  
lopera2 = opera2.length;  
// Extract the string into month, date and year  
if (lopera1>1)  
{  
var pdate = inputText.value.split('/');  
}  
else if (lopera2>1)  
{  
var pdate = inputText.value.split('-');  
}  
var mm  = parseInt(pdate[0]);  
var dd = parseInt(pdate[1]);  
var yy = parseInt(pdate[2]);  
// Create list of days of a month [assume there is no leap year by default]  
var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];  
if (mm==1 || mm>2)  
{  
if (dd>ListofDays[mm-1])  
{  
alert('Invalid date format!');  
return false;  
}  
}  
if (mm==2)  
{  
var lyear = false;  
if ( (!(yy % 4) && yy % 100) || !(yy % 400))   
{  
lyear = true;  
}  
if ((lyear==false) && (dd>=29))  
{  
alert('Invalid date format!');  
return false;  
}  
if ((lyear==true) && (dd>29))  
{  
alert('Invalid date format!');  
return false;  
}  
}  
}  
else  
{  
alert("Invalid date format!");  
document.form1.text1.focus();  
return false;  
}  
}  

</script>
<script type="text/javascript">
function AllowAlphabet(){
    if (!document.forms[0].username.value.match(/^[a-zA-Z ]*$/) && document.forms[0].username.value !="")
    {
 	   document.forms[0].username.value="";
 	   document.forms[0].username.focus(); 
         alert("Please Enter only alphabets in text field");
         return false;   
    }
    if (!document.forms[0].firstname.value.match(/^[a-zA-Z ]*$/) && document.forms[0].firstname.value !="")
    {
 	   document.forms[0].firstname.value="";
 	   document.forms[0].firstname.focus(); 
         alert("Please Enter only alphabets in text field");
         return false;   
    }
    if (!document.forms[0].lastname.value.match(/^[a-zA-Z ]*$/) && document.forms[0].lastname.value !="")
    {
 	   document.forms[0].lastname.value="";
 	   document.forms[0].lastname.focus(); 
         alert("Please Enter only alphabets in text field");
         return false;   
    }

    if (!document.forms[0].fathername.value.match(/^[a-zA-Z ]*$/) && document.forms[0].fathername.value !="")
    {
 	   document.forms[0].fathername.value="";
 	   document.forms[0].fathername.focus(); 
         alert("Please Enter only alphabets in text field");
         return false;   
    }

    if (!document.forms[0].mothername.value.match(/^[a-zA-Z ]*$/) && document.forms[0].mothername.value !="")
    {
 	   document.forms[0].mothername.value="";
 	   document.forms[0].mothername.focus(); 
         alert("Please Enter only alphabets in text field");
         return false;   
    } 

    if (!document.forms[0].spousename.value.match(/^[a-zA-Z ]*$/) && document.forms[0].spousename.value !="")
    {
 	   document.forms[0].spousename.value="";
 	   document.forms[0].spousename.focus(); 
         alert("Please Enter only alphabets in text field");
         return false;   
    } 
    
}

function checkPassword(){
	if(!document.forms[0].password.value.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,20}$/)&& document.forms[0].password.value!="")
	{
		document.forms[0].password.value="";
		document.forms[0].password.focus();
		alert("password should be min 8 characters,min 1 capital letter,small letter, numeric & special character");
		return false;
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


function check8(ctrl)
{
   document.getElementById('info1').style.display = (ctrl.checked) ? "":"none";
}
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode != 46 && charCode > 31 
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
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

<script type="text/javascript">
function myAgeValidation() {
	 
    var lre = /^\s*/;
    var datemsg = "";
  // alert( document.forms[0].myDate.value);
    var inputDate = document.forms[0].myDate.value;
    inputDate = inputDate.replace(lre, "");
    document.forms[0].myDate.value = inputDate;
    datemsg = isValidDate(inputDate);
        if (datemsg != "") {
           //alert(datemsg);
            return false;
        }
        else {
            //Now find the Age based on the Birth Date
            getAge(new Date(inputDate));
        }
 
}
 
function getAge(birth) {
 
    var today = new Date();
    var nowyear = today.getFullYear();
    var nowmonth = today.getMonth();
    var nowday = today.getDate();
 
    var birthyear = birth.getFullYear();
    var birthmonth = birth.getMonth();
    var birthday = birth.getDate();
 
    var age = nowyear - birthyear;
    var age_month = nowmonth - birthmonth;
    var age_day = nowday - birthday;
    
    if(age_month < 0 || (age_month == 0 && age_day <0)) 
        {
            age = parseInt(age) -1;
            document.getElementById('age1').value=age;
        }

}
 
function isValidDate(dateStr) {
 
    
    var msg = "";
    // Checks for the following valid date formats:
    // MM/DD/YY   MM/DD/YYYY   MM-DD-YY   MM-DD-YYYY
    // Also separates date into month, day, and year variables
 
    // To require a 2 & 4 digit year entry, use this line instead:
    //var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{2}|\d{4})$/;
    // To require a 4 digit year entry, use this line instead:
    var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{4})$/;
 
    var matchArray = dateStr.match(datePat); // is the format ok?
    if (matchArray == null) {
        msg = "Date is not in a valid format.";
        alert(msg);
        //return msg;
    }
 
    month = matchArray[1]; // parse date into variables
    day = matchArray[3];
    year = matchArray[4];
 
    
    if (month < 1 || month > 12) { // check month range
        msg = "Month must be between 1 and 12.";
        return msg;
    }
 
    if (day < 1 || day > 31) {
        msg = "Day must be between 1 and 31.";
        return msg;
    }
 
    if ((month==4 || month==6 || month==9 || month==11) && day==31) {
        msg = "Month "+month+" doesn't have 31 days!";
        return msg;
    }
 
    if (month == 2) { // check for february 29th
    var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    if (day>29 || (day==29 && !isleap)) {
        msg = "February " + year + " doesn't have " + day + " days!";
        return msg;
    }
    }
 
    if (day.charAt(0) == '0') day= day.charAt(1);
    
    //Incase you need the value in CCYYMMDD format in your server program
    //msg = (parseInt(year,10) * 10000) + (parseInt(month,10) * 100) + parseInt(day,10);
    
    return msg;  // date is valid
}

</script>

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
 <td align="center"><img src="images/usermaster.png" /></td>
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
 
 <td colspan="13">
 <html:form action="/User.do?action=add" onsubmit="return validateForm();">
 <logic:notEmpty name="status">
<font color="blue"><bean:write name="status"></bean:write></font>
</logic:notEmpty>
<table>
<tr>
<td>
User Name :</td>
<td><html:text property="username" onkeyup="AllowAlphabet()"></html:text> <html:hidden property="userid" ></html:hidden></td>
<td>
Password :</td>
<td><html:password property="password" ></html:password></td>
<td>
First Name :</td>
<td><html:text property="firstname" onkeyup="AllowAlphabet()"></html:text></td>

</tr>
<tr>
<td>
Last Name :</td>
<td><html:text property="lastname" onkeyup="AllowAlphabet()"></html:text></td>
<td>
Date of Birth(MM/DD/YYYY) :
</td>
<td>
<input type="text" name="myDate" size=10 maxlength=10 >
</td>

<td>
Age :
</td>
<td>
<input type="text" name="age1" id="age1" size="10" maxlength="10"  value=" " readonly="readonly"></input>
</td>


</tr>
<tr>
<td>
Father Name :
</td>
<td>
<html:text property="fathername" onkeyup="AllowAlphabet()"></html:text>
</td>

<td>
Mother Name :
</td>
<td>
<html:text property="mothername" onkeyup="AllowAlphabet()"></html:text>
</td>
<td>
Date of Joining :
</td>
<td>
 <input type="text" name="doj" value="" id="calendar2" class="calendarFocus" />
</td>

</tr>
<tr>
<td>
Salary Account Number :
</td>
<td>
<input type="text" name="salaryaccountnumber" onfocus="Javascript:myAgeValidation()" onkeypress="return isNumberKey(event)"></input>

</td>
<td>
Bank Name : 
</td>
<td>
<html:select property="bankid" >
<html:option value="-1">--Select--</html:option>
<html:options collection="banklist" property="bankid" labelProperty="bankname" />
</html:select>
</td>
<td>
Emergency Contact Number : 
</td>
<td>
<html:text property="emercontnumber" onkeypress="return isNumberKey(event)"></html:text>
</td>
<tr>
<td>Telephone No:</td>
<td><html:text property="phone1" onkeypress="return isNumberKey(event)"></html:text></td>
<td>
Mobile No:</td>
<td><html:text property="phone2" maxlength="10" onkeypress="return isNumberKey(event)"></html:text></td>
<td>
Email Id:</td>
<td><html:text property="emailid"></html:text></td>
</tr>

</tr>

<tr>
<td>
Present Address:</td>
<td><html:text property="presentadd"></html:text></td>

<td>
Permanent address :
</td>
<td>
<html:text property="permadd"></html:text>
</td>

<td>
Role :</td>
<td>
<html:select property="roleid" >
<html:option value="-1">--Select--</html:option>
<html:options collection="roleList" property="roleid" labelProperty="rolename" />
</html:select>
</td>
</tr>

<tr>
<td>
Designation : 
</td>
<td>
<html:select property="desiid" >
<html:option value="-1">--Select</html:option>
<html:options collection="desilist" property="desiid" labelProperty="desiname" />
</html:select>
</td>

<td>
Approver :</td>
<td>
<html:select property="appId" >
<html:option value="-1">--Select--</html:option>
<html:options collection="approveList" property="appId" labelProperty="approver" />
</html:select>
</td>

<td>
Martial Status : 
</td>

       <td>
	   <input type="radio" name="gender" id="gender" value="Single" >Single
	    <input type="radio" name="gender"  id="gender" value="Married">Married
	    <input type="radio" name="gender" id="gender" value="Divorced">Divorced
	    </td>
	       
	       		
	      
</tr>

<tr>
<td>Spouse Name<input type="text" name="spousename" onkeyup="AllowAlphabet()">
 </td>
<td>Spouse Age<input type="text" name="spouseage"  onkeypress="return isNumberKey(event)">
</td>
<td>Spouse Education Qualification<input type="text" name="spouseeducadet"  onkeypress="return isNumberKey1(event)">
</td>

</tr>
<tr>
<td>Spouse Job Details<input type="text" name="spousejobdetails"  onkeypress="return isNumberKey1(event)">
</td>
<td>
Number of children, Name and age : 
<input type="text" name = "childdetails"></input>
</td>
<td>
Dependent parent details:
<input type="text" name="depeparentdetails" value=""></input>
</td> 
</tr>
<tr>
<td>Employee ID: 
<input type="text" name="employeeid" value=" "/>
</td>
<td>
PANCARD NUMBER : 
<input type="text" name ="pancardnumber" value=" "></input>
</td>
<td>
PF Details:
<input type="text" name="pfdetails" value=""></input>
</td> 
</tr>

<tr>
<td>Blood Group

<select name="bloodgroup">
<option value="-1">Select Blood Group</option>
<option value="A+">A+</option>
<option value="O+">O+</option>
<option value="B+" selected>B+</option>
<option value="AB+">AB+</option>
<option value="A-">A-</option>
<option value="O-">O-</option>
<option value="B-" selected>B-</option>
<option value="AB-">AB-</option>
</select>
</td>
</tr>

<tr height="20"> <td colspan="6"></td></tr>
<tr>
<td colspan="6">
 <input type="hidden" name="user" id="textfield" />
 &nbsp;&nbsp; 
   &nbsp;&nbsp; 
  
   
   <input type="submit"  name="btn"  value="Save" style="background:#666; color:#fff;" onclick="checkPassword();" />
   <input type="reset"  value="Reset" style="background:#666; color:#fff;"/>   
      <a href="uploaddoc.jsp">upload documents</a>
   
   </td>
   </tr>
   <tr height="20"> <td colspan="6"></td></tr>
   </table>
 </td>
   
 </tr>
 
 </html:form>

 <logic:notEmpty name="userList">
 <tr bgcolor="#999999" height="30" align="center" >
 <td ><b>User ID</b></td>
 <td><b>User Name</b></td>
 <td><b>First Name </b></td>
 <td><b>Last Name</b></td>
  <td><b>Telephone No.</b></td> 
 <td><b>Mobile No.</b></td>
 <td><b>Email Id </b></td>

  <!-- <td><b>Role</b></td>
 <td><b>Company</b></td> -->
 <td><b>STATUS </b></td>
 <td><b>ACTION</b></td>
 </tr>
 <logic:iterate id="user" name="userList" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td> 
 
 <td><bean:write name="user" property="username"/></td>
 <td><bean:write name="user" property="firstname"/>
 <td><bean:write name="user" property="lastname"/></td>
 <td><bean:write name="user" property="phone1"/>
  <td><bean:write name="user" property="phone2"/></td>
 <td><bean:write name="user" property="emailid"/>
  
<!--   <td><bean:write name="user" property="roleid"/></td>
 <td><bean:write name="user" property="companyid"/>-->

 <td><logic:equal name="user" property="active" value="true">
	  <font color="white">Active</font>
	 </logic:equal> 
	 
	 <logic:equal name="user" property="active" value="false">
	 <font color="red">Inactive</font>
	 </logic:equal>
 </td>
 
 <td>
 <logic:equal name="user" property="active" value="true">
<a href='User.do?action=changestatus&amp;userid=<bean:write name="user" property="userid"/>&amp;active=false' style="text-decoration:none;"  ><input type="submit"  value="Remove" style="background:#666; color:#fff;"/></a>
								&nbsp;&nbsp;
<a href='#'	onclick='edit("<bean:write name="user" property="userid"/>","<bean:write name="user" property="username"/>","<bean:write name="user" property="password"/>","<bean:write name="user" property="firstname"/>","<bean:write name="user" property="lastname"/>","<bean:write name="user" property="phone1"/>","<bean:write name="user" property="phone2"/>","<bean:write name="user" property="emailid"/>","<bean:write name="user" property="ssn"/>","<bean:write name="user" property="roleid"/>","<bean:write name="user" property="companyid"/>","<bean:write name="user" property="myDate"/>","<bean:write name="user" property="age1"/>","<bean:write name="user" property="fathername"/>","<bean:write name="user" property="mothername"/>","<bean:write name="user" property="doj"/>","<bean:write name="user" property="salaryaccountnumber"/>","<bean:write name="user" property="bankid"/>","<bean:write name="user" property="emercontnumber"/>","<bean:write name="user" property="presentadd"/>","<bean:write name="user" property="permadd"/>","<bean:write name="user" property="spousename"/>","<bean:write name="user" property="spouseage"/>","<bean:write name="user" property="spouseeducadet"/>","<bean:write name="user" property="spousejobdetails"/>","<bean:write name="user" property="childdetails"/>","<bean:write name="user" property="depeparentdetails"/>")' style="text-decoration:none" ><input type="submit"  value="Edit" style="background:#666; color:#fff;"/></a>
						     </logic:equal> 
						     <logic:equal name="user" property="active" value="false">
							<a href='User.do?action=changestatus&amp;userid=<bean:write name="user" property="userid"/>&amp;active=true' style="text-decoration:none;"><input type="submit"  value="Activate" style="background:#666; color:#fff;"/></a>
						</logic:equal> 
 </logic:iterate>
 </logic:notEmpty> 
 <logic:present name="userList">
			<logic:empty name="userList">
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
<div style="clear:both"></div>
<div id="footer">
<p align="left" class="style2">Copyright © 2013 Itech Solutions. All rights Reserved.</p>
</div><!--footer-->
</div><!--content-->
</body>
</html>