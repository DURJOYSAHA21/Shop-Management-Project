package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class IppmFrame extends JFrame implements ActionListener{
	private JPanel panel,panel1;
	private JButton exitButton,backButton,phoneButton1,phoneButton2,phoneButton3,phoneButton4,phoneButton5,phoneButton6;
	private Cursor cursor;
	private Font f1,f2,f3;
	private JTextField qTextField;
	private JLabel logoLabel,tagLabel,titleLabel,sloganLabel,label5,label6,label7,label,label1,label2,label3,label4;
	private int price=1000;
	private String productId="107";
	public IppmFrame(){
		//frame
		super("Iphone 15 pro max");
		this.setSize(1300,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//panel
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		//subpanel
		this.panel1=new JPanel();
		this.panel1.setLayout(null);
		this.panel1.setBounds(800,180,300,210);
		this.panel1.setBackground(new Color(179,179,179));
		this.panel.add(panel1);
		//lable on sub pannel
	  //this.label5=new JLable("Quantity");	
	  //this.label4=new JLable("Price      : 1000$");	
	  //this.label2=new JLabel("Model No   : Mweni-34");	
	  //this.label3=new JLabel("Version    : Global");
		this.label1=new JLabel("Device Name: Iphone 15 pro max");
		this.label1.setBounds(10,10,280,30);
		this.label1.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label1.setForeground(Color.black);
		this.panel1.add(label1);
		
		this.label2=new JLabel("Model No      : Mweni-34");
		this.label2.setBounds(10,50,280,30);
		this.label2.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label2.setForeground(Color.black);
		this.panel1.add(label2);
		
		this.label3=new JLabel("Version          : Global");
		this.label3.setBounds(10,90,280,30);
		this.label3.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label3.setForeground(Color.black);
		this.panel1.add(label3);
		
		this.label4=new JLabel("Price               : 1000$");
		this.label4.setBounds(10,130,280,30);
		this.label4.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label4.setForeground(Color.black);
		this.panel1.add(label4);
		
		this.label5=new JLabel("Quantity");
		this.label5.setBounds(10,170,100,30);
		this.label5.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label5.setForeground(Color.black);
		this.panel1.add(label5);
		
		//text field
		this.qTextField=new JTextField();
		this.qTextField.setBounds(120,170,170,30);
		this.qTextField.setBorder(null);
		this.panel1.add(qTextField);
		
		//piclabel
		
		this.label7=new JLabel(new ImageIcon("images/bippmPaint.png"));
		this.label7.setBounds(100,176,500,357);//100,100,200,30
		//this.label3.setVerticalTextPosition(JButton.CENTER);
		this.panel.add(label7);
		/*this.phoneButton1=new JButton();
		this.phoneButton1.setBounds(100,166,500,357);//400
		this.phoneButton1.setBorder(BorderFactory.createEtchedBorder());
		this.phoneButton1.setFocusable(false);
		this.phoneButton1.setFont(f3);
		this.phoneButton1.setForeground(Color.black);
		this.phoneButton1.setBackground(new Color(148,148,148));
		this.phoneButton1.setCursor(cursor);
		this.phoneButton1.addActionListener(this);
		this.panel.add(phoneButton1);*/
		
		//this.phoneButton2.setBounds(875,415,150,50);
		//this.phoneButton2.
		
		this.phoneButton2=new JButton("Buy");
		this.phoneButton2.setBounds(875,415,150,50);
		this.phoneButton2.setBorder(BorderFactory.createEtchedBorder());
		this.phoneButton2.setFocusable(false);
		this.phoneButton2.setFont(new Font("Calibri", Font.BOLD, 21));
		this.phoneButton2.setForeground(Color.black);
		this.phoneButton2.setBackground(new Color(255,133,74));
		this.phoneButton2.setCursor(cursor);
		this.phoneButton2.addActionListener(this);
		this.panel.add(phoneButton2);
		
		//bottom label of the photo
		this.label6=new JLabel("IPhone 15 Pro Max");
		this.label6.setBounds(100,571,500,30);//100,100,200,30
		this.label6.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label6.setForeground(new Color(246,255,170));
		this.label6.setHorizontalAlignment(JLabel.CENTER);
		//this.label3.setVerticalTextPosition(JButton.CENTER);
		this.panel.add(label6);
		//cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		//labels
		//header label
		this.titleLabel=new JLabel("Welcome to our Pixel Palace");
		this.titleLabel.setBounds(160,30,650,90);
		this.titleLabel.setFont(new Font("Calibri", Font.BOLD, 50));
		this.titleLabel.setForeground(new Color(150,255,255));
		this.panel.add(titleLabel);
		
		this.sloganLabel=new JLabel("Where Every Pixel Tells a Story");
		this.sloganLabel.setBounds(165,85,420,50);//100,100,200,30
		this.sloganLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		this.sloganLabel.setForeground(new Color(255,153,78));
		this.panel.add(sloganLabel);
		
		this.logoLabel=new JLabel();
		this.logoLabel.setIcon(new ImageIcon("images/FinalLogo2.png"));
		this.logoLabel.setBounds(50,30,130,100);
		this.logoLabel.setOpaque(false);
		this.panel.add(logoLabel);
		
		this.tagLabel=new JLabel("Home/Phones/Iphone 15 pro max");
		this.tagLabel.setBounds(80,140,400,25);
		this.tagLabel.setForeground(new Color(145,116,232));
		this.tagLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		this.panel.add(tagLabel);
		
		this.backButton=new JButton();
		this.backButton.setIcon(new ImageIcon("images/return.png"));
		this.backButton.setBounds(17,9,35,35);
		this.backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.backButton.setBorder(BorderFactory.createEtchedBorder());
		this.backButton.setFocusPainted(false);
		this.panel.add(backButton);
		this.backButton.addActionListener(this);
		//Fonts
		this.f1 = new Font("Calibri", Font.PLAIN, 20);
        this.f2 = new Font("Segoe UI Black", Font.PLAIN, 20);
		this.f3 = new Font("Calibri", Font.BOLD, 18);
		
		//buttons
		
		this.exitButton=new JButton("Exit");
		this.exitButton.setBounds(1100,700,100,30);
		this.exitButton.setBorder(BorderFactory.createEtchedBorder());
		this.exitButton.setFocusable(false);
		this.exitButton.setFont(f3);
		this.exitButton.setForeground(Color.black);
		this.exitButton.setBackground(new Color(148,148,148));
		this.exitButton.setCursor(cursor);
		this.exitButton.addActionListener(this);
		this.panel.add(exitButton);
		
		this.panel.setBackground(new Color(28,28,28));
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		if(ae.getSource()==backButton){
			PhoneFrame pf=new PhoneFrame();
			pf.setVisible(true);
			this.setVisible(false);
		}
		if(phoneButton2.getText().equals(command)){
			PaymentFrame.open(this,qTextField.getText(),productId);
		}
		if(exitButton.getText().equals(command)){
			System.exit(0);
		}
	}
}