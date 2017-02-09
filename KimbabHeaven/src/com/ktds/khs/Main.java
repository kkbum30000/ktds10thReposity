package com.ktds.khs;

import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	int select;

	public void start() {

		Kimbab kimbab = new Kimbab(10, 10); // 파라미터는 메뉴들의 수량을 설정한 것
		Client client = new Client(20000); // 파라미터는 손님들이 가지고 있는 돈

		while (true) {
			System.out.println("\n메뉴를 선택해주세요.");
			System.out.println("1. 김치볶음밥\n2. 돈까스\n종료를 원하시면 999를 입력해주세요.");
			select = scan.nextInt();
			if (select == 1) {
				System.out.println("김치볶음밥을 주문하셨습니다.");
				client.order(select, kimbab);
			} else if (select == 2) {
				System.out.println("돈까스를 주문하셨습니다.");
				client.order(select, kimbab);
			} else if (select == 999) {
				System.out.println("종료되었습니다.");
				break;
			} else {
				System.out.println("---해당메뉴가 없습니다.---");
			}

		}
	}

	public static void main(String[] args) {

		new Main().start();

	}

}
