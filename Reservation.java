
/**
 * Write a description of class Reservation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reservation
{
    // declarating Instance Variable
    private String guestName;
    private int roomNumber;
    
    // multi-argument constructor
    public Reservation(String chguestName, int chroomNumber)
    {
        guestName = chguestName;
        roomNumber = chroomNumber;
    }
    
    // getter to get instance variable roomNumber when called on a time object
    // will be used in a method to get instance variable.
    public int getRoomNumber()
    {
        return roomNumber;
    }
   
    // toString used when printing any Reservation object in Driver class.
    public String toString()
    {
        String reservationInfo;
        reservationInfo = "Full Name: " + guestName + "\t\t" + " Room Number: " + roomNumber;
        return reservationInfo;
    }
}
