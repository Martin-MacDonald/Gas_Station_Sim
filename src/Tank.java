package com.martin_bolton_macdonald;

import java.util.Random;

public abstract class Tank{
	
	private int tankFuelCapacity;
	private int fuelInTank;
	
	public Tank(int tankFuelCapacity){
		this.tankFuelCapacity = tankFuelCapacity;
		Random rand = new Random();
		do{
		this.fuelInTank = rand.nextInt(tankFuelCapacity);
		} while (this.fuelInTank == tankFuelCapacity);
	}
	
	public int getTankFuelCapacity(){
		return this.tankFuelCapacity;
	}
	
	public int getFuelInTank(){
		return this.fuelInTank;
	};
	
}