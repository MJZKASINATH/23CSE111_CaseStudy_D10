package HotelManagementSystem;


public class Receptionist extends Admin {
    public Receptionist(String name, int pin){
        super(name,pin);
    }
    public void checkInGuest(Guest g) {
        System.out.println(g.getName() + " checked in.");
    }

    public void checkOutGuest(Guest g) {
        System.out.println(g.getName() + " checked out.");
    }
    public void retrieveBooking(Booking b) {
        b.getBookingDetails();
    }
}
