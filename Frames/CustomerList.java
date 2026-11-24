package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class CustomerList extends JFrame implements ActionListener
{
   
   	private JButton backButton;
	private JTable customerTable;
	private JScrollPane customerTableP;
	private JPanel panel;
	private User p;
	
	public CustomerList(User p)
	{
		super("ALL Customer");
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
		
		CustomerRepo pr=new CustomerRepo();
		Customer[] customerList=pr.getAllCustomer();
	    String customerdata[][]=new String[customerList.length][9];
		
		for(int i=0;i<customerList.length;i++)
		{
			if(customerList[i]!=null)
			{
				customerdata[i][0]=customerList[i].getUserId();
				customerdata[i][1]=customerList[i].getName();
				customerdata[i][2]=customerList[i].getGender();
				customerdata[i][3]=String.valueOf(customerList[i].getAge());
				
				customerdata[i][4]=customerList[i].getEmail();
								customerdata[i][5]=customerList[i].getPhoneNo();
				
					customerdata[i][6]=customerList[i].getAddress();
								customerdata[i][7]=customerList[i].getDiscountPercentage();
									customerdata[i][8]=customerList[i].getMembershipType();
			}
		}
		
		String head[]={"Customer Id","Name","Gender","Age","Email","Phone no","Address","Discount Percentage","Membership"};
		this.customerTable=new JTable(customerdata,head);
		
		this.customerTableP=new JScrollPane(customerTable);
		this.customerTableP.setBounds(50,110,1000,450);
		this.customerTable.setEnabled(false);
		this.panel.add(customerTableP);
		
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

	
	
		
				