package com.coral.store.model;

import java.util.Date;

/**
 * <p>Title: com.coral.store.model.OrderSheet</p>
 * <p>Description: OrderSheet entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-08-09 11:20 </p>
 */
public class OrderSheet implements java.io.Serializable  {

	private String orderId;
	private String orderNo;
	private String customerName;
	private String receivePerson;
	private String mobile;
	private String deliverAddress;
	private String deliverPostcode;
	private Date deliverDate = new Date();
	private String mark;
	private String totalPrice;
	private String salesmanId;
	private String creatorId;
	private String orderPinYin;
	private String abstractOrder;
	private Date insertDate = new Date();

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId=orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo=orderNo;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName=customerName;
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

