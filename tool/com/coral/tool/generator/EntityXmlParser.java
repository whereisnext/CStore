/**
 * 
 */
package com.coral.tool.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.coral.tool.generator.model.Coral;
import com.coral.tool.generator.model.Entity;
import com.coral.tool.generator.model.Property;

/**
 * <p>Title: com.ebao.gs.tools.generater.MappingXmlParser.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009     </p>
 * <p>Company: eBaoTech Co., Ltd.       </p>
 * <p>Create Time: 2009 ����11:49:39      </p>
 * @author coral.ma
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public class EntityXmlParser {
  
  public List<String> getMappingXML() {
	  List<String> mappingXMLs = new ArrayList<String>();
	  mappingXMLs.add("fundationEntityClasses.xml");
	  mappingXMLs.add("storeEntityClasses.xml");
	  return mappingXMLs;
  }

  /**
   * Parse Mapping Xml to generate a mapping model.
   * @return Mapping
   * @throws Exception
   */
  public List<Coral> parseMappingXml() throws Exception {
	List<Coral> corals = new ArrayList<Coral>();
	List<String> mappingXMLs = getMappingXML();
	for(String mappingXml : mappingXMLs) {
		Coral coral = new Coral();
	    File configFile = new File(mappingXml).getAbsoluteFile();
	    if (!configFile.exists()) {
	      throw new Exception("Mapping XML does not exist!");
	    }
	    SAXReader reader = new SAXReader();
	    Document document = reader.read(configFile);
	    List<Element> root = document.selectNodes("coral");
	    Element coralRoot = root.get(0);
	    coral.setName(coralRoot.attributeValue("name"));
	    coral.setEntityPackage(coralRoot.attributeValue("entityPackage"));
	    coral.setDaoIntfPackage(coralRoot.attributeValue("daoIntfPackage"));
	    coral.setDaoImplPackage(coralRoot.attributeValue("daoImplPackage"));
	    coral.setServicePackage(coralRoot.attributeValue("servicePackage"));
	    List<Element> handlerNodeList = coralRoot.elements("entity");
	    List<Entity> entityList = new ArrayList<Entity>();
	    
	    for (Element handlerNode : handlerNodeList) {
	      Entity entity = new Entity();
	//      entity.setPackageName(handlerNode.attributeValue("entityPackage"));
	      entity.setEntityName(handlerNode.attributeValue("entityName"));
	//      entity.setDaoImplName(handlerNode.attributeValue("daoImplName"));
	//      entity.setDaoIntfName(handlerNode.attributeValue("daoIntfName"));
	      
	      List<Element> attributeList = handlerNode.elements("property");
	      for (Element attributeNode : attributeList) {
	    	Property prop = new Property();
	    	prop.setPropertyName(attributeNode.attributeValue("propertyName"));
	    	prop.setType(attributeNode.attributeValue("type"));
	    	prop.setLength(attributeNode.attributeValue("length"));
	    	prop.setIsTableColumn(attributeNode.attributeValue("isTableColumn"));
	    	prop.setIsViewColumn(attributeNode.attributeValue("isViewColumn"));
	    	prop.setRef(attributeNode.attributeValue("ref"));
	    	prop.setPk(attributeNode.attributeValue("pk"));
	    	entity.addProperty(prop);
	      }
	      entityList.add(entity);
	    }
	    coral.setEntityList(entityList);
	    corals.add(coral);
	}
    return corals;
  }
}
