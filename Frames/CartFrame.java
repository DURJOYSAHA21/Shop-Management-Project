package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

// Shows the products in Session.cart and lets the user remove them or check out.
public class CartFrame extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel titleLabel,totalLabel,productIdLabel;
	private JButton backButton,removeButton,clearButton,checkoutButton;
	private JTextField productIdTF;
	private JTable cartTable;
	private JScrollPane cartTableP;

	// Called by every product screen's Add to Cart button.
	public static void addToCart(JFrame from,String quantityText,String productId){
		Product product=new ProductRepo().searchProductByProductId(productId);
		if(product==null){
			JOptionPane.showMessageDialog(from,"This product is no longer available.");
			return;
		}
		OrderLine existing=null;
		for(OrderLine ol:Session.cart){
			if(ol!=null && ol.getProductId().equals(productId)){
				existing=ol;
			}
		}
		int quantity=PaymentFrame.readQuantity(from,quantityText,product,existing!=null?existing.getQuantity():0);
		if(quantity==0){
			return;
		}
		if(existing!=null){
			existing.setQuantity(existing.getQuantity()+quantity);
			existing.setAmount(existing.getQuantity()*product.getPricePerUnit());
		}
		else{
			boolean added=false;
			for(int i=0;i<Session.cart.length;i++){
				if(Session.cart[i]==null){
					Session.cart[i]=new OrderLine(null,null,productId,quantity,quantity*product.getPricePerUnit());
					added=true;
					break;
				}
			}
			if(!added){
				JOptionPane.showMessageDialog(from,"Your cart is full.");
				return;
			}
		}
		JOptionPane.showMessageDialog(from,quantity+" x "+product.getName()+" added to cart.");
	}

	public CartFrame(){
		super("My Cart");
		this.setSize(900,650);
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

		this.titleLabel=new JLabel("My Cart");
		this.titleLabel.setBounds(0,20,900,40);
		this.titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		this.titleLabel.setHorizontalAlignment(JLabel.CENTER);
		this.titleLabel.setForeground(new Color(150,255,255));
		this.panel.add(titleLabel);

		ProductRepo productRepo=new ProductRepo();
		java.util.List<String[]> rows=new java.util.ArrayList<>();
		int total=0;
		for(OrderLine ol:Session.cart){
			if(ol==null) continue;
			Product p=productRepo.searchProductByProductId(ol.getProductId());
			rows.add(new String[]{ol.getProductId(),p!=null?p.getName():"",String.valueOf(ol.getQuantity()),
				(p!=null?p.getPricePerUnit():0)+"$",(int)ol.getAmount()+"$"});
			total+=(int)ol.getAmount();
		}
		String head[]={"Product Id","Product","Quantity","Price","Amount"};
		this.cartTable=new JTable(rows.toArray(new String[0][]),head);
		this.cartTable.setEnabled(false);
		this.cartTableP=new JScrollPane(cartTable);
		this.cartTableP.setBounds(50,80,800,350);
		this.panel.add(cartTableP);

		this.totalLabel=new JLabel("Total : "+total+"$  (member discount is applied at payment)");
		this.totalLabel.setBounds(50,440,800,30);
		this.totalLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		this.totalLabel.setForeground(new Color(246,255,170));
		this.panel.add(totalLabel);

		this.productIdLabel=new JLabel("Product Id");
		this.productIdLabel.setBounds(50,490,100,30);
		this.productIdLabel.setFont(new Font("Calibri", Font.BOLD, 19));
		this.productIdLabel.setForeground(Color.white);
		this.panel.add(productIdLabel);

		this.productIdTF=new JTextField();
		this.productIdTF.setBounds(150,490,150,30);
		this.productIdTF.setBorder(null);
		this.panel.add(productIdTF);

		this.removeButton=new JButton("Remove");
		this.removeButton.setBounds(320,490,130,30);
		this.removeButton.setFocusable(false);
		this.removeButton.setFont(new Font("Calibri", Font.BOLD, 20));
		this.removeButton.setForeground(Color.black);
		this.removeButton.setBackground(new Color(255,83,87));
		this.removeButton.setBorder(BorderFactory.createEtchedBorder());
		this.removeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.removeButton.addActionListener(this);
		this.panel.add(removeButton);

		this.clearButton=new JButton("Clear Cart");
		this.clearButton.setBounds(50,550,150,35);
		this.clearButton.setFocusable(false);
		this.clearButton.setFont(new Font("Calibri", Font.BOLD, 20));
		this.clearButton.setForeground(Color.black);
		this.clearButton.setBackground(new Color(148,148,148));
		this.clearButton.setBorder(BorderFactory.createEtchedBorder());
		this.clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.clearButton.addActionListener(this);
		this.panel.add(clearButton);

		this.checkoutButton=new JButton("Checkout");
		this.checkoutButton.setBounds(700,550,150,35);
		this.checkoutButton.setFocusable(false);
		this.checkoutButton.setFont(new Font("Calibri", Font.BOLD, 20));
		this.checkoutButton.setForeground(Color.black);
		this.checkoutButton.setBackground(new Color(112,255,87));
		this.checkoutButton.setBorder(BorderFactory.createEtchedBorder());
		this.checkoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.checkoutButton.addActionListener(this);
		this.panel.add(checkoutButton);

		this.panel.setBackground(new Color(28,28,28));
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		if(ae.getSource()==backButton)
		{
			HomeFrame hf=new HomeFrame();
			hf.setVisible(true);
			this.setVisible(false);
		}
		if(removeButton.getText().equals(command))
		{
			boolean found=false;
			for(int i=0;i<Session.cart.length;i++){
				if(Session.cart[i]!=null && Session.cart[i].getProductId().equals(productIdTF.getText().trim())){
					Session.cart[i]=null;
					found=true;
				}
			}
			if(!found){
				JOptionPane.showMessageDialog(this,"That product is not in your cart.");
				return;
			}
			CartFrame cf=new CartFrame();
			cf.setVisible(true);
			this.setVisible(false);
		}
		if(clearButton.getText().equals(command))
		{
			Session.cart=new OrderLine[100];
			CartFrame cf=new CartFrame();
			cf.setVisible(true);
			this.setVisible(false);
		}
		if(checkoutButton.getText().equals(command))
		{
			boolean empty=true;
			for(OrderLine ol:Session.cart){
				if(ol!=null) empty=false;
			}
			if(empty){
				JOptionPane.showMessageDialog(this,"Your cart is empty.");
				return;
			}
			PaymentFrame pm=new PaymentFrame(Session.cart,true);
			pm.setVisible(true);
			this.setVisible(false);
		}
	}
}
