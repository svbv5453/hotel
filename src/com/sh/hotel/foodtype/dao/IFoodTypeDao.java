package com.sh.hotel.foodtype.dao;

import java.util.List;

import com.sh.hotel.foodtype.domain.FoodType;

/**
 * 菜系Dao接口，包括
 * 增加菜系
 * 更新菜系、
 * 	根据id查询
 * 删除菜系
 * 查找所有菜系
 * @author Administrator
 *
 */
public interface IFoodTypeDao {
	
	void addFoodType(FoodType foodType);
	void updateFoodType(FoodType foodType);
	void deleteFoodType(int foodTypeId);
	List<FoodType> findAll();
	FoodType findByFoodTypeId(int foodTypeId);
	

}
