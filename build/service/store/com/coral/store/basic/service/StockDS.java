package com.coral.store.basic.service;

import java.util.Date;
import com.coral.store.basic.dao.IStockDao;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.IDGenerater;
import com.coral.fundation.Log;
import com.coral.fundation.bean.BeanUtils;
import com.coral.fundation.utils.SqlUtils;
import com.coral.store.utils.StoreUtils;
import java.util.List;
import com.coral.store.model.Stock;
/**
 * <p>Title: com.coral.store.basic.service.StockDS</p>
 * <p>Description: StockDS entity </p>
 * <p>Copyright: Copyright (c) 2011 </p>
 * <p>Company: Coral Co., Ltd. </p>
 * <p>Create Time: 2011-09-02 12:02 </p>
 */
public class StockDS {

	IStockDao stockDao = BeanUtils.getBean("stockDao", IStockDao.class);

	public Stock createStock(Stock stock) {
		try {
			stock.setStockId(IDGenerater.generate());
			StoreUtils.abstractStock(stock);
			stockDao.create(stock);
		} catch (Exception e) {
			Log.error("Create Stock error.", this.getClass(),e.getCause());
		}
		return stock;
	}

	public Stock updateStock(Stock stock) {
		try {
			StoreUtils.abstractStock(stock);
			stockDao.update(stock);
		} catch (Exception e) {
			Log.error("Update Stock error.", this.getClass(),e.getCause());
		}
		return stock;
	}

	public String deleteStock(Stock stock) {
		deleteStock(stock.getStockId());
		return StrUtils.empty;
	}

	public String deleteStock(String stockId) {
		try {
			stockDao.remove(stockId);
		} catch (Exception e) {
			Log.error("Delete Stock error.", this.getClass(),e.getCause());
		}
		return StrUtils.empty;
	}

	public Stock loadStock(String stockId) {
		Stock stock= null;
		try {
			stock = stockDao.load(stockId);
		} catch (Exception e) {
			Log.error("load Stock error.", this.getClass(),e.getCause());
		}
		return stock;
	}

	public List<Stock> loadAllStock() {
		List<Stock> stockList = null;
		try {
			stockList = stockDao.loadAll();
		} catch (Exception e) {
			Log.error("load Stock error.", this.getClass(),e.getCause());
		}
		return stockList;
	}
}

