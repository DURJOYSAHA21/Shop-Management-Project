package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import entities.*;
import repositories.*;

public class LoginFrame extends JFrame implements ActionListener{
	private JLabel userName,password,backgroundP,subLogo,liner1;
	private JTextField uTextField;
	private JPasswordField pPassField;
	private JButton FPbutton,loginButton,signUpButton;
	private JPanel panel;
	private ImageIcon image1;
	private ImageIcon image2;
	private Font f1, f2,f3;
	private Cursor cursor;
	private Color color1,color2,color3,color4;
	
	public LoginFrame(){
		
		//Frame
		super("Pixel Palace");
		this.setSize(1000,497);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//color
		this.color1=new Color(255,42,121);
		this.color2=new Color(0,242,255);
		this.color3=new Color(0,255,124);
		this.color4=new Color(203,180,232);
		
		//cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		//Panel
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		//Fonts
		this.f1 = new Font("Calibri", Font.PLAIN, 20);
        this.f2 = new Font("Segoe UI Black", Font.PLAIN, 20);
		this.f3 = new Font("Calibri", Font.BOLD, 18);
		
		//images
		this.image1=new ImageIcon("images/Final.jpg");
		this.image2=new ImageIcon("images/FinalLogo2.png");
		
		//setting icon
		this.setIconImage(image2.getImage());
		
		//setting icon to the page
		this.subLogo=new JLabel(image2);
		this.subLogo.setBounds(800,0,200,200);
		//this.panel.add(subLogo);
		
		//labels
		this.userName=new JLabel("User ID");
		this.userName.setBounds(100,100,100,30);//100,100,200,30
		this.userName.setFont(f1);
		this.userName.setForeground(Color.black);
		this.panel.add(userName);
		
		this.password=new JLabel("Password");
		this.password.setBounds(100,150,100,30);
		this.password.setFont(f1);
		this.password.setForeground(Color.black);
        this.panel.add(password);		
		
		/*this.liner1=new JLabel("______________________");
		this.liner1.setBounds(290,230,150,5);
		this.panel.add(liner1);*/
		
		//text fields
		this.uTextField=new JTextField();
		this.uTextField.setBounds(210,100,310,30);
		this.uTextField.setBorder(null);
		this.panel.add(uTextField);
		
		//passwordfields
		this.pPassField=new JPasswordField();
		this.pPassField.setBounds(210,150,310,30);
		this.pPassField.setEchoChar('*');
		this.pPassField.setBorder(null);
		this.panel.add(pPassField);
		
		//buttons
		//Forgot pasword button
		this.FPbutton=new JButton("Forgot Password?");
		this.FPbutton.setBounds(290,200,150,30);//225,200,150,30
		this.FPbutton.setFocusable(false);
		this.FPbutton.setBorder(BorderFactory.createEtchedBorder());
	    this.FPbutton.setFont(f3);
		this.FPbutton.setOpaque(false);
		this.FPbutton.setHorizontalTextPosition(JButton.CENTER);
		this.FPbutton.setVerticalTextPosition(JButton.CENTER);
		this.FPbutton.setCursor(cursor);
		this.FPbutton.setBorder(null);
		this.FPbutton.setBackground(color4);
		this.FPbutton.setForeground(new Color(71,71,71));
		this.FPbutton.addActionListener(this);
		this.panel.add(FPbutton);
		
		//login button
		this.loginButton=new JButton("Login");
		this.loginButton.setBounds(210,250,150,30);//225,250,150,30
		this.loginButton.setFocusable(false);
		this.loginButton.setBorder(BorderFactory.createEtchedBorder());
		this.loginButton.setFont(f3);
		this.loginButton.setHorizontalTextPosition(JButton.CENTER);
		this.loginButton.setVerticalTextPosition(JButton.CENTER);
		this.loginButton.setCursor(cursor);
		this.loginButton.setBorder(null);
		this.loginButton.setBackground(color2);
		this.loginButton.addActionListener(this);
		this.panel.add(loginButton);
		
		//Sign up button
		this.signUpButton=new JButton("Sign Up");
		this.signUpButton.setBounds(370,250,150,30);
		this.signUpButton.setFocusable(false);
		this.signUpButton.setBorder(BorderFactory.createEtchedBorder());
		this.signUpButton.setFont(f3);
		this.signUpButton.setHorizontalTextPosition(JButton.CENTER);
		this.signUpButton.setVerticalTextPosition(JButton.CENTER);
		this.signUpButton.setCursor(cursor);
		this.signUpButton.setBorder(null);
		this.signUpButton.setBackground(color3);
		this.signUpButton.addActionListener(this);
		this.panel.add(signUpButton);
		
		//adding image1
		this.backgroundP=new JLabel(image1);
		this.backgroundP.setBounds(0,0,1000,497);
		//this.backgroundP.setIcon(image1);
		this.panel.add(backgroundP);
		//this.panel.setBackground(Color.gray);
		
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		String forgot=FPbutton.getText();
		String login=loginButton.getText();
		String sign=signUpButton.getText();
		
		if(FPbutton.getText().equals(command)){
			ForgotFrame scf=new ForgotFrame();
			scf.setVisible(true);
			this.setVisible(false);
		}
		
		
			
		if(loginButton.getText().equals(command)){
			
			String uId=uTextField.getText();
			String pass=pPassField.getText();
			UserRepo urp=new UserRepo();
			User user=urp.searchUserById(uId);
			if(user!=null){
				if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==1){
					//employees restock products
					Session.currentUser=user;
					ManageProduct hcf=new ManageProduct(user);
					JOptionPane.showMessageDialog(this,"Employee logged in successfully!");
			        hcf.setVisible(true);
			        this.setVisible(false);
				}
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==2){
					Session.currentUser=user;
					OwnerOperation hcf=new OwnerOperation(user);
					JOptionPane.showMessageDialog(this,"Owner loged in sucessfully!:)");
			        hcf.setVisible(true);
			        this.setVisible(false);
				}
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==3){
					Session.currentUser=user;
					HomeFrame hcf=new HomeFrame();
					JOptionPane.showMessageDialog(this,"Customer loged in sucessfully!:)");
			        hcf.setVisible(true);
			        this.setVisible(false);

				}
				else{
					JOptionPane.showMessageDialog(this,"Can't log in!!!Wrong User Id or Password!:(");
					this.uTextField.setText(null);
					this.pPassField.setText(null);
				}	
			}
			else{
				JOptionPane.showMessageDialog(this,"Can't log in!!!Wrong User Id or Password!:(");
				this.uTextField.setText(null);
				this.pPassField.setText(null);
			}
		}
		//*/
		if(signUpButton.getText().equals(command)){
			SignUp fcf=new SignUp();
			fcf.setVisible(true);
			this.setVisible(false);
		}
		
		
			
	}
	public String getU()
			{
				return this.uTextField.getText();
			}
}