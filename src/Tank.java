package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.VehicleType;
import java.util.Random;

public abstract class Tank{
	
	private int tankFuelCapacity;
	private int fuelInTank;
	
	public Tank(int tankFuelCapacity){
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
			this.fuelInTank = rand.nextInt(this.tankFuelCapacity);
		} while (this.fuelInTank == this.tankFuelCapacity);
		
	}
	
	public int getTankFuelCapacity(){
		return this.tankFuelCapacity;
	}
	
	void setFuelInTank(int fuelVolumeChange){
		this.fuelInTank += fuelVolumeChange;
	}
	
	public int getFuelInTank(){
		return this.fuelInTank;
	};
	
	public boolean isTankEmpty(){
		if (this.fuelInTank == 0) return true;
		else return false;
	}
	
	public abstract void changeFuelInTank();
	
}