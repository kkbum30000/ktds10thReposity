package com.ktds.khs;

public class Client {

	private int money;
	private int menu1Amount;
	private int menu2Amount;

	public Client(int money) {
		this.money = money;
		this.menu1Amount = 0;
		this.menu2Amount = 0;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void order(int select, Kimbab kimbab) {
		if (select == 1) {
			if (this.money >= kimbab.getMenu1Amount()) {
				this.money -= kimbab.getMenu1Price();
				kimbab.sell(select);
				this.menu1Amount++;
				System.out.println(this);
			} else {
				System.out.println("금액이 부족합니다.");
			}
		} else {
			if (this.money >= kimbab.getMenu2Amount()) {
				this.money -= kimbab.getMenu2Price();
				kimbab.sell(select);
				this.menu2Amount++;
				System.out.println(this);
			} else {
				System.out.println("금액이 부족합니다.");
			}
		}
	}

	@Override
	public String toString() {
		String msg = String.format(
				"=====================\n 손님 현황\n---------------------\n"
						+ "김치볶음밥 주문 수 : %d개\n돈까스 주문 수 : %d\n보유 금액 : %d원\n" + "=====================",
				this.menu1Amount, this.menu2Amount, this.money);
		return msg;
	}
}
