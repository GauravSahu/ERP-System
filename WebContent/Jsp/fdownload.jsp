<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html:form action="DownloadDocc.do?action=listlist">

 <html:select property="userid" styleClass="select1" >
		<html:option value="-1">--Select Employee--</html:option>
		<html:options collection="Userlist" property="userid" labelProperty="username"/>
</html:select>
<input type="submit" onclick=" return valid();" value="submit" /> 
<input type="reset" onclick=" return resetall();" value="Reset" />

<table cellpadding="2" border="1" rules="all" width="90%"
			style="table-layout: fixed;" align="center">
			<tr class="tdheader">
				<th width="5%">Sl. No.</th>
				<th width="30%">File Name</th>
				<th width="10%">UserName</th>
			</tr>
			<logic:notEmpty name="docList">
				<logic:iterate id="doc" name="docList" indexId="index">
					<tr class="tdContent2">

						<td align="center" style="color: black"><%=index+1 %></td>
					<td><a href='DownloadItDocs.do?&amp;fileid=<bean:write name="doc" property="fid"/>&amp;userid=<bean:write name="doc" property="userid"/>&amp;filetype=<bean:write name="doc" property="filetype"/>&amp;filename=<bean:write name="doc" property="filename"/>'>
				<bean:write name = "doc" property = "filename"></bean:write>
				</a></td>
					 <td><bean:write name="doc" property="username"/> </td>
						
					</tr>
				</logic:iterate>
			</logic:notEmpty>
			<logic:present name="docList">
				<logic:empty name="docList">
					<tr class="tdContent2">
						<td colspan="8" align="center">No audio file uploaded.</td>
					</tr>
				</logic:empty>
			</logic:present>
		</table>

</html:form>
</body>
</html>