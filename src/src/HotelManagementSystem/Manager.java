package HotelManagementSystem;

import java.util.ArrayList;

public class Manager extends Admin{
    public Manager(String name,int pin){
        super(name,pin);
    }
    public void generalReport(ArrayList<Booking> b){
        for(Booking booking:b){
            booking.getBookingDetails();
        }
    }
    
}