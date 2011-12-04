/**
 * 
 */
package com.coral.store.ext.dao.impl;

import com.coral.store.ext.IExtProductDao;

/**
 * @author coral.ma
 *
 */
public class ExtStoreFactory {

	private static IExtProductDao extProductDao = new ExtProductDaoImpl();
	public static IExtProductDao getExtProductDao() {
		return extProductDao;
	}
}
