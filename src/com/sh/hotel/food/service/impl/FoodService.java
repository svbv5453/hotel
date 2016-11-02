package com.sh.hotel.food.service.impl;

import java.util.List;
import java.util.Map;

import com.sh.hotel.food.dao.IFoodDao;
import com.sh.hotel.food.dao.impl.FoodDao;
import com.sh.hotel.food.domain.Food;
import com.sh.hotel.food.service.IFoodService;

/**
 * Food业务逻辑层实现类
 * 包括增删改查方法
 * @author Administrator
 *
 */
public class FoodService implements IFoodService{

	private IFoodDao foodDao = new FoodDao();
	public void addFood(Food food) {
		// TODO Auto-generated method stub
		foodDao.addFood(food);
	}

	public void deleteFood(int fId) {
		// TODO Auto-generated method stub
		foodDao.deleteFood(fId);
	}

	public void updateFood(Food food) {
		// TODO Auto-generated method stub
		foodDao.updateFood(food);
	}

	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return foodDao.findAllFood();
		
	}

	public Map<String, Object> findFoodById(int fId) {
		// TODO Auto-generated method stub
		return foodDao.findFoodById(fId);
	}

}
