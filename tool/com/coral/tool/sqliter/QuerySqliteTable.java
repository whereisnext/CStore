/**
 * 
 */
package com.coral.tool.sqliter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author coral.ma
 *
 */
public class QuerySqliteTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sql = "";
//		sql = "select * from ModelMenu";
//		sql = "select * from RoleMenu";
		sql = "select * from ModelMenu mm, RoleMenu rm where mm.menuId = rm.menuId";
		query(sql);
	}

	public static void query(String sql) {
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			Class.forName("org.sqlite.JDBC");
		    Connection conn =DriverManager.getConnection("jdbc:sqlite:cstore.db");
		    Statement stat = conn.createStatement();
		    ResultSet rs = stat.executeQuery(sql);
		    while (rs.next()) {
		    	List<String> str = new ArrayList<String>();
		    	try {
			    	for(int i=1; i< 100; i++) {
			    		String value = rs.getString(i);
			    		if(value != null) {
			    			if("".equals(value)) value = "<null>";
			    			str.add(value);
			    		} else {
			    			str.add(String.valueOf(rs.getLong(i)));
			    		}
			    	}
			    	list.add(str);
		    	} catch (Exception e) {
		    		list.add(str);
		    		continue;
				}   	
		    }		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		// display
		int maxLength = 0;
	    int localLength = 0;
		for(List<String> str : list) {
			for(String s : str) {
				localLength = s.length();
				if(localLength > maxLength) {
    				maxLength = localLength;
    			}
			}
		}
		for(List<String> str : list) {
			for(String s : str) {
				String space="";
				localLength = s.length();
				int es = maxLength - localLength;
				if(es>0) {
    				for(int j=0;j<es;j++) {
    					space +=" ";
    				}
    			}
				System.out.print(s + space+ " ");
			}
			System.out.println("");
		}
	}
}
