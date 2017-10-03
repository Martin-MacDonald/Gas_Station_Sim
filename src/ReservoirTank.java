package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.Tank;

public class ReservoirTank extends Tank{
	
	private final int FUEL_CHANGE_VALUE = -1;
	
	public ReservoirTank(int tankFuelCapacity){
		super(tankFuelCapacity);	
	}

	@Override
	public void changeFuelInTank(){
		setFuelInTank(FUEL_CHANGE_VALUE);
	}
	
}