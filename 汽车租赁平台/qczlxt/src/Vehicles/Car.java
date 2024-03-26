package Vehicles;

public class Car extends Vehicle{//Car类继承于Vehicle类
    private String type;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    public Car(String brand, String id, String type,int price,String flag) {
        super(brand, id,price,flag);
        this.type = type;
    }
    @Override
    public void info() {
        System.out.println("品牌:"+getBrand()+" 车牌号:"+getId()+" 类型:"+getType()+" 日租金"+getPrice()+" 租用状态:"+getflag());
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.getBrand()+"  "+super.getId()+"  "+this.getType()+"  "+super.getPrice()+"  "+super.getflag();
    }


}