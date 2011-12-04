package com.coral.fundation.model;


/**
 * <p>Title: com.coral.fundation.model.BasicInfo</p>
 * <p>Description: BasicInfo entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class BasicInfo implements java.io.Serializable  {

	private String basicInfoId;
	private String companyName;
	private String phone;
	private String fax;
	private String district;
	private String deliverAddress;
	private String deliverPostcode;
	private String url;
	private String email;
	private String accountBank;
	private String accountNumber;
	private String accountPerson;

	public String getBasicInfoId() {
		return basicInfoId;
	}
	public void setBasicInfoId(String basicInfoId) {
		this.basicInfoId=basicInfoId;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName=companyName;
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

	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district=district;
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

}

