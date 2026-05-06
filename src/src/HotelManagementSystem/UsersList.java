package HotelManagementSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class UsersList {
    private static ArrayList<Admin> admins=new ArrayList<>(Arrays.asList(new Receptionist("Devang",0013,"receptionist"),new Receptionist("Kasinath",0027,"receptionist"),new Manager("Devanandana",0012,"manager"),new Manager("Anandanarayan",0002,"manager")));;
    private static ArrayList<guest> guests=new ArrayList<>();
    public static ArrayList<room> rooms=new ArrayList<>();
    public static ArrayList<booking>bookings=new ArrayList<>();

    private static final String GUEST_FILE = "/home/kasinath-k-s/Documents/JavaProject/23CSE111_CaseStudy_D10/output/files/guests.dat";
    private static final String BOOKING_FILE = "/home/kasinath-k-s/Documents/JavaProject/23CSE111_CaseStudy_D10/output/files/bookings.dat";
    private static final String ROOM_FILE = "/home/kasinath-k-s/Documents/JavaProject/23CSE111_CaseStudy_D10/output/files/rooms.dat";


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
    @SuppressWarnings("unchecked")
    public static void loadGuestsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(GUEST_FILE))) {
            guests = (ArrayList<guest>) ois.readObject();
            System.out.println("Guest data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No previous guest data found. Starting fresh.");
            guests = new ArrayList<>(); 
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading guest data: " + e.getMessage());
            guests = new ArrayList<>();
        }
    }
    public static void saveGuestsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GUEST_FILE))) {
            oos.writeObject(guests);
        } catch (IOException e) {
            System.out.println("Error saving guest data: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static void loadBookingsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BOOKING_FILE))) {
            bookings = (ArrayList<booking>) ois.readObject();
            System.out.println("Booking data loaded successfully!");
        } catch (Exception e) {
            System.out.println("No previous booking data found. Starting fresh.");
            bookings = new ArrayList<>();
        }
    }
    public static void saveBookingsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKING_FILE))) {
            oos.writeObject(bookings);
        } catch (IOException e) {
            System.out.println("Error saving booking data: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static void loadRoomsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ROOM_FILE))) {
            rooms = (ArrayList<room>) ois.readObject();
            System.out.println("Room data loaded successfully!");
        } catch (Exception e) {
            System.out.println("No previous room data found. Starting fresh.");
            rooms = new ArrayList<>(); // You might want to generate default rooms here instead!
        }
    }

    public static void saveRoomsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ROOM_FILE))) {
            oos.writeObject(rooms);
        } catch (IOException e) {
            System.out.println("Error saving room data: " + e.getMessage());
        }
    }
}
