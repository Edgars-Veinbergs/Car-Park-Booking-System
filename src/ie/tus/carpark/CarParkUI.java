package ie.tus.carpark;
import javax.swing.*;
import java.awt.event.*;


public class CarParkUI extends JFrame implements ActionListener {

	
	
	
	public CarParkUI() {
		super("Car Park UI");
		
		setSize(400,350);
		
		
		setVisible(true);
		Account newAcc = new Account();
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	
	public static void main(String[] args) {
		CarParkUI carPark = new CarParkUI();
	}




}
