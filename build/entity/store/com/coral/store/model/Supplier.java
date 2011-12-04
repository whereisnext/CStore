package com.coral.store.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.coral.store.model.Product;

/**
 * <p>Title: com.coral.store.model.Supplier</p>
 * <p>Description: Supplier entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class Supplier implements java.io.Serializable  {

	private String supplierId;
	private String supplierName;
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
	private String status;
	private String supplierPinYin;
	private String abstractSupplier;
	private Date insertDate = new Date();
	private List<Product> products;

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

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}

	public String getSupplierPinYin() {
		return supplierPinYin;
	}
	public void setSupplierPinYin(String supplierPinYin) {
		this.supplierPinYin=supplierPinYin;
	}

	public String getAbstractSupplier() {
		return abstractSupplier;
	}
	public void setAbstractSupplier(String abstractSupplier) {
		this.abstractSupplier=abstractSupplier;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate=insertDate;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products=products;
	}

}

