package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

// Owners can change prices and restock products. Employees can only restock.
public class ManageProduct extends JFrame implements ActionListener
{
	private JButton backButton,priceButton,restockButton;
	private JLabel titleLabel,productIdLabel,priceLabel,stockLabel;
	private JTextField productIdTF,priceTF,stockTF;
	private JTable productTable;
	private JScrollPane productTableP;
	private JPanel panel;
	private User p;
	private boolean isOwner;

	public ManageProduct(User p)
	{
		super("MANAGE PRODUCTS");
		this.setSize(1300,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.p=p;
		this.isOwner=p!=null && p.getRole()==2;

		this.panel=new JPanel();
		this.panel.setLayout(null);

	    this.backButton=new JButton();
		this.backButton.setIcon(new ImageIcon("images/return.png"));
		this.backButton.setBounds(17,9,35,35);
		this.backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.backButton.setBorder(BorderFactory.createEtchedBorder());
		this.backButton.setFocusPainted(false);
		this.panel.add(backButton);
		this.backButton.addActionListener(this);

		this.titleLabel=new JLabel(isOwner?"Manage Products":"Restock Products");
		this.titleLabel.setBounds(50,50,600,40);
		this.titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		this.panel.add(titleLabel);

		ProductRepo pr=new ProductRepo();
		Product[] productList=pr.getAllProduct();
	    String productdata[][]=new String[productList.length][5];

		for(int i=0;i<productList.length;i++)
		{
			if(productList[i]!=null)
			{
				productdata[i][0]=productList[i].getProductId();
				productdata[i][1]=productList[i].getName();
				productdata[i][2]=productList[i].getCategory();
				productdata[i][3]=String.valueOf(productList[i].getPricePerUnit());
				productdata[i][4]=String.valueOf(productList[i].getAvailableQuantity());
			}
		}

		String head[]={"Product Id","Name","Category","Price","Available Quantity"};
		this.productTable=new JTable(productdata,head);

		this.productTableP=new JScrollPane(productTable);
		this.productTableP.setBounds(50,110,1000,400);
		this.productTable.setEnabled(false);
		this.panel.add(productTableP);

		this.productIdLabel=new JLabel("Product Id");
		this.productIdLabel.setBounds(50,540,150,30);
		this.productIdLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.panel.add(productIdLabel);

		this.productIdTF=new JTextField();
		this.productIdTF.setBounds(200,540,200,30);
		this.productIdTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.productIdTF.setBorder(null);
		this.panel.add(productIdTF);

		this.stockLabel=new JLabel("Add Stock");
		this.stockLabel.setBounds(50,590,150,30);
		this.stockLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.panel.add(stockLabel);

		this.stockTF=new JTextField();
		this.stockTF.setBounds(200,590,200,30);
		this.stockTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.stockTF.setBorder(null);
		this.panel.add(stockTF);

		this.restockButton=new JButton("Restock");
		this.restockButton.setBounds(430,590,150,30);
		this.restockButton.setFont(new Font("Calibri",Font.BOLD,20));
		this.restockButton.setForeground(Color.black);
		this.restockButton.setFocusable(false);
		this.restockButton.setBorder(BorderFactory.createEtchedBorder());
		this.restockButton.setBackground(new Color(166,255,153));
		this.restockButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.restockButton.addActionListener(this);
		this.panel.add(restockButton);

		this.priceLabel=new JLabel("New Price");
		this.priceLabel.setBounds(50,640,150,30);
		this.priceLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.priceLabel.setVisible(isOwner);
		this.panel.add(priceLabel);

		this.priceTF=new JTextField();
		this.priceTF.setBounds(200,640,200,30);
		this.priceTF.setFont(new Font("Cambria",Font.PLAIN,16));
		this.priceTF.setBorder(null);
		this.priceTF.setVisible(isOwner);
		this.panel.add(priceTF);

		this.priceButton=new JButton("Update Price");
		this.priceButton.setBounds(430,640,150,30);
		this.priceButton.setFont(new Font("Calibri",Font.BOLD,20));
		this.priceButton.setForeground(Color.black);
		this.priceButton.setFocusable(false);
		this.priceButton.setBorder(BorderFactory.createEtchedBorder());
		this.priceButton.setBackground(new Color(255,253,110));
		this.priceButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.priceButton.addActionListener(this);
		this.priceButton.setVisible(isOwner);
		this.panel.add(priceButton);

		this.panel.setBackground(new Color(156,215,255));
		this.add(panel);
	}

	// Reads a whole number above 0 from a text field, or returns 0 after showing a message.
	private int readPositive(JTextField tf,String what)
	{
		try
		{
			int value=Integer.parseInt(tf.getText().trim());
			if(value>0)
			{
				return value;
			}
		}
		catch(NumberFormatException e)
		{
		}
		JOptionPane.showMessageDialog(this,what+" must be a whole number above 0.");
		return 0;
	}

	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		if(ae.getSource()==backButton){
			if(isOwner)
			{
				OwnerOperation pf=new OwnerOperation(this.p);
				pf.setVisible(true);
			}
			else
			{
				//employees have no other screen, so going back logs them out
				Session.currentUser=null;
				LoginFrame lf=new LoginFrame();
				lf.setVisible(true);
			}
			this.setVisible(false);
		}
		if(restockButton.getText().equals(command) || (isOwner && priceButton.getText().equals(command)))
		{
			ProductRepo pr=new ProductRepo();
			Product product=pr.searchProductByProductId(productIdTF.getText().trim());
			if(product==null)
			{
				JOptionPane.showMessageDialog(this,"No product with that Product Id.");
				return;
			}
			if(restockButton.getText().equals(command))
			{
				int stock=readPositive(stockTF,"Stock to add");
				if(stock==0) return;
				product.setAvailableQuantity(product.getAvailableQuantity()+stock);
			}
			else
			{
				int price=readPositive(priceTF,"Price");
				if(price==0) return;
				product.setPricePerUnit(price);
			}
			pr.updateProduct(product);
			JOptionPane.showMessageDialog(this,product.getName()+" updated.");
			ManageProduct mp=new ManageProduct(this.p);
			mp.setVisible(true);
			this.setVisible(false);
		}
	}
}
