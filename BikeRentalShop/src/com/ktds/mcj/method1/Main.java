package com.ktds.mcj.method1;

public class Main {

	public void start() {
		User user = new User(91000);
		BikeRentalShop bikeRentalShop = new BikeRentalShop(45000);
		
		bikeRentalShop.rent(10, user);
		
		System.out.println(bikeRentalShop);
		System.out.println();
		System.out.println(user);
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
	
}
