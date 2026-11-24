package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class AllProductList extends JFrame implements ActionListener
{
   
   	private JButton backButton;
	private JTable productTable;
	private JScrollPane productTableP;
	private JPanel panel;
	private User p;
	
	public AllProductList(User p)
	{
		super("ALL PRODUCT");
		this.setSize(1300,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);		
		
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
		
		ProductRepo pr=new ProductRepo();
		Product[] productList=pr.getAllProduct();
	    String productdata[][]=new String[productList.length][6];
		
		for(int i=0;i<productList.length;i++)
		{
			if(productList[i]!=null)
			{
				productdata[i][0]=productList[i].getProductId();
				productdata[i][1]=productList[i].getName();
				productdata[i][2]=productList[i].getCategory();
				productdata[i][3]=String.valueOf(productList[i].getPricePerUnit());
				productdata[i][4]=String.valueOf(productList[i].getAvailableQuantity());
				productdata[i][5]=productList[i].getDetails();
			}
		}
		
		String head[]={"Product Id","Name","Category","Price","Available Quantity","Details"};
		this.productTable=new JTable(productdata,head);
		
		this.productTableP=new JScrollPane(productTable);
		this.productTableP.setBounds(50,110,1000,450);
		this.productTable.setEnabled(false);
		this.panel.add(productTableP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.p=p;
	}
	
	public void actionPerformed(ActionEvent ae){
		String command=ae.getActionCommand();
		if(ae.getSource()==backButton){
			OwnerOperation pf=new OwnerOperation(this.p);
			pf.setVisible(true);
			this.setVisible(false);
	}
}
}

	
	
		
				