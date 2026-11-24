package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

// Shows every order the user has placed.
public class PaymentHistoryFrame extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel titleLabel;
	private JButton backButton;
	private JTable orderTable;
	private JScrollPane orderTableP;
	public PaymentHistoryFrame(String userId){
		super("Order History");
		this.setSize(900,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		//panel
		this.panel=new JPanel();
		this.panel.setLayout(null);

		//backButton
		this.backButton=new JButton();
		this.backButton.setIcon(new ImageIcon("images/return.png"));
		this.backButton.setBounds(17,9,35,35);
		this.backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.backButton.setBorder(BorderFactory.createEtchedBorder());
		this.backButton.setFocusPainted(false);
		this.backButton.addActionListener(this);
		this.panel.add(backButton);

		this.titleLabel=new JLabel("Order History - "+userId);
		this.titleLabel.setBounds(0,20,900,40);
		this.titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		this.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		this.titleLabel.setForeground(new Color(150,255,255));
		this.panel.add(titleLabel);

		Order[] orders=new OrderRepo().searchOrderByUserId(userId);
		OrderLineRepo lineRepo=new OrderLineRepo();
		ProductRepo productRepo=new ProductRepo();
		java.util.List<String[]> rows=new java.util.ArrayList<>();
		for(Order o:orders){
			if(o==null) continue;
			for(OrderLine ol:lineRepo.searchOrderLineByOrderId(o.getOrderId())){
				if(ol==null) continue;
				Product p=productRepo.searchProductByProductId(ol.getProductId());
				rows.add(new String[]{o.getOrderId(),p!=null?p.getName():ol.getProductId(),String.valueOf(ol.getQuantity()),
					o.getTotalAmount()+"$",o.getPaymentStatus(),o.getOrderDate()});
			}
		}
		String head[]={"Order Id","Product","Quantity","Amount","Payment","Date"};
		this.orderTable=new JTable(rows.toArray(new String[0][]),head);
		this.orderTable.setEnabled(false);
		this.orderTableP=new JScrollPane(orderTable);
		this.orderTableP.setBounds(50,90,800,420);
		this.panel.add(orderTableP);

		this.panel.setBackground(new Color(28,28,28));
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==backButton)
		{
			HomeFrame lf=new HomeFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
	}
}
