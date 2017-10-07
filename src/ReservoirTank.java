package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.Tank;

public class ReservoirTank extends Tank{
	
	private final double FUEL_CHANGE_VALUE = -0.01d;
	
	public ReservoirTank(double tankFuelCapacity){
		super(tankFuelCapacity);	
	}

	@Override
	public void changeFuelInTank(){
		setFuelInTank(FUEL_CHANGE_VALUE);
	}
	
}