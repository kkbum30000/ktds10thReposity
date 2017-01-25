package com.ktds.mcj.vending.machine.sub;

public class Main {

	public static void main(String[] args) {
		Seller 손진무 = new Seller();
		손진무.setMoney(1000);
		손진무.setCola(100);
		손진무.setFanta(500);
		
		User 김슬기 = new User();
		김슬기.setMoney(10000);
		
		김슬기.use(5000, 손진무);
		
		System.out.println(김슬기.getMoney());
		System.out.println(김슬기.getCola());
		System.out.println(김슬기.getFanta());
		
		System.out.println(손진무.getMoney());
		System.out.println(손진무.getCola());
		System.out.println(손진무.getFanta());
	}
	
}
