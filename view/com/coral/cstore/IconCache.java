/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.coral.cstore;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

import com.coral.cstore.utils.StrUtils;

/**
 * Manages icons for the application. This is necessary as we could easily end
 * up creating thousands of icons bearing the same image.
 */
public class IconCache {

	public Map<String, String> imageLocations = new HashMap<String, String>() {
		{
			put("shellIcon", "/icons/app_icon.ico");
		}
	};

	
	public Map<String, Image> stockImages;

	// Stock cursors
	public final int cursorDefault = 0, cursorWait = 1;
	public Cursor stockCursors[];
	// Cached icons
//	private Hashtable iconCache; /* map Program to Image */

	public IconCache() {
	}

	/**
	 * Loads the resources
	 * 
	 * @param display
	 *            the display
	 */
	public void initResources(Display display) {
		if (stockImages == null) {
			stockImages = new HashMap<String, Image>();

			Set<String> imageKeys = imageLocations.keySet();
			for (String imageKey : imageKeys) {
				Image image = createStockImage(display, imageLocations.get(imageKey));
				if (image == null) {
					freeResources();
					throw new IllegalStateException(
							StrUtils.getResourceString("error.CouldNotLoadResources"));
				}
				stockImages.put(imageKey, image);
			}
		}
		if (stockCursors == null) {
			stockCursors = new Cursor[] { null,
					new Cursor(display, SWT.CURSOR_WAIT) };
		}
//		iconCache = new Hashtable();
	}

	/**
	 * Frees the resources
	 */
	public void freeResources() {
		if (stockImages != null) {
			for (Image image : stockImages.values()) {
				if (image != null)
					image.dispose();
			}
			stockImages = null;
		}
//		if (iconCache != null) {
//			for (Enumeration it = iconCache.elements(); it.hasMoreElements();) {
//				Image image = (Image) it.nextElement();
//				image.dispose();
//			}
//		}
		if (stockCursors != null) {
			for (int i = 0; i < stockCursors.length; ++i) {
				final Cursor cursor = stockCursors[i];
				if (cursor != null)
					cursor.dispose();
			}
			stockCursors = null;
		}
	}

	/**
	 * Creates a stock image
	 * 
	 * @param display
	 *            the display
	 * @param path
	 *            the relative path to the icon
	 */
	private Image createStockImage(Display display, String path) {
		InputStream stream = IconCache.class.getResourceAsStream(path);
		ImageData imageData = new ImageData(stream);
		ImageData mask = imageData.getTransparencyMask();
		Image result = new Image(display, imageData, mask);
		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Image getIcon(String key) {
		return stockImages.get(key);
	}
	/**
	 * Gets an image for a file associated with a given program
	 * 
	 * @param program
	 *            the Program
	 */
	// public Image getIconFromProgram(Program program) {
	// Image image = (Image) iconCache.get(program);
	// if (image == null) {
	// ImageData imageData = program.getImageData();
	// if (imageData != null) {
	// image = new Image(null, imageData, imageData.getTransparencyMask());
	// iconCache.put(program, image);
	// } else {
	// image = stockImages[iconFile];
	// }
	// }
	// return image;
	// }
}
