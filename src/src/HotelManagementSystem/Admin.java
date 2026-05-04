package HotelManagementSystem;

import java.util.ArrayList;
public abstract class Admin {
    private String name;
    private int pin;

    public Admin(String name,int pin){
        this.name=name;
        this.pin=pin;
    }
    public void viewOccupancy(ArrayList<Room> rooms){
        System.out.println("Occupancy Report:");
        for (Room room:rooms){
            if (room.checkAvailability()){
                room.displayRoom();
            }
        }
    }
    public void displayAdminName(){
        System.out.println("Name = "+name);
        
    }
}
