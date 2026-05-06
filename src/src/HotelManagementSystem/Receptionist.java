package HotelManagementSystem;

import java.util.Scanner;

public class Receptionist extends Admin {
    public Receptionist(String name, int pin,String type){
        super(name,pin,type);
    }
    public void checkInGuest(guest g) {
        g.getBooking().getRoom().releaseRoom();
        System.out.println(g.getName() + " checked in.");
    }

    public void checkOutGuest(guest g) {
        g.getBooking().getRoom().lockRoom();
        System.out.println(g.getName() + " checked out.");
    }
   
    public void initiateService(booking b){
        Scanner sc =new Scanner(System.in);
        String servicetype;
        System.out.println("Enter service type: ");
        servicetype=sc.nextLine();
        if(servicetype.equals("foodservice")){
            System.out.println("Enter the meals: ");
            servicetype= sc.nextLine();
            foodService food=new foodService(servicetype);
            food.provideService();
            sc.close();
            b.addFoodServiceCost(food.getPrice());
            b.foodServiceCost+=food.getPrice();
        }else if(servicetype.equals("roomservice")){
            System.out.println("Enter the type of Service:");
            servicetype=sc.nextLine();
            roomService room = new roomService(servicetype);
            room.provideService();
            sc.close();
            b.addRoomServiceCost(room.getPrice());
        }
        
    }
}
