package com.coral.store.model;

import java.util.Date;

/**
 * <p>Title: com.coral.store.model.Product</p>
 * <p>Description: Product entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class Product implements java.io.Serializable  {

	private String productId;
	private String productCode;
	private String productName;
	private String brand;
	private String unit;
	private String spec;
	private String color;
	private String buyPrice;
	private String salePrice;
	private String mark;
	private String status;
	private String supplierId;
	private String supplierName;
	private String productPinYin;
	private String abstractProduct;
	private Date insertDate = new Date();

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId=productId;
	}

	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode=productCode;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName=productName;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand=brand;
	}

	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit=unit;
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

	public String getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(String buyPrice) {
		this.buyPrice=buyPrice;
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

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}

	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId=supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName=supplierName;
	}

	public String getProductPinYin() {
		return productPinYin;
	}
	public void setProductPinYin(String productPinYin) {
		this.productPinYin=productPinYin;
	}

	public String getAbstractProduct() {
		return abstractProduct;
	}
	public void setAbstractProduct(String abstractProduct) {
		this.abstractProduct=abstractProduct;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate=insertDate;
	}

}

