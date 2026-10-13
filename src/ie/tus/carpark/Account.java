package ie.tus.carpark;
import javax.swing.*;
import java.awt.*;

public class Account extends JFrame {

	private JLabel title;
	
	// For logging in
	private JLabel loginUsername;
	private JLabel loginPassword;
	
	private JTextField loginUsernameField;
	private JTextField loginPasswordField;
	private JButton loginButton;
	
	// For registering
	private JLabel registerUsername;
	private JLabel registerPassword;
	private JLabel registerConfirmPassword;
	
	private JTextField registerUsernameField;
	private JTextField registerPasswordField;
	private JTextField registerPasswordConfirmField;
	
	private JButton registerButton;
	private JButton createAccountButton;
	
	private JPanel titlePanel;
	private JPanel centerPanel;
	private JPanel buttonPanel;
	
	public Account() {
		super("Authorization");
		
		setSize(400,350);
		
		titlePanel = new JPanel();
		centerPanel = new JPanel(new GridLayout(4,2));
		buttonPanel = new JPanel();
		
		title = new JLabel("Log In");
		loginUsername = new JLabel("Username: ");
		loginPassword = new JLabel("Password: ");
		loginUsernameField = new JTextField("Enter Username Here..");
		loginPasswordField = new JTextField("Enter Password Here..");
		
		setVisible(true);
	}
	
}
