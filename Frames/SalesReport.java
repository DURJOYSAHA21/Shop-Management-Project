package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

// Owner screen: every order placed in the shop and the total revenue.
public class SalesReport extends JFrame implements ActionListener
{
	private JButton backButton;
	private JLabel titleLabel,revenueLabel;
	private JTable orderTable;
	private JScrollPane orderTableP;
	private JPanel panel;
	private User p;

	public SalesReport(User p)
	{
		super("SALES REPORT");
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

		this.titleLabel=new JLabel("Sales Report");
		this.titleLabel.setBounds(50,50,600,40);
		this.titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		this.panel.add(titleLabel);

		Order[] orderList=new OrderRepo().getAllOrder();
		OrderLineRepo lineRepo=new OrderLineRepo();
		ProductRepo productRepo=new ProductRepo();
	    String orderdata[][]=new String[orderList.length][6];
		int revenue=0,count=0;

		for(int i=0;i<orderList.length;i++)
		{
			if(orderList[i]!=null)
			{
				//list the products of the order, e.g. "IPhone 15 x2, Pixel 8 x1"
				String products="";
				for(OrderLine ol:lineRepo.searchOrderLineByOrderId(orderList[i].getOrderId()))
				{
					if(ol!=null)
					{
						Product pr=productRepo.searchProductByProductId(ol.getProductId());
						products+=(products.isEmpty()?"":", ")+(pr!=null?pr.getName():ol.getProductId())+" x"+ol.getQuantity();
					}
				}
				orderdata[count][0]=orderList[i].getOrderId();
				orderdata[count][1]=orderList[i].getUserId();
				orderdata[count][2]=products;
				orderdata[count][3]=orderList[i].getTotalAmount()+"$";
				orderdata[count][4]=orderList[i].getPaymentStatus();
				orderdata[count][5]=orderList[i].getOrderDate();
				revenue+=orderList[i].getTotalAmount();
				count++;
			}
		}

		String head[]={"Order Id","Customer","Products","Total","Payment","Date"};
		this.orderTable=new JTable(orderdata,head);
		this.orderTable.getColumnModel().getColumn(2).setPreferredWidth(350);

		this.orderTableP=new JScrollPane(orderTable);
		this.orderTableP.setBounds(50,110,1150,450);
		this.orderTable.setEnabled(false);
		this.panel.add(orderTableP);

		this.revenueLabel=new JLabel("Total orders : "+count+"     Total revenue : "+revenue+"$");
		this.revenueLabel.setBounds(50,580,800,40);
		this.revenueLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		this.panel.add(revenueLabel);

		this.add(panel);

		this.p=p;
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==backButton){
			OwnerOperation pf=new OwnerOperation(this.p);
			pf.setVisible(true);
			this.setVisible(false);
		}
	}
}
