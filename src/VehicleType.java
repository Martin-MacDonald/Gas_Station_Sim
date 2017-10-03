package com.martin_bolton_macdonald;

public enum VehicleType{
	
	CAR(0), VAN(1), MOTORBIKE(2), LORRY(3);
	
	private int vehicleFuelCapacity;
	private final int CAR_FUEL_CAPACITY = 65;
	private final int VAN_FUEL_CAPACITY = 80;
	private final int MOTO_FUEL_CAPACITY = 13;
	private final int LORRY_FUEL_CAPACITY = 250;
	
	private VehicleType(int vehicleFuelCapacity){
		
		switch (vehicleFuelCapacity){
			case 0:
				this.vehicleFuelCapacity = CAR_FUEL_CAPACITY;
				break;
			case 1:
				this.vehicleFuelCapacity = VAN_FUEL_CAPACITY;
				break;
			case 2:
				this.vehicleFuelCapacity = MOTO_FUEL_CAPACITY;
				break;
			case 3:
				this.vehicleFuelCapacity = LORRY_FUEL_CAPACITY;
				break;
			default:
				this.vehicleFuelCapacity = CAR_FUEL_CAPACITY;
				break;
		}
		
	}
	
	public int getVehicleFuelCapacity(){
		return this.vehicleFuelCapacity;
	}
	
	public String lowerCaseName(){
		return name().toLowerCase();
	}
	
}