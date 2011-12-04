package com.coral.store.model;

import java.util.Date;

/**
 * <p>Title: com.coral.store.model.Stock</p>
 * <p>Description: Stock entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class Stock implements java.io.Serializable  {

	private String stockId;
	private String supplierName;
	private String productName;
	private String number;
	private String spec;
	private String color;
	private String averagePrice;
	private String mark;
	private String warehouseLocation;
	private Long weight;
	private Date insertDate = new Date();

	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId=stockId;
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

	public String getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(String averagePrice) {
		this.averagePrice=averagePrice;
	}

	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark=mark;
	}

	public String getWarehouseLocation() {
		return warehouseLocation;
	}
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation=warehouseLocation;
	}

	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight=weight;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate=insertDate;
	}

}

