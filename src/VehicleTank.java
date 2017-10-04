package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.Tank;
import com.martin_bolton_macdonald.VehicleType;
import com.martin_bolton_macdonald.FuelType;

public class VehicleTank extends Tank{

	private final int FUEL_CHANGE_VALUE = 1;
	private int emptyVolume;
	
	public VehicleTank(VehicleType vehicleType){
		super(vehicleType);	
		this.emptyVolume = getTankFuelCapacity() - getFuelInTank();
	}

	@Override
	public void changeFuelInTank(){
		setFuelInTank(FUEL_CHANGE_VALUE);
	}
	
	public int getEmptyVolume(){
		return this.emptyVolume;
	}
	
	public double costToFill(FuelType fuelType, int litres){
		return (fuelType.getCostPerLitre() * litres);
	}
}