package entities;
import java.lang.*;

public class Customer extends User
{
	private String discountPercentage;
	private String membershipType;
	
	public Customer()
	{
		super();
	}
	
	public Customer(String userId, String name, String gender,int age, String email, String phoneNo, String address, int role, String securityAns, String password, String discountPercentage, String membershipType)
	{
		super(userId, name, gender, age, email, phoneNo, address, role, securityAns, password);
		this.discountPercentage=discountPercentage;
		this.membershipType=membershipType;
	}
	
	public void setDiscountPercentage(String discountPercentage)
	{
		this.discountPercentage=discountPercentage;
	}
	
	public void setMembershipType(String membershipType)
	{
		this.membershipType=membershipType;
	}
	
	public String getDiscountPercentage()
	{
		return this.discountPercentage;
	}
	
	public String getMembershipType()
	{
		return this.membershipType;
	}
	
	
	public String toStringCustomer()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.discountPercentage+","+this.membershipType+"\n";
		return str;
	}
	
	public Customer formCustomer(String str)
	{
		String[] info=str.split(",");
		Customer c=new Customer();
		c.setUserId(info[0]);
		c.setName(info[1]);
		c.setGender(info[2]);
		c.setAge(Integer.parseInt(info[3]));
		c.setEmail(info[4]);
		c.setPhoneNo(info[5]);
		c.setAddress(info[6]);
		c.setDiscountPercentage(info[7]);
		c.setMembershipType(info[8]);
		
		return c;
	}
	
	
}