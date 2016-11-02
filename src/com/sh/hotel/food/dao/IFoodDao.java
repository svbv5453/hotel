package com.sh.hotel.food.dao;

import java.util.List;
import java.util.Map;

import com.sh.hotel.food.domain.Food;

/**
 * 菜品模型接口
 * 包括，增加菜品
 * 删除菜品
 * 修改菜品
 * 查找菜品
 * 根据id查找菜品
 * @author Administrator
 *
 */
public interface IFoodDao {
	
	void addFood(Food food);
	void deleteFood(int fId);
	void updateFood(Food food);
	List<Map<String, Object>> findAllFood();
	Map<String, Object> findFoodById(int fId);
	
	

}
