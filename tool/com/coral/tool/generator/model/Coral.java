/**
 * 
 */
package com.coral.tool.generator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Coral
 *
 */
public class Coral {
	private String name;
	private String entityPackage;
	private String daoIntfPackage; 
	private String daoImplPackage;
	private String servicePackage;
	private List<Entity> entityList = new ArrayList<Entity>();
	/**
	 * @return the entityPackage
	 */
	public String getEntityPackage() {
		return entityPackage;
	}
	/**
	 * @param entityPackage the entityPackage to set
	 */
	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}
	/**
	 * @return the daoIntfPackage
	 */
	public String getDaoIntfPackage() {
		return daoIntfPackage;
	}
	/**
	 * @param daoIntfPackage the daoIntfPackage to set
	 */
	public void setDaoIntfPackage(String daoIntfPackage) {
		this.daoIntfPackage = daoIntfPackage;
	}
	/**
	 * @return the daoImplPackage
	 */
	public String getDaoImplPackage() {
		return daoImplPackage;
	}
	/**
	 * @param daoImplPackage the daoImplPackage to set
	 */
	public void setDaoImplPackage(String daoImplPackage) {
		this.daoImplPackage = daoImplPackage;
	}
	/**
	 * @return the entityList
	 */
	public List<Entity> getEntityList() {
		return entityList;
	}
	/**
	 * @param entityList the entityList to set
	 */
	public void setEntityList(List<Entity> entityList) {
		this.entityList = entityList;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the servicePackage
	 */
	public String getServicePackage() {
		return servicePackage;
	}
	/**
	 * @param servicePackage the servicePackage to set
	 */
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
}
