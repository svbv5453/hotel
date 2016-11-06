package com.sh.hotel.dinnertable.service.impl;

import java.util.List;

import com.sh.hotel.dinnertable.dao.impl.TableDao;
import com.sh.hotel.dinnertable.domain.Table;
import com.sh.hotel.dinnertable.service.ITableService;
import com.sh.hotel.utils.TableStatus;

/**
 * table业务逻辑处理实现类
 * 实现与model层的解耦，分层，
 * 包含
 * 增删改查方法；
 * @author Administrator
 *
 */
public class TableService implements ITableService{
	
	private TableDao tableDao = new TableDao();

	public void addTable(Table table) {
		// TODO Auto-generated method stub
		tableDao.addTable(table);
		
	}

	public void deleteTable(int tId) {
		// TODO Auto-generated method stub
		tableDao.deleteTable(tId);
	}

	public void updateTable(Table table) {
		// TODO Auto-generated method stub
		tableDao.updateTable(table);
	}

	public List<Table> findAllTable() {
		// TODO Auto-generated method stub
		return tableDao.findAllTable();
	}

	public Table findTableById(int tId) {
		// TODO Auto-generated method stub
		return tableDao.findTableById(tId);
	}

	public List<Table> findAllTableNoUse() {
		// TODO Auto-generated method stub
		return tableDao.findAllTableNoUse(TableStatus.FREE);
	}
	

}
