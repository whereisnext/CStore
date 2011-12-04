create table User(userId, userName, password, roleName, roleId, insertDate, abstractUser);
create table Role(roleId, roleName, roleDescription, abstractRole);
create table ModelMenu(modelMenuId, menuId, menuName, parentMenuId, viewName, icon, orderIndex, abstractModelMenu);
create table RoleMenu(roleMenuId, roleId, menuId, abstractRoleMenu);
create table ShotCut(shotCutId, menuId, icon, shotCutName, viewName, abstractShotCut);
create table RoleShotCut(roleShotCutId, roleId, shotCutId, orderIndex, abstractRoleShotCut);
create table WorkflowProcess(workflowProcessId, nextProcessId, failProcessId, status, statusLabel, failStatusLabel, roleId, abstractWorkflowProcess);
create table BasicInfo(basicInfoId, companyName, phone, fax, district, deliverAddress, deliverPostcode, url, email, accountBank, accountNumber, accountPerson);

