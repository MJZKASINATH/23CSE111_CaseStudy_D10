package HotelManagementSystem;

import java.io.Serializable;

public class room implements Serializable{
    private int roomNo;
    private String roomType;
    private double price;
    private boolean isAvailable;
    public room(int roomNo, String roomType) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        if (roomType.equalsIgnoreCase("Deluxe")) {
        		this.price=500;
        }
        else if (roomType.equalsIgnoreCase("VIP")){
        	this.price=1000;
        }
    }
    public boolean checkAvailability() {
        return isAvailable;
    }
    public void lockRoom() {
        isAvailable = false;
        System.out.println("Room " + roomNo + " is now occupied.");
    }
    public void releaseRoom() {
        isAvailable = true;
        System.out.println("Room " + roomNo + " is now available.");
    }
    
    public int getRoomNo() {
        return roomNo;
    }
    public String getRoomType() {
        return roomType;
    }
    public double getPrice() {
        return price;
    }
    public void displayRoom() {
        System.out.println("Room No: " + roomNo +
                " | Type: " + roomType +
                " | Price: ₹" + price +
                " | Available: " + isAvailable);
    }
}