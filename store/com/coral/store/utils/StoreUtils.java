/**
 * 
 */
package com.coral.store.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import com.coral.store.model.Customer;
import com.coral.store.model.ExportStock;
import com.coral.store.model.ImportStock;
import com.coral.store.model.Product;
import com.coral.store.model.PurchaseOrderProduct;
import com.coral.store.model.PurchaseOrderSheet;
import com.coral.store.model.SaleOrderProduct;
import com.coral.store.model.SaleOrderSheet;
import com.coral.store.model.Stock;
import com.coral.store.model.Supplier;

/**
 * @author coral.ma
 * 
 */
public class StoreUtils {

	/**
	 * 获取汉字串拼音首字母，英文字符不变
	 * 
	 * @param chinese
	 *            汉字串
	 * @return 汉语拼音首字母
	 */
	public static String cn2FirstSpell(String chinese) {
		StringBuffer pybf = new StringBuffer();
		char[] arr = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 128) {
				try {
					String[] _t = PinyinHelper.toHanyuPinyinStringArray(arr[i],
							defaultFormat);
					if (_t != null) {
						pybf.append(_t[0].charAt(0));
					}
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pybf.append(arr[i]);
			}
		}
		return pybf.toString().replaceAll("\\W", "").trim();
	}

	/**
	 * 获取汉字串拼音，英文字符不变
	 * 
	 * @param chinese
	 *            汉字串
	 * @return 汉语拼音
	 */
	public static String cn2Spell(String chinese) {

		StringBuffer pybf = new StringBuffer();
		char[] arr = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 128) {
				try {
					pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i],
							defaultFormat)[0]);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pybf.append(arr[i]);
			}
		}
		return pybf.toString();
	}

	public static Customer abstractCustomer(Customer customer) {
		StringBuffer sb = new StringBuffer();
		sb.append(customer.getCustomerName() + " ");
		sb.append(customer.getContectPerson() + " ");
		sb.append(customer.getDistrict() + " ");
		sb.append(customer.getAddress() + " ");
		sb.append(customer.getMobile() + " ");
		sb.append(customer.getPhone() + " ");
		sb.append(customer.getFax() + " ");
		sb.append(customer.getAccountNumber() + " ");
		customer.setAbstractCustomer(sb.toString());
		customer.setCustomerPinYin(cn2Spell(sb.toString()));
		return customer;
	}

	public static Supplier abstractSupplier(Supplier supplier) {
		StringBuffer sb = new StringBuffer();
		sb.append(supplier.getSupplierName() + " ");
		sb.append(supplier.getContectPerson() + " ");
		sb.append(supplier.getDistrict() + " ");
		sb.append(supplier.getAddress() + " ");
		sb.append(supplier.getMobile() + " ");
		sb.append(supplier.getPhone() + " ");
		sb.append(supplier.getFax() + " ");
		sb.append(supplier.getAccountNumber() + " ");
		supplier.setAbstractSupplier(sb.toString());
		supplier.setSupplierPinYin(cn2Spell(sb.toString()));
		return supplier;
	}

	public static PurchaseOrderSheet abstractPurchaseOrder(
			PurchaseOrderSheet sheet) {
		// StringBuffer sb = new StringBuffer();
		// sb.append(sheet.getSupplierName()+" ");
		// sb.append(supplier.getContectPerson()+" ");
		// sb.append(supplier.getDistrict()+" ");
		// sb.append(supplier.getAddress()+" ");
		// sb.append(supplier.getMobile()+" ");
		// sb.append(supplier.getPhone()+" ");
		// sb.append(supplier.getFax()+" ");
		// sb.append(supplier.getAccountNumber()+" ");
		// supplier.setAbstractSupplier(sb.toString());
		// supplier.setSupplierPinYin(cn2Spell(sb.toString()));
		return sheet;
	}

	public static Product abstractProduct(Product product) {
		StringBuffer sb = new StringBuffer();
		sb.append(product.getProductCode() + " ");
		sb.append(product.getProductName() + " ");
		sb.append(product.getBrand() + " ");
		sb.append(product.getSpec() + " ");
		sb.append(product.getUnit() + " ");
		sb.append(product.getColor() + " ");
		sb.append(product.getBuyPrice() + " ");
		sb.append(product.getSalePrice() + " ");
		sb.append(product.getSupplierName() + " ");
		product.setAbstractProduct(sb.toString());
		product.setProductPinYin(cn2Spell(sb.toString()));
		return product;
	}

	public static PurchaseOrderSheet abstractPurchaseOrderSheet(
			PurchaseOrderSheet purchaseOrderSheet) {
		return null;
	}

	public static PurchaseOrderProduct abstractPurchaseOrderProduct(
			PurchaseOrderProduct purchaseOrderProduct) {
		return null;
	}

	public static Stock abstractStock(Stock stock) {
		return null;
	}

	public static ImportStock abstractImportStock(ImportStock importStock) {
		return null;
	}

	public static ExportStock abstractExportStock(ExportStock exportStock) {
		return null;
	}

	public static SaleOrderSheet abstractSaleOrderSheet(
			SaleOrderSheet saleOrderSheet) {
		return null;
	}

	public static SaleOrderProduct abstractSaleOrderProduct(
			SaleOrderProduct saleOrderProduct) {
		return null;
	}
}
