package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.VehicleType;
import com.martin_bolton_macdonald.FuelType;
import com.martin_bolton_macdonald.VehicleTank;
import com.martin_bolton_macdonald.ReservoirTank;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GasStationSim{
	
	private final int RESERVOIR_CAPACITY = 20000;
	private VehicleType vehicleType;
	private VehicleTank vehicleTank;
	private JLabel lblDescriptor;
	
	public GasStationSim(){
		createUI();
	}
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(() -> {
			GasStationSim gasStationSim = new GasStationSim();
		});
		
		
		
		
	}
	
	private void createUI(){
		
		JFrame jFrame = new JFrame();		
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setTitle("Gas Station Simulator");
		
		lblDescriptor = new JLabel("You are driving a car that takes unleaded petrol....care to fill up?", SwingConstants.CENTER);
		lblDescriptor.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		
		jFrame.add(lblDescriptor);
		
		jFrame.pack();
		jFrame.setVisible(true);
		
		createNewVehicle();
		
	}
	
	private void createNewVehicle(){
		
		VehicleType[] vehicleArray = VehicleType.values(); 																						
		Random rand = new Random();
		vehicleType = vehicleArray[rand.nextInt(vehicleArray.length)]; 																
		vehicleTank = new VehicleTank(vehicleType);
	
		FuelType[] fuelTypeArray = FuelType.values();
		FuelType fuelType = fuelTypeArray[rand.nextInt(fuelTypeArray.length)];

		updateLabelText(vehicleType, fuelType);
		
	}
	
	private void createNewReservoir(){
		
	
	}
	
	private void updateLabelText(VehicleType vehicleType, FuelType fuelType){
		
		lblDescriptor.setText("You are driving a " + vehicleType.name().toLowerCase() + " that takes " + fuelType.name().toLowerCase() + "... care to fill up?");
		
	}
	
}