package com.ktds.mcj.method1;

public class User {

	private int bikeStock;
	private int money;

	public User(int money) {
		this.money = money;
	}

	public int getBikeStock() {
		return bikeStock;
	}

	public void setBikeStock(int bikeStock) {
		this.bikeStock = bikeStock;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void borrow(int bike) {
		bikeStock += bike;
	}
	
	public void pay(int money) {
		this.money -= money;
	}
	
	@Override
	public String toString() {
		String message = "===================================================";
		message += "\n	대여자 현황";
		message += "\n—————————————————————————————————------------------";
		message += String.format("\n	자전거 보유 수 : %d대", this.bikeStock);
		message += String.format("\n	보유 금액 : %d원", this.money);
		message += "\n===================================================";
		return message;
	}
}








