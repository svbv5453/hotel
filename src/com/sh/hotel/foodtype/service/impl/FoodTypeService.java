package com.sh.hotel.foodtype.service.impl;

import java.util.List;

import com.sh.hotel.foodtype.dao.IFoodTypeDao;
import com.sh.hotel.foodtype.dao.impl.FoodTypeDao;
import com.sh.hotel.foodtype.domain.FoodType;
import com.sh.hotel.foodtype.service.IFoodTypeService;

/**
 * 业务逻辑层
 * 菜系service实现类
 * 实现增删改查方法
 * @author Administrator
 *
 */
public class FoodTypeService implements IFoodTypeService{
	
	private IFoodTypeDao foodTypeDao = new FoodTypeDao();

	public List<FoodType> findAll() {
		// TODO Auto-generated method stub
		return foodTypeDao.findAll();
		
	}

	public FoodType findByFoodTypeId(int foodTypeId) {
		// TODO Auto-generated method stub
		return foodTypeDao.findByFoodTypeId(foodTypeId);
	}

	public void add(FoodType foodType) {
		// TODO Auto-generated method stub
		foodTypeDao.addFoodType(foodType);
		
	}

	public void delete(int foodTypeId) {
		// TODO Auto-generated method stub
		foodTypeDao.deleteFoodType(foodTypeId);
	}

	public void update(FoodType foodType) {
		// TODO Auto-generated method stub
		foodTypeDao.updateFoodType(foodType);
	}

}
