package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;

public class PaymentRepo implements IPaymentRepo
{
	
	public Payment searchPaymentByPaymentId(String payid){
		Payment[] paymentList=this.getAllPayment();//getting objects from the text field
		
		for(int i=0;i<paymentList.length;i++){
			if(paymentList[i]!=null){
				if(paymentList[i].getPaymentId().equals(payid)){
				    return paymentList[i];
			    }
			}
		}
		return null;
	}
	
	public Payment[] getAllPayment(){
		FileIO fi=new FileIO();//access to the file io class
		String[] data=fi.readFile("repositories/data/Payment.txt");//to read all methods from txt file
		Payment p1=new Payment();//to get access of formProduct/formProduct method
		Payment[] paymentList=new Payment[100];//first time creating a list
		
		int i=0;
		for(String str:data){
			if(str!=null){
				paymentList[i]=p1.formPayment(str);
			}
			i++;//updating the index
		}
		return paymentList;
	}
	public void addPayment(Payment p1){
		Payment[] paymentList=this.getAllPayment();
		for(int i=0;i<paymentList.length;i++){
			if(paymentList[i]==null){
				paymentList[i]=p1;
				break;
			}
		}
		this.write(paymentList);//give the updated value to the write method to update on txt file
	}
	public void removePayment(String payid){
		Payment[] paymentList=this.getAllPayment();
		for(int i=0;i<paymentList.length;i++){
			if(paymentList[i]!=null && paymentList[i].getPaymentId().equals(payid)){
				paymentList[i]=null;
				break;
			}
		}
		this.write(paymentList);//give the updated value to the write method to update on txt file
	}
	public void updatePayment(Payment p1){
		Payment[] paymentList=this.getAllPayment();

		for(int i=0;i<paymentList.length;i++){
			if(paymentList[i]!=null && paymentList[i].getPaymentId().equals(p1.getPaymentId())){
				paymentList[i]=p1;
				break;
			}
		}
		this.write(paymentList);//give the updated value to the write method to update on txt file
	}
	public void write(Payment[] paymentList){
		FileIO fi=new FileIO();
		
		String[] data=new String[100];
		for(int i=0;i<paymentList.length;i++){
			if(paymentList[i]!=null){
				data[i]=paymentList[i].toStringPayment();
			}
		}
		fi.writeFile(data,"repositories/data/Payment.txt");
	}
}