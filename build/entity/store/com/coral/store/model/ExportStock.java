package com.coral.store.model;

import java.util.Date;

/**
 * <p>Title: com.coral.store.model.ExportStock</p>
 * <p>Description: ExportStock entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class ExportStock implements java.io.Serializable  {

	private String exportStockId;
	private String supplierName;
	private String productName;
	private String number;
	private String spec;
	private String color;
	private String salePrice;
	private String mark;
	private Date insertDate = new Date();

	public String getExportStockId() {
		return exportStockId;
	}
	public void setExportStockId(String exportStockId) {
		this.exportStockId=exportStockId;
	}

	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName=supplierName;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName=productName;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number=number;
	}

	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec=spec;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color=color;
	}

	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice=salePrice;
	}

	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark=mark;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate=insertDate;
	}

}

