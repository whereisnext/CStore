package com.coral.store.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.coral.store.model.PurchaseOrderProduct;

/**
 * <p>Title: com.coral.store.model.PurchaseOrderSheet</p>
 * <p>Description: PurchaseOrderSheet entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class PurchaseOrderSheet implements java.io.Serializable  {

	private String purchaseOrderSheetId;
	private String purchaseOrderNo;
	private String saleOrderNo;
	private String supplierName;
	private String receivePerson;
	private String mobile;
	private String deliverAddress;
	private String deliverPostcode;
	private Date deliverDate = new Date();
	private String mark;
	private String totalPrice;
	private String status;
	private List<PurchaseOrderProduct> products;
	private String salesmanId;
	private String creatorId;
	private String orderPinYin;
	private String abstractOrder;
	private Date insertDate = new Date();

	public String getPurchaseOrderSheetId() {
		return purchaseOrderSheetId;
	}
	public void setPurchaseOrderSheetId(String purchaseOrderSheetId) {
		this.purchaseOrderSheetId=purchaseOrderSheetId;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}
	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo=purchaseOrderNo;
	}

	public String getSaleOrderNo() {
		return saleOrderNo;
	}
	public void setSaleOrderNo(String saleOrderNo) {
		this.saleOrderNo=saleOrderNo;
	}

	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName=supplierName;
	}

	public String getReceivePerson() {
		return receivePerson;
	}
	public void setReceivePerson(String receivePerson) {
		this.receivePerson=receivePerson;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile=mobile;
	}

	public String getDeliverAddress() {
		return deliverAddress;
	}
	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress=deliverAddress;
	}

	public String getDeliverPostcode() {
		return deliverPostcode;
	}
	public void setDeliverPostcode(String deliverPostcode) {
		this.deliverPostcode=deliverPostcode;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate=deliverDate;
	}

	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark=mark;
	}

	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice=totalPrice;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}

	public List<PurchaseOrderProduct> getProducts() {
		return products;
	}
	public void setProducts(List<PurchaseOrderProduct> products) {
		this.products=products;
	}

	public String getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(String salesmanId) {
		this.salesmanId=salesmanId;
	}

	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId=creatorId;
	}

	public String getOrderPinYin() {
		return orderPinYin;
	}
	public void setOrderPinYin(String orderPinYin) {
		this.orderPinYin=orderPinYin;
	}

	public String getAbstractOrder() {
		return abstractOrder;
	}
	public void setAbstractOrder(String abstractOrder) {
		this.abstractOrder=abstractOrder;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate=insertDate;
	}

}

