package com.ktds.khs;

public class Kimbab {

	private final String menu1 = "김치볶음밥";
	private final String menu2 = "돈까스";
	private final int menu1Price = 5000;
	private final int menu2Price = 7000;
	private int money;
	private int menu1Amount;
	private int menu2Amount;

	public Kimbab(int menu1, int menu2) {
		this.money = 100000;
		this.menu1Amount = menu1;
		this.menu2Amount = menu2;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMenu1Amount() {
		return menu1Amount;
	}

	public void setMenu1Amount(int menu1Amount) {
		this.menu1Amount = menu1Amount;
	}

	public int getMenu2Amount() {
		return menu2Amount;
	}

	public void setMenu2Amount(int menu2Amount) {
		this.menu2Amount = menu2Amount;
	}

	public String getMenu1() {
		return menu1;
	}

	public String getMenu2() {
		return menu2;
	}

	public int getMenu1Price() {
		return menu1Price;
	}

	public int getMenu2Price() {
		return menu2Price;
	}

	public void sell(int select) {
		if (select == 1) {
			if (this.menu1Amount > 0) {
				this.money += this.menu1Price;
				this.menu1Amount--;
				System.out.println(this);
			} else {
				System.out.println("다팔렸습니다.");
			}
		} else {
			if (this.menu2Amount > 0) {
				this.money += this.menu2Price;
				this.menu1Amount--;
				System.out.println(this);
			} else {
				System.out.println("다팔렸습니다.");
			}
		}
	}

	@Override
	public String toString() {
		String msg = String.format(
				"=====================\n 김밥천국 현황\n---------------------\n"
						+ "김치볶음밥 잔여 수 : %d개\n돈까스 잔여 수 : %d\n보유 금액 : %d원\n" + "=====================",
				this.menu1Amount, this.menu2Amount, this.money);
		return msg;
	}

}
