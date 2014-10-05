<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@page import="com.itech.iERP.utils.ConnectionUtil"%>
<%@page import="javax.servlet.ServletConfig"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="java.text.*"%>
<%@page import="com.itech.iERP.utils.Util"%>
<%@page import="com.itech.iERP.forms.LoginForm" %>
<%@page import="javax.servlet.Servlet"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Group audio Upload</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/UI_style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/calender/calendar.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
window.history.forward();
function noBack() { window.history.forward(); }
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/homecalender.js"></script>
<script language="javaScript" type="text/javascript" src="<%=request.getContextPath() %>/calender/calendar.js"></script>

<script type="text/javascript">
window.history.forward();
function noBack() { window.history.forward(); }

</script>
</head>
<body onload="goforit(),dateDiaplay()" onpageshow="if (event.persisted) noBack();" onunload="">
<div id="header">

	<div id="logo">
    
    </div><!--logo-->
    <div id="search">
    <a href="<%=request.getContextPath() %>/Login.do?action=login"><img src="<%=request.getContextPath() %>/images/home.png" /></a> 
    <a href="<%=request.getContextPath() %>/Logout.do"><img src="<%=request.getContextPath() %>/images/logout1.png" /></a>
    </div>
</div><!--header-->
<div id="content_admin">
<br/>

<center>
<table border="2">
	
	<%
      ServletConfig config1 = getServletConfig();
  	 
  	String eventDescStr="";
  //	long  useridStr= 0;  
  	String id = "";
  
  	//List<String> allfileName=new ArrayList<String>();
    String allfileName[]=new String[50];
  	int counterNoOfFiles=0;
  	int uid = 0;
  //	long payment = Long.parseLong(request.getParameter("amount"));
  //	System.out.println(request.getParameter("amount"));
  	String invalidFile="";
     
      boolean isMultipart = ServletFileUpload.isMultipartContent(request);
  	
  	if (!isMultipart){
  	}else{
  		FileItemFactory factory = new DiskFileItemFactory();
  	    ServletFileUpload upload = new ServletFileUpload(factory);
  	    List items = null;
  	    try{
  	    	items = upload.parseRequest(request);
  	    }catch (FileUploadException e){
  	    	e.printStackTrace();
  	    }
  	    Iterator itr = items.iterator();
  	    while (itr.hasNext()) {
	    	    FileItem item = (FileItem) itr.next();
	    	    if (item.isFormField()){
	    	    	////
	    	    	
	    	    	String name = item.getFieldName();
	    	    	String value = item.getString();
					Long value1 = item.getSize();
					
					if(name.equals("eventDesc")){
						eventDescStr=value;
					}
					
				///	if(name.equals("userid")){
						
				//		useridStr = value1;										
				//	}
					
					//System.out.println("user id is "+useridStr);
	    	 		////
	    	    }else	
	    	    {
	    	    	
	    	    	try{
	    	    		String itemName = item.getName();
	    	    		//allfileName.add(itemName);
	    	    		if (item.getSize() > 0){
							File uploadedFile = null; 
							String myFullFileName = item.getName(),	myFileName = "",
							slashType = (myFullFileName.lastIndexOf("\\") > 0) ? "\\" : "/"; // Windows or UNIX
							//System.out.println("in multiple file upload"+slashType);
							int startIndex = myFullFileName.lastIndexOf(slashType);
							myFileName = myFullFileName.substring(startIndex + 1, myFullFileName.length());	
							System.out.println("in multiple file upload"+myFileName);
							//uploadedFile = new File("C:\\Documents and Settings\\sys\\Desktop\\shastrogyan\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Hayagriva\\files\\", myFileName);
							uploadedFile = new File(getServletContext().getRealPath("\\")+"files", myFileName);
							//getServletContext().getRealPath("\\")+"uploadfiles\\"
							item.write(uploadedFile);
							allfileName[counterNoOfFiles]=itemName;
							counterNoOfFiles++;
							
	    	    		}  
	    	    	}catch (Exception e){
	    	    		e.printStackTrace();
	    	    	}
	    	    }
  	    }
  	}
  	///Code to check for invalid File
  	/*for(int j=0;j<counterNoOfFiles;j++)
  	{
  		try{
  			//boolean result=CheckInvalidFile.checkForValidFile(config1.getServletContext().getRealPath("/")+"emp_image\\image\\"+allfileName[j]);
  			boolean result=Util.checkForValidFile("E:\\Datascribe\\TMS\\WebContent\\audiofiles"+allfileName[j]);
  			if(result!=true)invalidFile=invalidFile+" and "+allfileName[j];
  		}catch (Exception e) {
  			e.printStackTrace();
			}
  	}*/
  	///Code to check for invalid File
  	//if(invalidFile.equalsIgnoreCase("")){
	    	///Code for Change to Thumbnail
	    	/*for(int j=0;j<counterNoOfFiles;j++)
	    		{
	    		try{
	    			ThumbNails.createThumbnail(config1.getServletContext().getRealPath("/")+"emp_image//image//"+allfileName[j],config1.getServletContext().getRealPath("/")+"emp_image1//image//"+allfileName[j],80, 80);
	    		}catch (Exception e) {
	    			e.printStackTrace();
					// TODO: handle exception
				}
	    	}*/
  	
	    	///Code for Change to Thumbnail
  	
	    	///Code for Change to Temp Thumbnail
	    	/*for(int j=0;j<counterNoOfFiles;j++)
	    	{
	    		//System.out.println("148"+allfileName.size());
	    		try{
	    			ThumbNails.createThumbnail(config1.getServletContext().getRealPath("/")+"emp_image//image//"+allfileName[j],config1.getServletContext().getRealPath("/")+"emp_image3//image//"+allfileName[j],600, 600);
	    		}
	    		catch (Exception e) {
	    			
				}
	    	}*/
	    	///Code for Change to Temp Thumbnail
  	
  	
  	
	    	///Code for Change to WaterMark
	    	/*for(int i=0;i<counterNoOfFiles;i++){
	    		//System.out.println("162"+allfileName.size());
	    		try {
					WaterMarks.createWaterMark(config1.getServletContext().getRealPath("/")+"emp_image3//image//"+allfileName[i],config1.getServletContext().getRealPath("/")+"emp_image2//image//"+allfileName[i]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		//System.out.println(result);
	    	}*/
	    	///Code for Change to WaterMark
	    	
	      Connection con = null;
          PreparedStatement preStat = null;
          ResultSet rs = null;
          	try{
          		
       		  long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
	          con = ConnectionUtil.getMySqlConnection();
	          String query = "select max(userid) as a from usermaster where COMPANYID = '"+compid+"'";
	          preStat = con.prepareStatement(query);
	          uid=rs.getInt("a");
			  rs = preStat.executeQuery();%>
			  
			  <% 
	          while(rs.next()){	        	  
	          		          
	             id = rs.getString(1) ; 
	            System.out.println(id);
	           	         
       	  	  }
	          
	        } catch(Exception e){
	        	e.printStackTrace();
	        }finally{
	        	preStat.close();
	            rs.close();
	            con.close();
	        }      
	        
	          String img=" ";
	    		    	for(int i=0;i<=counterNoOfFiles;i++)
	    		    	{
	    		    		System.out.println("Number of files "+counterNoOfFiles);
	    		    	   	img = allfileName[i];
	    		    	   	System.out.println("Image name "+img);
	    		    	}
	    		    	System.out.println("All Image names "+img);
  	
	    	//Code for Add to database
	    	for(int i=0;i<counterNoOfFiles;i++){
	    		//System.out.println("175"+allfileName.size());
	    		
	   	   	    PreparedStatement psmt=null;
	   	   	    
	   	   		try{
	   	   				con=ConnectionUtil.getMySqlConnection();
		    	    	//Code for insertion of Thumbnails and original Image
		    	    	if(psmt!=null)psmt.close();
		    	    	String query = "insert into filemanager (filename,USERID,ACTIVE) values(?,?,?)";
		    	    	psmt=con.prepareStatement(query);
		    	    	psmt.setString(1, allfileName[i].toString());
		    			psmt.setInt(2,uid);
		    			//psmt.setLong(5, uid);
		    		//	System.out.println("ttttttt"+useridStr);
		    			//psmt.setLong(5, (Long) session.getAttribute("userid"));
		    			psmt.setBoolean(3, true);
		    			//psmt.setLong(7, payment);
		    	    	psmt.executeUpdate();
		    	    	
		    	        /*query = "update filemanager set VRS_FILENAME=? where AUDIOFILENAME = (select CONCAT((select SUBSTRING(?, 1, (select length(?)-4))), '.mp3'))";
		    	    	psmt=con.prepareStatement(query);
		    	    	String str = new String(allfileName[i].toString());
		    	    	str = new String(str.substring(0,(str.length()-4))+".txt");		    	   			    	   	
		    	    	psmt.setString(1, str);
		    	    	psmt.setString(2, allfileName[i].toString());
		    	    	psmt.setString(3, allfileName[i].toString());
		    	    	System.out.println(allfileName);
		    	    	psmt.executeUpdate();*/
		    	    	
		    	    }catch(Exception ex){
		    	   		ex.printStackTrace();
		    	    }finally{
		    	    	try{
		    	    		ConnectionUtil.closeResources(con,psmt,rs);
		    	    	}catch(Exception ex1){
		    	    		ex1.printStackTrace();
		    	    	}
		    	}
	    	}
	    	invalidFile="fileuploading took place succesfully";
	    	//request.setAttribute("fileuploadmessage", "fileuploading took place succesfully");
	    	//Code for Add to database
  	/*}
  	else {
  		invalidFile=invalidFile.replaceFirst("and", "");
  		//request.setAttribute("fileuploadmessage", "fileuploading doesn't took place due to informat file"+invalidFile);
  		invalidFile="fileuploading doesn't took place due to informat file"+invalidFile;
  	}*/
   %>
 
</table>
</center>
<center>
<h3><%=invalidFile %></h3>
</center>
<center><a href="<%=request.getContextPath() %>/Jsp/multifileupload.jsp">Go to upload page</a></center>
<br/>
 
<div style="height:200px;"></div>
</div>

<div style="height:350px;"></div>
<div id="footer">
<div id="footer1">
<div id="copy">
Copyright&copy;2013, Hayagriva Jyothishyalaya, All Right Reserved,

</div><!--copy-->

<div id="social">
</div><!--social-->
<div id="itech">
Design and Developed by <a href="http://www.itechsolutions.in">Itech solutions </a>

</div><!--itech-->
</div><!--footer1-->
</div><!--footer-->

</body>
</html>