/**
 * 
 */
package temp;

import java.util.List;
import java.util.Properties;

import com.coral.tool.generator.model.Entity;

/**
 * <p>Title: com.ebao.gs.tools.generater.MappingHandlerGenerater.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009     </p>
 * <p>Company: eBaoTech Co., Ltd.       </p>
 * <p>Create Time: 2009 ����04:59:36      </p>
 * @author coral.ma
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public class DaoGenerater {

  private List<Entity> mapping;
  private String packageName;
  private String parentClass;
  private String implInterface;


  public DaoGenerater() {
  }

  public DaoGenerater(List<Entity> mapping, Properties properties) {
    this.mapping = mapping;
    this.packageName = properties.getProperty("packageName");
    this.parentClass = properties.getProperty("parentClass");
    this.implInterface = properties.getProperty("implInterface");
  }

//  /**
//   * Generate business object handler java class by parsing xml. 
//   * @throws Exception
//   */
//  public void generater() throws Exception {
//    if (mapping == null) {
//      throw new Exception("Mapping XML parse error!");
//    }
//    File bulidFile = new File("build\\handler");
//    if (!bulidFile.exists()) {
//      bulidFile.mkdirs();
//    }
//
//    List<MappingHandler> handlerList = mapping.getHandlerList();
//    for (MappingHandler handler : handlerList) {
//      FileWriter fw = null;
//      PrintWriter pw = null;
//      try {
//        String classContent = parseMapping(handler);
//        fw = new FileWriter("build\\handler\\" + handler.getName() + ".java");
//        pw = new PrintWriter(fw);
//        pw.println(classContent);
//        pw.flush();
//      } catch (IOException e) {
//        throw e;
//        //        e.printStackTrace();
//      } finally {
//        pw.close();
//        fw.close();
//      }
//    }
//  }
//
//  /**
//   * Parsing Object of XML definition to create the java class content.
//   * @param handler
//   * @return String
//   * @throws Exception
//   */
//  public String parseMapping(MappingHandler handler) throws Exception {
//    StringBuffer sb = new StringBuffer();
//    sb.append("package " + packageName + endTag);
//    sb.append(spaceTag);
//    sb.append("import " + parentClass + endTag);
//    sb.append("import " + implInterface + endTag);
//    sb.append(spaceTag);
//    sb.append("/**" + spaceTag);
//    sb.append(" * <p>Title: " + packageName + "." + handler.getName() + "</p>"
//        + spaceTag);
//    sb.append(" * <p>Description: " + handler.getName() + " for "
//        + handler.getBoClass() + " and " + handler.getSoaBoClass()
//        + " conversion</p>" + spaceTag);
//    sb.append(" * <p>Copyright: Copyright (c) 2009     </p>" + spaceTag);
//    sb.append(" * <p>Company: eBaoTech Co., Ltd.       </p>" + spaceTag);
//    sb.append(" * <p>Create Time: "
//        + new SimpleDateFormat("yyyy-MM-dd HH:mm")
//            .format(com.ebao.framework.AppContext.getCurrentUserLocalTime())
//        + " </p>" + spaceTag);
//    sb.append(" */" + spaceTag);
//    sb.append("public class " + handler.getName()
//        + " extends DefaultMappingHandler implements IMappingHandler"
//        + braceStartTag);
//    sb.append(spaceTag);
//    generateCopyBoToSoaBoMethod(handler, sb);
//    sb.append(spaceTag);
//    generateCopySoaBoToBoMethod(handler, sb);
//    sb.append(spaceTag);
//    sb.append(braceEndTag);
//    return sb.toString();
//  }
//
//  /**
//   * Generate copy bo attribute to soabo method.
//   * @param handler
//   * @param sb
//   */
//  public void generateCopyBoToSoaBoMethod(MappingHandler handler,
//      StringBuffer sb) {
//    String boClass = handler.getBoClass();
//    String soaBoClass = handler.getSoaBoClass();
//    sb.append(tabTag + "/**" + spaceTag);
//    sb.append(tabTag + " * Copy all attribute value from "
//        + handler.getBoClass() + " to " + handler.getSoaBoClass() + spaceTag);
//    sb.append(tabTag + " * @param boParam" + spaceTag);
//    sb.append(tabTag + " * @param soaBoParam" + spaceTag);
//    sb.append(tabTag + " * @return Object" + spaceTag);
//    sb.append(tabTag + " */" + spaceTag);
//    sb
//        .append(tabTag
//            + "public Object copyBoToSoaBo(Object boParam, Object soaBoParam) throws Exception"
//            + braceStartTag);
//    sb.append(tabTag + tabTag + "super.copyBoToSoaBo(boParam, soaBoParam)"
//        + endTag);
//    sb.append(tabTag + tabTag + boClass + " bo = (" + boClass + ") boParam"
//        + endTag);
//    sb.append(tabTag + tabTag + soaBoClass + " soaBo = (" + soaBoClass
//        + ") soaBoParam" + endTag);
//    for (MappingAttribute attribute : handler.getAttributeList()) {
//      sb.append(tabTag + tabTag + "soaBo."
//          + attribute.getSoaBoAttributeSetter() + "(bo."
//          + attribute.getBoAttributeGetter() + "())" + endTag);
//    }
//    sb.append(tabTag + tabTag + "return soaBo" + endTag);
//    sb.append(tabTag + braceEndTag);
//  }
//
//  /**
//   * General copy soabo to bo method.
//   * @param handler
//   * @param sb
//   */
//  public void generateCopySoaBoToBoMethod(MappingHandler handler,
//      StringBuffer sb) {
//    String boClass = handler.getBoClass();
//    String soaBoClass = handler.getSoaBoClass();
//    sb.append(tabTag + "/**" + spaceTag);
//    sb.append(tabTag + " * Copy all attribute value from "
//        + handler.getSoaBoClass() + " to " + handler.getBoClass() + spaceTag);
//    sb.append(tabTag + " * @param soaBoParam" + spaceTag);
//    sb.append(tabTag + " * @param boParam" + spaceTag);
//    sb.append(tabTag + " * @return Object" + spaceTag);
//    sb.append(tabTag + " */" + spaceTag);
//    sb
//        .append(tabTag
//            + "public Object copySoaBoToBo(Object soaBoParam, Object boParam) throws Exception"
//            + braceStartTag);
//    sb.append(tabTag + tabTag + "super.copySoaBoToBo(soaBoParam, boParam)"
//        + endTag);
//    sb.append(tabTag + tabTag + soaBoClass + " soaBo = (" + soaBoClass
//        + ") soaBoParam" + endTag);
//    sb.append(tabTag + tabTag + boClass + " bo = (" + boClass + ") boParam"
//        + endTag);
//    for (MappingAttribute attribute : handler.getAttributeList()) {
//      sb.append(tabTag + tabTag + "bo." + attribute.getBoAttributeSetter()
//          + "(soaBo." + attribute.getSoaBoAttributeGetter() + "())" + endTag);
//    }
//    sb.append(tabTag + tabTag + "return bo" + endTag);
//    sb.append(tabTag + braceEndTag);
//  }
}
