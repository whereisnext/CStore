package com.coral.store.model;

import java.util.Date;

/**
 * <p>Title: com.coral.store.model.Customer</p>
 * <p>Description: Customer entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-07-29 10:56 </p>
 */
public class Customer implements java.io.Serializable  {

	private String customerId;
	private String customerName;
	private String contectPerson;
	private String district;
	private String postcode;
	private String address;
	private String mobile;
	private String phone;
	private String fax;
	private String url;
	private String email;
	private String accountBank;
	private String accountNumber;
	private String accountPerson;
	private String mark;
	private String customerPinYin;
	private String abstractCustomer;
	private Date insertDate = new Date();

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId=customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName=customerName;
	}

	public String getContectPerson() {
		return contectPerson;
	}
	public void setContectPerson(String contectPerson) {
		this.contectPerson=contectPerson;
	}

	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district=district;
	}

	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode=postcode;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile=mobile;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}

	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax=fax;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url=url;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}

	public String getAccountBank() {
		return accountBank;
	}
	public void setAccountBank(String accountBank) {
		this.accountBank=accountBank;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}

	public String getAccountPerson() {
		return accountPerson;
	}
	public void setAccountPerson(String accountPerson) {
		this.accountPerson=accountPerson;
	}

	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark=mark;
	}

	public String getCustomerPinYin() {
		return customerPinYin;
	}
	public void setCustomerPinYin(String customerPinYin) {
		this.customerPinYin=customerPinYin;
	}

	public String getAbstractCustomer() {
		return abstractCustomer;
	}
	public void setAbstractCustomer(String abstractCustomer) {
		this.abstractCustomer=abstractCustomer;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate=insertDate;
	}

}

