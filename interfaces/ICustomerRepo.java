package interfaces;
import repositories.*;
import java.lang.*;
import entities.*;

public interface ICustomerRepo
{
	void addCustomer(Customer c);
	void removeCustomer(String id);
	void updateCustomer(Customer c);
    void write(Customer[] customerList);
	User searchCustomerById(String id);
    Customer[] getAllCustomer();
	
}
