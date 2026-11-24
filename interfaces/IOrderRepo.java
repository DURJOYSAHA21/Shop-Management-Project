package interfaces;
import repositories.*;
import java.lang.*;
import entities.*;

public interface IOrderRepo
{
	void addOrder(Order o);
	void removeOrder(String oid);
	void updateOrder(Order o);
    void write(Order[] orderList);
	Order searchOrderByOrderId(String id);
	Order[] searchOrderByUserId(String id);
    Order[]   getAllOrder();
	
}
