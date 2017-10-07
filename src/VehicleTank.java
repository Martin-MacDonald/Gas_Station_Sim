package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.Tank;
import com.martin_bolton_macdonald.VehicleType;
import com.martin_bolton_macdonald.FuelType;

public class VehicleTank extends Tank{

	private final double FUEL_CHANGE_VALUE = 0.01d;
	
	public VehicleTank(VehicleType vehicleType){
		super(vehicleType);	

	}

	@Override
	public void changeFuelInTank(){
		setFuelInTank(FUEL_CHANGE_VALUE);
	}


}