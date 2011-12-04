/**
 * 
 */
package com.coral.fundation.service.test;

import com.coral.fundation.model.BasicInfo;
import com.coral.fundation.service.BasicInfoSetupService;

import junit.framework.TestCase;

/**
 * @author coral.ma
 *
 */
public class BasicInfoServiceTest extends TestCase {

	public void testSaveBasicInfo() {
		BasicInfoSetupService service = new BasicInfoSetupService();
		BasicInfo basicInfo = new BasicInfo();
		basicInfo.setCompanyName("abc");
		service.saveBasicInfo(basicInfo);
		BasicInfo rs = service.loadBasicInfo();
		System.out.println(rs);
	}
}
