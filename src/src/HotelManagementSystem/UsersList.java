package HotelManagementSystem;

import java.util.ArrayList;
import java.util.Arrays;

public class UsersList {
    private static ArrayList<Admin> admins=new ArrayList<>(Arrays.asList(new Receptionist("Devang",0013,"receptionist"),new Receptionist("Kasinath",0027,"receptionist"),new Manager("Devanandana",0012,"manager"),new Manager("Anandanarayan",0002,"manager")));;
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
