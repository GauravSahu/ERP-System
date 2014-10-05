<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calendar Master</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />

<link href="<%=request.getContextPath() %>/calender/calendar.css" rel="stylesheet" type="text/css">
<script language="javaScript" type="text/javascript" src="<%=request.getContextPath() %>/calender/calendar.js"></script>

<script type="text/javascript">
function edit(caldayid,companyid)
{	
	alert(companyid);
    document.forms[0].action="CalenderType.do?action=update";
	//	document.forms[0].caldayid.options[document.forms[0].caldayid.selectedIndex].value=caldayid;
	//	document.forms[0].companyid.options[document.forms[0].companyid.selectedIndex].value=companyid;
    document.forms[0].caldayid.value=caldayid;
    document.forms[0].companyid.value=companyid;
    document.forms[0].submit;
}
</script>
<script type="text/javascript">
var dtCh= "-";
var minYear=1970;
var maxYear=2050;

function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++)
        {   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31;
		if (i==4 || i==6 || i==9 || i==11) {
			this[i] = 30;
			}
		if (i==2) 
			{
			this[i] = 29;
			}
   } 
   return this;
}

function isDate(dtStr){
	var daysInMonth = DaysArray(12);
	var pos1=dtStr.indexOf(dtCh);
	var pos2=dtStr.indexOf(dtCh,pos1+1);
	var strDay=dtStr.substring(0,pos1);
	var strMonth=dtStr.substring(pos1+1,pos2);
	var strYear=dtStr.substring(pos2+1);
	strYr=strYear;
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1);
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1);
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1);
	}
	month=parseInt(strMonth);
	day=parseInt(strDay);
	year=parseInt(strYr);
	if (pos1==-1 || pos2==-1){
		alert("The date format should be : dd-mm-yyyy");
		return false;
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("Please enter a valid month");
		return false;
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("Please enter a valid day");
		return false;
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear);
		return false;
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("Please enter a valid date");
		return false;
	}
return true;
}

function ValidateForm(){
	var dt=document.forms[0].date;
	if (isDate(dt.value)==false){
		dt.focus();
		return false;
	}
    return true;
 }

</script>
<script type="text/javascript">

function getDay()
{
var d = new Date();
var dat = document.getElementById('date').value;

var myDateParts = dat.split("-");
var dayNames = new Array('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday');
myNewDate = new Date(myDateParts[2], myDateParts[1]-1, myDateParts[0]);

//alert(myNewDate)
//alert(myNewDate.getDay());
//alert(dayNames[myNewDate.getDay()-1]);
document.getElementById('day').value= dayNames[myNewDate.getDay()-1];
}

function updatedaytype(url)
{
	window.open(url,"","toolbar=no,location=no,directories=no,menubar=no,scrollbars=yes,resizable=no,width=370,height=350,left=100,top=200"," ");
}
function validate()
{

	if(document.forms[0].companyid.value.trim()=="-1")
	{
		alert("Company cannot be empty");
		document.forms[0].companyid.focus();
		return false;
	}

	if(document.forms[0].date.value.trim()=="")
	{
		alert("Date cannot be empty");
		document.forms[0].date.focus();
		return false;
	}
	if(document.forms[0].day.value.trim()=="-1")
	{
		alert("Day cannot be empty");
		document.forms[0].day.focus();
		return false;
	}

	if(document.forms[0].caldayid.value.trim()=="-1")
	{
		alert("Day Type cannot be empty");
		document.forms[0].caldayid.focus();
		return false;
	}
	/*var dt = document.getElementById("date");
	if(!dt.value.match(/^[0-9]+[0-9-]+[0-9]+$/))
	{
	    alert('Date can only be numeric with hypen');
	    return false;
	}*/
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
		    %> 
			<%=ob%> 
			<%
 			}
 			%></td>
 	<td align="center"><img src="images/calendermaster.png" /></td>
	<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>

 <table id="calenderTable">
        <tbody id="calenderTableHead">
          <tr>
            <td colspan="4" align="center">
	          <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
	           this.selectedIndex, false));" id="selectMonth">
	              <option value="0">Jan</option>
	              <option value="1">Feb</option>
	              <option value="2">Mar</option>
	              <option value="3">Apr</option>
	              <option value="4">May</option>
	              <option value="5">Jun</option>
	              <option value="6">Jul</option>
	              <option value="7">Aug</option>
	              <option value="8">Sep</option>
	              <option value="9">Oct</option>
	              <option value="10">Nov</option>
	              <option value="11">Dec</option>
	          </select>
            </td>
            <td colspan="2" align="center">
			    <select onChange="showCalenderBody(createCalender(this.value, 
				document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
				</select>
			</td>
            <td align="center">
			    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
			</td>
		  </tr>
       </tbody>
       <tbody id="calenderTableDays">
         <tr style="">
           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
         </tr>
       </tbody>
       <tbody id="calender"></tbody>
	   </table>

</div><!--header-->


<div id="content">
<div id="city_content">
<table align="center">
			 	<tr><td><logic:notEmpty name="result">
					<font color="red"><bean:write name="result"></bean:write></font>
				</logic:notEmpty> </td></tr></table> 
  
 <table width="950" cellpadding="0" cellspacing="0" align="center" class="para" border="1" rules="all">
 <%
		ServletConfig config2 = getServletConfig();
	%>
 <html:form action="/CalenderType.do?action=add" >
 <logic:notEmpty name="status">
					<font color="blue"><bean:write name="status"></bean:write></font>
			</logic:notEmpty>
<tr>
<td>	
Company:
<html:select property="companyid" >
<html:option value="-1">--Select--</html:option>
<html:options collection="companyList" property="companyid" labelProperty="companyname" />
</html:select>
</td>
<td>
Date:

 <td width="130px" ><input  type="text" name="date"  size="10" id="date" value="" onchange="getDay()" onblur="return ValidateForm()" onfocus="if(this.value=='dd-mm-yyyy') this.value='';" onblur="if(this.value=='') this.value='dd-mm-yyyy';">
		   <a href="#" onClick="setYears(1970, 2050);
      				 showCalender(this, 'date');">
     			 <img src="<%=request.getContextPath() %>/calender/calender.png"></a>
		   </td>
 <td>
Day:</td>
<td>
<input name="day" id="day"  onfocus="getDay();" />
</td>
<td>
Day Type:
<html:select property="caldayid" >
<html:option value="-1">--Select--</html:option>
<html:options collection="cstatusList" property="caldayid" labelProperty="calendername" />
</html:select>
</td>
<td> <input type="submit"  name="btn"  value="Save" onclick="return validate()" style="background:#666; color:#fff;"/></td>
   <td><input type="reset"  value="Reset" style="background:#666; color:#fff;"/></td>
</tr>

  
 </html:form>
 
<html:form action="CalenderType.do?action=update">
 <logic:notEmpty name="calenderList">
 <tr bgcolor="#999999" height="30" align="center" >
 <td width="60"><b>Sl. No.</b></td>
 <td width="134"><b>Company</b></td>
 <td width="286"><b>Date</b></td>
 <td width="100"><b>Day </b></td>
 <td width="227"><b>Day Type </b></td>
 <td width="60"><b>Action</b></td>

 </tr>
 <logic:iterate id="calender" name="calenderList" indexId="index">
 <tr align="center" height="25">
 <td><%=index+1 %></td> 
 <td><bean:write name="calender" property="companyname"/><html:hidden property="companyid" name="calender"></html:hidden></td>
 <td><bean:write name="calender" property="date"/>
 <td><bean:write name="calender" property="day"/></td>
 <td><bean:write name="calender" property="caldaytypename"/></td>
  <td><a href="#" onclick="updatedaytype('<%config2.getServletContext().getRealPath("\\");%>CalenderType.do?action=dtypelist&cid=<bean:write name="calender" property="companyid"/>')">Change DayType</a></td>
<!-- <td><a href='#' onclick="return edit('<bean:write name="calender" property="caldayid"/>','<bean:write name="calender" property="companyid"/>')">Submit</a></td>  --> 
 </logic:iterate>
 </logic:notEmpty> 
 <logic:present name="calenderList">
			<logic:empty name="calenderList">
				No Data added yet. 
			</logic:empty>
 </logic:present>

</html:form>
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