package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.time.LocalDate;
import entities.*;
import repositories.*;

public class PaymentFrame extends JFrame implements ActionListener{

	private JPanel panel;
	private JLabel titleLabel,amountLabel,paymentTypeLabel,dateLabel,userIdLabel,productLabel;
	private JButton creditButton,cancelButton,confirmButton;
	private JTextField dateField,userTextField;
	private int quantity;
	private Product product;
	private int amount;

	// Called by every product screen's Buy button: checks the quantity and stock before opening the payment screen.
	public static void open(JFrame from,String quantityText,String productId){
		int quantity;
		try{
			quantity=Integer.parseInt(quantityText.trim());
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(from,"Please enter a valid quantity (a whole number).");
			return;
		}
		if(quantity<=0){
			JOptionPane.showMessageDialog(from,"Quantity must be at least 1.");
			return;
		}
		Product product=new ProductRepo().searchProductByProductId(productId);
		if(product==null){
			JOptionPane.showMessageDialog(from,"This product is no longer available.");
			return;
		}
		if(quantity>product.getAvailableQuantity()){
			JOptionPane.showMessageDialog(from,"Only "+product.getAvailableQuantity()+" left in stock.");
			return;
		}
		PaymentFrame pm=new PaymentFrame(quantity,product);
		pm.setVisible(true);
		from.setVisible(false);
	}

	public PaymentFrame(int quantity,Product product){
		super("Payment");
		this.setSize(505,425);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.panel=new JPanel();
		this.panel.setLayout(null);

		this.quantity=quantity;
		this.product=product;
		//price comes from Product.txt so screens and stock stay in sync
		this.amount=product.getPricePerUnit()*quantity;

		//title label
		this.titleLabel=new JLabel("Payment Card");
		this.titleLabel.setBounds(0,10,500,25);
		this.titleLabel.setFont(new Font("Calibri",Font.BOLD | Font.ITALIC, 20));
		this.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		this.titleLabel.setForeground(new Color(246,255,170));
		this.panel.add(titleLabel);

		//creditButton
		this.creditButton=new JButton("Credit Card");
		this.creditButton.setBounds(20,50,450,40);
		this.creditButton.setFocusable(false);
		this.creditButton.setFont(new Font("Calibri", Font.BOLD, 20));
		this.creditButton.setForeground(Color.black);
		this.creditButton.setBackground(new Color(255,133,74));
		this.creditButton.setBorder(BorderFactory.createEtchedBorder());
		this.panel.add(creditButton);

		//userlavel
		this.userIdLabel=new JLabel("User Id");
		this.userIdLabel.setBounds(20,110,115,25);
		this.userIdLabel.setFont(new Font("Calibri",Font.BOLD, 19));
		this.userIdLabel.setHorizontalAlignment(JLabel.CENTER);
		this.userIdLabel.setForeground(new Color(255,255,255));
		this.panel.add(userIdLabel);

		//usertextField: filled from the logged-in user
		this.userTextField=new JTextField();
		this.userTextField.setBounds(145,110,200,25);
		this.userTextField.setFont(new Font("Cambria",Font.PLAIN,16));
		this.userTextField.setBorder(null);
		if(Session.currentUser!=null){
			this.userTextField.setText(Session.currentUser.getUserId());
			this.userTextField.setEditable(false);
		}
		this.panel.add(userTextField);

		//datelavel
		this.dateLabel=new JLabel("Date");
		this.dateLabel.setBounds(20,155,115,25);
		this.dateLabel.setFont(new Font("Calibri",Font.BOLD, 19));
		this.dateLabel.setHorizontalAlignment(JLabel.CENTER);
		this.dateLabel.setForeground(new Color(255,255,255));
		this.panel.add(dateLabel);

		//datetextField: today's date
		this.dateField=new JTextField(LocalDate.now().toString());
		this.dateField.setBounds(145,155,200,25);
		this.dateField.setFont(new Font("Cambria",Font.PLAIN,16));
		this.dateField.setBorder(null);
		this.dateField.setEditable(false);
		this.panel.add(dateField);

		this.productLabel=new JLabel(product.getName()+"  x "+quantity+"  ("+product.getPricePerUnit()+"$ each)");
		this.productLabel.setBounds(20,200,450,25);
		this.productLabel.setFont(new Font("Calibri",Font.BOLD, 19));
		this.productLabel.setHorizontalAlignment(JLabel.CENTER);
		this.productLabel.setForeground(new Color(255,255,255));
		this.panel.add(productLabel);

		this.amountLabel=new JLabel("Total Amount : "+amount+"$");
		this.amountLabel.setBounds(20,235,450,25);
		this.amountLabel.setFont(new Font("Calibri",Font.BOLD, 19));
		this.amountLabel.setHorizontalAlignment(JLabel.CENTER);
		this.amountLabel.setForeground(new Color(255,255,255));
		this.panel.add(amountLabel);

		this.paymentTypeLabel=new JLabel("Payment type : One time");
		this.paymentTypeLabel.setBounds(20,270,450,25);
		this.paymentTypeLabel.setFont(new Font("Calibri",Font.BOLD, 19));
		this.paymentTypeLabel.setHorizontalAlignment(JLabel.CENTER);
		this.paymentTypeLabel.setForeground(new Color(255,255,255));
		this.panel.add(paymentTypeLabel);

		this.cancelButton=new JButton("Cancel");
		this.cancelButton.setBounds(20,330,150,30);
		this.cancelButton.setFocusable(false);
		this.cancelButton.setFont(new Font("Calibri", Font.BOLD, 20));
		this.cancelButton.setForeground(Color.black);
		this.cancelButton.setBackground(new Color(255,83,87));
		this.cancelButton.setBorder(BorderFactory.createEtchedBorder());
		this.cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.cancelButton.addActionListener(this);
		this.panel.add(cancelButton);

		this.confirmButton=new JButton("Confirm");
		this.confirmButton.setBounds(320,330,150,30);
		this.confirmButton.setFocusable(false);
		this.confirmButton.setFont(new Font("Calibri", Font.BOLD, 20));
		this.confirmButton.setForeground(Color.black);
		this.confirmButton.setBackground(new Color(112,255,87));
		this.confirmButton.setBorder(BorderFactory.createEtchedBorder());
		this.confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.confirmButton.addActionListener(this);
		this.panel.add(confirmButton);

		this.panel.setBackground(new Color(28,28,28));
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		if(cancelButton.getText().equals(command))
		{
			JOptionPane.showMessageDialog(this,"Order canceled.");
			HomeFrame hf=new HomeFrame();
			hf.setVisible(true);
			this.setVisible(false);
		}
		if(confirmButton.getText().equals(command))
		{
			String userId=userTextField.getText().trim();
			if(userId.isEmpty()){
				JOptionPane.showMessageDialog(this,"Please enter your user id.");
				return;
			}
			if(new UserRepo().searchUserById(userId)==null){
				JOptionPane.showMessageDialog(this,"User ID didn't match.");
				return;
			}

			//re-check stock in case it changed while this screen was open
			ProductRepo productRepo=new ProductRepo();
			Product current=productRepo.searchProductByProductId(product.getProductId());
			if(current==null || current.getAvailableQuantity()<quantity){
				JOptionPane.showMessageDialog(this,"Sorry, there is not enough stock left.");
				return;
			}
			current.setAvailableQuantity(current.getAvailableQuantity()-quantity);
			productRepo.updateProduct(current);

			String date=dateField.getText();
			String orderId="O"+System.currentTimeMillis();
			new OrderRepo().addOrder(new Order(orderId,userId,amount,amount,0,"Confirmed","Paid",date));
			new OrderLineRepo().addOrderLine(new OrderLine("L"+orderId.substring(1),orderId,product.getProductId(),quantity,amount));
			new PaymentRepo().addPayment(new Payment("P"+orderId.substring(1),orderId,userId,amount,date));

			JOptionPane.showMessageDialog(this,"Purchase successful! Order ID: "+orderId);
			PaymentHistoryFrame phf=new PaymentHistoryFrame(userId);
			phf.setVisible(true);
			this.setVisible(false);
		}
	}
}
