package com.sh.hotel.food.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

import com.sh.hotel.food.dao.IFoodDao;
import com.sh.hotel.food.domain.Food;


/**
 * Food模型实现类
 * 实现增加菜品
 * 删除菜品
 * 查找所以菜品
 * 更新菜品
 * 根据id查找菜品
 * @author Administrator
 *
 */
public class FoodDao implements IFoodDao{
	
	private QueryRunner qr = new TxQueryRunner();
	
	private static Logger log = Logger.getLogger(FoodDao.class.toString());

	public void addFood(Food food) {
		// TODO Auto-generated method stub
		String sql = "insert into food(foodName, ftId, price, vprice, remark, img) values(?,?,?,?,?,?)";
		Object[] param = {food.getFoodName(), food.getFtId(), food.getPrice(), food.getvPrice(), food.getRemark(), food.getImg()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteFood(int fId) {
		// TODO Auto-generated method stub
		String sql = "delete from food where fId = ?";
		try {
			
			qr.update(sql, fId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateFood(Food food) {
		// TODO Auto-generated method stub
		String sql = "update food set foodName = ?, ftId = ?, price = ?, vprice = ?, remark = ?, img = ? where fId = ?";
		Object[] param = {food.getFoodName(), food.getFtId(), food.getPrice(), food.getvPrice(), food.getRemark()
				, food.getImg(), food.getfId()};
		try {
			qr.update(sql, param);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 需要处理查找菜品时同时将菜系查找出来
	 * 使用map集合将所有查询结果放在map集合里面，然后映射到JavaBean对象里面；
	 */
	public List<Map<String, Object>> findAllFood() {
		// TODO Auto-generated method stub
		String sql = "select * from food join foodtype using(ftId)";
		try {
			List<Map<String, Object>> lists = qr.query(sql, new MapListHandler());
			/*for (Map<String, Object> map : lists) {
				log.info(map.get("ftName").toString() + "-------");
				log.info(map.get("vprice").toString() + "-------");
				
			}*/
			
			
			return lists;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 根据id查询
	 * 注意查询语句，使用join using，去除重复列
	 */
	public Map<String, Object> findFoodById(int fId) {
		// TODO Auto-generated method stub
		String sql = "select * from food join foodtype using(ftId) where fId = ?";
		try {
			return qr.query(sql, new MapHandler(), fId);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Food> findAllFoodByPage(int m, int n) {
		// TODO Auto-generated method stub
		String sql = "select * from food limit ?,?";
		//m为起始的数，n为要每页要显示的个数
		int count = m * n;
		Object[] param = {count, n};
		try {
			List<Food> foods = qr.query(sql, new BeanListHandler<Food>(Food.class), count, n);
			for (Food food : foods) {
				log.info("数据库查找菜品" + food.toString());
			}
			 return foods;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		
	}

	/**
	 * 查找所有的菜品数
	 */
	public int findAllFoodCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from food";
		
		try {
			
			long count = qr.query(sql, new ScalarHandler<Integer>());
			
			
			log.info("count:" + count);
			return Integer.parseInt(String.valueOf(count));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	
	

}
