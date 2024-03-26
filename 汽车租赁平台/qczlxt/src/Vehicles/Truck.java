package Vehicles;

public class Truck extends Vehicle{
    private String loadCapacity;

    public String getLoadCapacity() {
        return loadCapacity;
    }
    public void setLoadCapacity(String loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    public Truck(String brand, String id, String loadCapacity,int price,String flag) {
        super(brand, id,price,flag);
        this.loadCapacity = loadCapacity;
    }
    @Override
    public void info() {
        // TODO Auto-generated method stub
        System.out.println("品牌:"+getBrand()+" 车牌号:"+getId()+" 载货量:"+getLoadCapacity()+" 日租金"+getPrice()+" 租用状态:"+getflag());
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.getBrand()+"  "+super.getId()+"  "+this.getLoadCapacity()+"  "+super.getPrice()+"  "+super.getflag();
    }





}
