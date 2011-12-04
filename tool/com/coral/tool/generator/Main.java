/**
 * 
 */
package com.coral.tool.generator;

import java.util.List;

import com.coral.tool.generator.model.Coral;
import com.coral.tool.generator.model.Entity;

/**
 * <p>Title: com.ebao.gs.tools.generater.Main.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009     </p>
 * <p>Company: eBaoTech Co., Ltd.       </p>
 * <p>Create Time: 2009 ����04:59:58      </p>
 * @author coral.ma
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public class Main {

  /**
   * Running main class to generate handler and api.
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
//	      SQLiteDaoGenerater liteDaoGen = new SQLiteDaoGenerater(coral);
//	      liteDaoGen.generator();
//	      MySQLDaoGenerater daoGen = new MySQLDaoGenerater(coral);
//	      daoGen.generator();
//	      MySQLDDLGenerator ddlGen = new MySQLDDLGenerator(coral);
//	      ddlGen.generater();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
