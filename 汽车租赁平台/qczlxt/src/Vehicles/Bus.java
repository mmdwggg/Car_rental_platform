package Vehicles;

public class Bus extends Vehicle{
    private String passengerCapacity;

    public String getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(String passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Bus(String brand, String id, String passengerCapacity,int price,String flag) {
        super(brand, id,price,flag);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void info() {
        // TODO Auto-generated method stub
        System.out.println("品牌"+getBrand()+" 车牌号:"+getId()+" 载客量:"+getPassengerCapacity()+" 日租金"+getPrice()+" 租用状态:"+getflag());
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.getBrand()+"  "+super.getId()+"  "+this.getPassengerCapacity()+"  "+super.getPrice()+"  "+super.getflag();
    }
}

