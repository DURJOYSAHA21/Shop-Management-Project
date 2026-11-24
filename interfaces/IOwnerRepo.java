package interfaces;
import repositories.*;
import java.lang.*;
import entities.*;


public interface IOwnerRepo
{
	void addOwner(Owner o);
	void removeOwner(String uid);
	void updateOwner(Owner o);
	void write(Owner[] ownerList);
	Owner searchOwnerByUserId(String id);
	Owner[] getAllOwner();
	
}