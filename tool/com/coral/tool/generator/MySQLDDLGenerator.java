/**
 * 
 */
package com.coral.tool.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coral.tool.generator.model.Coral;
import com.coral.tool.generator.model.Entity;
import com.coral.tool.generator.model.Property;

/**
 * @author coral.ma
 *
 */
public class MySQLDDLGenerator extends AbstractGenerator {

	private Coral coral;
	private static Map<String, String> colMap = new HashMap<String, String>();
	static{
		 colMap.put("String","VARCHAR");
		 colMap.put("Long","INT");
		 colMap.put("Date","DATE");
	}
	String VARCHAR="VARCHAR";

	public MySQLDDLGenerator(Coral entityList) {
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
		File bulidFile = new File("build\\SQL\\MySQL");
		if (!bulidFile.exists()) {
			bulidFile.mkdirs();
		}

		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			String classContent = parseEntity();
			fw = new FileWriter("build\\SQL\\MySQL\\MySQLDB_"+coral.getName()+".sql");
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
	
	public String parseEntity() {
		StringBuffer sb = new StringBuffer();
		for (Entity entity : coral.getEntityList()) {
			String tableName= entity.getEntityName();
			sb.append("CREATE TABLE ");
			sb.append(tableName);
			sb.append("(");
//			String pString = "";
			String pkField = null;
			for(Property p : entity.getProperties()) {
				if(isColumn(p)) {
					continue;
				}
				String length = p.getLength();
				if(length == null) {
					length = "50";
				}
				if(isPK(p)) {
					pkField = p.getPropertyName();
					String type = colMap.get(p.getType());
					if(VARCHAR.equals(type)) {
						sb.append(pkField + os + type + "("+ length +") NOT NULL,");
					} else {
						sb.append(pkField + os + type + " NOT NULL,");
					}
				} else {
					String type = colMap.get(p.getType());
					if(VARCHAR.equals(type)) {
						sb.append(p.getPropertyName() + os + type + "("+ length +"),");
					} else {
						sb.append(p.getPropertyName() + os + type + ",");
					}
				}
			}
			if(pkField != null) {
				sb.append("PRIMARY KEY ("+ pkField + ")");
			}
			sb.append(");");
			sb.append(spaceTag);
		}
		return sb.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try {
		      EntityXmlParser mappingXmlParser = new EntityXmlParser();
		      List<Coral> coralList = mappingXmlParser.parseMappingXml();
		      MySQLDDLGenerator ddlGen = new MySQLDDLGenerator(coralList.get(0));
		      ddlGen.generater();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}

}
