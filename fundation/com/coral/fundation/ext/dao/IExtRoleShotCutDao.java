/**
 * 
 */
package com.coral.fundation.ext.dao;

import java.util.List;

import com.coral.fundation.model.ShotCut;

/**
 * @author coral.ma
 *
 */
public interface IExtRoleShotCutDao {
	
	public List<ShotCut> loadShotCutByRole(String roleId);

}
