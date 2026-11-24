package entities;
import java.lang.*;

public class Product{
	private String productId;
	private String name;
	private String category;
	private int pricePerUnit;
	private int availableQuantity;
	private String details;
	
	public Product(){
		
	}
	public Product(String productId,String name,String category,int pricePerUnit,int availableQuantity,String details){
		this.productId=productId;
		this.name=name;
		this.category=category;
		this.pricePerUnit=pricePerUnit;
		this.availableQuantity=availableQuantity;
		this.details=details;
	}
	public void setProductId(String productId){
		this.productId=productId;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setCategory(String category){
		this.category=category;
	}
	public void setPricePerUnit(int pricePerUnit){
		this.pricePerUnit=pricePerUnit;
	}
	public void setAvailableQuantity(int availableQuantity){
		this.availableQuantity=availableQuantity;
	}
	public void setDetails(String details){
		this.details=details;
	}
	//getter method
	public String getProductId(){
		return this.productId;
	}
	public String getName(){
		return this.name;
	}
	public String getCategory(){
		return this.category;
	}
	public int getPricePerUnit(){
		return this.pricePerUnit;
	}
	public int getAvailableQuantity(){
		return this.availableQuantity;
	}
    public String getDetails(){
		return this.details;
    }
	public String toStringProduct(){
		String str=this.productId+","+this.name+","+this.category+","+this.pricePerUnit+","+this.availableQuantity+","+this.details+"\n";
		return str;
	}
	public Product formProduct(String str){
		Product p=new Product();
		
		String[] info=str.split(",");
		p.setProductId(info[0]);
		p.setName(info[1]);
		p.setCategory(info[2]);
		p.setPricePerUnit(Integer.parseInt(info[3]));
		p.setAvailableQuantity(Integer.parseInt(info[4]));
		p.setDetails(info[5]);
		
		return p;
	}
}