package com.itech.iERP.forms;
import org.apache.struts.validator.ValidatorForm;

public class BookMasterForm extends ValidatorForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookid;
	private String booktitle;
	private String author;
	private int accessionno;
	private int bookcatid;
	private String bookcatname;

	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	public int getAccessionno() {
		return accessionno;
	}
	public void setAccessionno(int accessionno) {
		this.accessionno = accessionno;
	}
	
	
	public int getBookcatid() {
		return bookcatid;
	}
	public void setBookcatid(int bookcatid) {
		this.bookcatid = bookcatid;
	}
	public String getBookcatname() {
		return bookcatname;
	}
	public void setBookcatname(String bookcatname) {
		this.bookcatname = bookcatname;
	}
	
}
