package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class DeleteAccFramet extends JFrame  implements  ActionListener
{
	JPanel mainPanel,subPanel;
	JLabel userId,password,conPassword;
	JPasswordField nPassField,cPassField;
	JButton backButton,okButton;
	JTextField userTextField;
	
	
	public DeleteAccFramet()
	{
		super("Delete Account");
        this.setSize(630,630);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);		
		
		this.mainPanel=new JPanel();
		this.mainPanel.setLayout(null);
		this.mainPanel.setBackground(new Color(41,41,41));
		
        this.subPanel=new JPanel();
		this.subPanel.setBounds(115,150,400,300);
		this.subPanel.setLayout(null);
		this.subPanel.setBackground(new Color(179,179,179));		

		this.userId=new JLabel("User ID");
		this.userId.setBounds(10,10,130,30);
		this.userId.setFont(new Font("Calibri", Font.BOLD, 18));
		this.userId.setForeground(Color.black);
		this.subPanel.add(userId);
		
		this.password=new JLabel("Password");
		this.password.setBounds(10,50,130,30);
		this.password.setFont(new Font("Calibri", Font.BOLD, 18));
		this.password.setForeground(Color.black);
		this.password.setVisible(false);
		this.subPanel.add(password);		
		
		this.conPassword=new JLabel("Confirm Password");
		this.conPassword.setBounds(10,90,130,30);
		this.conPassword.setFont(new Font("Calibri", Font.BOLD, 18));
		this.conPassword.setForeground(Color.black);
		this.conPassword.setVisible(false);
		this.subPanel.add(conPassword);	

		//users can only delete their own account
		this.userTextField=new JTextField();
		if(Session.currentUser!=null){
			this.userTextField.setText(Session.currentUser.getUserId());
		}
		this.userTextField.setEditable(false);
		this.userTextField.setBounds(170,10,190,30);
		this.userTextField.setBorder(null);
		this.subPanel.add(userTextField);

		this.nPassField=new JPasswordField();
		this.nPassField.setBounds(170,50,190,30);
		this.nPassField.setBorder(null);
		this.nPassField.setVisible(false);
		this.subPanel.add(nPassField);		
		
		this.cPassField=new JPasswordField();
		this.cPassField.setBounds(170,90,190,30);
		this.cPassField.setBorder(null);
		this.cPassField.setVisible(false);
		this.subPanel.add(cPassField);
		
		this.backButton=new JButton();
		this.backButton.setIcon(new ImageIcon("images/return.png"));
		this.backButton.setBounds(17,9,35,35);
		this.backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.backButton.setBorder(BorderFactory.createEtchedBorder());
		this.backButton.setFocusPainted(false);
		this.mainPanel.add(backButton);
		this.backButton.addActionListener(this);
		
		this.okButton=new JButton("Ok");
		this.okButton.setBounds(480,550,100,30);
		this.okButton.setFocusable(false);
		this.okButton.setBorder(BorderFactory.createEtchedBorder());
		this.okButton.setFont(new Font("Calibri", Font.BOLD, 18));
		this.okButton.setForeground(Color.black);
		this.okButton.setBackground(new Color(148,148,148));
		this.okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.okButton.addActionListener(this);
		this.mainPanel.add(okButton);
		
		this.mainPanel.add(subPanel);
		this.add(mainPanel);
	}
		int c=0;
		public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		if(ae.getSource()==backButton)
		{
			HomeFrame home=new HomeFrame();
			home.setVisible(true);
			this.setVisible(false);
		}
		if(okButton.getText().equals(command)&&c==0){
			
			UserRepo userR=new UserRepo(); 
		    User user=userR.searchUserById(userTextField.getText());
			if(user!=null&&user.getUserId().equals(userTextField.getText())){
				
				    this.userTextField.setEditable(false);
					this.password.setVisible(true);
		            this.nPassField.setVisible(true);
					this.conPassword.setVisible(true);
					this.cPassField.setVisible(true);
					this.userTextField.setEditable(false);
					c++;
			}
            else{
					JOptionPane.showMessageDialog(this,"User ID doesn't match!:(");
		    } 
		}
			else if(okButton.getText().equals(command)&&c==1){
			
			if(!nPassField.getText().equals(cPassField.getText())){
				JOptionPane.showMessageDialog(this,"Passwords don't match!");
			}
			else{
				    UserRepo userR=new UserRepo();
		            User user=userR.searchUserById(userTextField.getText());
					if(user!=null&&user.getPassword().equals(nPassField.getText())){

					    userR.removeUser(userTextField.getText());
						new CustomerRepo().removeCustomer(userTextField.getText());
						Session.currentUser=null;
						JOptionPane.showMessageDialog(this,"Account deleted.");

						LoginFrame f3=new LoginFrame();
			            f3.setVisible(true);
			            this.setVisible(false);
					    c=0;
					}
					else{
						JOptionPane.showMessageDialog(this,"Wrong password!");
					}
			}

		}			
		

	}
}
		
		
		
		