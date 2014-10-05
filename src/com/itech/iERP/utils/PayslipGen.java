package com.itech.iERP.utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class PayslipGen
{ 
	public static void main(String[] args) {
		 
        try {
 
              OutputStream file = new FileOutputStream(new File("C:\\PDF_Java4s.pdf"));
              Paragraph para = new Paragraph();
              Document document = new Document();
              PdfWriter.getInstance(document, file);
 
            //Inserting Image in PDF
                 Image image = Image.getInstance ("src/company_logo1.png");
                 image.scaleAbsolute(80f,40f);//image width,height  
                 image.setAlignment(Element.ALIGN_CENTER);
                 document.open();
                 Font font1 = new Font(Font.FontFamily.COURIER ,10, Font.BOLD);
                   
                 document.add(image);
                 document.add(Chunk.NEWLINE); 
                 para = new Paragraph("Itech Solutions",font1);
                 para.setAlignment(Element.ALIGN_CENTER);
                 document.add(para);
                 para = new Paragraph("Bangalore",font1);
                 para.setAlignment(Element.ALIGN_CENTER);
                 document.add(para);
                 Calendar cal = Calendar.getInstance();
                 java.util.Date d = new java.util.Date(cal.getTimeInMillis());
                 String month = new SimpleDateFormat("MMMM").format(d);
                 int year = cal.get(Calendar.YEAR);
                 System.out.println("Month "+month);
                
                 para = new Paragraph("Pay-slip for the month of " + month +" " + year,font1 );
                 para.setAlignment(Element.ALIGN_CENTER);
                 document.add(para);
                 document.add(Chunk.NEWLINE);
                 PdfPTable table = new PdfPTable(2); // Code 1

         		// Code 2
         	
         		table.addCell(new Phrase("Employee No ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("I0035", FontFactory.getFont(FontFactory.COURIER,10)));         		
         		// Code 3
         		table.addCell(new Phrase("Name ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("Vanishree K ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		// Code 4
         		table.addCell(new Phrase("Designation ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("Software Developer ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		// Code 5
         		
         		document.add(table);
         		document.add(Chunk.NEWLINE);
         		 
         		PdfPTable table1 = new PdfPTable(6); // 3 columns.
         		table1.setTotalWidth(new float[]{ 136,60,110,45,110,90});
         		/*PdfPCell cell1 = new PdfPCell(new Paragraph("Earnings"));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Rs"));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Deductions"));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Rs"));
                PdfPCell cell5 = new PdfPCell(new Paragraph("Other Details"));
                PdfPCell cell6 = new PdfPCell(new Paragraph("Rs"));
                table1.addCell(cell1);
                table1.addCell(cell2);
                table1.addCell(cell3);
                table1.addCell(cell4);
                table1.addCell(cell5);
                table1.addCell(cell6);*/
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("Earnings ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("Rs ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("Deductions ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("Rs ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("Other Details ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("  ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Basic ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Professional Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Date of Joining ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("02-04-2012 ", FontFactory.getFont(FontFactory.COURIER,10)));
                 
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Dearness Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("210 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Income Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Present Days ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("22 ", FontFactory.getFont(FontFactory.COURIER,10)));
                 
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Performance Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("1925 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("LOP ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("367 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Working Days ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("25 ", FontFactory.getFont(FontFactory.COURIER,10)));
          		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Other Allowances ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("1182 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Other Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Calendar Days ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("30 ", FontFactory.getFont(FontFactory.COURIER,10)));
          	
                
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Special Pay ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Location ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("Bangalore ", FontFactory.getFont(FontFactory.COURIER,10)));       
                
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Loyality bonus monthly comp  ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("825 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Pan No ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" - ", FontFactory.getFont(FontFactory.COURIER,10)));
                
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Leave For the Month ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("3 ", FontFactory.getFont(FontFactory.COURIER,10)));
                
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Actual Performance %  ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" 80 ", FontFactory.getFont(FontFactory.COURIER,10)));
                
                table1.addCell("  ");
                table1.addCell("  ");
                table1.addCell("  ");
                table1.addCell("  ");
                table1.addCell("  ");
                table1.addCell("  ");
                
                table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            	table1.addCell(new Phrase("Total Earnings  ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            	table1.addCell(new Phrase("7517 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            	table1.addCell(new Phrase("Total Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
            	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            	table1.addCell(new Phrase("367 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
            	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            	table1.addCell(new Phrase("Net Salary Rupees  ", FontFactory.getFont(FontFactory.COURIER,10)));
            	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            	table1.addCell(new Phrase("7150 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
                
                document.add(table1);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                para = new Paragraph("www.itechsolutions.in",font1);
                para.setAlignment(Element.ALIGN_CENTER);
                document.add(para);
                document.close();
                 file.close();
                 System.out.println("Pdf generated normally");
                 
             
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
