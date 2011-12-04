/**
 * 
 */
package com.coral.cstore.utils;

import org.eclipse.swt.graphics.Image;

import com.coral.cstore.cache.IconCache;

/**
 * @author Coral
 *
 */
public class ImageUtils {
	
	private static IconCache iconCache;
	
	public static Image getImage(String key) {
		if(iconCache == null) {
			return null;
		}
		return iconCache.getIcon(key);
	}

	/**
	 * @return the iconCache
	 */
	public static IconCache getIconCache() {
		return iconCache;
	}

	/**
	 * @param iconCache the iconCache to set
	 */
	public static void setIconCache(IconCache iconCache) {
		ImageUtils.iconCache = iconCache;
	}

}
