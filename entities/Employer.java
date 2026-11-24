package entities;
import java.lang.*;

public class Employer extends User
{
	private String designation;
	private int salary;
	
	public Employer()
	{
		super();
	}
	
	public Employer(String userId, String name, String gender,int age, String email, String phoneNo, String address, int role, String securityAns, String password, String designation, int salary)
	{
		super(userId, name, gender, age, email, phoneNo, address, role, securityAns, password);
		this.designation=designation;
		this.salary=salary;
	}
	
	public void setDesignation(String designation)
	{
		this.designation=designation;
	}
	
	public void setSalary(int salary)
	{
		this.salary=salary;
	}
	
	public String getDesignation()
	{
		return this.designation;
	}
	
	public int getSalary()
	{
		return this.salary;
	}
	
	
	public String toStringEmployer()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.designation+","+this.salary+"\n";
		return str;
	}
	
	public Employer formEmployer(String str)
	{
		String[] info=str.split(",");
		Employer e=new Employer();
		e.setUserId(info[0]);
		e.setName(info[1]);
		e.setGender(info[2]);
		e.setAge(Integer.parseInt(info[3]));
		e.setEmail(info[4]);
		e.setPhoneNo(info[5]);
		e.setAddress(info[6]);
		e.setDesignation(info[7]);
		e.setSalary(Integer.parseInt(info[8]));
		
		return e;
	}
	
	
}