/**
 * 
 */
package com.coral.tool.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.coral.tool.generator.model.Coral;
import com.coral.tool.generator.model.Entity;
import com.coral.tool.generator.model.Property;

/**
 * @author coral.ma
 *
 */
public class SQLiteDDLGenerator extends AbstractGenerator {

	private Coral coral;

	public SQLiteDDLGenerator(Coral entityList) {
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
		File bulidFile = new File("build\\SQL\\SQLite");
		if (!bulidFile.exists()) {
			bulidFile.mkdirs();
		}

		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			System.out.println("### Generate Entity related info of "+ coral.getName() +" ###");
			String classContent = parseEntity();
			System.out.println("### End generate Entity related info of "+ coral.getName() +" ###");
			fw = new FileWriter("build\\SQL\\SQLite\\SQLiteDB_"+coral.getName()+".sql");
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
		StringBuffer allSb = new StringBuffer();
		for (Entity entity : coral.getEntityList()) {
			StringBuffer sb = new StringBuffer();
			String tableName= entity.getEntityName();
			System.out.println("stat.executeUpdate(\"drop table if exists " + tableName + ";\");"); 
			sb.append("create table ");
			sb.append(tableName);
			sb.append("(");
			String pString = "";
			for(Property p : entity.getProperties()) {
				if("false".equals(p.getIsTableColumn())) {
					continue;
				}
				pString+= p.getPropertyName() + ", ";
			}
			pString = pString.substring(0,pString.lastIndexOf(","));
			sb.append(pString);
			sb.append(");");
			System.out.println("stat.executeUpdate(\""+sb + "\");");
			sb.append(spaceTag);
			allSb.append(sb);
		}
		
		return allSb.toString();
	}
	
	/** test case. */
	public static void main(String[] args) {
	    try {
	      EntityXmlParser mappingXmlParser = new EntityXmlParser();
	      List<Coral> coralList = mappingXmlParser.parseMappingXml();
	      SQLiteDDLGenerator ddlGen = new SQLiteDDLGenerator(coralList.get(0));
	      ddlGen.generater();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
}
