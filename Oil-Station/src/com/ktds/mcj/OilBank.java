package com.ktds.mcj;

public class OilBank {

	private int oilStock;
	private int pricePerLiter;
	private int budget;

	public void setOilStock(int oilStock) {
		this.oilStock = oilStock;
	}

	public int getOilStock() {
		return oilStock;
	}

	public void setPricePerLiter(int pricePerLiter) {
		this.pricePerLiter = pricePerLiter;
	}

	public int getPricePerLiter() {
		return pricePerLiter;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getBudget() {
		return budget;
	}

	public void filling(Car car) {
		this.oilStock -= car.getOilTankVolume();
		
		System.out.println(this);
		car.fillOil(this);
		
		this.budget += (pricePerLiter * car.getOilTankVolume());
	}

}
