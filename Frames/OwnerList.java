package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class OwnerList extends JFrame implements ActionListener
{
   
   	private JButton backButton;
	private JTable ownerTable;
	private JScrollPane ownerTableP;
	private JPanel panel;
	private User p;
	
	public OwnerList(User p)
	{
		super("ALL owner");
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
		
		OwnerR pr=new OwnerR();
		Owner[] ownerList=pr.getAllOwner();
	    String ownerdata[][]=new String[ownerList.length][8];
		
		for(int i=0;i<ownerList.length;i++)
		{
			if(ownerList[i]!=null)
			{
                ownerdata[i][0]=ownerList[i].getUserId();
				ownerdata[i][1]=ownerList[i].getName();
				ownerdata[i][2]=ownerList[i].getGender();
				ownerdata[i][3]=String.valueOf(ownerList[i].getAge());
				
				ownerdata[i][4]=ownerList[i].getEmail();
				ownerdata[i][5]=ownerList[i].getPhoneNo();
				
				ownerdata[i][6]=ownerList[i].getAddress();
				ownerdata[i][7]=String.valueOf(ownerList[i].getCompanySharePercentage());
				
				
			
			}
		}
		
		String head[]={"user Id","name","gender","age","email","phone no","address","company share percentage"};
		this.ownerTable=new JTable(ownerdata,head);
		
		this.ownerTableP=new JScrollPane(ownerTable);
		this.ownerTableP.setBounds(50,110,1000,450);
		this.ownerTable.setEnabled(false);
		this.panel.add(ownerTableP);
		
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

	
	
		
				