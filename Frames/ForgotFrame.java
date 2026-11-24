package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class ForgotFrame extends JFrame implements ActionListener{
	
	private JPanel panel,panel2;
	private JTextField sTextField,uTextField;
	private JPasswordField nPassField,cPassField;
	private JLabel sQuestion,newPassword,conPassword,userId;
	private JButton backButton,okButton;
	private Font f1,f2,f3;
	private Cursor cursor;
	
	public ForgotFrame(){
		super("Forgot Password");
		this.setSize(630,630);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		//this.getContentPane().setLayout(null);
		//JOptionPane.showMessageDialog(this,"Forgot password frame created successfully");
		
		//cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		//Fonts
		this.f1 = new Font("Calibri", Font.PLAIN, 16);
        this.f2 = new Font("Segoe UI Black", Font.PLAIN, 20);
		this.f3 = new Font("Calibri", Font.BOLD, 18);
		
		//panel
		this.panel2=new JPanel();
		this.panel2.setLayout(null);
		this.panel2.setBackground(new Color(41,41,41));
		
		//mid panel
		this.panel=new JPanel();
		this.panel.setBounds(115,150,400,300);//150,150,300,300
		this.panel.setLayout(null);
		//this.panel.setLocationRelativeTo(null);
		this.panel.setBackground(new Color(179,179,179));
		
		//labels
		this.userId=new JLabel("User ID");
		this.userId.setBounds(10,10,130,30);
		this.userId.setFont(f1);
		this.userId.setForeground(Color.black);
		this.panel.add(userId);
		
		this.sQuestion=new JLabel("Security Answer");
		this.sQuestion.setBounds(10,50,130,30);
		this.sQuestion.setFont(f1);
		this.sQuestion.setForeground(Color.black);
		this.sQuestion.setVisible(false);
		this.panel.add(sQuestion);
		
		this.newPassword=new JLabel("New Password");
		this.newPassword.setBounds(10,90,130,30);
		this.newPassword.setFont(f1);
		this.newPassword.setForeground(Color.black);
		this.newPassword.setVisible(false);
		this.panel.add(newPassword);
		
		this.conPassword=new JLabel("Confirm Password");
		this.conPassword.setBounds(10,130,130,30);
		this.conPassword.setFont(f1);
		this.conPassword.setForeground(Color.black);
		this.conPassword.setVisible(false);
		this.panel.add(conPassword);
		
		//text field
		
		this.uTextField=new JTextField("User ID");
		this.uTextField.setBounds(170,10,190,30);
		this.uTextField.setBorder(null);
		this.panel.add(uTextField);
		
		this.sTextField=new JTextField("Security Question");
		this.sTextField.setBounds(170,50,190,30);
		this.sTextField.setBorder(null);
		this.sTextField.setVisible(false);
		this.panel.add(sTextField);
		
		//password field
		this.nPassField=new JPasswordField();
		this.nPassField.setBounds(170,90,190,30);
		this.nPassField.setEchoChar('*');
		this.nPassField.setBorder(null);
		this.nPassField.setVisible(false);
		this.panel.add(nPassField);
		
		this.cPassField=new JPasswordField();
		this.cPassField.setBounds(170,130,190,30);
		this.cPassField.setEchoChar('*');
		this.cPassField.setBorder(null);
		this.cPassField.setVisible(false);
		this.panel.add(cPassField);
		
		/*
		(sq questioin)label-textfield
		(password and confirm password)
		*/
		//buttons
		//back button
		this.backButton=new JButton("Back");
		this.backButton.setBounds(370,550,100,30);
		this.backButton.setFocusable(false);
		this.backButton.setBorder(BorderFactory.createEtchedBorder());
		this.backButton.setFont(f3);
		this.backButton.setForeground(Color.black);
		this.backButton.setBackground(new Color(148,148,148));
		this.backButton.setCursor(cursor);
		this.backButton.addActionListener(this);
		this.panel2.add(backButton);
		
		//ok Button
		this.okButton=new JButton("Ok");
		this.okButton.setBounds(480,550,100,30);
		this.okButton.setFocusable(false);
		this.okButton.setBorder(BorderFactory.createEtchedBorder());
		this.okButton.setFont(f3);
		this.okButton.setForeground(Color.black);
		this.okButton.setBackground(new Color(148,148,148));
		this.okButton.setCursor(cursor);
		this.okButton.addActionListener(this);
		this.panel2.add(okButton);
		
		//frames
		//this.getContentPane().setBackground(new Color(41,41,41));
		
		this.panel2.add(panel);
		this.add(panel2);
	}
	int c=0;
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		String back=backButton.getText();
		String ok=okButton.getText();
		
		if(backButton.getText().equals(command)){
			LoginFrame f2=new LoginFrame();
			f2.setVisible(true);
			this.setVisible(false);
		}
		if(okButton.getText().equals(command)&&c==0){
			
			UserRepo userR=new UserRepo(); 
		    User user=userR.searchUserById(uTextField.getText());
			if(user!=null&&user.getUserId().equals(uTextField.getText())){
				
				    this.uTextField.setEditable(false);
					this.sQuestion.setVisible(true);
		            this.sTextField.setVisible(true);
					this.uTextField.setEditable(false);
					c++;
			}
            else{
					JOptionPane.showMessageDialog(this,"User ID doesn't match!:(");
		    } 
		}	
		else if(okButton.getText().equals(command)&&c==1){
			
			UserRepo userR=new UserRepo();
		    User user=userR.searchUserById(uTextField.getText());
			if(user!=null&&user.getSecurityAns().equals(sTextField.getText())){
			        //new password visibility(labels and textfields) 
			        this.newPassword.setVisible(true);
		   
		            this.nPassField.setVisible(true);
		    
			
			        //confirm password visibility(labels and textfields) 
			        this.conPassword.setVisible(true);
		
		    		this.cPassField.setVisible(true);
					c++;
			}
            else{
				JOptionPane.showMessageDialog(this,"Security question doesn't match or Invalid operation!:(");
			} 			
		}
		else if(okButton.getText().equals(command)&&c==2){
			
			if(nPassField.getText().equals(cPassField.getText())){
				    UserRepo userR=new UserRepo(); 
		            User user=userR.searchUserById(uTextField.getText());
					if(user!=null&&user.getSecurityAns().equals(sTextField.getText())){
						user.setPassword(cPassField.getText());
					    userR.updateUser(user);
						JOptionPane.showMessageDialog(this,"Password updated successfully!:)");
						LoginFrame f3=new LoginFrame();
			            f3.setVisible(true);
			            this.setVisible(false);
					    c=0;
					}
					else{
						JOptionPane.showMessageDialog(this,"Unfortunatly user didn't match!:(");
					}
			}
            else{
					JOptionPane.showMessageDialog(this,"Confirm pasword doesn't match!:(");
		    } 
		}
		else{
			
		}
	}
}