package com.itech.iERP.actions;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadCountry
 */
public class UploadCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadCountry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn = null;
		if(session.getAttribute("username")!= null){
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 
        if (isMultipart) {
        	// Create a factory for disk-based file items
        	FileItemFactory factory = new DiskFileItemFactory();

        	// Create a new file upload handler
        	ServletFileUpload upload = new ServletFileUpload(factory);
 
            try {
            	// Parse the request
            	List /* FileItem */ items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        String fileName = item.getName();	 
                        String root = getServletContext().getRealPath("/");
                        File path = new File(root + "/uploads");
                        if (!path.exists()) {
                            @SuppressWarnings("unused")
							boolean status = path.mkdirs();
                        }
 
                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                 
		ArrayList list1=new ArrayList();
		ArrayList list2=new ArrayList();
		ArrayList list3=new ArrayList();
		ArrayList list4=new ArrayList();
		    Cell rowData[] = null;
		    int rowCount = 0;
		    int columnCount = 0;
		   // int totalSheet = 0;
		    int c = 0;
		    int c1=0;
		    int c2=0;
		    try
		    {
				
		       WorkbookSettings ws = new WorkbookSettings();
		        ws.setLocale(new Locale("en", "EN"));
		       Workbook workbook = Workbook.getWorkbook(uploadedFile, ws);

		        Sheet s = workbook.getSheet(0);
		        rowCount = s.getRows();
		        columnCount = s.getColumns();
		        System.out.println("rowCount-->"+rowCount);
		        System.out.println("columnCount-->"+columnCount);
		        for(int i = 1; i < rowCount; i++){
		            rowData = s.getRow(i);
		            if(rowData[1].getContents().length() != 0){ 
		                for(int j = 0; j < columnCount ;j++){
		                 switch(j){
		                 case 0:
								list1.add(rowData[j].getContents());
								break;
						case 1:
								list2.add(rowData[j].getContents());
								break;
						case 2:
								list3.add(rowData[j].getContents());
								break;
						case 3:
								list4.add(rowData[j].getContents());
								break;
						
		                       }
		                    }
		                  }
		        }
		 workbook.close(); 
		   System.out.println("Before DB Connection");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ierp","root", "root");
		System.out.println("DB Connected");
		Statement st=conn.createStatement();
		System.out.println("Outside the Loop" +list2.size());	
		for(int i=0;i<list2.size();i++){
System.out.println("Inside the Loop");
			

			/*int countryid = Integer.parseInt(list1.get(i).toString());
			System.out.println("outletid->"+countryid);*/
			
			String countryname = list2.get(i).toString();
			System.out.println("productname->"+countryname);
			
			boolean active = Boolean.parseBoolean(list3.get(i).toString());
			System.out.println("active->"+active);
			int flag;
			if(active==true){
				flag=1;
			}else{
				flag=0;
			}
			int compid;
	      try {
		          compid = Integer.parseInt(list4.get(i).toString());
		         System.out.println("uomid->"+compid);
	           } catch (Exception e) {
	        	   compid=0;
	        }
			
			
			String sql="select * from countrymaster where countryname='"+countryname+"'";
			System.out.println(sql);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
			  //System.out.println("duplicate productname="+productname);	
			  c1++;
			}
			else{
				String sql1="insert into countrymaster" +
				"(COUNTRYNAME,ACTIVE,COMPID) VALUES" +
				"('"+countryname+"','"+flag+"','"+compid+"')";
				System.out.println(sql1);
			c = st.executeUpdate(sql1);
			c2++;
			}
		}
		    }catch (Exception e) {
		    	e.printStackTrace();
		    	request.setAttribute("status", "Uploading Error, Try again with Correct File Format1");
		    	RequestDispatcher rd = request.getRequestDispatcher("ExcelUpload.do");
		    	rd.forward(request, response);
		    }
		    
		    
		    
		
			if(c2>0){
				//	System.out.println("if block");
					if(c1>0){
						request.setAttribute("status", c2+" COUNTRY(s) added Successfully And "+c1+" Duplicate(s) are Restricted!..");
					}else{
						request.setAttribute("status", c2+" COUNTRY(s) added Successfully!..");
					}
			    	RequestDispatcher rd = request.getRequestDispatcher("ExcelUpload.do");
			    	rd.forward(request, response);
			    	
			    }else{
			    	
			    	//System.out.println("else block");
			    	if(c1>0){
			    		request.setAttribute("status", "Duplicate COUNTRY(s) Restricted!..");
			    	}else{
			    		request.setAttribute("status", "Uploading Error, Try again with Correct File Format2");
			    	}
			    	RequestDispatcher rd = request.getRequestDispatcher("ExcelUpload.do");
			    	rd.forward(request, response);
			    		    	
			    }
                    }
                }
                    } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
            	try{
            		if(pstmt!=null)pstmt.close();
            		if(rs!=null)rs.close();
            		if(conn!=null)conn.close();
            	}catch (Exception e) {}
            }
        }} else {
			response.sendRedirect("SessionExpired.jsp");
		}
	}
}
