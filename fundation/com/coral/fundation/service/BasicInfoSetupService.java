/**
 * 
 */
package com.coral.fundation.service;

import com.coral.fundation.model.BasicInfo;

/**
 * @author coral.ma
 *
 */
public class BasicInfoSetupService {
	
	private String basicInfoId = "BasicInfo01";
	private BasicInfoDS basicInfoDS = new BasicInfoDS();
	
	public void saveBasicInfo(BasicInfo basicInfo) {
		basicInfo.setBasicInfoId(basicInfoId);
		basicInfoDS.updateBasicInfo(basicInfo);
	}
	
	public BasicInfo loadBasicInfo() {
		return basicInfoDS.loadBasicInfo(basicInfoId);
	}
	
}
