/**
 * 
 */
package com.coral.tool.sqliter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author coral.ma
 *
 */
public class CreateSqliteTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
		    Connection conn =DriverManager.getConnection("jdbc:sqlite:cstore.db");
		    Statement stat = conn.createStatement();
		    // drop all tables
		    // foundation
		    stat.executeUpdate("drop table if exists User;");
		    stat.executeUpdate("create table User(userId, userName, password, roleName, roleId, insertDate, abstractUser);");
		    stat.executeUpdate("drop table if exists Role;");
		    stat.executeUpdate("create table Role(roleId, roleName, roleDescription, abstractRole);");
		    stat.executeUpdate("drop table if exists ModelMenu;");
		    stat.executeUpdate("create table ModelMenu(modelMenuId, menuId, menuName, parentMenuId, viewName, icon, orderIndex, abstractModelMenu);");
		    stat.executeUpdate("drop table if exists RoleMenu;");
		    stat.executeUpdate("create table RoleMenu(roleMenuId, roleId, menuId, abstractRoleMenu);");
		    stat.executeUpdate("drop table if exists ShotCut;");
		    stat.executeUpdate("create table ShotCut(shotCutId, menuId, icon, shotCutName, viewName, abstractShotCut);");
		    stat.executeUpdate("drop table if exists RoleShotCut;");
		    stat.executeUpdate("create table RoleShotCut(roleShotCutId, roleId, shotCutId, orderIndex, abstractRoleShotCut);");
		    stat.executeUpdate("drop table if exists WorkflowProcess;");
		    stat.executeUpdate("create table WorkflowProcess(workflowProcessId, nextProcessId, failProcessId, status, statusLabel, failStatusLabel, roleId, abstractWorkflowProcess);");
		    stat.executeUpdate("drop table if exists BasicInfo;");
		    stat.executeUpdate("create table BasicInfo(basicInfoId, companyName, phone, fax, district, deliverAddress, deliverPostcode, url, email, accountBank, accountNumber, accountPerson);");

		    // cstore.
		    stat.executeUpdate("drop table if exists Customer;");
		    stat.executeUpdate("create table Customer(customerId, customerName, contectPerson, district, postcode, address, mobile, phone, fax, url, email, accountBank, accountNumber, accountPerson, mark, status, customerPinYin, abstractCustomer, insertDate);");
		    stat.executeUpdate("drop table if exists Supplier;");
		    stat.executeUpdate("create table Supplier(supplierId, supplierName, contectPerson, district, postcode, address, mobile, phone, fax, url, email, accountBank, accountNumber, accountPerson, mark, status, supplierPinYin, abstractSupplier, insertDate);");
		    stat.executeUpdate("drop table if exists Product;");
		    stat.executeUpdate("create table Product(productId, productCode, productName, brand, unit, spec, color, buyPrice, salePrice, mark, status, supplierId, supplierName, productPinYin, abstractProduct, insertDate);");
		    stat.executeUpdate("drop table if exists SaleOrderSheet;");
		    stat.executeUpdate("create table SaleOrderSheet(saleOrderSheetId, saleOrderNo, customerName, receivePerson, mobile, fax, district, deliverAddress, deliverPostcode, deliverDate, mark, totalPrice, status, salesmanId, creatorId, orderPinYin, abstractOrder, insertDate);");
		    stat.executeUpdate("drop table if exists SaleOrderProduct;");
		    stat.executeUpdate("create table SaleOrderProduct(saleOrderProductId, saleOrderSheetId, productName, number, spec, color, salePrice, mark, insertDate);");
		    stat.executeUpdate("drop table if exists PurchaseOrderSheet;");
		    stat.executeUpdate("create table PurchaseOrderSheet(purchaseOrderSheetId, purchaseOrderNo, saleOrderNo, supplierName, receivePerson, mobile, deliverAddress, deliverPostcode, deliverDate, mark, totalPrice, status, salesmanId, creatorId, orderPinYin, abstractOrder, insertDate);");
		    stat.executeUpdate("drop table if exists PurchaseOrderProduct;");
		    stat.executeUpdate("create table PurchaseOrderProduct(purchaseOrderProductId, purchaseOrderSheetId, supplierName, productName, spec, color, number, totalSalePrice, mark, insertDate);");
		    stat.executeUpdate("drop table if exists Stock;");
		    stat.executeUpdate("create table Stock(stockId, supplierName, productName, number, spec, color, averagePrice, mark, warehouseLocation, weight, insertDate);");
		    stat.executeUpdate("drop table if exists ImportStock;");
		    stat.executeUpdate("create table ImportStock(importStockId, supplierName, productName, number, spec, color, salePrice, mark, insertDate);");
		    stat.executeUpdate("drop table if exists ExportStock;");
		    stat.executeUpdate("create table ExportStock(exportStockId, supplierName, productName, number, spec, color, salePrice, mark, insertDate);");
		    
		    // demo data
		    stat.executeUpdate("insert into User values('1','coral','110','','1','','');");
		    
		    stat.executeUpdate("insert into Role values('1','Sales','Sales Role','');");
		    
		    stat.executeUpdate("insert into ModelMenu values('1',1,'menu.File.text',0,'','',1,'');");
		    stat.executeUpdate("insert into ModelMenu values('1_1',11,'menu.File.Close.text',1,'Close','Close',1,'');");
		    stat.executeUpdate("insert into ModelMenu values('2',2,'menu.Biz.text',0,'','',2,'');");
		    stat.executeUpdate("insert into ModelMenu values('2_1',21,'menu.Biz.createCustomer.text',2,'CreateCustomer','CreateCustomer',1,'');");
		    stat.executeUpdate("insert into ModelMenu values('2_2',22,'menu.Biz.mangCustomer',2,'ManageCustomer','ManageCustomer',2,'');");
		    stat.executeUpdate("insert into ModelMenu values('2_3',23,'menu.Biz.createSupplier.text',2,'CreateSupplier','CreateSupplier',3,'');");
		    stat.executeUpdate("insert into ModelMenu values('2_4',24,'menu.Biz.mangSupplier',2,'ManageSupplier','ManageSupplier',4,'');");
		    stat.executeUpdate("insert into ModelMenu values('2_5',25,'tab.saleorderSheet.label',2,'CreateSaleOrderSheet','CreateSaleOrderSheet',5,'');");
		    stat.executeUpdate("insert into ModelMenu values('2_6',26,'tab.query.label',2,'commonQuery','commonQuery',6,'');");
		    stat.executeUpdate("insert into ModelMenu values('3',3,'menu.Admin.text',0,'','',3,'');");
		    stat.executeUpdate("insert into ModelMenu values('3_1',31,'menu.Admin.createUser.text',3,'CreateUser','CreateUser',1,'');");
		    stat.executeUpdate("insert into ModelMenu values('3_2',32,'menu.Admin.changePassword.text',3,'ChangePassword','ChangePassword',2,'');");
		    stat.executeUpdate("insert into ModelMenu values('3_3',33,'tab.basicInfo',3,'BasicInfoSetup','BasicInfoSetup',3,'');");
		    stat.executeUpdate("insert into ModelMenu values('3_4',34,'tab.manageRole',3,'manageRole','manageRole',4,'');");
		    stat.executeUpdate("insert into ModelMenu values('4',4,'menu.Help.text',0,'','',4,'');");
		    stat.executeUpdate("insert into ModelMenu values('4_1',41,'menu.Help.About.text',4,'','',1,'');");

		    stat.executeUpdate("insert into RoleMenu values('1','1',1,'');");
		    stat.executeUpdate("insert into RoleMenu values('2','1',11,'');");
		    stat.executeUpdate("insert into RoleMenu values('3','1',2,'');");
		    stat.executeUpdate("insert into RoleMenu values('4','1',21,'');");
		    stat.executeUpdate("insert into RoleMenu values('5','1',22,'');");
		    stat.executeUpdate("insert into RoleMenu values('6','1',23,'');");
		    stat.executeUpdate("insert into RoleMenu values('7','1',24,'');");
		    stat.executeUpdate("insert into RoleMenu values('8','1',25,'');");
		    stat.executeUpdate("insert into RoleMenu values('9','1',26,'');");
		    stat.executeUpdate("insert into RoleMenu values('30','1',3,'');");
		    stat.executeUpdate("insert into RoleMenu values('31','1',31,'');");
		    stat.executeUpdate("insert into RoleMenu values('32','1',32,'');");
		    stat.executeUpdate("insert into RoleMenu values('33','1',33,'');");
		    stat.executeUpdate("insert into RoleMenu values('34','1',34,'');");
		    stat.executeUpdate("insert into RoleMenu values('40','1',4,'');");
		    stat.executeUpdate("insert into RoleMenu values('41','1',41,'');");
		    
		    stat.executeUpdate("insert into ShotCut values('1',21,'','menu.Biz.createCustomer.text','CreateCustomer','');");
		    stat.executeUpdate("insert into ShotCut values('2',22,'','menu.Biz.mangCustomer','ManageCustomer','');");
		    
		    stat.executeUpdate("insert into RoleShotCut values('1','1','1',1,'');");
		    stat.executeUpdate("insert into RoleShotCut values('2','1','2',2,'');");
		    
		    stat.executeUpdate("insert into BasicInfo values('BasicInfo01','','','','','','','','','','','');");
		    conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
