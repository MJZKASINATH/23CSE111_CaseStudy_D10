package HotelManagementSystem;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<guest> guests=new ArrayList<>();
    public static ArrayList<room> rooms=new ArrayList<>();
    public static ArrayList<booking>bookings=new ArrayList<>();
    static Receptionist defaultReceptionist=new Receptionist("Default",0000);
    public static void main(String[] args) {
        int choice;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hotel Management System");
        System.out.println("Enter login type: ");
        System.out.println("1. Guest Login"+"\n2. Admin Login");
        choice=sc.nextInt();
        switch(choice){
            case 1:System.out.println("Enter your name: ");
            name = sc.nextLine();
            for (guest g:guests){
                if (g.getName()==name){
                    System.out.println("Welcome\n\n");
                    System.out.println("Services provided: ");
                    System.out.println("1.Book a Room\n2.Request Service\n3.Cancellation" );
                    choice=sc.nextInt();
                    switch (choice){
                        case 1:g.bookRoom();
                        break;
                        case 2:defaultReceptionist.initiateService(g.getBooking());
                        break;
                        case 3:System.out.println("Cancellation can only be confirmed by talking to the receptionist or manager");break;
                    }
                }else{
                    System.out.println("Ask admin to add you to guest list");
                }
            }break;
            case 2:System.out.println("Enter your name: ");
            name = sc.nextLine();
            System.out.println("Enter your pin: ");
            int pin = sc.nextInt();
            for (Admin a:admins){
                if (a.getAdminName()==name){
                    if (a.getAdminPin()==pin){
                        switch(a.getAdminType()){
                            case "receptionist":{
                                Receptionist a1 = new Receptionist(name, pin);
                                System.out.println("Services provided: ");
                                System.out.println("1.Check in Guest\n2.Check Out Guest\n3.retrieveBookingDetails\n4.Guest Details\5.Room Details\6.View Occupancy" );
                                choice=sc.nextInt();
                                switch (choice){
                                    case 1:{
                                        System.out.println("Enter guest name");
                                        name=sc.nextLine();
                                        System.out.println("Enter idProof type");
                                        String id = sc.nextLine();
                                        System.out.println("Enter phone Number");
                                        int phn = sc.nextInt();
                                        guest newG=new guest(name, id, phn);
                                        a1.checkInGuest(newG);
                                        Main.guests.add(newG);
                                    }
                                    break;
                                    case 2:{
                                        System.out.println("Enter guest name");
                                        name=sc.nextLine();
                                        for(int i=0;i<guests.size();i++){
                                            if(guests.get(i).getName()==name){
                                                a1.checkOutGuest(guests.get(i));
                                                Main.guests.remove(i);
                                            }
                                        }
                                        
                                    }
                                    break;
                                    case 3:{
                                        System.out.println("Enter booking number");
                                        int bookNo=sc.nextInt();
                                        for (booking booking: bookings){
                                            if(booking.getBookingNo()==bookNo){
                                                a1.retrieveBooking(booking);
                                                System.out.println("Written to 'current.txt'");
                                            }
                                        }
                                    }
                                    break;
                                    case 4:{
                                        System.out.println("Enter guest name: ");
                                        name=sc.nextLine();
                                        for (guest g:guests){
                                            if(g.getName()==name){
                                                g.getGuestDetails();
                                            }
                                        }
                                    }break;
                                    case 5:{
                                        System.out.println("Enter room Number");
                                        int rno=sc.nextInt();
                                        for (room r: rooms){
                                            if(r.getRoomNo()==rno){
                                                r.displayRoom();
                                            }
                                    }
                                }break;
                                    case 6:{
                                        a1.viewOccupancy(rooms);
                                    }break;
                                }
                            }case "manager":{
                                 Manager a1 = new Manager(name, pin);
                                 System.out.println("Services provided: ");
                                    System.out.println("1.Generate Bill\n2.Generate Report\n3.retrieveBookingDetails\n4.view Occupancy" );
                                    choice=sc.nextInt();
                                    switch (choice){
                                        case 1:{
                                            System.out.println("Enter guest name");
                                            name=sc.nextLine();
                                            for (guest g:guests){
                                                if(name==g.getName()){
                                                    a1.generateBill(g);
                                                    System.out.println("Bill written to 'bill.txt'");
                                                }
                                            }
                                        }
                                        break;
                                        case 2:{
                                            System.out.println("Reports:");
                                            a1.generateReport(null);
                                            System.out.println("Report is written to the 'report.txt'");
                                        }
                                        break;
                                        case 3:{
                                        System.out.println("Enter booking number");
                                        int bookNo=sc.nextInt();
                                        for (booking booking: bookings){
                                            if(booking.getBookingNo()==bookNo){
                                                a1.retrieveBooking(booking);
                                                System.out.println("Written to 'current.txt'");
                                            }
                                        }
                                    }
                                        break;
                                        case 4:{
                                        a1.viewOccupancy(rooms);
                                    }break;
                                        
                                    }
                            }
                        }
                    }
                }

            }

        }
      sc.close();  
    }
   
    
}
