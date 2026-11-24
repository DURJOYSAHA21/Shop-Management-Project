package  repositories;
import java.lang.*;
import entities.*;
import interfaces.*;
public class CustomerRepo implements ICustomerRepo
{
	public void write(Customer[] customerList)
	{
		String[] data=new String[100];
		
		for(int i=0;i<100;i++)
		{
			
			if(customerList[i]!=null)
			{
				data[i]=customerList[i].toStringCustomer();
			}
			
		}
		
		FileIO f=new FileIO();
		f.writeFile(data, "repositories/data/customer.txt");
	}
	
	public Customer[] getAllCustomer()
	{
		FileIO f=new FileIO();
		String[] data=f.readFile("repositories/data/customer.txt");
		
		Customer c=new Customer();
		Customer[] customerList=new Customer[100];
		
		for(int i=0;i<data.length;i++)
		{
			String str=data[i];
			
			if(str!=null)
			{
				customerList[i]=c.formCustomer(str);
			}
		}
		return customerList;
	}
	
	public void addCustomer(Customer c)
	{
		Customer[] customerList=this.getAllCustomer();
		
		for(int i=0;i<customerList.length;i++)
		{
			if(customerList[i]==null)
			{
				customerList[i]=c;
				break;
			}
		}
		
		this.write(customerList);
	}
	
	public void removeCustomer(String id)
	{
		Customer[] customerList=this.getAllCustomer();
		
		for(int i=0;i<customerList.length;i++)
		{
			if(customerList[i]!=null)
			{
				if(customerList[i].getUserId().equals(id))
				{
					customerList[i]=null;
					break;
				}
			}
		 
		}
		this.write(customerList);
	}
	
	public void updateCustomer(Customer c)
		{
			Customer[] customerList=this.getAllCustomer();
			for(int i=0;i<customerList.length;i++)
			{
				if(customerList[i]!=null)
				{
					if(customerList[i].getUserId().equals(c.getUserId()))
					{
						customerList[i]=c;
						break;
					}
				}
				
			}
			this.write(customerList);
		}
		
		public Customer searchCustomerById(String id)
		{
			Customer[] customerList=this.getAllCustomer();
			
			for(int i=0;i<customerList.length;i++)
			{
				if(customerList[i]!=null)
				{
				    if(customerList[i].getUserId().equals(id))
				    {
						return customerList[i];
					}
				}
				
			}
			return null;
		}
}