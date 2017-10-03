package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.VehicleType;
import com.martin_bolton_macdonald.VehicleTank;
import com.martin_bolton_macdonald.ReservoirTank;
import java.util.Random;

public class GasStationSim{
	
	private final int RESERVOIR_CAPACITY = 20000;
	private VehicleType vehicleType;
	private ReservoirTank reservoirTank;
	
	public static void main(String[] args){
		
		GasStationSim gasStationSim = new GasStationSim();
		gasStationSim.createNewVehicle();
		gasStationSim.createNewReservoir();

		
		//TODO: if empty ask to move to another tank

		//TODO: Start filling sequence
		//TODO: fill up 1litre at a time
		//TODO: stop if, reservoir is empty, car is full or money amount has been reached
		//TODO: direct driver to pay amount or calculate amount first
		//TODO: end
		
	}
	
	private void createNewVehicle(){
		
		VehicleType[] vehicleArray = VehicleType.values(); 																						
		Random rand = new Random();
		vehicleType = vehicleArray[rand.nextInt(vehicleArray.length)]; 																
		VehicleTank vehicleTank = new VehicleTank(vehicleType);																		
		System.out.println("You are driving a " + vehicleType.lowerCaseName() + " that has a tank capacity of " + vehicleTank.getTankFuelCapacity() + " litres"); 	
		System.out.println("You currently have " + vehicleTank.getFuelInTank() + " litres of petrol in your " + vehicleType.lowerCaseName());
		
	}
	
	private void createNewReservoir(){
		
		reservoirTank = new ReservoirTank(RESERVOIR_CAPACITY);
		System.out.println("There is currently " + reservoirTank.getFuelInTank() + " litres of petrol in the reservoir");
		while(reservoirTank.isTankEmpty()){

			if (reservoirTank.isTankEmpty()){
				System.out.println("Reservoir is empty! Moving to another pump.....");
			}
			
			reservoirTank = new ReservoirTank(RESERVOIR_CAPACITY);
			System.out.println("The new pump has " + reservoirTank.getFuelInTank() + " litres of petrol in the reservoir");
			
		}
		
	}
	
}