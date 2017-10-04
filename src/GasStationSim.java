package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.VehicleType;
import com.martin_bolton_macdonald.FuelType;
import com.martin_bolton_macdonald.VehicleTank;
import com.martin_bolton_macdonald.ReservoirTank;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class GasStationSim{
	
	private final int RESERVOIR_CAPACITY = 20000;
	private VehicleType vehicleType;
	private ReservoirTank reservoirTank;
	private VehicleTank vehicleTank;
	private int maxFillVolume;
	private FuelType fuelType;
	
	public static void main(String[] args){
		
		GasStationSim gasStationSim = new GasStationSim();
		
		gasStationSim.createNewVehicle();
		gasStationSim.createNewReservoir();
		gasStationSim.howMuchToFill();


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
		vehicleTank = new VehicleTank(vehicleType);																		
		System.out.println("\nYou are driving a " + vehicleType.lowerCaseName() + " that has a tank capacity of " + vehicleTank.getTankFuelCapacity() + " litres."); 	
		System.out.println("You currently have " + vehicleTank.getFuelInTank() + " litres of petrol in your " + vehicleType.lowerCaseName());
		
	}
	
	private void createNewReservoir(){
		
		reservoirTank = new ReservoirTank(RESERVOIR_CAPACITY);
		System.out.println("There is currently " + reservoirTank.getFuelInTank() + " litres of petrol in the reservoir");
		
		while(reservoirTank.isTankEmpty()){

			System.out.println("Reservoir is empty! Moving to another pump.....");			
			reservoirTank = new ReservoirTank(RESERVOIR_CAPACITY);
			System.out.println("The new pump has " + reservoirTank.getFuelInTank() + " litres of petrol in the reservoir");
			
		}
		
		checkEnoughFuelInReservoir();
		checkMaxFillVolume(vehicleTank.getEmptyVolume(), reservoirTank.getFuelInTank());
	
	}
	
	private void checkEnoughFuelInReservoir(){
		
		if(reservoirTank.getFuelInTank() < vehicleTank.getEmptyVolume()){
			
			Scanner movePump = new Scanner(System.in);
			System.out.println("Not enough to fill up at this tank. Do you want to move to another? (Y/N)");
			String s = movePump.next().toLowerCase();
			
			while(!s.equals("y") && !s.equals("n")){
				System.out.println("Please answer Y or N....");
				s = movePump.next().toLowerCase();
			}
			
			if (s.equals("y")){
				createNewReservoir();
			}
			
		}
	}
	
	private void checkMaxFillVolume(int emptyVolume, int reservoirVolume){
		
		if (reservoirVolume < emptyVolume){
			maxFillVolume = reservoirVolume;
		} else {
			maxFillVolume = emptyVolume;
		}
		
	}
	
	private void howMuchToFill(){
		
		fuelType = getFuelType();
		double costToFillToTop = vehicleTank.costToFill(fuelType, maxFillVolume);
		DecimalFormat df = new DecimalFormat("#0.00"); 
		System.out.println("Cost per litre, of " + fuelType.name().toLowerCase() + ", is \u00A3" + df.format(fuelType.getCostPerLitre()) + ". It will cost \u00A3" + df.format(costToFillToTop) + " for " + maxFillVolume + " litres.");
		
		Scanner fillAmount = new Scanner(System.in);
		System.out.println("Do you want to fill up (Y/N)");
		String s = fillAmount.next().toLowerCase();
		
		while(!s.equals("y") && !s.equals("n")){
			System.out.println("Please answer Y or N....");
			s = fillAmount.next().toLowerCase();
		}
		
		if (s.equals("y")){
			System.out.println("Filling....");
		} else {	
			
			double d;
			
			do{
				System.out.println("Enter amount in whole \u00A3" + "\'s");
								
				while(!fillAmount.hasNextInt()){
					System.out.println("That's not a number...");
					fillAmount.next();
				}
				
				d = (double) fillAmount.nextInt();
				
			} while (d < 1.0d);
		}
	}
	
	private FuelType getFuelType(){
		
		FuelType[] fuelTypeArray = FuelType.values();
		Random rand = new Random();
		return fuelTypeArray[rand.nextInt(fuelTypeArray.length)];
	}
	
}