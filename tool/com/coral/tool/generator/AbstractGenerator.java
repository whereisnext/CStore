/**
 * 
 */
package com.coral.tool.generator;

import java.util.ArrayList;
import java.util.List;

import com.coral.tool.generator.model.Coral;
import com.coral.tool.generator.model.Entity;
import com.coral.tool.generator.model.Property;

/**
 * @author coral.ma
 * 
 */
public class AbstractGenerator {
	
	public static String os = " ";
	public static String endTag = ";\r\n";
	public static String braceStartTag = " {\r\n";
	public static String braceEndTag = "}\r\n";
	public static String methodBraceEndTag = "\t}\r\n";
	public static String spaceTag = "\r\n";
	public static String tabTag = "\t";
	public static String tabTag2 = "\t\t";
	public static String tabTag3 = "\t\t\t";
	public static String tabTag4 = "\t\t\t\t";
	
	public static String startBracket = "(";
	public static String endBracket = ")";
	public static String emptyBracket = "()";
	
	public static String default_entity_path = "build\\entity";
	
	/** generate import to class. */
	public String importGenerator(Entity entity,Coral coral) {
		StringBuffer sb = new StringBuffer();
//	    sb.append("import java.io.Serializable"+ endTag);
	    boolean hasBigDecimal=false;
	    boolean hasList=false;
	    boolean hasDate=false;
	    List<String> importEntity = new ArrayList<String>();
	    for(Property property : entity.getProperties()) {
	    	String type = property.getType();
	    	if(type.equals("BigDecimal")) {
	    		hasBigDecimal = true;
	    	}
	    	if(type.startsWith("List")) {
	    		String ref = property.getRef();
	    		if(!importEntity.contains(ref)) {
	    			importEntity.add(ref);
	    		}
	    		hasList = true;
	    	}
	    	if(type.equals("Date")) {
	    		hasDate = true;
	    	}
	    }
	    if(hasBigDecimal){
	    	sb.append("import java.math.BigDecimal"+ endTag);
	    }
	    if(hasList) {
		    sb.append("import java.util.ArrayList"+ endTag);
		    sb.append("import java.util.List"+ endTag);		    
	    }
	    if(hasDate) {
	    	sb.append("import java.util.Date"+ endTag);
	    }
	    for(Entity e : coral.getEntityList()) {
	    	for(String role : importEntity) {
	    		if(role.equals(e.getEntityName())) {
	    			sb.append("import " + coral.getEntityPackage() +"."+ e.getEntityName() + endTag);
	    		}
	    	}
	    }
		return sb.toString();
	}
	
	
	/** upperFirstLetter */
	public static String capitalizeFirstLetter(String s) {
		String rs = s.substring(0, 1).toUpperCase() + s.substring(1);
		return rs;
	}
	/** lower FirstLetter */
	public static String lfl(String s) {
		String rs = s.substring(0, 1).toLowerCase() + s.substring(1);
		return rs;
	}
	
	public static String getter(String s) {
		return "get" + capitalizeFirstLetter(s) +  emptyBracket;
	}
	
	public static String setter(String t, String s) {
		return "set" + capitalizeFirstLetter(s) + startBracket + t + os + s + endBracket;
	}
	public static String setter(String s) {
		return "set" + capitalizeFirstLetter(s);
	}
	public static String setterContent(String s) {
		return "this." + s + "=" + s;
	}
	
	public static String validType(Property p) {
		String type = p.getType();
		if("List".equals(type)) {
			return type + "<" + p.ref + ">";
		}
		return type;
	}
	
	public boolean isPK(Property p) {
		if("true".equals(p.getPk())) {
			return true;
		}
		return false;
	}
	
	public boolean isColumn(Property p) {
		if("false".equals(p.getIsTableColumn())) {
			return true;
		}
		return false;
	}
	
	public boolean isDate(Property p) {
		if("Date".equals(p.getType())) {
			return true;
		}
		return false;
	}
	
	public String daoMethodName(String entityName) {
		return entityName + "Dao";
	}
	
	public String daoInterfaceName(String entityName) {
		return "I" + entityName + "Dao";
	}

	public String daoImplementName(String entityName) {
		return entityName + "DaoImpl";
	}
	
	public String daoVariableName(String entityName) {
		return lfl(entityName) + "Dao";
	}

	
	public static void main(String[] args) {
		System.out.println(AbstractGenerator.capitalizeFirstLetter("userName"));
		System.out.println(AbstractGenerator.getter("userName"));
		System.out.println(AbstractGenerator.setter("String","userName"));
		System.out.println(AbstractGenerator.setterContent("userName"));
		String type = "List<Role>";
		String rs = type.substring(type.indexOf("<")+1,type.indexOf(">"));
		System.out.println(rs);
		Property p = new Property();
		p.setType("List");
		p.setRef("Role");
		System.out.println(AbstractGenerator.validType(p));
	}
}
