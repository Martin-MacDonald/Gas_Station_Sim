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
	private double costForFill;
	private DecimalFormat df = new DecimalFormat("#0.00");
	
	public static void main(String[] args){
		
		GasStationSim gasStationSim = new GasStationSim();
		
		gasStationSim.createNewVehicle();
		gasStationSim.createNewReservoir();
		gasStationSim.howMuchToFill();
		
	}
	
	private void createNewVehicle(){
		
		VehicleType[] vehicleArray = VehicleType.values(); 																						
		Random rand = new Random();
		vehicleType = vehicleArray[rand.nextInt(vehicleArray.length)]; 																
		vehicleTank = new VehicleTank(vehicleType);																		
		System.out.println("\nYou are driving a " + vehicleType.lowerCaseName() + " that has a tank capacity of " + vehicleTank.getTankFuelCapacity() + " litres."); 	
		System.out.println("You currently have " + vehicleTank.getFuelInTank() + " litres of petrol in your " + vehicleType.lowerCaseName() + "\n");
		
	}
	
	private void createNewReservoir(){
		
		reservoirTank = new ReservoirTank(RESERVOIR_CAPACITY);
		System.out.println("There is currently " + reservoirTank.getFuelInTank() + " litres of petrol in the reservoir\n");
		
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
				System.out.println("\nPlease answer Y or N....");
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
		costForFill = vehicleTank.costToFill(fuelType, maxFillVolume);
		System.out.println("Cost per litre, of " + fuelType.name().toLowerCase() + ", is \u00A3" + df.format(fuelType.getCostPerLitre()) + ". It will cost \u00A3" + df.format(costForFill) + " for " + maxFillVolume + " litres.");
		
		Scanner fillAmount = new Scanner(System.in);
		System.out.println("Do you want to fill up completely? (Y/N)");
		String s = fillAmount.next().toLowerCase();
		
		while(!s.equals("y") && !s.equals("n")){
			System.out.println("Please answer Y or N....");
			s = fillAmount.next().toLowerCase();
		}
		
		if (s.equals("y")){
			
			startFilling(maxFillVolume);
			
		} else {	
			
			double d;
			
			do{
				System.out.println("Enter amount in whole \u00A3\'s , between \u00A30 and \u00A3" + (int)costForFill + ", that you wish to fill up");
								
				while(!fillAmount.hasNextInt()){
					System.out.println("That's not a number...");
					fillAmount.next();
				}
				
				d = (double) fillAmount.nextInt();
				
			} while (d < 1.0d || d > costForFill);
			
			costForFill = d;
			
			startFilling((int)(costForFill/fuelType.getCostPerLitre()));
		}
	}
	
	private FuelType getFuelType(){
		
		FuelType[] fuelTypeArray = FuelType.values();
		Random rand = new Random();
		return fuelTypeArray[rand.nextInt(fuelTypeArray.length)];
		
	}
	
	private void startFilling(int amountToFill){
		
		for (int i = 0; i < amountToFill; i++){
			vehicleTank.changeFuelInTank();
			reservoirTank.changeFuelInTank();
			
			if (vehicleTank.getFuelInTank() % 5 == 0){
				System.out.println("\nYour " + vehicleType.lowerCaseName() + " now has " + vehicleTank.getFuelInTank() + " litres of petrol \nContinuing to fill...");
				try{
					Thread.sleep(2000);
				} catch (InterruptedException ie){
					System.out.println("Pump malfunction....");
					costForFill = (i+1) * fuelType.getCostPerLitre();
					break;
				}
			}
			
			if (reservoirTank.getFuelInTank() <= 0){
				System.out.println("Reservoir is now empty");
				break;
			}
		}
		
		askForPayment();
		
	}
	
	private void askForPayment(){
		
		System.out.println("\nFilling finished. Please go to checkout and pay \u00A3" + df.format(costForFill) + ".");
	}
	
}