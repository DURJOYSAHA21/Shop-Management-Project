package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class ProductRepo implements IProductRepo
{
	
	public Product searchProductByProductId(String uid){
		Product[] productList=this.getAllProduct();//getting objects from the text field
		
		for(int i=0;i<productList.length;i++){
			if(productList[i]!=null){
				if(productList[i].getProductId().equals(uid)){
				    return productList[i];
			    }
			}
		}
		return null;
	}
	
	public Product[] getAllProduct(){
		FileIO fi=new FileIO();//access to the file io class
		String[] data=fi.readFile("repositories/data/Product.txt");//to read all methods from txt file
		Product p=new Product();//to get access of formProduct/formProduct method
		Product[] productList=new Product[100];//first time creating a list
		
		int i=0;
		for(String str:data){
			if(str!=null){
				productList[i]=p.formProduct(str);
			}
			i++;//updating the index
		}
		return productList;
	}
	public void addProduct(Product p){
		Product[] productList=this.getAllProduct();
		for(int i=0;i<productList.length;i++){
			if(productList[i]==null){
				productList[i]=p;
				break;
			}
		}
		this.write(productList);//give the updated value to the write method to update on txt file
	}
	public void removeProduct(String uid){
		Product[] productList=this.getAllProduct();
		for(int i=0;i<productList.length;i++){
			if(productList[i]!=null && productList[i].getProductId().equals(uid)){
				productList[i]=null;
				break;
			}
		}
		this.write(productList);//give the updated value to the write method to update on txt file
	}
	public void updateProduct(Product p){
		Product[] productList=this.getAllProduct();

		for(int i=0;i<productList.length;i++){
			if(productList[i]!=null && productList[i].getProductId().equals(p.getProductId())){
				productList[i]=p;
				break;
			}
		}
		this.write(productList);//give the updated value to the write method to update on txt file
	}
	public void write(Product[] productList){
		FileIO fi=new FileIO();
		
		String[] data=new String[100];
		for(int i=0;i<productList.length;i++){
			if(productList[i]!=null){
				data[i]=productList[i].toStringProduct();
			}
		}
		fi.writeFile(data,"repositories/data/Product.txt");
	}
}