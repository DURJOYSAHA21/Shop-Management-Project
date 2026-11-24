package interfaces;
import repositories.*;
import java.lang.*;
import entities.*;

public interface IProductRepo
{
	void addProduct(Product p);
	void removeProduct(String uid);
	void updateProduct(Product p);
    void write(Product[] productList);
	Product searchProductByProductId(String uid);
    Product[] getAllProduct();
	
}
