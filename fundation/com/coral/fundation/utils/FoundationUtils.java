/**
 * 
 */
package com.coral.fundation.utils;

import com.coral.fundation.model.BasicInfo;
import com.coral.fundation.model.ModelMenu;
import com.coral.fundation.model.Role;
import com.coral.fundation.model.RoleMenu;
import com.coral.fundation.model.RoleShotCut;
import com.coral.fundation.model.ShotCut;
import com.coral.fundation.model.User;
import com.coral.fundation.model.WorkflowProcess;

/**
 * @author coral.ma
 * 
 */
public class FoundationUtils {

	public static User abstractUser(User user) {
		return user;
	}

	public static Role abstractRole(Role role) {
		return role;
	}

	public static ModelMenu abstractModelMenu(ModelMenu modelMenu) {
		return modelMenu;
	}

	public static RoleMenu abstractRoleMenu(RoleMenu roleMenu) {
		return roleMenu;
	}

	public static ShotCut abstractShotCut(ShotCut shotCut) {
		return shotCut;
	}

	public static RoleShotCut abstractRoleShotCut(RoleShotCut roleShotCut) {
		return roleShotCut;
	}

	public static WorkflowProcess abstractWorkflowProcess(
			WorkflowProcess workflowProcess) {
		return workflowProcess;
	}
	
	public static BasicInfo abstractBasicInfo(BasicInfo basicInfo) {
		return basicInfo;
	}
}
