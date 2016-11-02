package com.sh.hotel.dinnertable.dao;

import java.util.List;

import com.sh.hotel.dinnertable.domain.Table;

/**
 * 餐桌model层接口
 * 包括
 * 增加餐桌、删除餐桌、更改餐桌状态、查找所有餐桌方法
 * @author Administrator
 *
 */
public interface ITableDao {
	
	void addTable(Table table);
	void deleteTable(int tId);
	void updateTable(Table table);
	List<Table> findAllTable();
	Table findTableById(int tId);
	
	

}
