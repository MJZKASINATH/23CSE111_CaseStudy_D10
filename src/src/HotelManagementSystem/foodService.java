package HotelManagementSystem;
public class foodService extends service {

    private String mealType;

    public foodService(String mealType) {
        super("Food Service", 0);
        this.mealType = mealType.toLowerCase();

        switch (mealType.toLowerCase()) {
            case "breakfast":
                this.price = 200;
                break;
            case "lunch":
                this.price = 300;
                break;
            case "dinner":
                this.price = 300;
                break;
            default:
                this.price = 300;
        }
    }

    @Override
    public void provideService() {
        System.out.println(mealType + " provided. Cost: ₹" + price);
    }
}