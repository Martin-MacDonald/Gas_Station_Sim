package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.VehicleType;
import com.martin_bolton_macdonald.VehicleTank;
import java.util.Random;

public class GasStationSim{
	
	public static void main(String[] args){
		
		VehicleType[] vehicleArray = VehicleType.values(); 																						//Create a new array with all the VehicleType enum values
		Random rand = new Random();
		VehicleType vehicleType = vehicleArray[rand.nextInt(vehicleArray.length)]; 																//randomly pick a new vehicle type
		int tankCapacity = vehicleType.getVehicleFuelCapacity(); 																				//get the fuel capacity of the random vehicle type
		System.out.println("You are driving a " + vehicleType.lowerCaseName() + " that has a tank capacity of " + tankCapacity + " litres"); 	//shows the user what type of vehicle they are driving and it's fuel capacity
		VehicleTank vehicleTank = new VehicleTank(tankCapacity);																				//created new vehicle object with the generated capacity
		System.out.println("You currently have " + vehicleTank.getFuelInTank() + " litres of petrol in your " + vehicleType.lowerCaseName());

				
		//TODO: create new petrol tank and check if empty
		//TODO: if empty ask to move to another tank

		//TODO: Start filling sequence
		//TODO: fill up 1litre at a time
		//TODO: stop if, reservoir is empty, car is full or money amount has been reached
		//TODO: direct driver to pay amount or calculate amount first
		//TODO: end
		
	}
	
}