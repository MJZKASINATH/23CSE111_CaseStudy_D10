package HotelManagementSystem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class booking implements Serializable{
	private String checkInDate;
    private String checkOutDate;
    private String guestname;
    private room room;
    public double foodServiceCost ;
    public double roomServiceCost;
    private  int bookingNo;
    public static int totalBookings;
    private static final String TOTAL_BOOKINGS_FILE = "/home/kasinath-k-s/Documents/JavaProject/23CSE111_CaseStudy_D10/output/files/totalBookings.txt";
    
    public booking(String checkInDate, String checkOutDate,String guestname, room room) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestname = guestname;
        totalBookings++;
        this.bookingNo=totalBookings;
        saveTotalBookings();
        this.room=room;
    }
    public void getBookingDetails(String filepath) {
    	try {
            FileWriter writer = new FileWriter(filepath);
            writer.write("Booking no:"+bookingNo+"\n") ;
            writer.write("Guest: " + guestname + "\n");
            writer.write("Room No: " + room.getRoomNo() + "\n");
            writer.write("Check-in: " + checkInDate + "\n");
            writer.write("Check-out: " + checkOutDate + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error occurred");
        }
        System.out.println("Details written to file");
    }
    public long daysbetween(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDate start=LocalDate.parse(this.checkInDate,formatter);
        LocalDate end=LocalDate.parse(this.checkOutDate,formatter);
        return ChronoUnit.DAYS.between(start, end) + 1;
    }

    public static void loadTotalBookings() {
        try (Scanner fileScanner = new Scanner(new File(TOTAL_BOOKINGS_FILE))) {
            if (fileScanner.hasNextInt()) {
                totalBookings = fileScanner.nextInt();
            }
        } catch (IOException e) {
            totalBookings = 0; 
        }
    }

    public static void saveTotalBookings() {
        try (FileWriter writer = new FileWriter(TOTAL_BOOKINGS_FILE)) {
            writer.write(String.valueOf(totalBookings));
        } catch (IOException e) {
            System.out.println("Error saving total bookings counter.");
        }
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