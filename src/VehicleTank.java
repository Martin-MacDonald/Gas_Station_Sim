package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.Tank;
import com.martin_bolton_macdonald.VehicleType;

public class VehicleTank extends Tank{

	private final int FUEL_CHANGE_VALUE = 1;
	
	public VehicleTank(VehicleType vehicleType){
		super(vehicleType);	
	}

	@Override
	public void changeFuelInTank(){
		setFuelInTank(FUEL_CHANGE_VALUE);
	}
}