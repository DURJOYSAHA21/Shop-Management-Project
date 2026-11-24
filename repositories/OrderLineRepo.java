package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;

public class OrderLineRepo implements  IOrderLineRepo
{
	public void write(OrderLine[] orderLineList)
	{
		String[] data=new String[100];
	    
		for(int i=0;i<100;i++)
		{
			if(orderLineList[i]!=null)
			{
				
			data[i]=orderLineList[i].toStringOrderLine();
			
			}
		}
		FileIO f=new FileIO();
		f.writeFile(data, "repositories/data/orderline.txt");
	}
	
	public OrderLine[] getAllOrderLine()
	{
		FileIO f=new FileIO();
		String[] data=f.readFile("repositories/data/orderline.txt");
		
		OrderLine ol=new OrderLine();
		OrderLine[] orderLineList=new OrderLine[100];
		
		for(int i=0;i<data.length;i++)
		{
			String str=data[i];
			
			if(str!=null)
			{
				orderLineList[i]=ol.formOrderLine(str);
			}
		}
		return orderLineList;
	}
	
	public void addOrderLine(OrderLine ol)
	{
		OrderLine[] orderLineList=this.getAllOrderLine();
		
		for(int i=0;i<orderLineList.length;i++)
		{
			if(orderLineList[i]==null)
			{
				orderLineList[i]=ol;
				break;
			}
		}
		this.write(orderLineList);
	}
	
	public void removeOrderLine(String id)
	{
		OrderLine[] orderLineList=this.getAllOrderLine();
		
		for(int i=0;i<orderLineList.length;i++)
		{
			if(orderLineList[i]!=null)
			{
				if(orderLineList[i].getOrderLineId().equals(id))
				{
					orderLineList[i]=null;
					break;
				}
			}
		}
		this.write(orderLineList);
	}
		
		public void updateOrderLine(OrderLine ol)
		{
			OrderLine[] orderLineList=this.getAllOrderLine();
			for(int i=0;i<orderLineList.length;i++)
			{
				if(orderLineList[i]!=null)
				{
					if(orderLineList[i].getOrderLineId().equals(ol.getOrderLineId()))
					{
						orderLineList[i]=ol;
						break;
					}
				}
			}
			this.write(orderLineList);
		}
		
		public OrderLine searchOrderLineByOrderLineId(String id)
		{
			OrderLine[] orderLineList=this.getAllOrderLine();
			
			for(int i=0;i<orderLineList.length;i++)
			{
				if(orderLineList[i]!=null)
				{
				    if(orderLineList[i].getOrderLineId().equals(id))
				    {
						return orderLineList[i];
					}
				}
			}
			return null;
		}
		public OrderLine[] searchOrderLineByOrderId(String id)
		{
			OrderLine[] orderLineList=this.getAllOrderLine();
			OrderLine[] foundOrderLine=new OrderLine[100];
			for(int i=0;i<orderLineList.length;i++)
			{
				if(orderLineList[i]!=null)
				{
					if(orderLineList[i].getOrderId().equals(id))
					{
						foundOrderLine[i]=orderLineList[i];
					}
				}
			}
			return foundOrderLine;
		}
		
		public OrderLine[] searchOrderLineByProductId(String id)
		{
			OrderLine[] orderLineList=this.getAllOrderLine();
			OrderLine[] foundOrderLine=new OrderLine[100];
			for(int i=0;i<orderLineList.length;i++)
			{
				if(orderLineList[i]!=null)
				{
					if(orderLineList[i].getProductId().equals(id))
					{
						foundOrderLine[i]=orderLineList[i];
					}
				}
			}
			return foundOrderLine;
		}
}
		
			
			