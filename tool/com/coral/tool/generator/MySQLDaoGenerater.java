/**
 * 
 */
package com.coral.tool.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.coral.fundation.DBean;
import com.coral.fundation.utils.DateUtils;
import com.coral.store.model.Customer;
import com.coral.tool.generator.model.Coral;
import com.coral.tool.generator.model.Entity;
import com.coral.tool.generator.model.Property;

/**
 * <p>
 * Title: com.ebao.gs.tools.generater.MappingHandlerGenerater.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * <p>
 * Company: eBaoTech Co., Ltd.
 * </p>
 * <p>
 * Create Time: 2009 ����04:59:36
 * </p>
 * 
 * @deprecated
 * @author coral.ma
 *         <p>
 *         Update Time:
 *         </p>
 *         <p>
 *         Updater:
 *         </p>
 *         <p>
 *         Update Comments:
 *         </p>
 */
public class MySQLDaoGenerater extends AbstractGenerator {

	private Coral coral;

	private String entityPackage;
	private String daoIntfPackage;
	private String daoImplPackage;
	private List<Entity> entityList = new ArrayList<Entity>();
	private String daoFactory;
	private String default_dao_path = "build\\dao\\MySQL";

	public MySQLDaoGenerater(Coral coral) {
		this.coral = coral;
		this.entityPackage = coral.getEntityPackage();
		this.daoIntfPackage = coral.getDaoIntfPackage();
		this.daoImplPackage = coral.getDaoImplPackage();
		this.entityList = coral.getEntityList();
	}

	public void generator() throws Exception {
		if (coral == null) {
			throw new Exception(
					"Generate entity error! Can not load data from XML.");
		}
		String intfPath = generatePath(daoIntfPackage);
		String implPath = generatePath(daoImplPackage);
		for (Entity entity : entityList) {
			String classContent = generateDaoInterface(entity);
			generateFile(intfPath, classContent,daoInterfaceName(entity.getEntityName()));
		}
		for (Entity entity : entityList) {
			String classContent = generateDaoImplement(entity);
			generateFile(implPath, classContent,daoImplementName(entity.getEntityName()));
		}
		String classContent = generateDaoFactory();
		generateFile(implPath, classContent,daoFactory);
	}
	
	private String generatePath(String classPath) {
		String path = null;
		if (classPath != null) {
			path = default_dao_path + "\\" + classPath.replace(".", "\\")+ "\\";
		}
		File bulidIntfFile = new File(path);
		if (!bulidIntfFile.exists()) {
			bulidIntfFile.mkdirs();
		}
		return path;
	}

	private void generateFile(String classPath, String classContent,
			String className) throws Exception {
		FileWriter fw = null;
		PrintWriter pw = null;
		// generate interface
		try {
			fw = new FileWriter(classPath + className + ".java");
			pw = new PrintWriter(fw);
			pw.println(classContent);
			pw.flush();
		} catch (IOException e) {
			throw e;
		} finally {
			pw.close();
			fw.close();
		}
	}

	private String generateDaoInterface(Entity entity) {
		String intfName = daoInterfaceName(entity.getEntityName());
		String entityName = entity.getEntityName();
		String pkType = getPkType(entity);
		StringBuffer sb = new StringBuffer();
	    sb.append("package " + daoIntfPackage + endTag);
	    sb.append(spaceTag);
	    sb.append("import java.sql.*" + endTag);
	    sb.append("import java.util.List" + endTag);
	    sb.append("import " + entityPackage + "." + entityName + endTag);
	    sb.append(spaceTag);
	    sb.append("/**" + spaceTag);
	    sb.append(" * <p>Title: " + daoIntfPackage + "." + intfName + "</p>"
	        + spaceTag);
	    sb.append(" * <p>Description: " + intfName + " interface </p>" + spaceTag);
	    sb.append(" * <p>Copyright: Copyright (c) 2011 </p>" + spaceTag);
	    sb.append(" * <p>Company: Coral Co., Ltd. </p>" + spaceTag);
	    sb.append(" * <p>Create Time: "
	        + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())
	        + " </p>" + spaceTag);
	    sb.append(" */" + spaceTag);
	    sb.append("public interface " + intfName  + braceStartTag);
	    sb.append(spaceTag);
	    // interface body
	    sb.append(tabTag + "public "+entityName+" create(" + entityName  + " entity) throws Exception" + endTag);
	    sb.append(spaceTag);
	    sb.append(tabTag + "public void update(" + entityName  + " entity) throws Exception" + endTag);
	    sb.append(spaceTag);
	    sb.append(tabTag + "public void remove("+pkType+" entityId) throws Exception" + endTag);
	    sb.append(spaceTag);
	    sb.append(tabTag + "public "+entityName+" load("+pkType+" entityId) throws Exception" + endTag);
	    sb.append(spaceTag);
	    sb.append(tabTag + "public List<"+entityName+"> loadAll() throws Exception" + endTag);
	    sb.append(spaceTag);
	    
	    sb.append(tabTag + "public "+entityName+" fillEntity(ResultSet rs) throws Exception" + endTag);
	    sb.append(braceEndTag);
		return sb.toString();
	}

	private String generateDaoImplement(Entity entity) throws Exception {
		String implName = daoImplementName(entity.getEntityName());
		String intfName = daoInterfaceName(entity.getEntityName());
		String entityName = entity.getEntityName();
		String pkType = getPkType(entity);
		StringBuffer sb = new StringBuffer();
	    sb.append("package " + daoImplPackage + endTag);
	    sb.append(spaceTag);
	    sb.append("import java.sql.*" + endTag);
	    sb.append("import java.util.List" + endTag);
	    sb.append("import java.util.ArrayList" + endTag);
	    sb.append("import com.coral.fundation.DBean" + endTag);
	    sb.append("import " + daoIntfPackage + "." + intfName + endTag);
	    sb.append("import " + entityPackage + "." + entityName + endTag);
	    for(Property prop : entity.getProperties()) {
	    	if(isDate(prop)) {
	    		sb.append("import com.coral.fundation.utils.DateUtils" + endTag);	
	    	}
	    }
	    sb.append(spaceTag);
	    sb.append("/**" + spaceTag);
	    sb.append(" * <p>Title: " + daoImplPackage + "." + implName + "</p>"
	        + spaceTag);
	    sb.append(" * <p>Description: " + implName + " interface </p>" + spaceTag);
	    sb.append(" * <p>Copyright: Copyright (c) 2011 </p>" + spaceTag);
	    sb.append(" * <p>Company: Coral Co., Ltd. </p>" + spaceTag);
	    sb.append(" * <p>Create Time: "
	        + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())
	        + " </p>" + spaceTag);
	    sb.append(" */" + spaceTag);
	    sb.append("public class " + implName + " implements " + intfName + braceStartTag);
	    sb.append(spaceTag);
	    // interface body
	    sb.append(tabTag + "public "+entityName+" create(" + entityName  + " entity) throws Exception" + braceStartTag);
	    sb.append(generateCreateMethod(entity));
//	    sb.append(tabTag2 +"return null" + endTag);
	    sb.append(methodBraceEndTag);
	    sb.append(spaceTag);
	    sb.append(tabTag + "public void update(" + entityName  + " entity) throws Exception" + braceStartTag);
	    sb.append(generateUpdateMethod(entity));
	    sb.append(methodBraceEndTag);
	    sb.append(spaceTag);
	    sb.append(tabTag + "public void remove("+pkType+" entityId) throws Exception" + braceStartTag);
	    sb.append(generateRemoveMethod(entity));
	    sb.append(methodBraceEndTag);
	    sb.append(spaceTag);
	    sb.append(tabTag + "public "+entityName+" load("+pkType+" entityId) throws Exception" + braceStartTag);
//	    sb.append(tabTag2 +"return null" + endTag);
	    sb.append(generateLoadMethod(entity));
	    sb.append(methodBraceEndTag);
	    sb.append(spaceTag);
	    sb.append(tabTag + "public List<"+entityName+"> loadAll() throws Exception" + braceStartTag);
	    sb.append(generateLoadAllMethod(entity));
	    sb.append(methodBraceEndTag);
	    sb.append(spaceTag);
	    
	    sb.append(tabTag + "public "+entityName+" fillEntity(ResultSet rs) throws Exception" + braceStartTag);
	    sb.append(generateFillEntityMethod(entity));
//	    sb.append(tabTag2 +"return null" + endTag);
	    sb.append(methodBraceEndTag);
	    sb.append(braceEndTag);
		return sb.toString();
	}
	private String getPkType (Entity entity) {
	    String pkType= null;
	    List<Property> props = entity.getProperties();
	    for(int i=0; i< props.size(); i++) {
			if(isPK(props.get(i))) {
				pkType = props.get(i).getType();
				break;
			}
		}
	    return pkType;
	}
	private String generateCreateMethod(Entity entity) {
		StringBuffer sb = new StringBuffer();
		String entityName = entity.getEntityName();
		sb.append(tabTag2 + "DBean db = new DBean();" + spaceTag);
		sb.append(tabTag2 + "PreparedStatement ps = null;"+ spaceTag);
		sb.append(tabTag2 + "StringBuffer sb = new StringBuffer();"+ spaceTag);
		sb.append(tabTag2 + "sb.append(\"Insert into "+ entityName +"(\");"+ spaceTag);
		List<Property> props = entity.getProperties();
		int columIndex = 0;
		String conditionStr="";
		for(int i=0; i< props.size(); i++) {
			if("false".equals(props.get(i).getIsTableColumn())) {
				continue;
			}
			columIndex++;
			String starStr = "sb.append(\""; 
			conditionStr += tabTag2 + starStr + props.get(i).getPropertyName()+",\");"+ spaceTag;
		}
		conditionStr = conditionStr.substring(0,conditionStr.lastIndexOf(",")) + conditionStr.substring(conditionStr.lastIndexOf(",") + 1);
		sb.append(conditionStr);
		sb.append(tabTag2 + "sb.append(\") values(\");"+ spaceTag);
		
		sb.append(tabTag2 + "for (int i = 0; i < "+columIndex+"; i++) {"+ spaceTag);
		sb.append(tabTag3 + "sb.append(i == 0 ? \"?\" : \",?\");"+ spaceTag);
		sb.append(tabTag2 + braceEndTag);
		sb.append(tabTag2 + "sb.append(\")\");"+ spaceTag);
		sb.append(tabTag2 + "try {"+ spaceTag);
		sb.append(tabTag3 + "Connection con = db.getMySQLConnection();"+ spaceTag);
		sb.append(tabTag3 + "ps = con.prepareStatement(sb.toString());"+ spaceTag);
		sb.append(tabTag3 + "int pos = 1;"+ spaceTag);
		for(int i=0; i< props.size(); i++) {
			if(isColumn(props.get(i))) {
				continue;
			}
			if(isDate(props.get(i))) {
				sb.append(tabTag3 + "ps."+ setter(props.get(i).getType())+"(pos++, DateUtils.toSqlDate(entity."+ getter(props.get(i).getPropertyName()) +"));"+ spaceTag);
			}else {
				sb.append(tabTag3 + "ps."+ setter(props.get(i).getType())+"(pos++, entity."+ getter(props.get(i).getPropertyName()) +");"+ spaceTag);
			}
		}
//		sb.append(tabTag3 + "ps.setString(pos++, entity.getUserName());"+ spaceTag);
//		sb.append(tabTag3 + "ps.setString(pos++, entity.getPassword());"+ spaceTag);
		sb.append(tabTag3 + "ps.execute();"+ spaceTag);
		sb.append(tabTag2 + "}catch(Exception e) {"+ spaceTag);
		sb.append(tabTag3 + "e.printStackTrace();"+ spaceTag);
		sb.append(tabTag2 + "} finally {"+ spaceTag);
		sb.append(tabTag3 + "db.closeAll(null, ps, db);"+ spaceTag);
		sb.append(tabTag2 + "}"+ spaceTag);
		sb.append(tabTag2 + "return entity;"+ spaceTag);
		return sb.toString();
	}
	
	private String generateUpdateMethod(Entity entity) throws Exception {
		String entityName = entity.getEntityName();
		List<Property> props = entity.getProperties();
		String pkType = null;
		String pkColumnName = null;
		StringBuffer sb = new StringBuffer();
		sb.append(tabTag2 + "DBean db = new DBean();" + spaceTag);
		sb.append(tabTag2 + "PreparedStatement ps = null;"+ spaceTag);
		sb.append(tabTag2 + "StringBuffer sb = new StringBuffer();"+ spaceTag);
		sb.append(tabTag2 + "sb.append(\"Update "+entityName+" set \");"+ spaceTag);
		String conditionStr="";
		for(int i=0; i< props.size(); i++) {
			if(isColumn(props.get(i))) {
				continue;
			}
			if(isPK(props.get(i))) {
				pkColumnName = props.get(i).getPropertyName();
				pkType = props.get(i).getType();
				continue;
			}
			String starStr = "sb.append(\""; 
			conditionStr += tabTag2 + starStr + props.get(i).getPropertyName()+"=?,\");"+ spaceTag;
		}
		conditionStr = conditionStr.substring(0,conditionStr.lastIndexOf(",")) + conditionStr.substring(conditionStr.lastIndexOf(",") + 1);
		sb.append(conditionStr);
		if(pkColumnName == null) {
			throw new Exception(entityName + " entity didn't define PK.");
		}
		sb.append(tabTag2 + "sb.append(\" where "+pkColumnName+" = ?\");"+ spaceTag);
		
		sb.append(tabTag2 + "try {"+ spaceTag);
		sb.append(tabTag3 + "Connection con = db.getMySQLConnection();"+ spaceTag);
		sb.append(tabTag3 + "ps = con.prepareStatement(sb.toString());"+ spaceTag);
		sb.append(tabTag3 + "int pos = 1;"+ spaceTag);
		for(int i=0; i< props.size(); i++) {
			if(isColumn(props.get(i)) || isPK(props.get(i))) {
				continue;
			}
			
			String propName = props.get(i).getPropertyName();
			String propType = props.get(i).getType();
			if(isDate(props.get(i))) {
//				sb.append(tabTag3 + "ps."+ setter(props.get(i).getType())+"(pos++, DateUtils.toSqlDate(entity."+ getter(props.get(i).getPropertyName()) +"));"+ spaceTag);
				sb.append(tabTag3 + "ps.set"+propType+"(pos++, DateUtils.toSqlDate(entity."+getter(propName)+"));" + spaceTag);
			} else {
				sb.append(tabTag3 + "ps.set"+propType+"(pos++, entity."+getter(propName)+");" + spaceTag);
			}
		}
		sb.append(tabTag3 + "ps.set"+pkType+"(pos++, entity."+getter(pkColumnName)+");"+ spaceTag);
		sb.append(tabTag3 + "ps.execute();"+ spaceTag);
		sb.append(tabTag2 + "}catch(Exception e) {"+ spaceTag);
		sb.append(tabTag3 + "e.printStackTrace();"+ spaceTag);
		sb.append(tabTag2 + "} finally {"+ spaceTag);
		sb.append(tabTag3 + "db.closeAll(null, ps, db);"+ spaceTag);
		sb.append(tabTag2 + "}"+ spaceTag);
		return sb.toString();
	}
	
	private String generateRemoveMethod(Entity entity) throws Exception {
		String entityName = entity.getEntityName();
		List<Property> props = entity.getProperties();
		String pkType = null;
		String pkColumnName = null;
		StringBuffer sb = new StringBuffer();
		sb.append(tabTag2 + "DBean db = new DBean();" + spaceTag);
		sb.append(tabTag2 + "PreparedStatement ps = null;"+ spaceTag);
		sb.append(tabTag2 + "StringBuffer sb = new StringBuffer();"+ spaceTag);
		sb.append(tabTag2 + "sb.append(\"delete from "+entityName+" \");"+ spaceTag);
		for(int i=0; i< props.size(); i++) {
			if(isPK(props.get(i))) {
				pkColumnName = props.get(i).getPropertyName();
				pkType = props.get(i).getType();
				continue;
			}
		}
		sb.append(tabTag2 + "sb.append(\"where "+ pkColumnName +" = ?\");"+ spaceTag);
		sb.append(tabTag2 + "try {" + spaceTag);
		sb.append(tabTag3 + "Connection con = db.getMySQLConnection();" + spaceTag);
		sb.append(tabTag3 + "ps = con.prepareStatement(sb.toString());" + spaceTag);
		sb.append(tabTag3 + "ps.set"+pkType+"(1, entityId);"+ spaceTag);
		sb.append(tabTag3 + "ps.execute();" + spaceTag);
		sb.append(tabTag2 + "}catch(Exception e) {" + spaceTag);
		sb.append(tabTag3 + "e.printStackTrace();" + spaceTag);
		sb.append(tabTag2 + "} finally {" + spaceTag);
		sb.append(tabTag3 + "db.closeAll(null, ps, db);" + spaceTag);
		sb.append(tabTag2 + "}" + spaceTag);
		return sb.toString();
	}
	
	private String generateLoadMethod(Entity entity) throws Exception {
		String entityName = entity.getEntityName();
		List<Property> props = entity.getProperties();
		String pkType = null;
		String pkColumnName = null;
		StringBuffer sb = new StringBuffer();
		sb.append(tabTag2 + entityName + " entity = null;" + spaceTag);
		sb.append(tabTag2 + "DBean db = new DBean();" + spaceTag);
		sb.append(tabTag2 + "PreparedStatement ps = null;"+ spaceTag);
		sb.append(tabTag2 + "ResultSet rs = null;"+ spaceTag);
		sb.append(tabTag2 + "StringBuffer sb = new StringBuffer();"+ spaceTag);
		sb.append(tabTag2 + "sb.append(\"Select * from "+entityName+" \");"+ spaceTag);
		for(int i=0; i< props.size(); i++) {
			if(isPK(props.get(i))) {
				pkColumnName = props.get(i).getPropertyName();
				pkType = props.get(i).getType();
				continue;
			}
		}
		sb.append(tabTag2 + "sb.append(\"where "+ pkColumnName +" = ?\");"+ spaceTag);
		sb.append(tabTag2 + "try {" + spaceTag);
		sb.append(tabTag3 + "Connection con = db.getMySQLConnection();" + spaceTag);
		sb.append(tabTag3 + "ps = con.prepareStatement(sb.toString());" + spaceTag);
		sb.append(tabTag3 + "ps.set"+pkType+"(1, entityId);"+ spaceTag);
		sb.append(tabTag3 + "rs = ps.executeQuery();" + spaceTag);
		sb.append(tabTag3 + "if (rs.next()) {" + spaceTag);
		sb.append(tabTag4 + "entity = fillEntity(rs);" + spaceTag);
		sb.append(tabTag3 + "}" + spaceTag);
		sb.append(tabTag2 + "}catch(Exception e) {" + spaceTag);
		sb.append(tabTag3 + "e.printStackTrace();" + spaceTag);
		sb.append(tabTag2 + "} finally {" + spaceTag);
		sb.append(tabTag3 + "db.closeAll(null, ps, db);" + spaceTag);
		sb.append(tabTag2 + "}" + spaceTag);
		sb.append(tabTag2 + "return entity;" + spaceTag);
		return sb.toString();
	}
	
	private String generateLoadAllMethod(Entity entity) throws Exception {
		String entityName = entity.getEntityName();
		List<Property> props = entity.getProperties();
		StringBuffer sb = new StringBuffer();
		sb.append(tabTag2 + "List<" + entityName + "> entities = new ArrayList<"+entityName+">();" + spaceTag);
		sb.append(tabTag2 + "DBean db = new DBean();" + spaceTag);
		sb.append(tabTag2 + "PreparedStatement ps = null;"+ spaceTag);
		sb.append(tabTag2 + "ResultSet rs = null;"+ spaceTag);
		sb.append(tabTag2 + "StringBuffer sb = new StringBuffer();"+ spaceTag);
		sb.append(tabTag2 + "sb.append(\"Select * from "+entityName+" \");"+ spaceTag);
		
		sb.append(tabTag2 + "try {" + spaceTag);
		sb.append(tabTag3 + "Connection con = db.getMySQLConnection();" + spaceTag);
		sb.append(tabTag3 + "ps = con.prepareStatement(sb.toString());" + spaceTag);		
		sb.append(tabTag3 + "rs = ps.executeQuery();" + spaceTag);
		sb.append(tabTag3 + "while (rs.next()) {" + spaceTag);
		sb.append(tabTag4 + "entities.add(fillEntity(rs));" + spaceTag);
		sb.append(tabTag3 + "}" + spaceTag);
		sb.append(tabTag2 + "}catch(Exception e) {" + spaceTag);
		sb.append(tabTag3 + "e.printStackTrace();" + spaceTag);
		sb.append(tabTag2 + "} finally {" + spaceTag);
		sb.append(tabTag3 + "db.closeAll(null, ps, db);" + spaceTag);
		sb.append(tabTag2 + "}" + spaceTag);
		sb.append(tabTag2 + "return entities;" + spaceTag);
		return sb.toString();
	}

	private String generateFillEntityMethod(Entity entity) throws Exception {
		String entityName = entity.getEntityName();
		List<Property> props = entity.getProperties();
		StringBuffer sb = new StringBuffer();
		sb.append(tabTag2+ entityName + " entity = new " + entityName + "();" + spaceTag);
		for(int i=0; i< props.size(); i++) {
			if(isColumn(props.get(i))) {
				continue;
			}
			String propName = props.get(i).getPropertyName();
			String propType = props.get(i).getType();
			sb.append(tabTag2 + "entity."+ setter(propName)+"(rs.get"+ propType + "(\""+ propName +"\"));" + spaceTag);
		}
		sb.append(tabTag2 + "return entity;" + spaceTag);
		return sb.toString();
	}

	private String generateDaoFactory() {
		daoFactory=capitalizeFirstLetter(coral.getName()) + "DaoFactory";
		StringBuffer sb = new StringBuffer();
	    sb.append("package " + daoImplPackage + endTag);
	    sb.append(spaceTag);
	    for(Entity entity : entityList) {
		    sb.append("import " + daoIntfPackage + "." + daoInterfaceName(entity.getEntityName()) + endTag);
		    sb.append("import " + daoImplPackage + "." + daoImplementName(entity.getEntityName()) + endTag);
	    }
	    sb.append(spaceTag);
	    sb.append("/**" + spaceTag);
	    sb.append(" * <p>Title: " + daoImplPackage + "." + daoFactory + "</p>"
	        + spaceTag);
	    sb.append(" * <p>Description: All system dao factory </p>" + spaceTag);
	    sb.append(" * <p>Copyright: Copyright (c) 2011 </p>" + spaceTag);
	    sb.append(" * <p>Company: Coral Co., Ltd. </p>" + spaceTag);
	    sb.append(" * <p>Create Time: "
	        + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())
	        + " </p>" + spaceTag);
	    sb.append(" */" + spaceTag);
	    sb.append("public class " + daoFactory + braceStartTag);
	    sb.append(spaceTag);
	    for(Entity entity : entityList) {
	    	String eName = entity.getEntityName();
	    	String implName = daoImplementName(eName);
			String intfName = daoInterfaceName(eName);
			String variName = daoVariableName(eName);
			String methodName = daoMethodName(eName);
	    	sb.append(tabTag + "private static "+ intfName + os + variName + " = new " + implName + emptyBracket + endTag);
		    sb.append(tabTag + "public static " + intfName + os + getter(methodName) + braceStartTag);
		    sb.append(tabTag2 + "return " + variName + endTag);
		    sb.append(methodBraceEndTag);
		    sb.append(spaceTag);
	    }
	    sb.append(braceEndTag);
	    return sb.toString();
	}
	
//	private String daoMethodName(String entityName) {
//		return entityName + "Dao";
//	}
//	
//	private String daoInterfaceName(String entityName) {
//		return "I" + entityName + "Dao";
//	}
//
//	private String daoImplementName(String entityName) {
//		return entityName + "DaoImpl";
//	}
//	
//	private String daoVariableName(String entityName) {
//		return lfl(entityName) + "Dao";
//	}
	
	
	/** test case. */
	public static void main(String[] args) {
	    try {
	      EntityXmlParser mappingXmlParser = new EntityXmlParser();
	      List<Coral> coralList = mappingXmlParser.parseMappingXml();
	      MySQLDaoGenerater entityGenerator = new MySQLDaoGenerater(coralList.get(0));
	      entityGenerator.generator();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

}
