/**
 * 
 */
package com.coral.tool.generator.model;

/**
 * @author coral.ma
 *
 */
public class Property {

	public String propertyName;
	public String type;
	public String length;
	public String isTableColumn;
	public String isViewColumn;
	public String pk;
	public String ref;
	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}
	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}
	/**
	 * @return the isTableColumn
	 */
	public String getIsTableColumn() {
		return isTableColumn;
	}
	/**
	 * @param isTableColumn the isTableColumn to set
	 */
	public void setIsTableColumn(String isTableColumn) {
		this.isTableColumn = isTableColumn;
	}
	/**
	 * @return the isViewColumn
	 */
	public String getIsViewColumn() {
		return isViewColumn;
	}
	/**
	 * @param isViewColumn the isViewColumn to set
	 */
	public void setIsViewColumn(String isViewColumn) {
		this.isViewColumn = isViewColumn;
	}
	/**
	 * @return the pk
	 */
	public String getPk() {
		return pk;
	}
	/**
	 * @param pk the pk to set
	 */
	public void setPk(String pk) {
		this.pk = pk;
	}
	/**
	 * @return the length
	 */
	public String getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(String length) {
		this.length = length;
	}
}
