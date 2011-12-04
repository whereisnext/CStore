/**
 * 
 */
package com.coral.fundation.ext.dao;

import java.util.List;

import com.coral.fundation.model.ModelMenu;

/**
 * @author coral.ma
 *
 */
public interface IExtRoleModelMenuDao {

//	public List<ModelMenu> loadModelMenuByRole(String ruleId);
	
	public List<ModelMenu> loadFirstLevelModelMenuByRole(String ruleId);
	
	public List<ModelMenu> loadSubLevelModelMenuByRole(String ruleId, Long parentMenuId);
	
	public List<ModelMenu> loadFirstLevelModelMenu();
	
	public List<ModelMenu> loadSubLevelModelMenu(Long parentMenuId);
	
}
