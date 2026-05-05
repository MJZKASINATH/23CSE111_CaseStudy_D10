package HotelManagementSystem;

import java.util.Scanner;

public class Receptionist extends Admin {
    public Receptionist(String name, int pin){
        super(name,pin);
    }
    public void checkInGuest(guest g) {
        System.out.println(g.getName() + " checked in.");
    }

    public void checkOutGuest(guest g) {
        System.out.println(g.getName() + " checked out.");
    }
    public void retrieveBooking(booking b) {
        b.getBookingDetails("current.txt");
    }
    public void initiateService(booking b){
        Scanner sc =new Scanner(System.in);
        String servicetype;
        System.out.println("Enter service type: ");
        servicetype=sc.nextLine();
        if(servicetype=="foodservice"){
            System.out.println("Enter the meals: ");
            servicetype= sc.nextLine();
            foodService food=new foodService(servicetype);
            food.provideService();
            sc.close();
            b.foodServiceCost+=food.getPrice();
        }else if(servicetype=="roomservice"){
            System.out.println("Enter the type of Service:");
            servicetype=sc.nextLine();
            roomService room = new roomService(servicetype);
            room.provideService();
            sc.close();
             b.roomServiceCost+=room.getPrice();
        }
        
    }
}
