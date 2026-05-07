package HotelManagementSystem;

import java.util.Scanner;

public class Main {
    static Receptionist defaultReceptionist=new Receptionist("Default",0000,"receptionist");
    public static void main(String[] args) {
        int choice;
        String name;
        boolean flag,adminFound;
        flag=adminFound=false;
        UsersList.loadGuestsFromFile();
        UsersList.loadRoomsFromFile();
        UsersList.loadBookingsFromFile();
        booking.loadTotalBookings();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hotel Management System");
        System.out.println("Enter login type: ");
        System.out.println("1. Guest Login"+"\n2. Admin Login");
        System.out.print("-->");
        choice=sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:{System.out.println("Enter your name: ");
            name = sc.nextLine();
            for (guest g:UsersList.getGuestList()){
                if (g.getName().equals(name)){
                    System.out.println("Welcome\n\n");
                    System.out.println("Services provided: ");
                    System.out.println("1.Book a Room\n2.Request Service\n3.Cancellation" );
                    choice=sc.nextInt();
                    switch (choice){
                        case 1:g.bookRoom(sc);
                        break;
                        case 2:defaultReceptionist.initiateService(g.getBooking());
                        break;
                        case 3:System.out.println("Cancellation can only be confirmed by talking to the receptionist or manager");break;
                    }
                }else{
                    System.out.println("Ask admin to add you to guest list");
                }
            }}break;
            case 2:{
            System.out.println("Enter your name: ");
            System.out.print("-->");
            name = sc.nextLine();
            System.out.println("Enter your pin: ");
            System.out.print("-->");
            int pin = sc.nextInt();
            for (Admin a:UsersList.getAdminList()){
                if (a.getAdminName().equals(name)){
                    adminFound=true;
                    if (a.getAdminPin()==pin){
                        flag=true;
                        while (flag) {
                            switch(a.getAdminType()){
                            case "receptionist":{
                                Receptionist a1 = new Receptionist(name, pin,"receptionist");
                                System.out.println("Services provided: ");
                                System.out.println("1.Check in Guest\n2.Check Out Guest\n3.retrieveBookingDetails\n4.Guest Details\n5.Room Details\n6.View Occupancy" );
                                System.out.print("-->");
                                choice=sc.nextInt();
                                sc.nextLine();
                                switch (choice){
                                    case 1:{
                                        System.out.println("Enter guest name");
                                        System.out.print("-->");
                                        name=sc.nextLine();
                                        System.out.println("Enter idProof type");
                                        System.out.print("-->");
                                        String id = sc.nextLine();
                                        System.out.println("Enter phone Number");
                                        System.out.print("-->");
                                        long phn = sc.nextLong();
                                        sc.nextLine();
                                        guest newG=new guest(name, id, phn,sc);
                                        if (newG!=null){
                                            a1.checkInGuest(newG);
                                            UsersList.getGuestList().add(newG);
                                            UsersList.saveGuestsToFile();
                                        }      
                                    }
                                    break;
                                    case 2:{
                                        System.out.println("Enter guest name");
                                        System.out.print("-->");
                                        name=sc.nextLine();
                                        for(int i=0;i<UsersList.getGuestList().size();i++){
                                            if(UsersList.getGuestList().get(i).getName().equals(name)){
                                                a1.checkOutGuest(UsersList.getGuestList().get(i));
                                                UsersList.getGuestList().remove(i);
                                                UsersList.saveGuestsToFile();
                                                break;
                                            }
                                        }   
                                    }
                                    break;
                                    case 3:{
                                        System.out.println("Enter booking number");
                                        System.out.print("-->");
                                        int bookNo=sc.nextInt();
                                        for (booking booking: UsersList.getBookingList()){
                                            if(booking.getBookingNo()==bookNo){
                                                a1.retrieveBooking(booking);
                                            }
                                        }System.out.println("Written to 'current.txt'");
                                    }
                                    break;
                                    case 4:{
                                        System.out.println("Enter guest name: ");
                                        System.out.print("-->");
                                        name=sc.nextLine();
                                        boolean found=false;
                                        for (guest g:UsersList.getGuestList()){
                                            if(g.getName().equals(name)){
                                                found=true;
                                                g.getGuestDetails();
                                            }
                                        }if(!found){
                                            System.out.println("No guest with this name is found");
                                        }
                                    }break;
                                    case 5:{
                                        System.out.println("Enter room Number");
                                        System.out.print("-->");
                                        int rno=sc.nextInt();
                                        boolean found=false;
                                        for (room r: UsersList.getRoomsList()){
                                            if(r.getRoomNo()==rno){
                                                r.displayRoom();
                                                found=true;
                                                break;
                                            }
                                    }if(!found){
                                        System.out.println("No room with this room number is found");
                                    }
                                }break;
                                    case 6:{
                                        a1.viewOccupancy(UsersList.getRoomsList());
                                    }break;
                                    case 7:flag=false;
                                }break;  
                            }case "manager":{
                                 Manager a1 = new Manager(name, pin,"manager");
                                 System.out.println("Services provided: ");
                                    System.out.println("1.Generate Bill\n2.Generate Report\n3.retrieveBookingDetails\n4.view Occupancy\n5.LogOut" );
                                    System.out.print("-->");
                                    choice=sc.nextInt();
                                    sc.nextLine();
                                    switch (choice){
                                        case 1:{
                                            System.out.println("Enter guest name");
                                            System.out.print("-->");
                                            name=sc.nextLine();
                                            for (guest g:UsersList.getGuestList()){
                                                if(name.equals(g.getName())){
                                                    a1.generateBill(g);
                                                    System.out.println("Bill written to 'bill.txt'");
                                                }
                                            }
                                        }
                                        break;
                                        case 2:{
                                            System.out.println("Reports:");
                                            a1.generateReport(UsersList.bookings);
                                            System.out.println("Report is written to the 'report.txt'");
                                        }
                                        break;
                                        case 3:{
                                        System.out.println("Enter booking number");
                                        System.out.print("-->");
                                        int bookNo=sc.nextInt();
                                        for (booking booking: UsersList.getBookingList()){
                                            if(booking.getBookingNo()==bookNo){
                                                a1.retrieveBooking(booking);    
                                            }
                                        }System.out.println("Written to 'current.txt'");
                                    }
                                        break;
                                        case 4:{
                                        a1.viewOccupancy(UsersList.getRoomsList());
                                    }break;
                                        case 5:{
                                            flag=false;
                                        }break;
                                    }
                            }
                        }
                        }
               
                    }else{
                        System.out.println("Invalid Credentials.Try Again!");
                    }
                    break;
                }

            } if(!adminFound){
                    System.out.println("You're not an admin");
                }
        }
        }
      sc.close(); 

   
    
}
}
