package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.VehicleType;
import java.util.Random;

public abstract class Tank{
	
	private double tankFuelCapacity;
	private double fuelInTank;
	
	public Tank(double tankFuelCapacity){
		this.tankFuelCapacity = tankFuelCapacity;
		initializeFuelInTank();
	}
	
	public Tank(VehicleType vehicleType){		
		this.tankFuelCapacity = vehicleType.getVehicleFuelCapacity();
		initializeFuelInTank();
	}
	
	private void initializeFuelInTank(){		
				
		Random rand = new Random();
		
		do{
			this.fuelInTank = rand.nextDouble() * this.tankFuelCapacity;
		} while (this.fuelInTank == this.tankFuelCapacity);
		
	}
	
	public double getTankFuelCapacity(){
		return this.tankFuelCapacity;
	}
	
	void setFuelInTank(double fuelVolumeChange){
		this.fuelInTank += fuelVolumeChange;
	}
	
	public double getFuelInTank(){
		return this.fuelInTank;
	};
	
	public boolean isTankEmpty(){
		if (this.fuelInTank == 0) return true;
		else return false;
	}
	
	public abstract void changeFuelInTank();
	
}