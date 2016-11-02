package com.sh.hotel.dinnertable.service;

import java.util.List;

import com.sh.hotel.dinnertable.domain.Table;

/**
 * table业务逻辑处理层接口
 * 包含方法
 * 增加table
 * 
 * 删除table
 * 更新table状态
 * 查找所有table
 * 根据id查找table
 * @author Administrator
 *
 */
public interface ITableService {
	
	void addTable(Table table);
	void deleteTable(int tId);
	void updateTable(Table table);
	List<Table> findAllTable();
	Table findTableById(int tId);

}
