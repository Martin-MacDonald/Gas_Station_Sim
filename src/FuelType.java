package com.martin_bolton_macdonald;

public enum FuelType{
	
	UNLEADED(0), DIESEL(1);
	
	private double costPerLitre;
	
	private FuelType(int fuelType){
		
		if (fuelType == 0){
			costPerLitre = 1.3d;
		} else {
			costPerLitre = 1.2d;
		}
		
	}
	
	public double getCostPerLitre(){
		return costPerLitre;
	}
	
}