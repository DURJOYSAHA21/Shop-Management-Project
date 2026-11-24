package  repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class OrderRepo implements IOrderRepo
{
	public void write(Order[] orderList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(orderList[i]!=null)
			{		
			    data[i]=orderList[i].toStringOrder();
			}
		}
		        FileIO f=new FileIO();
		        f.writeFile(data, "repositories/data/order.txt");
	}
	public Order[]   getAllOrder()
	{
		FileIO f=new FileIO();
		String[] data=f.readFile("repositories/data/order.txt");
		
		Order o=new Order();
		Order[] orderList=new Order[100];
		
		for(int i=0;i<data.length;i++)
		{
			String str=data[i];
			
			if(str!=null)
			{
				orderList[i]=o.formOrder(str);
			}
		}
		return orderList;
	}
	
		public void addOrder(Order o)
	{
		Order[] orderList=this.getAllOrder();
		
		for(int i=0;i<orderList.length;i++)
		{
			if(orderList[i]==null)
			{
				orderList[i]=o;
				break;
			}
		}
		this.write(orderList);
	}
	
	public void removeOrder(String oid)
	{
		Order[] orderList=this.getAllOrder();
		
		for(int i=0;i<orderList.length;i++)
		{
			if(orderList[i]!=null)
			{
				if(orderList[i].getOrderId().equals(oid))
				{
					orderList[i]=null;
					break;
				}
			}
		}
		this.write(orderList);
	}
	
	public void updateOrder(Order o)
		{
			Order[] orderList=this.getAllOrder();
		
		    for(int i=0;i<orderList.length;i++)
			{
				if(orderList[i]!=null)
				{
					if(orderList[i].getOrderId().equals(o.getOrderId()))
					{
						orderList[i]=o;
						break;
					}
				}
			}
			this.write(orderList);
		}
		
		public Order searchOrderByOrderId(String id)
		{
			Order[] orderList=this.getAllOrder();
		
		    for(int i=0;i<orderList.length;i++)
			{
				if(orderList[i]!=null)
				{
				    if(orderList[i].getOrderId().equals(id))
				    {
						return orderList[i];
					}
				}
			}
			return null;
		}
		
		public Order[] searchOrderByUserId(String id)
		{
			Order[] orderList=this.getAllOrder();
			Order[]  foundOrder=new Order[100];
			for(int i=0;i<orderList.length;i++)
			{
				if(orderList[i]!=null)
				{
				    if(orderList[i].getUserId().equals(id))
					{
						foundOrder[i]=orderList[i];
					}
				}
			}
			return foundOrder;
		}
		
}
					
			
			