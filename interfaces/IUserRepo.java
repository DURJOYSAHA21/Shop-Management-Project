package interfaces;
import repositories.*;
import java.lang.*;
import entities.*;


public interface IUserRepo
{
	void write(User[] userList);
	void addUser(User u);
	void removeUser(String id);
	void updateUser(User u);
	User searchUserByUserId(String id);
	User[] getAllUser();
	
}