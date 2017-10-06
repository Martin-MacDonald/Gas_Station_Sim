package com.martin_bolton_macdonald;

import com.martin_bolton_macdonald.VehicleType;
import com.martin_bolton_macdonald.FuelType;
import com.martin_bolton_macdonald.VehicleTank;
import com.martin_bolton_macdonald.ReservoirTank;
import java.util.Random;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GasStationSim extends JFrame{
	
	private final int RESERVOIR_CAPACITY = 20000;
	private VehicleType vehicleType;
	private VehicleTank vehicleTank;
	private JButton bt1;
	private double litres = 0.00d;
	private double cost = 0.00d;
	private JLabel litreLabel;
	private JLabel costLabel;
	private DecimalFormat df = new DecimalFormat("000.00");
	
	public GasStationSim(){
		initComponents();
	}
	
	public static void main(String[] args){
		
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new GasStationSim().setVisible(true);
			}
		});			
		
	}
	
	
	private void initComponents(){
		

		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Gas Station Simulator");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JLabel lblDescriptor = new JLabel("Waiting on vehicle....");
		
		litreLabel = new JLabel("000.00 ltr");
		costLabel = new JLabel("£000.00");
		
		bt1 = new JButton("Fill up");
		ButtonModel bt1Model = bt1.getModel();
		bt1Model.addChangeListener(new ChangeListener(){
			
			Timer fillingTimer = startFilling();
			
			@Override
			public void stateChanged(ChangeEvent e){
				if (bt1Model.isPressed()){
					fillingTimer.start();
				} else if(!bt1Model.isPressed()){
					fillingTimer.stop();
				}
			}
			
		});
		
		JButton bt2 = new JButton("Finish");
		
		JPanel internalPanel = new JPanel();
		internalPanel.setLayout(new GridLayout(1,2));
		
		lblDescriptor.setAlignmentX(Component.CENTER_ALIGNMENT);
		litreLabel.setHorizontalAlignment(JLabel.CENTER);
		costLabel.setHorizontalAlignment(JLabel.CENTER);
		bt1.setAlignmentX(Component.CENTER_ALIGNMENT);
		bt2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		internalPanel.add(litreLabel);
		internalPanel.add(costLabel);
		mainPanel.add(lblDescriptor);
		mainPanel.add(internalPanel);
		mainPanel.add(bt1);
		mainPanel.add(bt2);
		add(mainPanel);
		
		pack();
		createNewVehicle();
		
	}
	
	private Timer startFilling(){

		Timer timer = new Timer(20, new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				if (Math.abs(vehicleTank.getTankFuelCapacity() - vehicleTank.getFuelInTank()) > 0.01d){
					vehicleTank.changeFuelInTank();
					litres += 0.01d;
					litreLabel.setText(df.format(litres) + " ltr");
					cost += 0.013d;
					costLabel.setText("\u00A3" + df.format(cost));
				}
			}
			
		});
		
		return timer;
	}
	
	private void createNewVehicle(){
		
		VehicleType[] vehicleArray = VehicleType.values(); 																						
		Random rand = new Random();
		vehicleType = vehicleArray[rand.nextInt(vehicleArray.length)]; 																
		vehicleTank = new VehicleTank(vehicleType);
	
		FuelType[] fuelTypeArray = FuelType.values();
		FuelType fuelType = fuelTypeArray[rand.nextInt(fuelTypeArray.length)];

		updateLabelText(vehicleType, fuelType);
		
		System.out.println(vehicleTank.getTankFuelCapacity());
		System.out.println(vehicleTank.getFuelInTank());
		
	}
	
	private void createNewReservoir(){
		
	
	}
	
	private void updateLabelText(VehicleType vehicleType, FuelType fuelType){
		
		//lblDescriptor.setText("You are driving a " + vehicleType.name().toLowerCase() + " that takes " + fuelType.name().toLowerCase() + "... care to fill up?");
		
	}
	
}