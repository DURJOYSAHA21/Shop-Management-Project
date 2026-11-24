package interfaces;
import repositories.*;
import java.lang.*;
import entities.*;

public interface IPaymentRepo
{
    void addPayment(Payment p1);
	void removePayment(String payid);
	void updatePayment(Payment p1);
    void write(Payment[] paymentList);
	Payment searchPaymentByPaymentId(String payid);
    Payment[] getAllPayment();
	
}
