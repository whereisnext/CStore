/**
 * 
 */
package com.coral.tool.generator.view;

import com.coral.tool.generator.AbstractGenerator;

/**
 * @author coral.ma
 *
 */
public class AbstractGen extends AbstractGenerator {

	public String generate(String[] twoColumns, String[] oneColumns, String i18nTitle) {
		StringBuffer sb = new StringBuffer(); 
		if(twoColumns != null) {
			for(int i=0;i<twoColumns.length;i=i+2) {
				String left = twoColumns[i];
				String right = null;
				try{
					right = twoColumns[i+1];
				}catch(Exception e) {
					right = null;
				}
				String leftLabel = left+"Label";
				String leftInput = left+"Input";
				String rightLabel = right+"Label";
				String rightInput = right+"Input";
				sb.append("// " +left + " controller."+spaceTag);
				sb.append("Label "+leftLabel +" = WidgetUtils.createLabel(composite, StrUtils.getResourceString(\""+i18nTitle+left+"\"));"+spaceTag);
				sb.append(leftLabel + ".setLayoutData(lLabelGD);"+spaceTag);
				sb.append("Text "+leftInput+" = WidgetUtils.createText(composite);"+spaceTag);
				sb.append(leftInput + ".setData(\""+ left +"\");"+spaceTag);
				sb.append(leftInput + ".setLayoutData(lInputGD);"+spaceTag);
				sb.append("createMidEmpty(composite);"+spaceTag);
				sb.append(spaceTag);
				if(right != null) {
					sb.append("// " +right + " controller."+spaceTag);
					sb.append("Label "+rightLabel +" = WidgetUtils.createLabel(composite, StrUtils.getResourceString(\""+i18nTitle+right+"\"));"+spaceTag);
					sb.append(rightLabel + ".setLayoutData(lLabelGD);"+spaceTag);
					sb.append("Text "+rightInput+" = WidgetUtils.createText(composite);"+spaceTag);
					sb.append(rightInput + ".setData(\""+ right +"\");"+spaceTag);
					sb.append(rightInput + ".setLayoutData(lInputGD);"+spaceTag);
					sb.append("createEndEmpty(composite);"+spaceTag);
					sb.append(spaceTag);
				}
			}
		}
		if(oneColumns != null) {
			for(int i=0;i<oneColumns.length;i++) {
				String column = oneColumns[i];
				String leftLabel = column+"Label";
				String leftInput = column+"Input";
				
				sb.append("// " +column + " controller."+spaceTag);
				sb.append("Label "+leftLabel +" = WidgetUtils.createLabel(composite, StrUtils.getResourceString(\""+i18nTitle+column+"\"));"+spaceTag);
				sb.append(leftLabel + ".setLayoutData(lLabelGD);"+spaceTag);
				sb.append("Text "+leftInput+" = WidgetUtils.createText(composite);"+spaceTag);
				sb.append(leftInput + ".setData(\""+ column +"\");"+spaceTag);
				sb.append(leftInput + ".setLayoutData(lCInputGD);"+spaceTag);
				sb.append("createEndEmpty(composite);"+spaceTag);
				sb.append(spaceTag);
			}
		}
		return sb.toString();
	}
}
