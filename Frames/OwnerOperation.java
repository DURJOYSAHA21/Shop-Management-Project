package Frames;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class OwnerOperation extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextField userIdTF,nameTF,addressTF,emailTF,numberTF,answerTF,ageTF,ShareTF;
	private JLabel ownerLabel,userIdLabel,nameLabel,addressLabel,emailLabel,genderLabel,numberLabel,passwordLabel,confirmpassLabel,securityLabel,securityAnswerLabel,ageLabel,shareLabel;
	private JPasswordField passTF,confirmpassTF;
	private JRadioButton maleRB,femaleRB;
	private ButtonGroup bg;
	private JButton addButton,backButton,removeButton,ulButton,updButton,customerButton,searchButton,exitButton,addCustomer,removeCustomer,searchCustomer,addEmployer,removeEmployer,searchEmployer,productButton,salesButton,manageButton;
	private JComboBox securityQ;
	private Cursor cursor;
	private User u;
	
	public OwnerOperation(User u){
		super("Owner Operation");
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(new Color(156,215,255));
		
		this.ownerLabel=new JLabel("Owner Home Page");
		this.ownerLabel.setBounds(0,15,1000,35);
		this.ownerLabel.setFont(new Font("Calibri",Font.BOLD | Font.ITALIC, 30));
		this.ownerLabel.setHorizontalAlignment(JLabel.CENTER);
		this.ownerLabel.setForeground(Color.black);
		this.panel.add(ownerLabel);
		
		this.userIdLabel=new JLabel("User Id");
		this.userIdLabel.setBounds(40,90,100,30);
		this.userIdLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.userIdLabel.setForeground(Color.black);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(150,90,200,30);
		this.userIdTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.userIdTF.setBorder(null);
		this.userIdTF.setForeground(Color.black);
		this.panel.add(userIdTF);
		
		this.nameLabel=new JLabel("Name");
		this.nameLabel.setBounds(40,140,100,30);
		this.nameLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.nameLabel.setForeground(Color.black);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(150,140,200,30);
		this.nameTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.nameTF.setForeground(Color.black);
		this.nameTF.setBorder(null);
		this.panel.add(nameTF);
		
		this.addressLabel=new JLabel("Address");
		this.addressLabel.setBounds(40,190,100,30);
		this.addressLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.addressLabel.setForeground(Color.black);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(150,190,200,30);
		this.addressTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.addressTF.setForeground(Color.black);
		this.addressTF.setBorder(null);
		this.panel.add(addressTF);
		
		this.emailLabel=new JLabel("Email");
		this.emailLabel.setBounds(40,240,100,30);
		this.emailLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.emailLabel.setForeground(Color.black);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(150,240,200,30);
		this.emailTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.emailTF.setForeground(Color.black);
		this.emailTF.setBorder(null);
		this.panel.add(emailTF);
		
		this.genderLabel=new JLabel("Gender");
		this.genderLabel.setBounds(40,290,100,30);
		this.genderLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.genderLabel.setForeground(Color.black);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(150,290,90,30);
		this.maleRB.setFont(new Font("Cambria",Font.PLAIN,16));
		this.maleRB.setOpaque(false);
		this.maleRB.setForeground(Color.black);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(260,290,90,30);
		this.femaleRB.setFont(new Font("Cambria",Font.PLAIN,16));
		this.femaleRB.setOpaque(false);
		this.femaleRB.setForeground(Color.black);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.numberLabel=new JLabel("Phone No");
		this.numberLabel.setBounds(40,340,100,30);
		this.numberLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.numberLabel.setForeground(Color.black);
		this.panel.add(numberLabel);
		
		this.numberTF=new JTextField();
		this.numberTF.setBounds(150,340,200,30);
		this.numberTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.numberTF.setForeground(Color.black);
		this.numberTF.setBorder(null);
		this.panel.add(numberTF);
		
		this.securityLabel=new JLabel("Question");
		this.securityLabel.setBounds(40,390,100,30);
		this.securityLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.securityLabel.setForeground(Color.black);
		this.panel.add(securityLabel);
		
		String[] secuQ = { "Choose a Security Question", "what's your father's name?", "what's your mother's name", "what's your favorite sports?", "what's your favourite movie?" };
		this.securityQ=new JComboBox(secuQ);
		this.securityQ.setBounds(150,390,200,30);
		this.panel.add(securityQ);
		
		this.securityAnswerLabel=new JLabel("Answer");
		this.securityAnswerLabel.setBounds(40,440,100,30);
		this.securityAnswerLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.securityAnswerLabel.setForeground(Color.black);
		this.panel.add(securityAnswerLabel);
		
		this.answerTF=new JTextField();
		this.answerTF.setBounds(150,440,200,30);
		this.answerTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.answerTF.setForeground(Color.black);
		this.answerTF.setBorder(null);
		this.panel.add(answerTF);
		
		this.ageLabel=new JLabel("Age");
		this.ageLabel.setBounds(620,90,100,30);
		this.ageLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.ageLabel.setForeground(Color.black);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(730,90,200,30);
		this.ageTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.ageTF.setForeground(Color.black);
		this.ageTF.setBorder(null);
		this.panel.add(ageTF);
		
		this.passwordLabel=new JLabel("Password");
		this.passwordLabel.setBounds(620,140,100,30);
		this.passwordLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.passwordLabel.setForeground(Color.black);
		this.panel.add(passwordLabel);
		
		this.passTF=new JPasswordField();
		this.passTF.setBounds(730,140,200,30);
		this.passTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.passTF.setForeground(Color.black);
		this.passTF.setBorder(null);
		this.panel.add(passTF);
		
		this.confirmpassLabel=new JLabel("Confirm");
		this.confirmpassLabel.setBounds(620,190,100,30);
		this.confirmpassLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.confirmpassLabel.setForeground(Color.black);
		this.panel.add(confirmpassLabel);
		
		this.confirmpassTF=new JPasswordField();
		this.confirmpassTF.setBounds(730,190,200,30);
		this.confirmpassTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.confirmpassTF.setForeground(Color.black);
		this.confirmpassTF.setBorder(null);
		this.panel.add(confirmpassTF);
		
		this.shareLabel=new JLabel("Share");
		this.shareLabel.setBounds(620,240,100,30);
		this.shareLabel.setFont(new Font("Calibri",Font.PLAIN,25));
		this.shareLabel.setForeground(Color.black);
		this.panel.add(shareLabel);
		
		this.ShareTF=new JTextField();
		this.ShareTF.setBounds(730,240,200,30);
		this.ShareTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.ShareTF.setForeground(Color.black);
		this.ShareTF.setBorder(null);
		this.panel.add(ShareTF);
		
	   this.productButton=new JButton("Product List");
		this.productButton.setBounds(730,280,150,40);
		this.productButton.setFont(new Font("Calibri",Font.BOLD,23));
		this.productButton.setForeground(Color.black);
		this.productButton.setFocusable(false);
		this.productButton.setBorder(BorderFactory.createEtchedBorder());
		this.productButton.setBackground(new Color(255,253,110));
		this.productButton.addActionListener(this);
		this.panel.add(productButton);
		
	   this.customerButton=new JButton("Customer List");
		this.customerButton.setBounds(530,280,150,40);
		this.customerButton.setFont(new Font("Calibri",Font.BOLD,23));
		this.customerButton.setForeground(Color.black);
		this.customerButton.setFocusable(false);
		this.customerButton.setBorder(BorderFactory.createEtchedBorder());
		this.customerButton.setBackground(new Color(255,253,110));
		this.customerButton.addActionListener(this);
		this.panel.add(customerButton);		
		
	     this.updButton=new JButton("Update");
		this.updButton.setBounds(530,330,150,40);
		this.updButton.setFont(new Font("Calibri",Font.BOLD,23));
		this.updButton.setForeground(Color.black);
		this.updButton.setFocusable(false);
		this.updButton.setBorder(BorderFactory.createEtchedBorder());
		this.updButton.setBackground(new Color(255,253,110));
		this.updButton.addActionListener(this);
		this.panel.add(updButton);	

		this.ulButton=new JButton("Owner List");
		this.ulButton.setBounds(730,330,150,40);
		this.ulButton.setFont(new Font("Calibri",Font.BOLD,23));
		this.ulButton.setForeground(Color.black);
		this.ulButton.setFocusable(false);
		this.ulButton.setBorder(BorderFactory.createEtchedBorder());
		this.ulButton.setBackground(new Color(255,253,110));
		this.ulButton.addActionListener(this);
		this.panel.add(ulButton);

		this.salesButton=new JButton("Sales Report");
		this.salesButton.setBounds(530,380,150,40);
		this.salesButton.setFont(new Font("Calibri",Font.BOLD,23));
		this.salesButton.setForeground(Color.black);
		this.salesButton.setFocusable(false);
		this.salesButton.setBorder(BorderFactory.createEtchedBorder());
		this.salesButton.setBackground(new Color(255,253,110));
		this.salesButton.addActionListener(this);
		this.panel.add(salesButton);

		this.manageButton=new JButton("Manage Stock");
		this.manageButton.setBounds(730,380,150,40);
		this.manageButton.setFont(new Font("Calibri",Font.BOLD,23));
		this.manageButton.setForeground(Color.black);
		this.manageButton.setFocusable(false);
		this.manageButton.setBorder(BorderFactory.createEtchedBorder());
		this.manageButton.setBackground(new Color(255,253,110));
		this.manageButton.addActionListener(this);
		this.panel.add(manageButton);
		
		//cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		//customer button
		this.addCustomer=new JButton("Add Customer");
		this.addCustomer.setBounds(40,520,250,40);
		this.addCustomer.setFont(new Font("Calibri",Font.BOLD,23));
		this.addCustomer.setForeground(Color.black);
		this.addCustomer.setFocusable(false);
		this.addCustomer.setBorder(BorderFactory.createEtchedBorder());
		this.addCustomer.setBackground(new Color(163,255,160));
		this.addCustomer.addActionListener(this);
		this.panel.add(addCustomer);
		
		this.removeCustomer=new JButton("Remove Customer");
		this.removeCustomer.setBounds(365,520,250,40);
		this.removeCustomer.setFont(new Font("Calibri",Font.BOLD,23));
		this.removeCustomer.setForeground(Color.black);
		this.removeCustomer.setFocusable(false);
		this.removeCustomer.setBackground(new Color(255,143,143));
		this.removeCustomer.addActionListener(this);
		this.panel.add(removeCustomer);
		
		this.searchCustomer=new JButton("Search Customer");
		this.searchCustomer.setBounds(690,520,250,40);
		this.searchCustomer.setFont(new Font("Calibri",Font.BOLD,23));
		this.searchCustomer.setForeground(Color.black);
		this.searchCustomer.setFocusable(false);
		this.searchCustomer.setBorder(BorderFactory.createEtchedBorder());
		this.searchCustomer.setBackground(new Color(255,253,110));
		this.searchCustomer.addActionListener(this);
		this.panel.add(searchCustomer);
		
		//ower button
		this.addButton=new JButton("Add Owner");
		this.addButton.setBounds(40,580,250,40);
		this.addButton.setFont(new Font("Calibri",Font.BOLD,23));
		this.addButton.setForeground(Color.black);
		this.addButton.setFocusable(false);
		this.addButton.setBorder(BorderFactory.createEtchedBorder());
		this.addButton.setBackground(new Color(163,255,160));
		this.addButton.addActionListener(this);
		this.panel.add(addButton);
		
		this.removeButton=new JButton("Remove Owner");
		this.removeButton.setBounds(365,580,250,40);
		this.removeButton.setFont(new Font("Calibri",Font.BOLD,23));
		this.removeButton.setForeground(Color.black);
		this.removeButton.setFocusable(false);
		this.removeButton.setBackground(new Color(255,143,143));
		this.removeButton.addActionListener(this);
		this.panel.add(removeButton);
		
		this.searchButton=new JButton("Search Owner");
		this.searchButton.setBounds(690,580,250,40);
		this.searchButton.setFont(new Font("Calibri",Font.BOLD,23));
		this.searchButton.setForeground(Color.black);
		this.searchButton.setFocusable(false);
		this.searchButton.addActionListener(this);
		this.searchButton.setBorder(BorderFactory.createEtchedBorder());
		this.searchButton.setBackground(new Color(255,253,110));
		this.panel.add(searchButton);
		
		//Employer
		this.addEmployer=new JButton("Add Employer");
		this.addEmployer.setBounds(40,640,250,40);
		this.addEmployer.setFont(new Font("Calibri",Font.BOLD,23));
		this.addEmployer.setForeground(Color.black);
		this.addEmployer.setFocusable(false);
		this.addEmployer.setBorder(BorderFactory.createEtchedBorder());
		this.addEmployer.setBackground(new Color(163,255,160));
		this.addEmployer.addActionListener(this);
		this.panel.add(addEmployer);
		
		this.removeEmployer=new JButton("Remove Employer");
		this.removeEmployer.setBounds(365,640,250,40);
		this.removeEmployer.setFont(new Font("Calibri",Font.BOLD,23));
		this.removeEmployer.setForeground(Color.black);
		this.removeEmployer.setFocusable(false);
		this.removeEmployer.setBackground(new Color(255,143,143));
		this.removeEmployer.addActionListener(this);
		this.panel.add(removeEmployer);
		
		this.searchEmployer=new JButton("Search Employer");
		this.searchEmployer.setBounds(690,640,250,40);
		this.searchEmployer.setFont(new Font("Calibri",Font.BOLD,23));
		this.searchEmployer.setForeground(Color.black);
		this.searchEmployer.setFocusable(false);
		this.searchEmployer.setBorder(BorderFactory.createEtchedBorder());
		this.searchEmployer.setBackground(new Color(255,253,110));
		this.searchEmployer.addActionListener(this);
		this.panel.add(searchEmployer);

	
		
		
		this.exitButton=new JButton("Exit");
		this.exitButton.setBounds(840,710,100,30);
		this.exitButton.setBorder(BorderFactory.createEtchedBorder());
		this.exitButton.setFocusable(false);
		this.exitButton.setFont(new Font("Calibri", Font.BOLD, 18));
		this.exitButton.setForeground(Color.black);
		this.exitButton.setBackground(new Color(199,199,199));
		this.exitButton.setCursor(cursor);
		this.exitButton.addActionListener(this);
		this.panel.add(exitButton);
		
		this.add(panel);
		this.u=u;
		
	}
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		//owner
		if(productButton.getText().equals(command))
		{
			AllProductList a=new AllProductList(this.u);
			this.setVisible(false);
			a.setVisible(true);
		}

		if(salesButton.getText().equals(command))
		{
			SalesReport a=new SalesReport(this.u);
			this.setVisible(false);
			a.setVisible(true);
		}

		if(manageButton.getText().equals(command))
		{
			ManageProduct a=new ManageProduct(this.u);
			this.setVisible(false);
			a.setVisible(true);
		}
		
			if(updButton.getText().equals(command))
		{
			String Id,name,address,email,number,answer,pass,cpass,gender;
			int age;
			float share;
			Id=userIdTF.getText();
			
			this.userIdTF.setEditable(false);
			if((!userIdTF.getText().isEmpty())&&(!nameTF.getText().isEmpty())&&(!emailTF.getText().isEmpty())&&(!numberTF.getText().isEmpty())&&((maleRB.isSelected())||(femaleRB.isSelected()))&&(!ageTF.getText().isEmpty())&&(!addressTF.getText().isEmpty()))
			{
				OwnerR or=new OwnerR();
			
			Owner o=or.searchOwnerByUserId(Id);
			if(o!=null)
			{
				
				
				try{
					name=nameTF.getText();
				address=addressTF.getText();
				email=emailTF.getText();
				number=numberTF.getText();
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}		
                            
                                age=Integer.parseInt(ageTF.getText());
                            	share=Float.parseFloat(ShareTF.getText());	
								o.setName(name);
								o.setEmail(email);
								o.setPhoneNo(number);
								o.setGender(gender);
								o.setAge(age);
								o.setCompanySharePercentage(share);
								or.updateOwner(o);
								JOptionPane.showMessageDialog(this,"admin updated Successfully");
								this.userIdTF.setEditable(true);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,"enter valid age");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"not valid user");
				this.userIdTF.setEditable(true);
			}	

			}
						else
			{
				JOptionPane.showMessageDialog(this,"enter what to update");
			}			
								
				
		}
				
				
			if(ulButton.getText().equals(command))
		{
			
			OwnerList a=new OwnerList(this.u);
			this.setVisible(false);
			a.setVisible(true);
		
		}

		
		
		
		if(customerButton.getText().equals(command))
		{
			
			CustomerList a=new CustomerList(this.u);
			this.setVisible(false);
			a.setVisible(true);
		
		}
		
		if(addButton.getText().equals(command))
		{
			String Id,name,address,email,number,answer,pass,cpass,gender;
			int age;
			float share;
			if((!userIdTF.getText().isEmpty())&&(!nameTF.getText().isEmpty())&&(!emailTF.getText().isEmpty())&&(!numberTF.getText().isEmpty())&&((maleRB.isSelected())||(femaleRB.isSelected()))&&(!ageTF.getText().isEmpty())&&(!addressTF.getText().isEmpty())&&(!answerTF.getText().isEmpty())&&(!passTF.getText().isEmpty())&&(!confirmpassTF.getText().isEmpty()))
		{
			Id=userIdTF.getText();
			UserRepo ur=new UserRepo();
			
			User u=ur.searchUserById(Id);
			if(u==null)
			{
				try
				{
				name=nameTF.getText();
				address=addressTF.getText();
				email=emailTF.getText();
				number=numberTF.getText();
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}		
                            
                                age=Integer.parseInt(ageTF.getText());
                            	share=Float.parseFloat(ShareTF.getText());		
                                int role =2;
                       			answer=answerTF.getText();
								pass=passTF.getText();
								
								
								Owner o=new Owner(Id,name,gender,age,email,number,address,role,answer,pass,share);
								ur.addUser(o);
								OwnerR or=new OwnerR();
								or.addOwner(o);
								JOptionPane.showMessageDialog(this,"added");
								
								
				}
				catch(Exception e)
				{
									JOptionPane.showMessageDialog(this,"add a valid age");
				}
								
						
		
		}
		else
			{
									JOptionPane.showMessageDialog(this,"exsits");
			}	
				
		}
		else
		{
			JOptionPane.showMessageDialog(this,"fill up all");
		}
		}
		
		
		
		if(removeButton.getText().equals(command))
		{
			String userId;
			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText();
				OwnerR or=new OwnerR();
				Owner o=or.searchOwnerByUserId(userId);
				
				if(o!=null)
				{
					UserRepo ur=new UserRepo();
					u=ur.searchUserById(userId);
					
					ur.removeUser(userId);
					or.removeOwner(userId);
					JOptionPane.showMessageDialog(this,"Owner Removed");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"not valid");
				}
			}
			JOptionPane.showMessageDialog(this,"fill the id");
		}
		
		if(removeEmployer.getText().equals(command))
		{
			String userId;
			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText();
				EmployerR or=new EmployerR();
				Employer o=or.searchEmployerByUserId(userId);
				
				if(o!=null)
				{
					UserRepo ur=new UserRepo();
					u=ur.searchUserById(userId);
					
					ur.removeUser(userId);
					or.removeEmployer(userId);
					JOptionPane.showMessageDialog(this,"Employer Removed");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"not valid");
				}

				
			}
			JOptionPane.showMessageDialog(this,"fill the id");

		}
		
		if(removeCustomer.getText().equals(command))
		{
			String userId;
			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText();
				CustomerRepo or=new CustomerRepo();
				Customer o=or.searchCustomerById(userId);
				
				if(o!=null)
				{
					UserRepo ur=new UserRepo();
				u=ur.searchUserById(userId);
					
					ur.removeUser(userId);
					or.removeCustomer(userId);
					JOptionPane.showMessageDialog(this,"Customer Removed");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"not valid");
				}
			}
			JOptionPane.showMessageDialog(this,"fill the id");
		}
		
		
		
		
		//search button for owner
		if(searchButton.getText().equals(command)){
			if(!userIdTF.getText().isEmpty()){
				OwnerR or=new OwnerR();
				Owner o=or.searchOwnerByUserId(userIdTF.getText());
				if(o!=null){
					userIdTF.setEditable(false);
					nameTF.setText(o.getName());
					addressTF.setText(o.getAddress());
					emailTF.setText(o.getEmail());
					numberTF.setText(o.getPhoneNo());
					answerTF.setText(o.getPhoneNo());
					ageTF.setText(String.valueOf(o.getAge()));
					ShareTF.setText(String.valueOf(o.getCompanySharePercentage()));
					if(o.getGender().equals("Male")){
						maleRB.setSelected(true);
					}
					else{
						femaleRB.setSelected(true);
					}
					JOptionPane.showMessageDialog(this,"Owner found:)");
				}
				else{
					JOptionPane.showMessageDialog(this,"Owner not found:(");
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"Enter User ID:(");
			}
		}
		//search button for customer
		if(searchCustomer.getText().equals(command)){
			if(!userIdTF.getText().isEmpty()){
				CustomerRepo or=new CustomerRepo();
				Customer o=or.searchCustomerById(userIdTF.getText());
				if(o!=null){
					userIdTF.setEditable(false);
					nameTF.setText(o.getName());
					addressTF.setText(o.getAddress());
					emailTF.setText(o.getEmail());
					numberTF.setText(o.getPhoneNo());
					answerTF.setText(o.getPhoneNo());
					ageTF.setText(String.valueOf(o.getAge()));
					if(o.getGender().equals("Male")){
						maleRB.setSelected(true);
					}
					else{
						femaleRB.setSelected(true);
					}
					JOptionPane.showMessageDialog(this,"Customer found:)");
				}
				else{
					JOptionPane.showMessageDialog(this,"Customer not found:(");
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"Enter User ID:(");
			}
		}
		//search button for Employer
		if(searchEmployer.getText().equals(command)){
			if(!userIdTF.getText().isEmpty()){
				EmployerR or=new EmployerR();
				Employer o=or.searchEmployerByUserId(userIdTF.getText());
				if(o!=null){
					userIdTF.setEditable(false);
					nameTF.setText(o.getName());
					addressTF.setText(o.getAddress());
					emailTF.setText(o.getEmail());
					numberTF.setText(o.getPhoneNo());
					answerTF.setText(o.getPhoneNo());
					ageTF.setText(String.valueOf(o.getAge()));
					if(o.getGender().equals("Male")){
						maleRB.setSelected(true);
					}
					else{
						femaleRB.setSelected(true);
					}
					JOptionPane.showMessageDialog(this,"Employer found:)");
				}
				else{
					JOptionPane.showMessageDialog(this,"Employer not found:(");
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"Enter User ID:(");
			}
		}
		if(addCustomer.getText().equals(command)){
			SignUp sg=new SignUp();
			sg.setVisible(true);
			this.setVisible(false);
		}
		/*if(phoneButton2.getText().equals(command)){
			
		}*/
		if(exitButton.getText().equals(command)){
			System.exit(0);
		}
	}
}
	