package Frames;
import entities.*;

// Holds the user who is logged in, so screens don't have to ask for the user ID again.
public class Session
{
	public static User currentUser;
	//products the user added to the cart; orderId and orderLineId are set at checkout
	public static OrderLine[] cart=new OrderLine[100];
}
