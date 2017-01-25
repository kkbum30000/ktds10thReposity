package com.ktds.mcj.method2;

public class BikeRentalShop {

	private final int PRICE = 5000;

	private int bikeStock;
	private int money;

	public BikeRentalShop(int money) {
		this.bikeStock = 100;
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
	
	/**
	 * 대여점이 사용자에게 빌려줌
	 * @param bike
	 * @param user
	 */
	public void rent(int bike, User user) {
		this.bikeStock -= bike;
		user.pay(PRICE * bike);
		money += PRICE * bike;
	}
	
	@Override
	public String toString() {
		String message = "===================================================";
		message += "\n	자전거 대여점 현황";
		message += "\n—————————————————————————————————------------------";
		message += String.format("\n	자전거 보유 수 : %d대", this.bikeStock);
		message += String.format("\n	대여료 총 합 : %d원", this.money);
		message += "\n===================================================";
		return message;
	}

}
