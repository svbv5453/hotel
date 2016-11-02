package com.sh.hotel.foodtype.service;

import java.util.List;

import com.sh.hotel.foodtype.domain.FoodType;

/**
 * 菜品类型Service；
 * 包括增加菜品
 * 删除菜品
 * 更新菜品
 * 查找所有菜品
 * @author Administrator
 *
 */
public interface IFoodTypeService {
	
	List<FoodType> findAll();
	FoodType findByFoodTypeId(int foodTypeId);
	void add(FoodType foodType);
	void delete(int foodTypeId);
	void update(FoodType foodType);
	
	

}
