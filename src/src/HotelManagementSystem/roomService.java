package HotelManagementSystem;
public class roomService extends service {

    private String serviceName;

    public roomService(String serviceName) {
        super("Room Service");
        this.serviceName = serviceName.toLowerCase();

        switch (serviceName.toLowerCase()) {
            case "cleaning":
                this.price = 150;
                break;
            case "laundry":
                this.price = 300;
                break;
            case "extra bed":
                this.price = 200;
                break;
            default:
                this.price = 200;
        }
    }

    @Override
    public void provideService() {
        System.out.println(serviceName + " service provided. Cost: ₹" + price);
    }
}