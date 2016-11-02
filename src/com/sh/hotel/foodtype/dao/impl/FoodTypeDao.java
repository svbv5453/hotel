package com.sh.hotel.foodtype.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.sh.hotel.foodtype.dao.IFoodTypeDao;
import com.sh.hotel.foodtype.domain.FoodType;

/**
 * model层
 * 菜系Dao实现类，
 * 实现增删改查方法
 * @author Administrator
 *
 */
public class FoodTypeDao implements IFoodTypeDao{
	
	private QueryRunner qr = new TxQueryRunner(); 
	public void addFoodType(FoodType foodType) {
		String sql = "insert into foodtype(ftName) values(?)";
		try {
			qr.update(sql, foodType.getFtName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void updateFoodType(FoodType foodType) {
		// TODO Auto-generated method stub
		String sql = "update foodtype set ftName = ? where ftId = ?";
		
		try {
			qr.update(sql, foodType.getFtName(), foodType.getFtId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void deleteFoodType(int foodTypeId) {
		// TODO Auto-generated method stub
		String sql = "delete from foodtype where ftId = ?";
		try {
			qr.update(sql, foodTypeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public List<FoodType> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from foodtype";
		try {
			return qr.query(sql, new BeanListHandler<FoodType>(FoodType.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	public FoodType findByFoodTypeId(int foodTypeId) {
		// TODO Auto-generated method stub
		String sql = "select * from foodtype where ftId = ?";
		try {
			return qr.query(sql, new BeanHandler<FoodType>(FoodType.class), foodTypeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

}
