package entities;
import java.lang.*;

public class Payment
{
	private String paymentId, orderId, userId, paymentDate;
	private float amount;
    
	public Payment()
	{
	}
	
	public Payment(String paymentId, String orderId, String userId, float amount, String paymentDate )
    {
		this.paymentId=paymentId;
		this.orderId=orderId;
		this.userId=userId;
		this.amount=amount;
		this.paymentDate=paymentDate;
	}
	
	public void setPaymentId(String paymentId)
	{
		this.paymentId=paymentId;
	}
	
	public void setOrderId(String orderId)
	{
		this.orderId=orderId;
	}
	 
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public void setAmount(float amount)
	{
		this.amount=amount;
	}
	
	public void setPaymentDate(String paymentDate)
	{
		this.paymentDate=paymentDate;
	}
    
	public String getPaymentId()
	{
		return this.paymentId;
	}
	
	public String getOrderId()
	{
		return this.orderId;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public float getAmount()
	{
		return this.amount;
	}

	public String getPaymentDate()
	{
		return this.paymentDate;
	}
	
	public String toStringPayment()
	{
		String str=this.paymentId+","+this.orderId+","+this.userId+","+this.amount+","+this.paymentDate+"\n";
		return str;
	}
	
	public Payment formPayment(String str)
	{
		String[] info=str.split(",");
		Payment p1=new Payment();
		p1.setPaymentId(info[0]);
		p1.setOrderId(info[1]);
		p1.setUserId(info[2]);
		p1.setAmount(Float.parseFloat(info[3]));
		p1.setPaymentDate(info[4]);
		
		return p1;
		
	}
	
}


	