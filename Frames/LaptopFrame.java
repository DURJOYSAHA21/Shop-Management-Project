package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class LaptopFrame extends JFrame implements  ActionListener
{
	private JPanel panel;
	private JLabel titleLabel,sloganLabel,tagLabel,logoLabel,laptopLabel1,laptopLabel2,laptopLabel3,laptopLabel4,laptopLabel5,laptopLabel6;
	private JButton laptopButton1,laptopButton2,laptopButton3,laptopButton4,laptopButton5,laptopButton6,backButton;
	
	
	public LaptopFrame(){
		//frame
		super("Laptops");
		this.setSize(1300,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//panel
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(new Color(28,28,28));
		this.add(panel);
		
		this.titleLabel=new JLabel("Welcome to Pixel Palace");
		this.titleLabel.setBounds(160,50,650,100);
		this.titleLabel.setFont(new Font("Calibri", Font.BOLD, 50));
		this.titleLabel.setForeground(new Color(150,255,255));
		this.panel.add(titleLabel);
		
		this.sloganLabel=new JLabel("Where Every Pixel Tells a Story");
		this.sloganLabel.setBounds(165,105,420,60);//100,100,200,30
		this.sloganLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		this.sloganLabel.setForeground(new Color(255,153,78));
		this.panel.add(sloganLabel);
		
		this.logoLabel=new JLabel();
		this.logoLabel.setIcon(new ImageIcon("images/FinalLogo2.png"));
		this.logoLabel.setBounds(50,45,130,120);
		this.logoLabel.setOpaque(false);
		this.panel.add(logoLabel);
		
		this.tagLabel=new JLabel("Home/Laptops");
		this.tagLabel.setBounds(80,160,200,25);
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
		
		this.laptopButton1=new JButton("1");
		this.laptopButton1.setIcon(new ImageIcon("images/Lap1.jpg"));
		this.laptopButton1.setBounds(137,210,250,170);
		this.laptopButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.laptopButton1.setBackground(Color.white);
		this.panel.add(laptopButton1);
		
		this.laptopLabel1=new JLabel("Asus Tuf F15");
		this.laptopLabel1.setBounds(162,400,200,25);
		this.laptopLabel1.setHorizontalAlignment(JLabel.CENTER);
		this.laptopLabel1.setForeground(new Color(246,255,170));
		this.laptopLabel1.setFont(new Font("Calibri", Font.BOLD, 20));
		this.panel.add(laptopLabel1);
		
		
		
		this.laptopButton2=new JButton("2");
		this.laptopButton2.setIcon(new ImageIcon("images/Lap3.jpg"));
		this.laptopButton2.setBounds(524,210,250,170);
		this.laptopButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.laptopButton2.setBackground(Color.white);
		this.panel.add(laptopButton2);
		
		this.laptopLabel2=new JLabel("Apple MacBook Pro");
		this.laptopLabel2.setBounds(549,400,200,25);
		this.laptopLabel2.setHorizontalAlignment(JLabel.CENTER);
		this.laptopLabel2.setForeground(new Color(246,255,170));
		this.laptopLabel2.setFont(new Font("Calibri", Font.BOLD, 20));
		this.panel.add(laptopLabel2);
		
		this.laptopButton3=new JButton("3");
		this.laptopButton3.setIcon(new ImageIcon("images/Lap4.jpg"));
		this.laptopButton3.setBounds(911,210,250,170);
		
		this.laptopButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.laptopButton3.setBackground(Color.white);
		this.panel.add(laptopButton3);
		
		this.laptopLabel3=new JLabel("MSI Modern 15");
		this.laptopLabel3.setBounds(936,400,200,25);
		this.laptopLabel3.setHorizontalAlignment(JLabel.CENTER);
		this.laptopLabel3.setForeground(new Color(246,255,170));
		this.laptopLabel3.setFont(new Font("Calibri", Font.BOLD, 20));
		this.panel.add(laptopLabel3);
		
		this.laptopButton4=new JButton("4");
		this.laptopButton4.setIcon(new ImageIcon("images/Lap8.png"));
		this.laptopButton4.setBounds(137,480,250,170);
		this.laptopButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.laptopButton4.setBackground(Color.white);
		this.panel.add(laptopButton4);
		
		this.laptopLabel4=new JLabel("Dell Inspiron 14");
		this.laptopLabel4.setBounds(162,670,200,25);
		this.laptopLabel4.setHorizontalAlignment(JLabel.CENTER);
		this.laptopLabel4.setForeground(new Color(246,255,170));
		this.laptopLabel4.setFont(new Font("Calibri", Font.BOLD, 20));
		this.panel.add(laptopLabel4);
		
		this.laptopButton5=new JButton("5");
		this.laptopButton5.setIcon(new ImageIcon("images/Lap10.jpg"));
		this.laptopButton5.setBounds(524,480,250,170);
		this.laptopButton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.laptopButton5.setBackground(Color.white);
		this.panel.add(laptopButton5);
		
		this.laptopLabel5=new JLabel("HP Pavilion 15");
		this.laptopLabel5.setBounds(549,670,200,25);
		this.laptopLabel5.setHorizontalAlignment(JLabel.CENTER);
		this.laptopLabel5.setForeground(new Color(246,255,170));
		this.laptopLabel5.setFont(new Font("Calibri", Font.BOLD, 20));
		this.panel.add(laptopLabel5);
		
		this.laptopButton6=new JButton("6");
		this.laptopButton6.setIcon(new ImageIcon("images/Lap11.jpg"));
		this.laptopButton6.setBounds(911,480,250,170);
		this.laptopButton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.laptopButton6.setBackground(Color.white);
		this.panel.add(laptopButton6);
		
		this.laptopLabel6=new JLabel("Acer Aspire 7");
		this.laptopLabel6.setBounds(936,670,200,25);
		this.laptopLabel6.setHorizontalAlignment(JLabel.CENTER);
		this.laptopLabel6.setForeground(new Color(246,255,170));
		this.laptopLabel6.setFont(new Font("Calibri", Font.BOLD, 20));
		this.panel.add(laptopLabel6);
		
		this.laptopButton1.addActionListener(this);
		this.laptopButton2.addActionListener(this);
		this.laptopButton3.addActionListener(this);
		this.laptopButton4.addActionListener(this);
		this.laptopButton5.addActionListener(this);
		this.laptopButton6.addActionListener(this);
		this.backButton.addActionListener(this);
		
		
		
				
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae)
		{
			String command=ae.getActionCommand();
			if (ae.getSource()==backButton)
			{
				this.setVisible(false);
				HomeFrame home=new HomeFrame();
				home.setVisible(true);
			}
			
			if(laptopButton1.getText().equals(command))
			{
			    AsusFrame asus=new AsusFrame();
			    asus.setVisible(true);
			    this.setVisible(false);
		    }
			
		
			if(laptopButton2.getText().equals(command))
			{
			    AppleFrame apple=new AppleFrame();
			    apple.setVisible(true);
			    this.setVisible(false);
		    }
			
			if(laptopButton3.getText().equals(command))
			{
			    MsiFrame msi=new MsiFrame();
			    msi.setVisible(true);
			    this.setVisible(false);
		    }
			
			if(laptopButton4.getText().equals(command))
			{
			    DellFrame dell=new DellFrame();
			    dell.setVisible(true);
			    this.setVisible(false);
		    }
			
			if(laptopButton5.getText().equals(command))
			{
			    HpFrame hp=new HpFrame();
			    hp.setVisible(true);
			    this.setVisible(false);
		    }
			
			if(laptopButton6.getText().equals(command))
			{
			    AcerFrame acer=new AcerFrame();
			    acer.setVisible(true);
			    this.setVisible(false);
		    }
			
			
			
			
		}
}