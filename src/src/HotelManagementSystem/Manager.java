package HotelManagementSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Manager extends Admin{
    public Manager(String name,int pin){
        super(name,pin);
    }
    public void generateReport(ArrayList<booking> bookings){
        for(booking booking:bookings){
            booking.getBookingDetails("/home/kasinath-k-s/Documents/JavaProject/23CSE111_CaseStudy_D10/output/files/report.txt");
        }
    }
    public void generateBill(guest g){
            try {
            FileWriter writer = new FileWriter("/home/kasinath-k-s/Documents/JavaProject/23CSE111_CaseStudy_D10/output/files/bill.txt");
            writer.write("Booking no:"+g.getBooking().getBookingNo()+"\n");
            writer.write("Room Cost:"+g.getBooking().getRoom().getPrice()*g.getBooking().daysbetween()+"\n");
            writer.write("Total Room Service Cost: "+g.getBooking().getRoomServiceCost()+"\n");
            writer.write("Total Food Service Cost"+g.getBooking().getFoodServiceCost()+"\n");
            writer.close();
            System.out.println("Bill generated as file");
        } catch (IOException e) {
            System.out.println("Error occurred");
        }

        }
    }
