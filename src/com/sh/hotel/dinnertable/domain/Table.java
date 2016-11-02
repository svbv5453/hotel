package com.sh.hotel.dinnertable.domain;

import java.util.Date;

public class Table {
	
	private int tId;
	private String tableName;
	private int tableStatus;
	private Date reservationTime;
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getTableStatus() {
		return tableStatus;
	}
	public void setTableStatus(int tableStatus) {
		this.tableStatus = tableStatus;
	}
	public Date getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}
	@Override
	public String toString() {
		return "DinnerTable [tId=" + tId + ", tableName=" + tableName
				+ ", tableStatus=" + tableStatus + ", reservationTime="
				+ reservationTime + "]";
	}
	
	
	

}
