package HotelManagementSystem;

import java.util.ArrayList;
public abstract class Admin {
    private String name;
    private int pin;
    private String type;

    public Admin(String name,int pin){
        this.name=name;
        this.pin=pin;
    }
    public void viewOccupancy(ArrayList<room> rooms){
        System.out.println("Occupancy Report:");
        for (room room:rooms){
            if (room.checkAvailability()){
                room.displayRoom();
            }
        }
    }
     public void retrieveBooking(booking b) {
        b.getBookingDetails("/home/kasinath-k-s/Documents/JavaProject/23CSE111_CaseStudy_D10/output/files/current.txt");
    }
    public String getAdminName(){
        return name;
        
    }
    public int getAdminPin(){
        return pin;
    }
    public String getAdminType(){
        return type;
    }
}
