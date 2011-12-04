/**
 * 
 */
package com.coral.tool.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.store.basic.dao.ICustomerDao;
import com.coral.store.model.Customer;
import com.coral.store.utils.StoreUtils;
import com.coral.tool.generator.model.Coral;
import com.coral.tool.generator.model.Entity;
import com.coral.tool.generator.model.Property;

/**
 * @author coral.ma
 *
 */
public class ServiceGenerator extends AbstractGenerator {
	
	private Coral coral;

	private String entityPackage;
	private String daoIntfPackage;
	private String daoImplPackage;
	private String servicePackage;
	private List<Entity> entityList = new ArrayList<Entity>();
	private String daoFactory = "DaoFactory";
	private String default_service_path = "build\\service";
	private String utilClass = "StoreUtils";
	
	public ServiceGenerator(Coral coral) {
		this.coral = coral;
		this.entityPackage = coral.getEntityPackage();
		this.daoIntfPackage = coral.getDaoIntfPackage();
		this.daoImplPackage = coral.getDaoImplPackage();
		this.servicePackage = coral.getServicePackage();
		this.entityList = coral.getEntityList();
	}
	
	/**
	 * Generate business object handler java class by parsing xml.
	 * 
	 * @throws Exception
	 */
	public void generater() throws Exception {
		if (coral == null) {
			throw new Exception(
					"Generate entity error! Can not load data from XML.");
		}
		for (Entity entity : coral.getEntityList()) {
			FileWriter fw = null;
			PrintWriter pw = null;
			String genPath = "";
			try {
				if(entityPackage != null) {
					
					genPath = default_service_path + "\\" + coral.getName() + "\\" + servicePackage.replace(".", "\\") + "\\";
					File bulidFile = new File(genPath);
					if (!bulidFile.exists()) {
						bulidFile.mkdirs();
					}
				}
				String classContent = parseEntity(entity,coral.getName());
				String className = entity.getEntityName() + "DS";
				fw = new FileWriter(genPath + className + ".java");
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
	}
	
	public String parseEntity(Entity entity, String name) throws Exception {
		String entityName = entity.getEntityName();
		String entityVarible = lfl(entity.getEntityName());
		String className = entityName + "DS";
		String daoVarible = daoVariableName(entity.getEntityName());
	    String daoIntf = daoInterfaceName(entity.getEntityName());
	    System.out.println("public static "+entityName +" abstract"+entityName+"("+entityName+" " + entityVarible +") {");
		StringBuffer sb = new StringBuffer();
	    sb.append("package " + servicePackage + endTag);
	    sb.append(spaceTag);
	    sb.append(importGenerator(entity,coral));
	    sb.append("import " + daoIntfPackage + "." + daoIntf+ endTag);
	    sb.append("import com.coral.cstore.utils.StrUtils;"+ spaceTag);
	    sb.append("import com.coral.fundation.IDGenerater;"+ spaceTag);
	    sb.append("import com.coral.fundation.Log;"+ spaceTag);
	    sb.append("import com.coral.fundation.bean.BeanUtils;"+ spaceTag);
	    sb.append("import com.coral.fundation.utils.SqlUtils;"+ spaceTag);
	    if("fundation".equals(name)) {
	    	utilClass = "FoundationUtils";
	    	sb.append("import com.coral.fundation.utils.FoundationUtils;"+ spaceTag);
	    } else if("store".equals(name)) {
	    	sb.append("import com.coral.store.utils.StoreUtils;"+ spaceTag);
	    	utilClass = "StoreUtils";
	    }
	    
	    sb.append("import java.util.List;"+ spaceTag);
	    sb.append("import "+entityPackage+"."+entityName+endTag);
	    
	    sb.append("/**" + spaceTag);
	    sb.append(" * <p>Title: " + servicePackage + "." + className + "</p>"
	        + spaceTag);
	    sb.append(" * <p>Description: " + className + " entity </p>" + spaceTag);
	    sb.append(" * <p>Copyright: Copyright (c) 2011 </p>" + spaceTag);
	    sb.append(" * <p>Company: Coral Co., Ltd. </p>" + spaceTag);
	    sb.append(" * <p>Create Time: "
	        + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())
	        + " </p>" + spaceTag);
	    sb.append(" */" + spaceTag);
	    sb.append("public class " + className + braceStartTag);
	    sb.append(spaceTag);
	    
	    sb.append(tabTag + daoIntf + " " + daoVarible + " = " + "BeanUtils.getBean(\""+daoVarible+"\", "+daoIntf+".class);"+spaceTag);
//	    ICustomerDao customerDao = BeanUtils.getBean("customerDao", ICustomerDao.class););
	    sb.append(spaceTag);
	    sb.append(createMethod(entity));
	    sb.append(spaceTag);
	    sb.append(updateMethod(entity));
	    sb.append(spaceTag);
	    sb.append(deleteMethod(entity));
	    sb.append(spaceTag);
	    sb.append(deleteByIdMethod(entity));
	    sb.append(spaceTag);
	    sb.append(loadMethod(entity));
	    sb.append(spaceTag);
	    sb.append(loadAllMethod(entity));
	    sb.append(braceEndTag);
		return sb.toString();
	}
	
	public String createMethod(Entity entity) {
		String entityName = entity.getEntityName();
		String entityVarible = lfl(entity.getEntityName());
		String daoVarible = daoVariableName(entity.getEntityName());
	    StringBuffer sb = new StringBuffer();
	    sb.append(tabTag + "public "+ entityName + " create"+entityName+"("+entityName+" "+entityVarible+") {"+spaceTag);
	    sb.append(tabTag2 + "try {"+spaceTag);
	    sb.append(tabTag3 + entityVarible+".set"+entityName+"Id(IDGenerater.generate());"+spaceTag);
	    sb.append(tabTag3 + utilClass +".abstract"+entityName + "("+entityVarible+");"+spaceTag);
	    sb.append(tabTag3 + daoVarible+".create("+entityVarible+");"+spaceTag);	
	    sb.append(tabTag2 + "} catch (Exception e) {"+spaceTag);
	    sb.append(tabTag3 + "Log.error(\"Create "+entityName+" error.\", this.getClass(),e.getCause());"+spaceTag);
	    sb.append(tabTag2 + braceEndTag);
	    sb.append(tabTag2 + "return "+entityVarible+endTag);
	    sb.append(tabTag + braceEndTag);
		return sb.toString();
	}
	
	public String updateMethod(Entity entity) {
		String entityName = entity.getEntityName();
		String entityVarible = lfl(entity.getEntityName());
		String daoVarible = daoVariableName(entity.getEntityName());
	    StringBuffer sb = new StringBuffer();
	    sb.append(tabTag + "public "+ entityName + " update"+entityName+"("+entityName+" "+entityVarible+") {"+spaceTag);
	    sb.append(tabTag2 + "try {"+spaceTag);
	    sb.append(tabTag3 + utilClass +".abstract"+entityName + "("+entityVarible+");"+spaceTag);
	    sb.append(tabTag3 + daoVarible+".update("+entityVarible+");"+spaceTag);	
	    sb.append(tabTag2 + "} catch (Exception e) {"+spaceTag);
	    sb.append(tabTag3 + "Log.error(\"Update "+entityName+" error.\", this.getClass(),e.getCause());"+spaceTag);
	    sb.append(tabTag2 + braceEndTag);
	    sb.append(tabTag2 + "return "+entityVarible+endTag);
	    sb.append(tabTag + braceEndTag);
		return sb.toString();
	}
	
	public String deleteMethod(Entity entity) {
		String entityName = entity.getEntityName();
		String entityVarible = lfl(entity.getEntityName());
	    StringBuffer sb = new StringBuffer();
	    sb.append(tabTag + "public String delete"+entityName+"("+entityName+" "+entityVarible+") {"+spaceTag);
	    sb.append(tabTag2 + "delete"+ entityName +"("+entityVarible+".get"+entityName+"Id());"+spaceTag);
	    sb.append(tabTag2 + "return StrUtils.empty;"+spaceTag);
	    sb.append(tabTag + braceEndTag);
		return sb.toString();
	}
	
	public String deleteByIdMethod(Entity entity) {
		String entityName = entity.getEntityName();
		String entityVaribleId = lfl(entity.getEntityName()) + "Id";
		String daoVarible = daoVariableName(entity.getEntityName());
	    StringBuffer sb = new StringBuffer();
	    sb.append(tabTag + "public String delete"+entityName+"(String "+entityVaribleId+") {"+spaceTag);
	    sb.append(tabTag2 + "try {"+spaceTag);
	    sb.append(tabTag3 + daoVarible+".remove("+entityVaribleId+");"+spaceTag);
	    sb.append(tabTag2 + "} catch (Exception e) {"+spaceTag);
	    sb.append(tabTag3 + "Log.error(\"Delete "+entityName+" error.\", this.getClass(),e.getCause());"+spaceTag);
	    sb.append(tabTag2 + braceEndTag);
	    sb.append(tabTag2 + "return StrUtils.empty;"+spaceTag);
	    sb.append(tabTag + braceEndTag);
		return sb.toString();
	}
	
	public String loadMethod(Entity entity) {
		String entityName = entity.getEntityName();
		String entityVarible = lfl(entity.getEntityName());
		String entityVaribleId = lfl(entity.getEntityName()) + "Id";
		String daoVarible = daoVariableName(entity.getEntityName());
	    StringBuffer sb = new StringBuffer();
	    sb.append(tabTag + "public "+ entityName + " load"+entityName+"(String "+entityVaribleId+") {"+spaceTag);
	    sb.append(tabTag2 + entityName + " " + entityVarible + "= null;" + spaceTag);
	    sb.append(tabTag2 + "try {"+spaceTag);
	    sb.append(tabTag3 + entityVarible + " = " +daoVarible+".load("+entityVaribleId+");"+spaceTag);
	    sb.append(tabTag2 + "} catch (Exception e) {"+spaceTag);
	    sb.append(tabTag3 + "Log.error(\"load "+entityName+" error.\", this.getClass(),e.getCause());"+spaceTag);
	    sb.append(tabTag2 + braceEndTag);
	    sb.append(tabTag2 + "return "+entityVarible+endTag);
	    sb.append(tabTag + braceEndTag);
		return sb.toString();
	}
	
	public String loadAllMethod(Entity entity) {
		String entityName = entity.getEntityName();
		String entityVaribleList = lfl(entity.getEntityName()) + "List";
		String daoVarible = daoVariableName(entity.getEntityName());
	    StringBuffer sb = new StringBuffer();
	    sb.append(tabTag + "public List<"+ entityName + "> loadAll"+entityName+"() {"+spaceTag);
	    sb.append(tabTag2 + "List<"+ entityName + "> " + entityVaribleList + " = null;" + spaceTag);
	    sb.append(tabTag2 + "try {"+spaceTag);
	    sb.append(tabTag3 + entityVaribleList + " = " +daoVarible+".loadAll();"+spaceTag);
	    sb.append(tabTag2 + "} catch (Exception e) {"+spaceTag);
	    sb.append(tabTag3 + "Log.error(\"load "+entityName+" error.\", this.getClass(),e.getCause());"+spaceTag);
	    sb.append(tabTag2 + braceEndTag);
	    sb.append(tabTag2 + "return "+entityVaribleList+endTag);
	    sb.append(tabTag + braceEndTag);
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		      EntityXmlParser mappingXmlParser = new EntityXmlParser();
		      List<Coral> coralList = mappingXmlParser.parseMappingXml();
		      // generate entity
		      for(Coral coral : coralList) {
			      EntityGenerator entityGenerator = new EntityGenerator(coral);
			      entityGenerator.generater();
			      // generate DDL
			      SQLiteDDLGenerator liteDdlGen = new SQLiteDDLGenerator(coral);
			      liteDdlGen.generater();
			      DaoGenerater daoGenerater = new DaoGenerater(coral);
			      daoGenerater.generator();
			      ServiceGenerator serGen = new ServiceGenerator(coral);
			      serGen.generater();
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}

}
