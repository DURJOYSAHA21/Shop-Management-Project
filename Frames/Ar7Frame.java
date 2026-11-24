package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class Ar7Frame extends JFrame implements ActionListener{
	private JPanel panel,detailsPanel;
	private JButton backButton,exitButton,buyButton;
	private JLabel titleLabel,tagLabel,sloganLabel,logoLabel,nameLabel,modelLabel,versionLabel,quanLabel,priceLabel,photoLabel,bnameLabel;
	private JTextField quanTextField;
	private JButton cartButton;
	private JLabel stockLabel;
	private String productId="109";
	public Ar7Frame(){
		//frame
		super("Asus ROG-7");
		this.setSize(1300,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//panel
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		//cursor
		
		//labels
		//header label
		this.titleLabel=new JLabel("Welcome to our Pixel Palace");
	    this.titleLabel.setBounds(160,30,650,90);
		this.titleLabel.setFont(new Font("Calibri", Font.BOLD, 50));
		this.titleLabel.setForeground(new Color(150,255,255));
		this.panel.add(titleLabel);
		
		this.sloganLabel=new JLabel("Where Every Pixel Tells a Story");
		this.sloganLabel.setBounds(165,85,420,50);
		this.sloganLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		this.sloganLabel.setForeground(new Color(255,153,78));
		this.panel.add(sloganLabel);
		
		this.logoLabel=new JLabel();
		this.logoLabel.setIcon(new ImageIcon("images/FinalLogo2.png"));
        this.logoLabel.setBounds(50,35,130,100);
		this.logoLabel.setOpaque(false);
		this.panel.add(logoLabel);
		
		this.tagLabel=new JLabel("Home/Phones/AsusROG");
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
		
				this.detailsPanel=new JPanel();
		this.detailsPanel.setLayout(null);
		this.detailsPanel.setBounds(800,180,300,210);
		this.detailsPanel.setBackground(new Color(179,179,179));
		this.panel.add(detailsPanel);
		
		this.nameLabel=new JLabel("Device Name: Asus ROG-7");
		this.nameLabel.setBounds(10,10,280,30);	
		this.nameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.nameLabel.setForeground(Color.black);
		this.detailsPanel.add(nameLabel);
		
		this.modelLabel=new JLabel("Model No      : 432T-H");
		this.modelLabel	.setBounds(10,50,280,30);	
		this.modelLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.modelLabel.setForeground(Color.black);
		this.detailsPanel.add(modelLabel);
		
		this.versionLabel=new JLabel("Version          :USA");
		this.versionLabel.setBounds(10,90,280,30);	
		this.versionLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.versionLabel.setForeground(Color.black);
		this.detailsPanel.add(versionLabel);
		
		//price and stock are read from Product.txt
		Product product=new ProductRepo().searchProductByProductId(productId);
		this.priceLabel=new JLabel("Price              : "+product.getPricePerUnit()+"$");
		this.priceLabel.setBounds(10,130,280,30);	
		this.priceLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.priceLabel.setForeground(Color.black);
		this.detailsPanel.add(priceLabel);
		
		this.quanLabel=new JLabel("Quantity");
		this.quanLabel	.setBounds(10,170,280,30);	
		this.quanLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.quanLabel.setForeground(Color.black);
		this.detailsPanel.add(quanLabel);
		
	    this.quanTextField=new JTextField();
		this.quanTextField.setBounds(120,170,170,30);
		this.quanTextField.setBorder(null);
		this.detailsPanel.add(quanTextField);	
		
		this.photoLabel=new JLabel(new ImageIcon("images/asus rog 7.png"));
		this.photoLabel.setBounds(100,176,500,357);
		this.panel.add(photoLabel);
		
		this.bnameLabel=new JLabel("Asus ROG-7");
		this.bnameLabel.setBounds(100,571,500,30);	
		this.bnameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.bnameLabel.setForeground(new Color(246,255,170));
		this.bnameLabel.setHorizontalAlignment(JLabel.CENTER);
		this.panel.add(bnameLabel);
		
		
		
		this.buyButton=new JButton("Buy");
		this.buyButton.setBounds(875,415,150,50);
		this.buyButton.setBorder(BorderFactory.createEtchedBorder());
		this.buyButton.setFocusable(false);
		this.buyButton.setFont(new Font("Calibri", Font.BOLD, 21));
		this.buyButton.setForeground(Color.black);
		this.buyButton.setBackground(new Color(255,133,74));
		this.buyButton.addActionListener(this);
		this.buyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.panel.add(buyButton);

		this.cartButton=new JButton("Add to Cart");
		this.cartButton.setBounds(875,480,150,40);
		this.cartButton.setBorder(BorderFactory.createEtchedBorder());
		this.cartButton.setFocusable(false);
		this.cartButton.setFont(new Font("Calibri", Font.BOLD, 19));
		this.cartButton.setForeground(Color.black);
		this.cartButton.setBackground(new Color(150,255,255));
		this.cartButton.addActionListener(this);
		this.cartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.panel.add(cartButton);

		this.stockLabel=new JLabel();
		this.stockLabel.setBounds(800,535,300,30);
		this.stockLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.stockLabel.setHorizontalAlignment(JLabel.CENTER);
		if(product.getAvailableQuantity()>0){
			this.stockLabel.setText("In stock : "+product.getAvailableQuantity());
			this.stockLabel.setForeground(new Color(112,255,87));
		}
		else{
			this.stockLabel.setText("Out of stock");
			this.stockLabel.setForeground(new Color(255,83,87));
			this.buyButton.setEnabled(false);
			this.cartButton.setEnabled(false);
		}
		this.panel.add(stockLabel);

		
		//Fonts
		
		//buttons
	
		
		this.exitButton=new JButton("Exit");
		this.exitButton.setBounds(1100,700,100,30);
		this.exitButton.setBorder(BorderFactory.createEtchedBorder());
		this.exitButton.setFocusable(false);
		this.exitButton.setFont(new Font("Calibri", Font.BOLD, 18));
		this.exitButton.setForeground(Color.black);
		this.exitButton.setBackground(new Color(148,148,148));
		this.exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		if(buyButton.getText().equals(command)){
			PaymentFrame.open(this,quanTextField.getText(),productId);
		}
		if(ae.getSource()==cartButton){
			CartFrame.addToCart(this,quanTextField.getText(),productId);
		}
		if(exitButton.getText().equals(command)){
			System.exit(0);
		}
	}
}