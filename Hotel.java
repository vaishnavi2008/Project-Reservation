
/**
 * Write a description of class Hotel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Hotel
{
   // declaring instance variable
   private Reservation[] rooms;
   private ArrayList<String> waitList;
   
   //zero-argument constructor: holds default values for the object's instance variable
   public Hotel()
   {
       rooms = new Reservation[7];// creating an array to hold 7 reservation objects
       
       // initializing the arrayList
       rooms[0] = new Reservation("Alex",0);
       rooms[1] = new Reservation("Jenny",1);
       rooms[2] = new Reservation("Maria",2);
       rooms[4] = new Reservation("Trump",4);
       rooms[5] = new Reservation("Adams",5);
      
       waitList = new ArrayList<String>();// creating an ArrayList
       waitList.add("Lizzy" );// using add(element) method to add names in the waitList
   }
   
   /**
    * if there are any empty rooms (rooms with no reservation),then create a reservation for an empty room for the specified guest
    * and return the new Reservation;otherwise, add the guest to the end of waitList and return null
    */ 

   public Reservation requestRoom(String guestName)
   {
       for (int i =0; i< rooms.length; i++)
       {
           if (rooms[i]== null)//checks if any room does not have a reference: if any room is empty
           {
             // declares and creates a new reservation object with the guest name in parameters and the empty room gets assigned to the guest
             Reservation reserve = new Reservation( guestName , i);
             rooms[i]= reserve;// the index that was empty will now hold the new reservation created   
             return reserve;// returns the created Reservation object
           }
       }
       waitList.add(guestName);// if room is not null or every index is holding an element the guest name gets added to the ArrayList of waitList.
       return null;// returns null
   }
   
   /**
    * release the room associated with parameter res, effectively canceling the reservation;
    * if any names are stored in waitList, remove the first name and create a Reservation for this person in the room reserved by res; 
    * return that new Reservation; if waitList is empty, mark the room specified by res as empty and return null
   */
   public Reservation cancelAndReassign(Reservation res)
   {
       for(int i=0; i<rooms.length; i++)
       {
           // compares the room number of the Reservation object with the rooms in array using getRoomNumber method from Reservation class
           if( res.getRoomNumber() == rooms[i].getRoomNumber()) 
           {  
               rooms[i] = null;// if found the index; assignes it to be null
               if ( waitList.size()>0)// checks if waitList contains any index; if size is more than 0 then it contains 
               {
                   String name = waitList.remove(0);// local variable name will store the element at index 0; first name from the list
                  // local variable stores the result from requestRoom method whoes parameter is first name from the list
                   Reservation reserve1 = requestRoom(name);//assignes the empty room to the first person from waiting list
                   return reserve1;
               }
           }
       }
       return null;// if no one in the waitList the method should return null
   }
   
   //toSring method helps to print hotel object in the driver class
   public String toString()
   {
       String hotelInfo = "The Rooms contain following guests : " + "\n" ;
       for ( int i =0; i<rooms.length; i++)
       {
           if ( rooms[i]!=null)// checks if any room is null; to prevent nullPointer error
           {
             hotelInfo += rooms[i].toString()+ "\n\n" ;
           }
           else
           {
             hotelInfo += "Room Number: " + i +"\t\t\t" + " empty." + "\n\n" ;
           }
       }
       
       if(waitList.size()>0)// checks if waitList contains any names by chaecking its size
       {
           for (int i = 0; i< waitList.size(); i++)
           {
               hotelInfo += "Waiting List: " +"\n" + "Name: " + waitList.get(i)+ "\n";
           }
           return hotelInfo;
       }
       else
       {
           hotelInfo+= "No guest in waiting list.";// if no one in waitList; this will be added to the String hotelIinfo
       }
       
       return hotelInfo;
   }
}
