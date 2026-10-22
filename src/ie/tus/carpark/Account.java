package ie.tus.carpark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	private boolean deleting = false;
	private int charsPassword = 0;
	
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
		loginUsernameField.addActionListener(this);
		
		loginUsernameField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				loginUsernameField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (loginUsernameField.getText().length() == 0) { 
					loginUsernameField.setText("Enter Username Here...");
				}
			} 
			
		});
		
		loginPasswordField.addFocusListener(new FocusListener() { 
			@Override
			public void focusGained(FocusEvent e) { 
				loginPasswordField.setText("");
			}
			
			@Override
			public void focusLost(FocusEvent e) { 
				if (loginPasswordField.getText().length() == 0) { 
					loginPasswordField.setText("Enter Password Here...");
				}
			}
		});
	
		registerPasswordConfirmField.addFocusListener(new FocusListener() { 
			@Override
			public void focusGained(FocusEvent e) { 
				registerPasswordConfirmField.setText("");
			}
			
			@Override
			public void focusLost(FocusEvent e) { 
				if (registerPasswordConfirmField.getText().length() == 0) { 
					registerPasswordConfirmField.setText("Confirm Password Here...");
				}
			}
		});
		
		loginUsernameField.addMouseListener(new MouseListener() { 
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUsernameField.setText("");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		registerPasswordConfirmField.addKeyListener(new KeyListener() { 
			@Override
			public void keyTyped(KeyEvent e) {
				if (deleting) { 
					if (registerPasswordConfirmField.getText().length() > 0) {
						typedConfirmPassword = typedConfirmPassword.substring(0,registerPasswordConfirmField.getText().length()-1); 						
					}

					return;
				}
				registerPasswordConfirmField.setText("");
				System.out.println(e.getKeyChar());
				System.out.println("Typed");
				char typed = e.getKeyChar();
				typedConfirmPassword = typedConfirmPassword+typed;
				e.consume();
		
				for (int i = 0; i < typedConfirmPassword.length(); i++) {
					registerPasswordConfirmField.setText(registerPasswordConfirmField.getText() + "*");
				}

			
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_BACK_SPACE) {
					deleting = true;
				
					
				}
				
				if (e.getKeyCode() == e.VK_ENTER) {
					e.consume();
					register();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_BACK_SPACE) {
					deleting = false;
				}
			
			}
		});
		
		
		loginPasswordField.addKeyListener(new KeyListener() { 
			@Override
			public void keyTyped(KeyEvent e) {
				if (deleting) { 
					if (loginPasswordField.getText().length() > 0) {
						typedPassword = typedPassword.substring(0,loginPasswordField.getText().length()-1); 						
					}

					return;
				}
				loginPasswordField.setText("");
				System.out.println(e.getKeyChar());
				System.out.println("Typed");
				char typed = e.getKeyChar();
				typedPassword = typedPassword+typed;
				e.consume();
				charsPassword++;
				for (int i = 0; i < typedPassword.length(); i++) {
					loginPasswordField.setText(loginPasswordField.getText() + "*");
				}

			
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_BACK_SPACE) {
					deleting = true;
		
					
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_BACK_SPACE) {
					deleting = false;
				}
			
			}
		});
	}
	
	
	public void register() { 
		String usernameText = loginUsernameField.getText();
		String passwordText = loginPasswordField.getText();
		String confirmPasswordText = registerPasswordConfirmField.getText();
		System.out.println("Register");
		if (!usernameText.equals("Enter Username Here..") && !passwordText.equals("Enter Password Here..")) {
			if (typedPassword.equals(typedConfirmPassword)) {
				setLoginScreen();
				System.out.println("Creating Account: \nUsername: "+usernameText+"\nPassword: "+passwordText);
			} else {
				typedPassword = "";
				typedConfirmPassword = "";
				loginPasswordField.setText("");
				registerPasswordConfirmField.setText("");
				JOptionPane.showInternalMessageDialog(null,"Password does not match..");
			}
		}
		
		loginUsernameField.setText("Enter Username Here..");
		loginPasswordField.setText("Enter Password Here..");
		registerPasswordConfirmField.setText("");
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
			register();
			
		} 
		
	}
	

	
}
