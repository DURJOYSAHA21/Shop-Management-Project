package entities;
import java.lang.*;

public class Order
{
	private String orderId;
	private String userId;
	private int totalAmount;
	private float paidAmount;
	private float dueAmount;
	private String orderStatus;
	private String paymentStatus;
	private String orderDate;
	
	public Order()
	{
	}
	
	public Order(String orderId,String userId,int totalAmount,float paidAmount,float dueAmount,String orderStatus,String paymentStatus, String orderDate)
	{
		this.orderId=orderId;
		this.userId=userId;
		this.totalAmount=totalAmount;
		this.paidAmount=paidAmount;
		this.dueAmount=dueAmount;
		this.orderStatus=orderStatus;
		this.paymentStatus=paymentStatus;
		this.orderDate=orderDate;
	}
	
	public void setOrderId(String orderId)
	{
		this.orderId=orderId;
		
	}
		public void setUserId(String userId)
	{
		this.userId=userId;
		
	}
	
		public void setTotalAmount(int totalAmount)
	{
		
		this.totalAmount=totalAmount;
	}
	
		public void setPaidAmount(float paidAmount)
	{	
		this.paidAmount=paidAmount;
	}
	
		public void setDueAmount(float dueAmount)
	{
		this.dueAmount=dueAmount;
	}
	
		public void setOrderStatus(String orderStatus)
	{
		
		this.orderStatus=orderStatus;
	}
	
	public void setPaymentStatus(String paymentStatus)
	{
		this.paymentStatus=paymentStatus;
		
	}
	
		public void setOrderDate(String orderDate)
	{
		this.orderDate=orderDate;
		
	}
	
	public String getOrderId()
	{
		return this.orderId;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public int getTotalAmount()
	{
		return this.totalAmount;
	}
	
	public float getPaidAmount()
	{
		return this.paidAmount;
	}
	
	public float getDueAmount()
	{
		return this.dueAmount;
	}
	
	public String getOrderStatus()
	{
		return this.orderStatus;
	}
	
	public String getPaymentStatus()
	{
		return this.paymentStatus;
	}
	
	public String getOrderDate()
	{
		return this.orderDate;
	}
	
	public String toStringOrder()
	{
		String str=this.orderId+","+this.userId+","+this.totalAmount+","+this.paidAmount+","+this.dueAmount+","+this.orderStatus+","+this.paymentStatus+","+this.orderDate+"\n";
	    return str;
	}
	
	public Order formOrder(String str)
	{
	
		String[] orderInfo=str.split(",");
		Order or=new Order();
		or.setOrderId(orderInfo[0]);
		or.setUserId(orderInfo[1]);
		or.setTotalAmount(Integer.parseInt(orderInfo[2]));
		or.setPaidAmount(Float.parseFloat(orderInfo[3]));
		or.setDueAmount(Float.parseFloat(orderInfo[4]));
		or.setOrderStatus(orderInfo[5]);
		or.setPaymentStatus(orderInfo[6]);
		or.setOrderDate(orderInfo[7]);
		
		return or;
	}
}
	
	
	
	
	