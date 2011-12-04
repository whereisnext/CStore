package com.coral.store.model;

import java.util.Date;

/**
 * <p>Title: com.coral.store.model.PurchaseOrderProduct</p>
 * <p>Description: PurchaseOrderProduct entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class PurchaseOrderProduct implements java.io.Serializable  {

	private String purchaseOrderProductId;
	private String purchaseOrderSheetId;
	private String supplierName;
	private String productName;
	private String spec;
	private String color;
	private String number;
	private String totalSalePrice;
	private String mark;
	private Date insertDate = new Date();

	public String getPurchaseOrderProductId() {
		return purchaseOrderProductId;
	}
	public void setPurchaseOrderProductId(String purchaseOrderProductId) {
		this.purchaseOrderProductId=purchaseOrderProductId;
	}

	public String getPurchaseOrderSheetId() {
		return purchaseOrderSheetId;
	}
	public void setPurchaseOrderSheetId(String purchaseOrderSheetId) {
		this.purchaseOrderSheetId=purchaseOrderSheetId;
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

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number=number;
	}

	public String getTotalSalePrice() {
		return totalSalePrice;
	}
	public void setTotalSalePrice(String totalSalePrice) {
		this.totalSalePrice=totalSalePrice;
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

