package com.sh.hotel.foodtype.domain;

import java.util.List;

/**
 * 菜系管理，包括id和name；
 * @author Administrator
 *
 */
public class FoodType {
	
	/*CREATE TABLE foodType(
			ftId INT PRIMARY KEY AUTO_INCREMENT, -- 菜系id
			ftName VARCHAR(20) -- 菜系名称
			
		);*/
	
	private int ftId;
	private String ftName;
	//private List<Food> foodsList;
	public int getFtId() {
		return ftId;
	}
	public void setFtId(int ftId) {
		this.ftId = ftId;
	}
	public String getFtName() {
		return ftName;
	}
	public void setFtName(String ftName) {
		this.ftName = ftName;
	}
	/*public List<Food> getFoodsList() {
		return foodsList;
	}
	public void setFoodsList(List<Food> foodsList) {
		this.foodsList = foodsList;
	}
	@Override
	public String toString() {
		return "FoodType [ftId=" + ftId + ", ftName=" + ftName + ", foodsList="
				+ foodsList + "]";
	}*/
	
	
	
	

}
