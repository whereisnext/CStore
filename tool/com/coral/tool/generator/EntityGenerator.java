/**
 * 
 */
package com.coral.tool.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.coral.tool.generator.model.Coral;
import com.coral.tool.generator.model.Entity;
import com.coral.tool.generator.model.Property;

/**
 * @author coral.ma
 * 
 */
public class EntityGenerator extends AbstractGenerator {

	private Coral coral;

	public EntityGenerator(Coral entityList) {
		this.coral = entityList;
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
		String path = default_entity_path;
		String entityPackage = coral.getEntityPackage();
		
		for (Entity entity : coral.getEntityList()) {
			FileWriter fw = null;
			PrintWriter pw = null;
			String genPath = "";
			try {
				if(entityPackage != null) {
					genPath = path + "\\" + coral.getName() + "\\" + entityPackage.replace(".", "\\") + "\\";
					File bulidFile = new File(genPath);
					if (!bulidFile.exists()) {
						bulidFile.mkdirs();
					}
				}
				String classContent = parseEntity(entity);
				// generate some bean info.
//				System.out.println("@@@ Getter / Setter generate of "+entity.getEntityName()+"@@@");
//				for(Property property : entity.getProperties()) {
//					String type = validType(property);
//					System.out.println("public " + type + os + getter(property.getPropertyName()));
//				}
//				for(Property property : entity.getProperties()) {
//					System.out.println("public void " + setter(property.getPropertyName()));
//				}
//				System.out.println("@@@ End Getter / Setter generate @@@");
				fw = new FileWriter(genPath + entity.getEntityName() + ".java");
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

	public String parseEntity(Entity entity) {
		String packageName =  coral.getEntityPackage();
		String entityName = entity.getEntityName();
		StringBuffer sb = new StringBuffer();
	    sb.append("package " + packageName + endTag);
	    sb.append(spaceTag);
	    sb.append(importGenerator(entity,coral));
	    
	    sb.append(spaceTag);
	    sb.append("/**" + spaceTag);
	    sb.append(" * <p>Title: " + packageName + "." + entityName + "</p>"
	        + spaceTag);
	    sb.append(" * <p>Description: " + entityName + " entity </p>" + spaceTag);
	    sb.append(" * <p>Copyright: Copyright (c) 2011 </p>" + spaceTag);
	    sb.append(" * <p>Company: Coral Co., Ltd. </p>" + spaceTag);
	    sb.append(" * <p>Create Time: "
	        + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())
	        + " </p>" + spaceTag);
	    sb.append(" */" + spaceTag);
	    sb.append("public class " + entityName + " implements java.io.Serializable " + braceStartTag);
	    sb.append(spaceTag);
	    // property declare
	    for(Property property : entity.getProperties()) {
	    	String type = validType(property);
	    	if("Date".equals(type)) {
	    		sb.append(tabTag + "private " + type + os + property.getPropertyName() +" = new Date()" + endTag);
	    	} else {
	    		sb.append(tabTag + "private " + type + os + property.getPropertyName() + endTag);
	    	}
	    }
	    sb.append(spaceTag);
	    for(Property property : entity.getProperties()) {
	    	String type = validType(property);
	    	sb.append(tabTag + "public " + type + os + getter(property.getPropertyName()) +  braceStartTag);
	    	sb.append(tabTag2 + "return " + property.getPropertyName() + endTag);
	    	sb.append(tabTag + braceEndTag);
	    	sb.append(tabTag + "public void " + setter(type,property.getPropertyName()) +  braceStartTag);
	    	sb.append(tabTag2 + setterContent(property.getPropertyName()) + endTag);
	    	sb.append(tabTag + braceEndTag);
	    	sb.append(spaceTag);
	    }
	    sb.append(braceEndTag);
		return sb.toString();
	}
	
	/** test case. */
	public static void main(String[] args) {
	    try {
	      EntityXmlParser mappingXmlParser = new EntityXmlParser();
	      List<Coral> coralList = mappingXmlParser.parseMappingXml();
	      // generate entity
	      EntityGenerator entityGenerator = new EntityGenerator(coralList.get(0));
	      entityGenerator.generater();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
}
