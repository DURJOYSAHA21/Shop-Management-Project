package Frames;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class SignUp extends JFrame implements ActionListener
{
	private JPanel panel;
	private Color color1;
	private JLabel signUpLabel,userIdLabel,line1,nameLabel,line2,addressLabel,line3,emailLabel,line4,genderLabel,numberLabel,line5,passwordLabel,line6,confirmpassLabel,line7,securityLabel,securityAnswerLabel,line8,ageLabel,line9,memtypeLabel,memdisLabel;
	private Font font1,font2,font3;
	private JTextField userIdTF,nameTF,addressTF,emailTF,numberTF,answerTF,ageTF,disTF;
	private JRadioButton maleRB,femaleRB,otherRB;
	private JPasswordField passTF,confirmpassTF;
	private ButtonGroup bg;
	private JComboBox securityQ,memtype;
	private JButton signUpButton,backButton;
	
	public SignUp()
	{
		super("SHOP");
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.color1=new Color(132,120,190);
		this.panel.setBackground(color1);
		
		this.signUpLabel=new JLabel("SIGN UP");
		this.signUpLabel.setBounds(400,30,200,40);
		this.font1=new Font("Cambria", Font.BOLD, 40);
		this.signUpLabel.setFont(font1);
		this.signUpLabel.setForeground(Color.black);
		this.panel.add(signUpLabel);
		
		this.userIdLabel=new JLabel("User Id");
		this.userIdLabel.setBounds(40,100,130,20);
		this.font2=new Font("Cambria",Font.PLAIN,20);
		this.userIdLabel.setFont(font2);
		this.userIdLabel.setForeground(Color.black);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(40,125,300,25);
		this.font3=new Font("Cambria",Font.PLAIN,16);
		this.userIdTF.setFont(font3);
		this.userIdTF.setBorder(null);
		this.userIdTF.setOpaque(false);
		this.userIdTF.setForeground(Color.black);
		this.panel.add(userIdTF);
		
		this.line1=new JLabel("_________________________________________________");
		this.line1.setBounds(40,130,350,25);
		this.panel.add(line1);
		
		this.nameLabel=new JLabel("Name");
		this.nameLabel.setBounds(450,100,130,20);
		this.nameLabel.setFont(font2);
		this.nameLabel.setForeground(Color.black);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(450,125,300,25);
		this.nameTF.setFont(font3);
		this.nameTF.setForeground(Color.black);
		this.nameTF.setBorder(null);
		this.nameTF.setOpaque(false);
		this.panel.add(nameTF);
		
		this.line2=new JLabel("_________________________________________________");
		this.line2.setBounds(450,130,350,25);
		this.panel.add(line2);
		
	  
		
		this.addressLabel=new JLabel("Address");
		this.addressLabel.setBounds(40,240,130,20);
		this.addressLabel.setFont(font2);
		this.addressLabel.setForeground(Color.black);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(40,265,300,25);
		this.addressTF.setFont(font3);
		this.addressTF.setForeground(Color.black);
		this.addressTF.setBorder(null);
		this.addressTF.setOpaque(false);
		this.panel.add(addressTF);
		
		this.line3=new JLabel("_________________________________________________");
		this.line3.setBounds(40,270,350,25);
		this.panel.add(line3);
		
		this.emailLabel=new JLabel("Email");
		this.emailLabel.setBounds(40,310,130,20);
		this.emailLabel.setFont(font2);
		this.emailLabel.setForeground(Color.black);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(40,335,300,25);
		this.emailTF.setFont(font3);
		this.emailTF.setForeground(Color.black);
		this.emailTF.setBorder(null);
		this.emailTF.setOpaque(false);
		this.panel.add(emailTF);
		
		this.line4=new JLabel("_________________________________________________");
		this.line4.setBounds(40,340,350,25);
		this.panel.add(line4);
		
		
		this.genderLabel=new JLabel("Gender");
		this.genderLabel.setBounds(40,380,130,20);
		this.genderLabel.setFont(font2);
		this.genderLabel.setForeground(Color.black);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(250,378,100,20);
		this.maleRB.setFont(font2);
		this.maleRB.setOpaque(false);
		this.maleRB.setForeground(Color.black);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(400,378,100,20);
		this.femaleRB.setFont(font2);
		this.femaleRB.setOpaque(false);
		this.femaleRB.setForeground(Color.black);
		this.panel.add(femaleRB);
		
		this.otherRB=new JRadioButton("Other");
		this.otherRB.setBounds(550,378,100,20);
		this.otherRB.setFont(font2);
		this.otherRB.setOpaque(false);
		this.otherRB.setForeground(Color.black);
		this.panel.add(otherRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		bg.add(otherRB);
		
		this.numberLabel=new JLabel("Phone No");
		this.numberLabel.setBounds(40,420,130,20);
		this.numberLabel.setFont(font2);
		this.numberLabel.setForeground(Color.black);
		this.panel.add(numberLabel);
		
		this.numberTF=new JTextField();
		this.numberTF.setBounds(40,445,300,25);
		this.numberTF.setFont(font3);
		this.numberTF.setForeground(Color.black);
		this.numberTF.setBorder(null);
		this.numberTF.setOpaque(false);
		this.panel.add(numberTF);
		
		this.line5=new JLabel("_________________________________________________");
		this.line5.setBounds(40,450,350,25);
		this.panel.add(line5);
		
	    this.passwordLabel=new JLabel("Password");
		this.passwordLabel.setBounds(40,490,130,20);
		this.passwordLabel.setFont(font2);
		this.passwordLabel.setForeground(Color.black);
		this.panel.add(passwordLabel);
		
		this.passTF=new JPasswordField();
		this.passTF.setBounds(40,515,300,25);
		this.passTF.setFont(font3);
		this.passTF.setForeground(Color.black);
		this.passTF.setBorder(null);
		this.passTF.setOpaque(false);
		this.panel.add(passTF);
		
		this.line6=new JLabel("_________________________________________________");
		this.line6.setBounds(40,520,350,25);
		this.panel.add(line6);
		
		this.confirmpassLabel=new JLabel("Confirm Password");
		this.confirmpassLabel.setBounds(450,490,200,20);
		this.confirmpassLabel.setFont(font2);
		this.confirmpassLabel.setForeground(Color.black);
		this.panel.add(confirmpassLabel);
		
		this.confirmpassTF=new JPasswordField();
		this.confirmpassTF.setBounds(450,515,300,25);
		this.confirmpassTF.setFont(font3);
		this.confirmpassTF.setForeground(Color.black);
		this.confirmpassTF.setBorder(null);
		this.confirmpassTF.setOpaque(false);
		this.panel.add(confirmpassTF);
		
		this.line7=new JLabel("_________________________________________________");
		this.line7.setBounds(450,520,350,25);
		this.panel.add(line7);
		
		this.securityLabel=new JLabel("Security Question");
		this.securityLabel.setBounds(40,560,160,20);
		this.securityLabel.setFont(font2);
		this.securityLabel.setForeground(Color.black);
		this.panel.add(securityLabel);
		
		String[] secuQ = { "Choose a Security Question", "what's your father's name?", "what's your mother's name", "what's your favorite sports?", "what's your favourite movie?" };
		this.securityQ=new JComboBox(secuQ);
		this.securityQ.setBounds(205,560,200,20);
		this.panel.add(securityQ);
		
		this.securityAnswerLabel=new JLabel("Answer");
		this.securityAnswerLabel.setBounds(40,600,80,20);
		this.securityAnswerLabel.setFont(font2);
		this.securityAnswerLabel.setForeground(Color.black);
		this.panel.add(securityAnswerLabel);
		
		this.answerTF=new JTextField();
		this.answerTF.setBounds(120,600,300,18);
		this.answerTF.setFont(font3);
		this.answerTF.setForeground(Color.black);
		this.answerTF.setBorder(null);
		this.answerTF.setOpaque(false);
		this.panel.add(answerTF);
		
		this.line8=new JLabel("_________________________________________________");
		this.line8.setBounds(120,600,300,26);
		this.panel.add(line8);
		
		this.ageLabel=new JLabel("Age");
		this.ageLabel.setBounds(40,170,130,24);
		this.ageLabel.setFont(font2);
		this.ageLabel.setForeground(Color.black);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(40,195,300,25);
		this.ageTF.setFont(font3);
		this.ageTF.setForeground(Color.black);
		this.ageTF.setBorder(null);
		this.ageTF.setOpaque(false);
		this.panel.add(ageTF);
		
		this.line9=new JLabel("_________________________________________________");
		this.line9.setBounds(40,200,350,25);
		this.panel.add(line9);
		
		this.memtypeLabel=new JLabel("Membership Type");
		this.memtypeLabel.setBounds(450,170,200,25);
		this.memtypeLabel.setFont(font2);
		this.memtypeLabel.setForeground(Color.black);
		this.panel.add(memtypeLabel);
		
		String[] type = { "None","Silver", "Gold", "Platinum" };
		this.memtype=new JComboBox(type);
		this.memtype.setBounds(650,170,130,25);
		this.panel.add(memtype);
		
		this.memdisLabel=new JLabel("Discount Percentage");
		this.memdisLabel.setBounds(450,210,200,25);
		this.memdisLabel.setFont(font2);
		this.memdisLabel.setForeground(Color.black);
		this.panel.add(memdisLabel);
		
		this.disTF=new JTextField();
		this.disTF.setBounds(650,210,130,25);
		this.disTF.setFont(font3);
		this.disTF.setForeground(Color.black);
		this.disTF.setBorder(null);
		this.disTF.setOpaque(false);
		this.panel.add(disTF);
		
		
		

		
		this.signUpButton=new JButton("Sign Up");
		this.signUpButton.setBounds(480,680,100,30);
		this.signUpButton.setForeground(Color.black);
		this.signUpButton.setBackground(Color.cyan);
		this.panel.add(signUpButton);
		
		this.backButton=new JButton("Back");
		this.backButton.setBounds(350,680,100,30);
		this.backButton.setForeground(Color.black);
		this.backButton.setBackground(Color.cyan);
		this.panel.add(backButton);
		
		this.signUpButton.addActionListener(this);
        this.backButton.addActionListener(this);
		this.memtype.addActionListener(this);
	
		this.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(backButton.getText().equals(command))
		{
			this.setVisible(false);
			LoginFrame login=new LoginFrame();
			login.setVisible(true);
			
		}
		 else if (ae.getSource() == memtype) 
		{ 
            
            String selectedType = memtype.getSelectedItem().toString();
            switch (selectedType)
			{
				case "None":
                    disTF.setText("0%");
					disTF.setEditable(false);
                    break;
				
                case "Silver":
                    disTF.setText("10%");
					disTF.setEditable(false);
                    break;
                case "Gold":
                    disTF.setText("20%");
					disTF.setEditable(false);
                    break;
                case "Platinum":
                    disTF.setText("30%");
					disTF.setEditable(false);
                    break;
                default:
                    disTF.setText(""); 
                    break;
            }
        }
		if(signUpButton.getText().equals(command))
		{
			String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
			s1= userIdTF.getText();
			s2= nameTF.getText();
			s3= addressTF.getText();
			s4= emailTF.getText();
			s5= numberTF.getText();
			s6= passTF.getText();
			s7= confirmpassTF.getText();
			s8= answerTF.getText();
			s9= ageTF.getText();
			s10= disTF.getText();
			
			if(s1.isEmpty() ||s1.isEmpty() ||s2.isEmpty() ||s3.isEmpty() ||s4.isEmpty() ||s5.isEmpty() ||s6.isEmpty() ||s7.isEmpty() ||s8.isEmpty() ||s9.isEmpty() ||s10.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please fill all of the fields");
			}
			else if(!s6.equals(s7))
			{
				JOptionPane.showMessageDialog(null, "Passwords do not match");
				JOptionPane.showMessageDialog(null, "Please re-enter");
				passTF.setText("");
				confirmpassTF.setText("");
			}
			
			
			else if (!(maleRB.isSelected() || femaleRB.isSelected() || otherRB.isSelected())) 
			{
                 JOptionPane.showMessageDialog(null, "Please select a gender");
		    }
			
			else if (securityQ.getSelectedIndex() == 0) 
			{
				
               JOptionPane.showMessageDialog(null, "Please select a security question");
            }
			
			
			else if(!userIdTF.getText().isEmpty())
			{
				String userId=userIdTF.getText();
				UserRepo ure=new UserRepo();
				User user=ure.searchUserById(userId);
				if(user==null)
				{
					try
					{
						String uId=userIdTF.getText();
						String nm=nameTF.getText();
						String address=addressTF.getText();
						String email=emailTF.getText();
						String number=numberTF.getText();
						String pass=passTF.getText();
						String seqans=answerTF.getText();
						int age=Integer.parseInt(ageTF.getText());
						String discount=disTF.getText();
						String membershipType = memtype.getSelectedItem().toString();
						String gen;
						if(maleRB.isSelected())
						{
							gen=maleRB.getText();
						}
						else if(femaleRB.isSelected())
						{
							gen=femaleRB.getText();
						}
						else
						{
							gen=maleRB.getText();
						}
						
						int role=3;
						
						Customer c=new Customer(uId,nm,gen,age,email,number,address,role,seqans,pass,discount,membershipType);
						ure.addUser(c);
						CustomerRepo sre=new CustomerRepo();
						sre.addCustomer(c);
						
						
				        JOptionPane.showMessageDialog(null, "Succesfull");
						LoginFrame h=new LoginFrame();
						h.setVisible(true);
						this.setVisible(false);

				 
			        }
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "Enter valid age");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "exsits");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "fill up");
			}
		}
		
		
				
	

		
		
    }
}
	

