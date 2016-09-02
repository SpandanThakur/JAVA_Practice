package com.reflections;

public class RentCar {

	private int rate;
	private String type;
	public int price;

	public RentCar(int length) {
		if (length < 455) {
			type = "small";
			rate = 5000;
		} else if ((length >= 455) && (length < 495)) {
			type = "mid-sized";
			rate = 7500;
		} else if (length >= 495) {
			type = "large";
			rate = 10000;
		}
	}


	public int getRate() {
		return rate;
	}

	public String getType() {
		return type;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void computeRentalCost(int numDays) {
		price = numDays * rate;
		System.out
				.println("The cost of your rental car is " + price + " rupees");
	}
}