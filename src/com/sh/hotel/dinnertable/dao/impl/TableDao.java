package com.sh.hotel.dinnertable.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.sh.hotel.dinnertable.dao.ITableDao;
import com.sh.hotel.dinnertable.domain.Table;

/**
 * 餐桌model层实现
 * 包括五个方法
 * 增加餐桌
 * 删除餐桌
 * 更新餐桌
 * 查找所有餐桌
 * 根据id查找餐桌
 * @author Administrator
 *
 */
public class TableDao implements ITableDao{

	//使用其对数据库进行操作
	private QueryRunner qr = new TxQueryRunner();
	
	public void addTable(Table table) {
		// TODO Auto-generated method stub
		String sql = "insert into dinnertable(tableName) values(?)";
		try {
			qr.update(sql, table.getTableName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void deleteTable(int tId) {
		// TODO Auto-generated method stub
		String sql = "delete from dinnertable where tId = ?";
		try {
			qr.update(sql, tId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateTable(Table table) {
		// TODO Auto-generated method stub
		String sql = "update dinnertable set tableStatus = ? and reservationTime = ? where tId = ?";
		Object[] param = {table.getTableStatus(), table.getReservationTime(), table.gettId()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Table> findAllTable() {
		// TODO Auto-generated method stub
		String sql = "select * from dinnertable";
		try {
			return qr.query(sql, new BeanListHandler<Table>(Table.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	public Table findTableById(int tId) {
		// TODO Auto-generated method stub
		String sql = "select * from dinnertable where tId = ?";
		try {
			return qr.query(sql, tId, new BeanHandler<Table>(Table.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
