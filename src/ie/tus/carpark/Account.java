package ie.tus.carpark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Account extends JFrame implements ActionListener{

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
	private String typedPassword = "";
	private String typedConfirmPassword = "";
	
	
	public Account() {
		
		setSize(400,175);
		
		titlePanel = new JPanel();
		centerPanel = new JPanel(new GridLayout(3,2,6,6));
		buttonPanel = new JPanel();
		
		title = new JLabel("Log In");
		loginUsername = new JLabel("Username: ");
		loginPassword = new JLabel("Password: ");
		loginUsernameField = new JTextField("Enter Username Here..");
		loginPasswordField = new JTextField("Enter Password Here..");
		loginButton = new JButton("Login");
		createAccountButton =  new JButton("Create an Account");
		registerPassword = new JLabel("Password: ");
		registerConfirmPassword = new JLabel("Confirm Password");
		registerPasswordConfirmField = new JTextField("Confirm Password Here..");
		registerButton = new JButton("Reigster");
		
	
		setLoginScreen();
		
		createAccountButton.addActionListener(this);
		setVisible(true);
		
		registerButton.addActionListener(this);
		loginUsernameField.addActionListener(this);
		loginPasswordField.addActionListener(this);
		registerPasswordConfirmField.addActionListener(this);
		
		loginPasswordField.addKeyListener(new KeyListener() { 
			@Override
			public void keyTyped(KeyEvent e) {
				char typed = e.getKeyChar();
				typedPassword = typedPassword+typed;
				e.consume();
				loginPasswordField.setText(loginPasswordField.getText() + "*");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
	}
	
	public void setLoginScreen() {
		title.setText("Login");
		buttonPanel.remove(registerButton);
		centerPanel.remove(registerConfirmPassword); centerPanel.remove(registerPasswordConfirmField);
		titlePanel.add(title,BorderLayout.CENTER);
		centerPanel.add(loginUsername); centerPanel.add(loginUsernameField);
		centerPanel.add(loginPassword); centerPanel.add(loginPasswordField);
		
		buttonPanel.add(loginButton);
		buttonPanel.add(createAccountButton);
		
		add(titlePanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		repaint();
	}
	
	public void setRegisterScreen() {
		title.setText("Register");
		buttonPanel.remove(loginButton);
		buttonPanel.remove(createAccountButton);
		titlePanel.add(title,BorderLayout.CENTER);
		centerPanel.add(loginUsername); centerPanel.add(loginUsernameField);
		centerPanel.add(loginPassword); centerPanel.add(loginPasswordField);
		centerPanel.add(registerConfirmPassword); centerPanel.add(registerPasswordConfirmField);
		buttonPanel.add(registerButton);
		
		add(titlePanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createAccountButton) {
			System.out.println("Clicked");
			setRegisterScreen();
			
		} else if (e.getSource() == registerButton) {
			String usernameText = loginUsernameField.getText();
			String passwordText = loginPasswordField.getText();
			String confirmPasswordText = registerPasswordConfirmField.getText();
			System.out.println("Register");
			if (!usernameText.equals("Enter Username Here..") && !passwordText.equals("Enter Password Here..")) {
				if (passwordText.equals(confirmPasswordText)) {
					setLoginScreen();
					System.out.println("Creating Account: \nUsername: "+usernameText+"\nPassword: "+passwordText);
				} else {
					JOptionPane.showInternalMessageDialog(null,"Password does not match..");
				}
			}
			
		} 
		
	}
	

	
}
