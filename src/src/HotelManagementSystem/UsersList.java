package HotelManagementSystem;

import java.util.ArrayList;

public class UsersList {
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<guest> guests=new ArrayList<>();
    public static ArrayList<room> rooms=new ArrayList<>();
    public static ArrayList<booking>bookings=new ArrayList<>();


    public static ArrayList<Admin> getAdminList(){
        return admins;
    }
    public static ArrayList<guest> getGuestList(){
        return guests;
    }
    public static ArrayList<booking> getBookingList(){
        return bookings;
    }
    public static ArrayList<room> getRoomsList(){
        return rooms;
    }
}
