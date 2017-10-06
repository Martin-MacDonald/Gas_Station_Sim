package com.martin_bolton_macdonald;

public enum VehicleType{
	
	CAR(0), VAN(1), MOTORBIKE(2), LORRY(3);
	
	private double vehicleFuelCapacity;
	private final double CAR_FUEL_CAPACITY = 50.00d;
	private final double VAN_FUEL_CAPACITY = 80.00d;
	private final double MOTO_FUEL_CAPACITY = 15.00d;
	private final double LORRY_FUEL_CAPACITY = 250.00d;
	
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
	
	public double getVehicleFuelCapacity(){
		return this.vehicleFuelCapacity;
	}
	
	public String lowerCaseName(){
		return name().toLowerCase();
	}
	
}