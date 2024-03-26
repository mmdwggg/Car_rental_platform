package Vehicles;

public abstract class Vehicle {
    private int price;
    private String brand;
    private String id;
    private String flag;
    public String getflag(){
        return flag;
    }
    public void setFlag(String flag){
        this.flag=flag;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Vehicle(String brand, String id,int price,String flag) {
        super();
        this.price=price;
        this.brand = brand;
        this.id = id;
        this.flag=flag;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return getId()==((Vehicle)obj).getId();
    }
    public abstract void info();
    public abstract String toString();
}