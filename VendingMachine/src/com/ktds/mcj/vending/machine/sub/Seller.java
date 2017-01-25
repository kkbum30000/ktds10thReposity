package com.ktds.mcj.vending.machine.sub;

public class Seller {

	private int money;

	private int cola;
	private int fanta;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getCola() {
		return cola;
	}

	public void setCola(int cola) {
		this.cola = cola;
	}

	public int getFanta() {
		return fanta;
	}

	public void setFanta(int fanta) {
		this.fanta = fanta;
	}

	public void sell(int inputMoney, User user) {
		money += inputMoney;
		
		System.out.println("무엇을 사시겠습니까? 1 : 콜라, 2 : 환타");
		System.out.println("선택하세요.");
		
		int selectedMenu = user.selectDrink();
		removeDrink(selectedMenu);
		user.takeDrink(selectedMenu);
		
		inputMoney = subtractRemainMoney(selectedMenu, inputMoney);
		user.takeRemainMoney(inputMoney);
	}

	public void removeDrink(int selectedMenu) {
		if ( selectedMenu == 1 ) {
			cola--;
		}
		else if ( selectedMenu == 2 ) {
			fanta--;
		}
	}

	public int subtractRemainMoney(int selectedMenu, int inputMoney) {
		if ( selectedMenu == 1 ) {
			money -= (inputMoney - 1000); // Seller
			return inputMoney - 1000;
		}
		else if ( selectedMenu == 2 ) {
			money -= (inputMoney - 1100); // Seller
			return inputMoney - 1100;
		}
		
		return 0;
	}

}








