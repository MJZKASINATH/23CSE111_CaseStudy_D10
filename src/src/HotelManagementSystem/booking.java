package HotelManagementSystem;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class booking implements Serializable{
	private String checkInDate;
    private String checkOutDate;
    private String guestname;
    private room room;
    public double foodServiceCost ;
    public double roomServiceCost;
    private  int bookingNo;
    public static int totalBookings;
    
    public booking(String checkInDate, String checkOutDate,String guestname, room room) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestname = guestname;
        totalBookings++;
        this.bookingNo=totalBookings;
        this.room=room;
    }
    public void getBookingDetails(String filepath) {
    	try {
            FileWriter writer = new FileWriter(filepath, true);
            writer.write("Booking no:"+bookingNo+"\n") ;
            writer.write("Guest: " + guestname + "\n");
            writer.write("Room No: " + room.getRoomNo() + "\n");
            writer.write("Check-in: " + checkInDate + "\n");
            writer.write("Check-out: " + checkOutDate + "\n");
            writer.close();
            System.out.println("Details written to file");
        } catch (IOException e) {
            System.out.println("Error occurred");
        }
    }
    public long daysbetween(){
        LocalDate start=LocalDate.parse(this.checkInDate);
        LocalDate end=LocalDate.parse(this.checkOutDate);
        return ChronoUnit.DAYS.between(start, end) + 1;
    }
    public int getBookingNo(){
        return bookingNo;
    }
    public void addFoodServiceCost(double price){
        this.foodServiceCost+=price;
    }
    public void addRoomServiceCost(double price){
        this.roomServiceCost+=price;
    }
    public double getFoodServiceCost(){
        return foodServiceCost;
    }
    public double getRoomServiceCost(){
        return roomServiceCost;
    }
    public room getRoom(){
        return room;
    }
}