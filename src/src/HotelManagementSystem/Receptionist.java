package HotelManagementSystem;

import java.util.Scanner;

public class Receptionist extends Admin {
    public Receptionist(String name, int pin,String type){
        super(name,pin,type);
    }
    public void checkInGuest(guest g) {
        g.getBooking().getRoom().releaseRoom();
        System.out.println(g.getName() + " checked in Room no:"+g.getBooking().getRoom().getRoomNo());
    }

    public void checkOutGuest(guest g) {
        g.getBooking().getRoom().lockRoom();
        System.out.println(g.getName() + " checked out from Room no:"+g.getBooking().getRoom().getRoomNo());
    }
   
    public void initiateService(booking b){
        Scanner sc =new Scanner(System.in);
        String servicetype;
        System.out.println("Enter service type: ");
        servicetype=sc.nextLine();
        if(servicetype.equals("foodservice")){
            System.out.println("Enter the meals: ");
            System.out.println("Breakfast,Lunch,Dinner\n");
            servicetype= sc.nextLine();
            foodService food=new foodService(servicetype);
            food.provideService();
            sc.close();
            b.addFoodServiceCost(food.getPrice());
            b.foodServiceCost+=food.getPrice();
        }else if(servicetype.equals("roomservice")){
            System.out.println("List of Services:\n1.Cleaning\n2.laundry\n3.extra bed");
            System.out.println("Enter the type of Service:");
            servicetype=sc.nextLine();
            roomService room = new roomService(servicetype);
            room.provideService();
            sc.close();
            b.addRoomServiceCost(room.getPrice());
        }
        
    }
}
