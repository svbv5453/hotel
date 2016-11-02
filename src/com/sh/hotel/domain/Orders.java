package com.sh.hotel.domain;

import java.util.Date;

public class Orders {
	
	private int oId;
	private int tId;
	private Date orderTime;
	private double total;
	private int oStatus;
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getoStatus() {
		return oStatus;
	}
	public void setoStatus(int oStatus) {
		this.oStatus = oStatus;
	}
	@Override
	public String toString() {
		return "Orders [oId=" + oId + ", tId=" + tId + ", orderTime="
				+ orderTime + ", total=" + total + ", oStatus=" + oStatus + "]";
	}
	
	

}
