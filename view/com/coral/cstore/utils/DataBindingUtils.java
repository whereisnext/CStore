/**
 * 
 */
package com.coral.cstore.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.coral.fundation.Log;
import com.coral.store.model.Customer;

/**
 * @author Coral
 *
 */
public class DataBindingUtils {

	public static Object dataBinding(Control[] children, Object entity, Class cls) {
		for(Control child : children) {
			if(child instanceof Text) {
				Text childText = (Text)child;
				Object obj = childText.getData();
				if(obj != null) {
					injectData(childText.getData().toString(),childText.getText(),entity,cls);
				}
			} else if(child instanceof Combo) {
				Combo childCombo = (Combo) child;
				Object obj = childCombo.getText();
				if(obj != null) {
					injectData(childCombo.getData().toString(),childCombo.getText(),entity,cls);
				}
			}
		}
		return entity;
	}
	
	public static Object bindingToComposite(Object entity, Composite composite) {
		if(entity == null) {
			return null;
		}
		Control[] children = composite.getChildren();
		for(Control child : children) {
			if(child instanceof Text) {
				Text childText = (Text)child;
				Object obj = childText.getData();
				if(obj != null) {
					Object data = digData(childText.getData().toString(),entity,entity.getClass());
					if(data != null) {
						childText.setText(String.valueOf(data));
					}
				}
			} else if(child instanceof Combo) {
				Combo childCombo = (Combo) child;
				Object obj = childCombo.getText();
				if(obj != null) {
					Object data = digData(childCombo.getData().toString(),entity,entity.getClass());
					if(data != null) {
						childCombo.setText(String.valueOf(data));
					}
				}
			}
		}
		return entity;
	}
	
	public static String[] entityBindingColumn(TableColumn[] heads, Object entity) {
		List<String> dataList = new ArrayList<String>();
		for(TableColumn head : heads) {
			Object data = digData(head.getData().toString(),entity,entity.getClass());
			if(data != null) {
				dataList.add(data.toString());
			} else {
				dataList.add(StrUtils.empty);
			}
		}
		return dataList.toArray(new String[]{});
	}
	
	public static Object columnBindingEntity(TableColumn[] heads, TableItem items, Object entity) {
		for(int i=0 ; i < heads.length; i++) {
			TableColumn head = heads[i];
			injectData(String.valueOf(head.getData()),String.valueOf(items.getText(i)),entity, entity.getClass());
		}
		return entity;
	}
	
	public static void injectData(String propertyData, String textValue, Object entity, Class cls) {
		try {
			Class param = cls.getDeclaredField(propertyData).getType();
			Method m = cls.getMethod(StrUtils.setter(propertyData),param); 
			m.invoke(entity,new Object[]{textValue});
		} catch (Exception e) {
			Log.error("System injectData Error! The propertyData is " + propertyData 
					+ " , and the injected value is " + textValue 
					+ " , and the entity is " + entity + " , and the class is " + cls.getName(), cls, e.fillInStackTrace());
		}
	}
	
	public static Object digData(String propertyData, Object entity, Class cls) {
		Object fillData = null;
		try {
			Method m = cls.getMethod(StrUtils.getter(propertyData)); 
			fillData = m.invoke(entity);
		} catch (Exception e) {
			Log.error("System fillData Error! The propertyData is " + propertyData 
					+ " , and the entity is " + entity + " , and the class is " + cls.getName(), cls, e.fillInStackTrace());
		}
		return fillData;
	}
	
	public static void main(String[] args) {
		Customer cust = new Customer();
		injectData("customerName","Coral",cust,Customer.class);
		System.out.println(digData("customerName",cust,Customer.class));
	}
}
