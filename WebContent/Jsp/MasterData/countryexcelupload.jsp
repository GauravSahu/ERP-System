<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-nested.tld" prefix="nested"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Excel File</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function validateFileUpload(obj)
{ 
	//alert("asfasf");
	var fileName = new String();  
    var fileExtension = new String();  
   //  var obj =  document.forms[1].uploadFile;
    // store the file name into the variable  
    fileName = obj;  
      
    // extract and store the file extension into another variable  
    fileExtension = fileName.substr(fileName.length - 3, 3);  
      
    // array of allowed file type extensions  
    var validFileExtensions = new Array("xls", "xlsx","csv");  
      
    var flag = false;  
    
    // loop over the valid file extensions to compare them with uploaded file  
    for(var index = 0; index < validFileExtensions.length; index++){  
        if(fileExtension.toLowerCase() == validFileExtensions[index].toString().toLowerCase()){  
            flag = true;  
        }  
    }  
      
    // display the alert message box according to the flag value 
   
    if(flag == false){  
       document.getElementById('uploadFile').value = "";
	//	document.getElementById('status').innerHTML='Files with extension ".' + fileExtension.toUpperCase() + '" are not allowed. You can upload the files with following extensions only:.mp3 .wav .mp4 .wma';
	//	document.getElementById('status').style.color="red";
	    alert('Files with extension ".' + fileExtension.toUpperCase() + '" are not allowed.\n\nYou can upload the files with following extension only:\n.xls\n.xslx\n .csv');  
        return false;  
    }  
    else         
        return true;  
	}

function validate()
{
	 // alert("asdfvad");
	  if(document.getElementById('uploadFile').value == "")
	  {
		  alert("Select a file to upload !..");
		  return false;
	  }
	  return true;
	 
}
function resetit(){
	document.forms[0].action="ExcelUpload.do";
	document.forms[0].submit();
}
</script>
</head>
<body>
<div id="wraper">
<div id="header">
<div id="logo"></div>
</div>

<hr></hr>
<div>
<logic:notEmpty name="status">
<font color="red" class="para"><bean:write name="status"/></font>
</logic:notEmpty>
</div>
<form action="UploadCountry" method="post" enctype="multipart/form-data">
<table class="para">
<tr>
<th align="center" height="40">
		<p class="search">Please Upload Exact File format of Country Master:</p>
		</th>
		
			<td align="center"><input type="file" name="uploadFile"
				id="uploadFile" accept="application/vnd.ms-excel"
				onchange="return validateFileUpload(this.value)" />
			
			</td>
		</tr>
		<tr>
		<td colspan="2" align="center">
		<input type="submit" name="Upload File" value="Upload" onclick='return validate();' class="button" style="background:#525151; background-repeat:no-repeat; width:64px; height:20px; border:none; color:#fff; font:bold 12px Verdana;"/>
		<input type="reset" value="Reset" onclick="return resetit();" class="button" style="background:#525151; background-repeat:no-repeat; width:64px; height:20px; border:none; color:#fff; font:bold 12px Verdana;"/>
		<input type="button" value="Close" onclick="window.close()" class="button" style="background:#525151; background-repeat:no-repeat; width:64px; height:20px; border:none; color:#fff; font:bold 12px Verdana;"/></td>
		</tr>
</table>
</form>

</div>
</body>
</html>