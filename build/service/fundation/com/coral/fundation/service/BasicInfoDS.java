package com.coral.fundation.service;

import com.coral.fundation.basic.dao.IBasicInfoDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.fundation.utils.FoundationUtils;
import java.util.List;
import com.coral.fundation.model.BasicInfo;
/**
 * <p>Title: com.coral.fundation.service.BasicInfoDS</p>
 * <p>Description: BasicInfoDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class BasicInfoDS {

	IBasicInfoDao basicInfoDao = BeanUtils.getBean("basicInfoDao", IBasicInfoDao.class);

	public BasicInfo createBasicInfo(BasicInfo basicInfo) {
		try {
			basicInfo.setBasicInfoId(IDGenerater.generate());
			FoundationUtils.abstractBasicInfo(basicInfo);
			basicInfoDao.create(basicInfo);
		} catch (Exception e) {
			Log.error("Create BasicInfo error.", this.getClass(),e.getCause());
		}
		return basicInfo;
	}

	public BasicInfo updateBasicInfo(BasicInfo basicInfo) {
		try {
			FoundationUtils.abstractBasicInfo(basicInfo);
			basicInfoDao.update(basicInfo);
		} catch (Exception e) {
			Log.error("Update BasicInfo error.", this.getClass(),e.getCause());
		}
		return basicInfo;
	}

	public String deleteBasicInfo(BasicInfo basicInfo) {
		deleteBasicInfo(basicInfo.getBasicInfoId());
		return StrUtils.empty;
	}

	public String deleteBasicInfo(String basicInfoId) {
		try {
			basicInfoDao.remove(basicInfoId);
		} catch (Exception e) {
			Log.error("Delete BasicInfo error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public BasicInfo loadBasicInfo(String basicInfoId) {
		BasicInfo basicInfo= null;
		try {
			basicInfo = basicInfoDao.load(basicInfoId);
		} catch (Exception e) {
			Log.error("load BasicInfo error.", this.getClass(),e.getCause());
		}
		return basicInfo;
	}

	public List<BasicInfo> loadAllBasicInfo() {
		List<BasicInfo> basicInfoList = null;
		try {
			basicInfoList = basicInfoDao.loadAll();
		} catch (Exception e) {
			Log.error("load BasicInfo error.", this.getClass(),e.getCause());
		}
		return basicInfoList;
	}
}

