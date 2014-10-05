package com.itech.iERP.forms;

import java.util.Date;

import org.apache.struts.validator.ValidatorForm;

public class GoodsResivedForm extends ValidatorForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int goodsresivedid;
	private int itemid;
	private String itemname;
	private int vendorid;
	private int stockupdateid;
	private int price;
	private int acceptqty;
	private int rejectqty;
	private int compid;
	private String date;
	private String remark;
	private String vendorname;
	
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public int getGoodsresivedid() {
		return goodsresivedid;
	}
	public void setGoodsresivedid(int goodsresivedid) {
		this.goodsresivedid = goodsresivedid;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAcceptqty() {
		return acceptqty;
	}
	public void setAcceptqty(int acceptqty) {
		this.acceptqty = acceptqty;
	}
	public int getRejectqty() {
		return rejectqty;
	}
	public void setRejectqty(int rejectqty) {
		this.rejectqty = rejectqty;
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
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getStockupdateid() {
		return stockupdateid;
	}
	public void setStockupdateid(int stockupdateid) {
		this.stockupdateid = stockupdateid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	
	

}
