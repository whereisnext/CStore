/**
 * 
 */
package com.coral.tool.generator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coral.ma
 *
 */
public class Entity {

//	public String entityPackage;
	public String entityName;
//	public String daoImplName;
//	public String daoIntfName;
	public List<Property> properties = new ArrayList<Property>();
//	/**
//	 * @return the packageName
//	 */
//	public String getPackageName() {
//		return packageName;
//	}
//	/**
//	 * @param packageName the packageName to set
//	 */
//	public void setPackageName(String packageName) {
//		this.packageName = packageName;
//	}
	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}
	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
//	/**
//	 * @return the daoImplName
//	 */
//	public String getDaoImplName() {
//		return daoImplName;
//	}
//	/**
//	 * @param daoImplName the daoImplName to set
//	 */
//	public void setDaoImplName(String daoImplName) {
//		this.daoImplName = daoImplName;
//	}
//	/**
//	 * @return the daoIntfName
//	 */
//	public String getDaoIntfName() {
//		return daoIntfName;
//	}
//	/**
//	 * @param daoIntfName the daoIntfName to set
//	 */
//	public void setDaoIntfName(String daoIntfName) {
//		this.daoIntfName = daoIntfName;
//	}
	/**
	 * @return the properties
	 */
	public List<Property> getProperties() {
		return properties;
	}
	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	public void addProperty(Property p) {
		properties.add(p);
	}
}
