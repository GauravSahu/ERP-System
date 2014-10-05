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
 
              OutputStream file = new FileOutputStream(new File("D:\\PDF_Java4s.pdf"));
              Paragraph para = new Paragraph();
              Document document = new Document();
              PdfWriter.getInstance(document, file);
 
                 document.open();
                 Font font1 = new Font(Font.FontFamily.COURIER ,10, Font.BOLD);
                   
          
                 para = new Paragraph("SRI BHAGAWAN MAHAVEER JAIN COLLEGE OF ENGINEERING",font1);
                 para.setAlignment(Element.ALIGN_CENTER);
                 document.add(para);
                 para = new Paragraph("JAKKASANDRA POST, KANAKAPURA TALUK,RAMANAGARA DISTRICT - 562112",font1);
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
                 PdfPTable table = new PdfPTable(3); // Code 1
                 table.getDefaultCell().setBorder(0);
         		// Code 2
         	
         		table.addCell(new Phrase("Name of Employee ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("Gaurav Sahu", FontFactory.getFont(FontFactory.COURIER,10)));         		
         		// Code 3
         		table.addCell(new Phrase("Designation ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("Java Developer ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		// Code 4
         		table.addCell(new Phrase("Department ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("R&D", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("Pf No ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("12345", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("PAN No ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("123456", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("SBA/CNO", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("123456", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table.addCell(new Phrase("Bank of Maharashtra", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("City Market,Bangalore", FontFactory.getFont(FontFactory.COURIER,10)));
         		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		// Code 5
         		
         		document.add(table);
         		
                document.add(Chunk.NEWLINE);
                
         		PdfPTable table1 = new PdfPTable(4); // 3 columns.
         		
         		 table1.getDefaultCell().setBorderWidth(1);
         		//table1.setTotalWidth(new float[]{ 136,60,110,45,110,90});
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
         		table1.addCell(new Phrase("INCOME", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("AMOUNT ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("DEDUCTIONS", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		table1.addCell(new Phrase("AMOUNT", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Basic ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Professional Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Dearness Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("210 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Income Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Performance Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("1925 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("LOP ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("367 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Other Allowances ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("1182 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Other Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		     	
                
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Special Pay ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Loyality bonus monthly comp  ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("825 ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		 
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