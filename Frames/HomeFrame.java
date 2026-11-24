package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
//import entities.*;
//import repositories.*;

public class HomeFrame extends JFrame implements ActionListener{
	private JPanel panel;
	
	private JLabel label1,label2,label3,label4,label5,label6;
	private JButton laptopButton,phoneButton,exitButton,dltButton,ordersButton;
	
	private Cursor cursor;
	private Font f1, f2,f3;
	
	public HomeFrame(){
		//frame
		super("Home");
		this.setSize(1300,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//panel
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		//Fonts
		this.f1 = new Font("Calibri", Font.PLAIN, 20);
        this.f2 = new Font("Segoe UI Black", Font.PLAIN, 20);
		this.f3 = new Font("Calibri", Font.BOLD, 18);
		
		//labels
		//header label
		this.label1=new JLabel("Welcome to our Pixel Palace");
		this.label1.setBounds(160,50,650,100);//100,100,200,30
		this.label1.setFont(new Font("Calibri", Font.BOLD, 50));
		this.label1.setForeground(new Color(150,255,255));
		this.panel.add(label1);
		
		//header label
		this.label2=new JLabel("Where Every Pixel Tells a Story");
		this.label2.setBounds(165,105,420,60);//100,100,200,30
		this.label2.setFont(new Font("Calibri", Font.PLAIN, 20));
		this.label2.setForeground(new Color(255,153,78));
		this.panel.add(label2);
		
		this.label5=new JLabel();
		this.label5.setIcon(new ImageIcon("images/FinalLogo2.png"));
		this.label5.setBounds(50,45,130,120);
		this.label5.setOpaque(false);
		this.panel.add(label5);
		
		
		//sublabels
		this.label3=new JLabel("Laptops");
		this.label3.setBounds(355,485,250,30);//100,100,200,30
		this.label3.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label3.setForeground(new Color(246,255,170));
		this.label3.setHorizontalAlignment(JLabel.CENTER);
		//this.label3.setVerticalTextPosition(JButton.CENTER);
		this.panel.add(label3);
		
		this.label4=new JLabel("Phones");
		this.label4.setBounds(695,485,250,30);//100,100,200,30
		this.label4.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label4.setForeground(new Color(161,255,175));
		this.label4.setHorizontalAlignment(JLabel.CENTER);
		//this.label4.setVerticalTextPosition(JLabel.CENTER);
		this.panel.add(label4);
		
		//buttons
		
		
		this.laptopButton=new JButton("l");
		this.laptopButton.setIcon(new ImageIcon("images/laptop.jpg"));
		this.laptopButton.setBounds(355,300,250,170);//225,200,150,30
		this.laptopButton.setFocusable(false);
		this.laptopButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.laptopButton.setBorder(null);
		this.laptopButton.addActionListener(this);
		this.laptopButton.setForeground(laptopButton.getBackground());
		this.panel.add(laptopButton);
		
		this.phoneButton=new JButton("p");
		this.phoneButton.setIcon(new ImageIcon("images/phone.jpg"));
		this.phoneButton.setBounds(695,300,250,170);//225,200,150,30
		this.phoneButton.setFocusable(false);
		this.phoneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.phoneButton.setBorder(null);
		this.phoneButton.addActionListener(this);
		this.phoneButton.setForeground(phoneButton.getBackground());
		this.panel.add(phoneButton);
		
		this.exitButton=new JButton("Exit");
		this.exitButton.setBounds(1100,620,100,30);
		this.exitButton.setBorder(BorderFactory.createEtchedBorder());
		this.exitButton.setFocusable(false);
		this.exitButton.setFont(f3);
		this.exitButton.setForeground(Color.black);
		this.exitButton.setBackground(new Color(148,148,148));
		this.exitButton.setCursor(cursor);
		this.exitButton.addActionListener(this);
		this.panel.add(exitButton);
		
		this.dltButton=new JButton("Delete");
		this.dltButton.setBounds(1100,50,100,30);
		this.dltButton.setBorder(BorderFactory.createEtchedBorder());
		this.dltButton.setFocusable(false);
		this.dltButton.setFont(f3);
		this.dltButton.setForeground(Color.black);
		this.dltButton.setBackground(new Color(148,148,148));
		this.dltButton.setCursor(cursor);
		this.dltButton.addActionListener(this);
		this.panel.add(dltButton);

		this.ordersButton=new JButton("My Orders");
		this.ordersButton.setBounds(970,50,120,30);
		this.ordersButton.setBorder(BorderFactory.createEtchedBorder());
		this.ordersButton.setFocusable(false);
		this.ordersButton.setFont(f3);
		this.ordersButton.setForeground(Color.black);
		this.ordersButton.setBackground(new Color(148,148,148));
		this.ordersButton.setCursor(cursor);
		this.ordersButton.addActionListener(this);
		this.panel.add(ordersButton);

		this.panel.setBackground(new Color(28,28,28));
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();

		
		
		if(laptopButton.getText().equals(command)){
			LaptopFrame lf=new LaptopFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		if(phoneButton.getText().equals(command)){
			PhoneFrame pf=new PhoneFrame();
			pf.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()==ordersButton && Session.currentUser!=null){
			PaymentHistoryFrame ph=new PaymentHistoryFrame(Session.currentUser.getUserId());
			ph.setVisible(true);
			this.setVisible(false);
		}
		if(dltButton.getText().equals(command)){
			DeleteAccFramet d=new DeleteAccFramet();
			d.setVisible(true);
			this.setVisible(false);
		}
		
		if(exitButton.getText().equals(command)){
			System.exit(0);
		}
	}
}