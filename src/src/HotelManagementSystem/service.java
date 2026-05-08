package HotelManagementSystem;
public abstract class service {
    protected String serviceType;
    protected double price;

    public service(String serviceType) {
        this.serviceType = serviceType;
    }

    public abstract void provideService();

    public double getPrice() {
        return price;
    }

    public String getServiceType() {
        return serviceType;
    }
}