package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class StockUpdateForm extends ValidatorForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int itemid;
	private int vendorid;
	private int stockupdateid;
	private int price;
	private int qty;
	private int compid;
	private String date;
	private String remark;
	private String vendorname;
	private String Itemname;
	private int purchaseOrderID;

	private boolean active;
	
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public int getStockupdateid() {
		return stockupdateid;
	}
	public void setStockupdateid(int stockupdateid) {
		this.stockupdateid = stockupdateid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getCompid() {
		return compid;
	}
	public void setCompid(int compid) {
		this.compid = compid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getQty() {
		return qty;
	}
	public void setItemname(String itemname) {
		this.Itemname = itemname;
	}
	public String getItemname() {
		return Itemname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setPurchaseOrderID(int purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}
	public int getPurchaseOrderID() {
		return purchaseOrderID;
	}
	
}
