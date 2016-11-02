package com.sh.hotel.food.service;

import java.util.List;
import java.util.Map;

import com.sh.hotel.food.domain.Food;

/**
 * Food业务逻辑处理接口
 * 包括增删改查
 * 
 * @author Administrator
 *
 */
public interface IFoodService {
	
	void addFood(Food food);
	void deleteFood(int fId);
	void updateFood(Food food);
	List<Map<String, Object>> findAll();
	Map<String, Object> findFoodById(int fId);

}
