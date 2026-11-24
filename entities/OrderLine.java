package entities;
import java.lang.*;

public class OrderLine{
	private String orderLineId;
	private String orderId;
    private String productId;
	private int quantity;
	private float amount;
    	
	
	public OrderLine(){
		
	}
	public OrderLine(String orderLineId,String orderId,String productId,int quantity,float amount){
		this.orderLineId=orderLineId;
		this.orderId=orderId;
		this.productId=productId;
		this.quantity=quantity;
		this.amount=amount;
	}
	public void setOrderLineId(String orderLineId){
		this.orderLineId=orderLineId;
	}
	public void setOrderId(String orderId){
		this.orderId=orderId;
	}
	public void setProductId(String productId){
		this.productId=productId;
	}
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	public void setAmount(float amount){
		this.amount=amount;
	}
	public String getOrderLineId(){
		return this.orderLineId;
	}
	public String getOrderId(){
		return this.orderId;
	}
	public String getProductId(){
		return this.productId;
	}
	public int getQuantity(){
		return this.quantity;
	}
	public float getAmount(){
		return this.amount;
	}
	public String toStringOrderLine(){
		String str=this.orderLineId+","+this.orderId+","+this.productId+","+this.quantity+","+this.amount+","+"\n";
		return str;
	}
	public OrderLine formOrderLine(String str){
		OrderLine ol=new OrderLine();
		String[] info=str.split(",");
		ol.setOrderLineId(info[0]);
		ol.setOrderId(info[1]);
		ol.setProductId(info[2]);
		ol.setQuantity(Integer.parseInt(info[3]));
		ol.setAmount(Float.parseFloat(info[4]));
		
		return ol;
	}
}