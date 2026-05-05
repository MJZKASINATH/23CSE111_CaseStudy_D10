package HotelManagementSystem;
import java.util.Scanner;
public class guest {
	private String name;
	private String idProof;
	private int phoneNumber;
	private booking booking;
	public guest(String name, String idProof, int phoneNumber) {
		this.name=name;
		this.idProof=idProof;
		this.phoneNumber=phoneNumber;
	}
	public void getGuestDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID Proof: " + idProof);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("BookingNo: " + booking);
	}
	public void bookRoom() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Check in date:");
		String cindate=sc.nextLine();
		System.out.println("Enter Check out date:");
		String codate=sc.nextLine();
		System.out.println("Enter RoomType:");
		String rt=sc.nextLine();
		System.out.println("Enter Room no:");
		int rno=sc.nextInt();
		booking b = new booking(cindate, codate, name, new room(rno,rt));
		this.booking=b;
		sc.close();
	}
	public void viewBooking() {
		booking.getBookingDetails("bookingDetails.txt");
	}
    public booking getBooking(){
        return booking;
    }
	public String getName() {
		return name;
	}
}