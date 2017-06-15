
/**
 * Write a description of class HotelDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class HotelDriver
{
    public static void main(String[]args)
    {
        // declares and creates a new hotel class with zero-argument constructor
        Hotel hotel = new Hotel();
        //calls requestRoom method on the hotel object
        Reservation roomRequest1 = hotel.requestRoom("Vaish");
        //calls requestRoom method on the hotel object with different name 
        Reservation roomRequest2 = hotel.requestRoom("Daniel");
        
        System.out.println("Reservation Status: "+ "\n" + roomRequest1+ "\n");
        
        System.out.println("Reservation Status: "+ "\n" + roomRequest2+ "\n");
        
        System.out.println(hotel.toString());
        
        Reservation res = new Reservation("Alex", 0);
        
        Reservation cancelRequest1 = hotel.cancelAndReassign(res);// local variable stores the result of cancelAndReassign method
        String check1 = check(cancelRequest1);// calls the check method with the above local variable as the parameter 
        System.out.println(check1 + cancelRequest1 + "\n");
        
        Reservation res1 = new Reservation("Daniel", 6);
        
        Reservation cancelRequest2 =  hotel.cancelAndReassign(res1);// local variable stores the result of cancelAndReassign method
        String check2 = check(cancelRequest2);// calls the check method with the above local variable as the parameter 
        System.out.println(check2 + cancelRequest2 + "\n");
        
        System.out.println(hotel.toString());// prints the hotel object using toString method
    }
    
    // method that checks the result of calling cancelAndReassign; this method prints differnetly in different situations 
    public static String check(Reservation res)// It takes Reservation object as a parameter which represents the results of the method 
    {
        String result = "";// creates an empty String
        if ( res == null)// checks if the result is null
        {
            result = "No one in waiting list. ";
        }
        else
        {
            result = "Guest from waiting list added: " + "Rservation: ";
        }
        return result;
    }
}