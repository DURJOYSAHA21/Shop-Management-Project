package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PhoneFrame extends JFrame implements ActionListener{
	private JPanel panel;
	private JButton exitButton,backButton,phoneButton1,phoneButton2,phoneButton3,phoneButton4,phoneButton5,phoneButton6;
	private Cursor cursor;
	private Font f1,f2,f3;
	private JLabel label1,label2,label3,label4,label5,label6,logoLabel,tagLabel;
	public PhoneFrame(){
		//frame
		super("Phones");
		this.setSize(1300,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//panel
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		//cursor
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		//labels
		//header label
		this.label1=new JLabel("Welcome to Pixel Palace");
		this.label1.setBounds(160,20,650,100);
		this.label1.setFont(new Font("Calibri", Font.BOLD, 50));
		this.label1.setForeground(new Color(150,255,255));
		this.panel.add(label1);
		
		this.label2=new JLabel("Where Every Pixel Tells a Story");
		this.label2.setBounds(165,70,420,60);//100,100,200,30
		this.label2.setFont(new Font("Calibri", Font.PLAIN, 20));
		this.label2.setForeground(new Color(255,153,78));
		this.panel.add(label2);
		
		//header label
	    this.logoLabel=new JLabel();
		this.logoLabel.setIcon(new ImageIcon("images/FinalLogo2.png"));
		this.logoLabel.setBounds(50,20,130,120);
		this.logoLabel.setOpaque(false);
		this.panel.add(logoLabel);
		
		this.tagLabel=new JLabel("Home/Phones");
		this.tagLabel.setBounds(80,140,200,25);
		this.tagLabel.setForeground(new Color(145,116,232));
		this.tagLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		this.panel.add(tagLabel);
		
		//Fonts
		this.f1 = new Font("Calibri", Font.PLAIN, 20);
        this.f2 = new Font("Segoe UI Black", Font.PLAIN, 20);
		this.f3 = new Font("Calibri", Font.BOLD, 18);
		
		//phones button1
		this.phoneButton1=new JButton("l1");
		this.phoneButton1.setBounds(150,165,184,184);//225,200,150,30
		this.phoneButton1.setIcon(new ImageIcon("images/ipmpaint.png"));
		this.phoneButton1.setFocusable(false);
		this.phoneButton1.setCursor(cursor);
		this.phoneButton1.setBorder(null);
		this.phoneButton1.addActionListener(this);
		this.phoneButton1.setForeground(phoneButton1.getBackground());
		this.panel.add(phoneButton1);
		
		//label for phone1
		this.label1=new JLabel("IPhone 15 Pro Max");
		this.label1.setBounds(150,364,184,21);//100,100,200,30
		this.label1.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label1.setForeground(new Color(246,255,170));
		this.label1.setHorizontalAlignment(JLabel.CENTER);
		//this.label3.setVerticalTextPosition(JButton.CENTER);
		this.panel.add(label1);
		
		//phones button2
		this.phoneButton2=new JButton("l2");
		this.phoneButton2.setIcon(new ImageIcon("images/s24paint.png"));
		this.phoneButton2.setBounds(558,165,184,184);//225,200,150,30
		this.phoneButton2.setFocusable(false);
		this.phoneButton2.setCursor(cursor);
		this.phoneButton2.setBorder(null);
		this.phoneButton2.addActionListener(this);
		this.phoneButton2.setForeground(phoneButton2.getBackground());
		this.panel.add(phoneButton2);
		
		//label for phone 2
		this.label2=new JLabel("Samsung Galaxy S24 ultra ");
		this.label2.setBounds(558,364,220,21);//100,100,200,30
		this.label2.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label2.setForeground(new Color(246,255,170));
		this.label2.setHorizontalAlignment(JLabel.CENTER);
		//this.label3.setVerticalTextPosition(JButton.CENTER);
		this.panel.add(label2);
		
		//phone button3
		this.phoneButton3=new JButton("l3");
		this.phoneButton3.setBounds(966,165,184,184);//225,200,150,30
		this.phoneButton3.setIcon(new ImageIcon("images/ar7paint.png"));
		this.phoneButton3.setFocusable(false);
		this.phoneButton3.setCursor(cursor);
		this.phoneButton3.setBorder(null);
		this.phoneButton3.addActionListener(this);
		this.phoneButton3.setForeground(phoneButton3.getBackground());
		this.panel.add(phoneButton3);
		
		//label for phone 3
		this.label3=new JLabel("Asus ROG-7");
		this.label3.setBounds(966,364,184,21);//100,100,200,30
		this.label3.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label3.setForeground(new Color(246,255,170));
		this.label3.setHorizontalAlignment(JLabel.CENTER);
		//this.label3.setVerticalTextPosition(JButton.CENTER);
		this.panel.add(label3);
		
		//phoneButton4
		this.phoneButton4=new JButton("l4");
		this.phoneButton4.setBounds(150,430,184,184);//225,200,150,30
		this.phoneButton4.setIcon(new ImageIcon("images/ippaint.png"));
		this.phoneButton4.setFocusable(false);
		this.phoneButton4.setCursor(cursor);
		this.phoneButton4.setBorder(null);
		this.phoneButton4.addActionListener(this);
		this.phoneButton4.setForeground(phoneButton4.getBackground());
		this.panel.add(phoneButton4);
		
		//label for phone 4
		this.label4=new JLabel("Iphone 15");
		this.label4.setBounds(150,629,184,21);//100,100,200,30
		this.label4.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label4.setForeground(new Color(246,255,170));
		this.label4.setHorizontalAlignment(JLabel.CENTER);
		//this.label3.setVerticalTextPosition(JButton.CENTER);
		this.panel.add(label4);
		
		//phoneButton5
		this.phoneButton5=new JButton("l5");
		this.phoneButton5.setBounds(558,430,184,184);//225,200,150,30
		this.phoneButton5.setIcon(new ImageIcon("images/gf5paint.png"));
		this.phoneButton5.setFocusable(false);
		this.phoneButton5.setCursor(cursor);
		this.phoneButton5.setBorder(null);
		this.phoneButton5.addActionListener(this);
		this.phoneButton5.setForeground(phoneButton5.getBackground());
		this.panel.add(phoneButton5);
		
		//label for phone 5
		this.label5=new JLabel("Galaxy Fold 5");
		this.label5.setBounds(558,629,184,21);//100,100,200,30
		this.label5.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label5.setForeground(new Color(246,255,170));
		this.label5.setHorizontalAlignment(JLabel.CENTER);
		//this.label3.setVerticalTextPosition(JButton.CENTER);
		this.panel.add(label5);
		
		//phoneButton6
		this.phoneButton6=new JButton("l6");
		this.phoneButton6.setBounds(966,430,184,184);//225,200,150,30
		this.phoneButton6.setIcon(new ImageIcon("images/gp8paint.png"));
		this.phoneButton6.setFocusable(false);
		this.phoneButton6.setCursor(cursor);
		this.phoneButton6.setBorder(null);
		this.phoneButton6.addActionListener(this);
		this.phoneButton6.setForeground(phoneButton6.getBackground());
		this.panel.add(phoneButton6);
		
		//label for phone 6
		this.label6=new JLabel("Pixel 8");
		this.label6.setBounds(966,629,184,21);//100,100,200,30
		this.label6.setFont(new Font("Calibri", Font.BOLD, 20));
		this.label6.setForeground(new Color(246,255,170));
		this.label6.setHorizontalAlignment(JLabel.CENTER);
		//this.label3.setVerticalTextPosition(JButton.CENTER);
		this.panel.add(label6);
		
		//buttons
		this.backButton=new JButton();
		this.backButton.setIcon(new ImageIcon("images/return.png"));
		this.backButton.setBounds(17,9,35,35);
		this.backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.backButton.setBorder(BorderFactory.createEtchedBorder());
		this.backButton.setFocusPainted(false);
		this.panel.add(backButton);
		
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
		this.backButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		if(ae.getSource()==backButton){
			HomeFrame hf=new HomeFrame();
			hf.setVisible(true);
			this.setVisible(false);
		}
		if(phoneButton1.getText().equals(command)){
			IppmFrame ipf=new IppmFrame();
			ipf.setVisible(true);
			this.setVisible(false);
		}
		if(phoneButton2.getText().equals(command)){
			Sgs24uFrame sf=new Sgs24uFrame();
			sf.setVisible(true);
			this.setVisible(false);
		}
		if(phoneButton3.getText().equals(command)){
			Ar7Frame af=new Ar7Frame();
			af.setVisible(true);
			this.setVisible(false);
		}
		if(phoneButton4.getText().equals(command)){
			Ip15Frame ipf15=new Ip15Frame();
			ipf15.setVisible(true);
			this.setVisible(false);
		}
		if(phoneButton5.getText().equals(command)){
			Gf5Frame gf=new Gf5Frame();
			gf.setVisible(true);
			this.setVisible(false);
		}
		if(phoneButton6.getText().equals(command)){
			Gp8Frame gf1=new Gp8Frame();
			gf1.setVisible(true);
			this.setVisible(false);
		}
		if(exitButton.getText().equals(command)){
			System.exit(0);
		}
	}
}