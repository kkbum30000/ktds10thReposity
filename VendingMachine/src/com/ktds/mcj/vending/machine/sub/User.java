package com.ktds.mcj.vending.machine.sub;

import java.util.Scanner;

public class User {

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

	public void use(int outputMoney, Seller seller) {
		// 내가 가진 돈에서 얼마만큼을 뺀다.
		this.money -= outputMoney;
		
		seller.sell(outputMoney, this);
	}
	
	public int selectDrink() {
		Scanner input = new Scanner(System.in);
		int drinkNumber = input.nextInt();
		return drinkNumber;
	}

	public void takeDrink(int drinkNumber) {
		if ( drinkNumber == 1 ) {
			cola++;
		}
		else if ( drinkNumber == 2 ) {
			fanta++;
		}
	}

	public void takeRemainMoney(int remainMoney) {
		this.money += remainMoney;
	}

}
