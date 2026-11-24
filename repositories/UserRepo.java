package  repositories;
import java.lang.*;
import entities.*;


public class UserRepo
{
	public void write(User[] userList)
	{
		String[] data=new String[100];
	    
		for(int i=0;i<100;i++)
		{
			if(userList[i]!=null)
			{
				
			data[i]=userList[i].toStringUser();
			
			}
		}
		FileIO f=new FileIO();
		f.writeFile(data, "repositories/data/user.txt");
	}
	
	public User[] getAllUser()
	{
		FileIO f=new FileIO();
		String[] data=f.readFile("repositories/data/user.txt");
		
		User u=new User();
		User[] userList=new User[100];
		
		for(int i=0;i<data.length;i++)
		{
			String str=data[i];
			
			if(str!=null)
			{
				userList[i]=u.formUser(str);
			}
		}
		return userList;
	}
	
	public void addUser(User u)
	{
		User[] userList=this.getAllUser();
		
		for(int i=0;i<userList.length;i++)
		{
			if(userList[i]==null)
			{
				userList[i]=u;
				break;
			}
		}
		this.write(userList);
	}
	
	public void removeUser(String id)
	{
		User[] userList=this.getAllUser();
		
		for(int i=0;i<userList.length;i++)
		{
			if(userList[i]!=null)
			{
				if(userList[i].getUserId().equals(id))
				{
					userList[i]=null;
					break;
				}
			}
		}
		this.write(userList);
	}
		
		public void updateUser(User u)
		{
			User[] userList=this.getAllUser();
			for(int i=0;i<userList.length;i++)
			{
				if(userList[i]!=null)
				{
					if(userList[i].getUserId().equals(u.getUserId()))
					{
						userList[i]=u;
						break;
					}
				}
			}
			this.write(userList);
		}
		
		public User searchUserById(String id)
		{
			User[] userList=this.getAllUser();
			
			for(int i=0;i<userList.length;i++)
			{
				if(userList[i]!=null)
				{
				    if(userList[i].getUserId().equals(id))
				    {
						return userList[i];
					}
				}
			}
			return null;
		}
	}
					
	