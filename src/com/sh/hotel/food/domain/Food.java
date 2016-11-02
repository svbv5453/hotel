package com.sh.hotel.food.domain;

import com.sh.hotel.foodtype.domain.FoodType;

public class Food {
	
	private int fId;
	private String foodName;
	private int ftId;
	private double price;
	private double vPrice;
	private String remark;
	private String img;
	private FoodType foodType;
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFtId() {
		return ftId;
	}
	public void setFtId(int ftId) {
		this.ftId = ftId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getvPrice() {
		return vPrice;
	}
	public void setvPrice(double vPrice) {
		this.vPrice = vPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public FoodType getFoodType() {
		return foodType;
	}
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	@Override
	public String toString() {
		return "Food [fId=" + fId + ", fName=" + foodName + ", ftId=" + ftId
				+ ", price=" + price + ", vPrice=" + vPrice + ", remark="
				+ remark + ", img=" + img + ", foodType=" + foodType + "]";
	}
	
	

}
