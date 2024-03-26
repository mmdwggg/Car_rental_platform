package RentCar;


import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Vehicles.Bus;
import Vehicles.Car;
import Vehicles.Truck;
import Vehicles.Vehicle;
//encoding: UTF-8
//encoding: UTF-8
public class User extends Loginer{


    private int Balance;
    private String vehicleRented;

    public String getVehicleRented() {
        return vehicleRented;
    }
    public void setVehicleRented(String vehicleRented) {
        this.vehicleRented = vehicleRented;
    }
    public int getBalance() {
        return Balance;
    }
    public void setBalance(int balance) {
        Balance = balance;
    }

    public User(String id, String password,int Balance,String vehicleRented) {
        super(id, password);
        this.Balance=Balance;
        this.vehicleRented=vehicleRented;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void go() throws IOException {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        Vehicle rented=Data.findVehicle(vehicleRented);
        System.out.println("用户登陆成功！");
        System.out.println("欢迎用户:"+getId()+",您当前账户余额为:"+getBalance());
        int x;
        while (true) {
            if (rented == null) {
                System.out.println("您当前未租用任何汽车");
                //while (true) {
                    System.out.println("请输入操作的编号：");
                    System.out.println("1、查看车辆信息  2、租车  3、充值  4.查看当前余额  0、退出系统");
                    x = sc.nextInt();
                    while (x != 0 && x != 1 && x != 2 && x != 3 && x != 4) {
                        System.out.println("请输入正确选择");
                        x = sc.nextInt();
                    }
                    if (x == 0) {
                        sc.close();
                        System.out.println("程序运行结束");
                        return;
                    } else if (x == 1) {
                        Data.show();
                    } else if (x == 2) {
                        String id;
                        System.out.println("请输入您想租用的汽车类型：");
                        System.out.println("请选择：1.小型汽车  2.客车  3.货车");
                        int s=sc.nextInt();
                        while (s!=1&&s!=2&&s!=3){
                            System.out.println("请输入正确选择");
                            s = sc.nextInt();
                        }
                        if (s==1){
                            Data.show1();
                            System.out.println("请输入您想租用的汽车品牌：");
                            String brand=sc.next();
                            int n=Data.show11(brand);
                            if (n==0){
                                System.out.println("我们没有满足您需求的车辆，请等后续完善");
                            }else {
                                System.out.println("\n请输入要租汽车的车牌号：");
                                id = sc.next();
                                if (Data.findVehicle(id) == null) {
                                    System.out.println("租车失败，输入错误，没有该车牌号的车辆。");
                                }
                                if (Data.findflag(id) == false) {
                                    System.out.println("租车失败，该车辆已被租用");
                                } else {
                                    System.out.println("请输入要租的天数：");
                                    int days = sc.nextInt();
                                    int money = days * Data.findVehicle(id).getPrice();
                                    if (getBalance() < money) {
                                        System.out.println("对不起，余额不足");
                                    } else {
                                        Car car = (Car) Data.findVehicle(id);
                                        car.setFlag("已租");
                                        /*String className = Data.findVehicle(id).getClass().getName();//使用反射获得类名
                                        if (className == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                            Car car = (Car) Data.findVehicle(id);
                                            car.setFlag("已租");
                                        /*} else if (className == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                            Bus bus = (Bus) Data.findVehicle(id);
                                            bus.setFlag("已租");
                                        } else if (className == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                            Truck truck = (Truck) Data.findVehicle(id);
                                            truck.setFlag("已租");
                                        }*/
                                        setBalance(getBalance() - money);
                                        System.out.println("租车成功，付款" + money + "元，账户余额" + getBalance() + "元");
                                        Data.setBusiness(Data.getBusiness() + money);
                                        setVehicleRented(id);
                                        Data.write();
                                    }
                                }
                            }
                        }
                        if (s==2){
                            Data.show2();
                            System.out.println("请输入您想租用的汽车品牌：");
                            String brand=sc.next();
                            int n=Data.show22(brand);
                            if (n==0){
                                System.out.println("我们没有满足您需求的车辆，请等后续完善");
                            }else {
                                System.out.println("\n请输入要租汽车的车牌号：");
                                id = sc.next();
                                if (Data.findVehicle(id) == null) {
                                    System.out.println("租车失败，输入错误，没有该车牌号的车辆。");
                                }
                                if (Data.findflag(id) == false) {
                                    System.out.println("租车失败，该车辆已被租用");
                                } else {
                                    System.out.println("请输入要租的天数：");
                                    int days = sc.nextInt();
                                    int money = days * Data.findVehicle(id).getPrice();
                                    if (getBalance() < money) {
                                        System.out.println("对不起，余额不足");
                                    } else {
                                        Bus bus = (Bus) Data.findVehicle(id);
                                        bus.setFlag("已租");
                                        /*String className = Data.findVehicle(id).getClass().getName();//使用反射获得类名
                                        if (className == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                            Car car = (Car) Data.findVehicle(id);
                                            car.setFlag("已租");
                                        /*} else if (className == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                            Bus bus = (Bus) Data.findVehicle(id);
                                            bus.setFlag("已租");
                                        } else if (className == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                            Truck truck = (Truck) Data.findVehicle(id);
                                            truck.setFlag("已租");
                                        }*/
                                        setBalance(getBalance() - money);
                                        System.out.println("租车成功，付款" + money + "元，账户余额" + getBalance() + "元");
                                        Data.setBusiness(Data.getBusiness() + money);
                                        setVehicleRented(id);
                                        Data.write();
                                    }
                                }
                            }
                        }
                        if (s==3){
                            Data.show3();
                            System.out.println("请输入您想租用的汽车品牌：");
                            String brand=sc.next();
                            int n=Data.show33(brand);
                            if (n==0){
                                System.out.println("我们没有满足您需求的车辆，请等后续完善");
                            }else {
                                System.out.println("\n请输入要租汽车的车牌号：");
                                id = sc.next();
                                if (Data.findVehicle(id) == null) {
                                    System.out.println("租车失败，输入错误，没有该车牌号的车辆。");
                                }
                                if (Data.findflag(id) == false) {
                                    System.out.println("租车失败，该车辆已被租用");
                                } else {
                                    System.out.println("请输入要租的天数：");
                                    int days = sc.nextInt();
                                    int money = days * Data.findVehicle(id).getPrice();
                                    if (getBalance() < money) {
                                        System.out.println("对不起，余额不足");
                                    } else {
                                        Truck truck = (Truck) Data.findVehicle(id);
                                        truck.setFlag("已租");
                                        /*String className = Data.findVehicle(id).getClass().getName();//使用反射获得类名
                                        if (className == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                            Car car = (Car) Data.findVehicle(id);
                                            car.setFlag("已租");
                                        /*} else if (className == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                            Bus bus = (Bus) Data.findVehicle(id);
                                            bus.setFlag("已租");
                                        } else if (className == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                            Truck truck = (Truck) Data.findVehicle(id);
                                            truck.setFlag("已租");
                                        }*/
                                        setBalance(getBalance() - money);
                                        System.out.println("租车成功，付款" + money + "元，账户余额" + getBalance() + "元");
                                        Data.setBusiness(Data.getBusiness() + money);
                                        setVehicleRented(id);
                                        Data.write();
                                    }
                                }
                            }
                        }
                    } else if (x == 3) {
                        System.out.println("请输入您要充值的金额：");
                        int money = sc.nextInt();
                        setBalance(getBalance() + money);
                        Data.write();
                        System.out.println("充值成功");
                    } else if (x == 4) {
                        System.out.println("您当前账户余额为:" + getBalance());
                    }
                    System.out.println("\n            按任意键继续 >>");
                    String string = sc.next();
                    try {
                        new Clear();
                        Clear.clear();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    System.out.println(">> >> >> >> >>");


                //}
            } else {
                System.out.print("您已租用汽车，汽车信息为：");
                rented.info();
                //while (true) {
                    System.out.println("请输入操作的编号：");
                    System.out.println("1、查看车辆信息  2、换车 3、退车  4、充值  5.查看余额  0、退出系统");
                    x = sc.nextInt();
                    while (x != 0 && x != 1 && x != 2 && x != 3 && x != 4 && x != 5) {
                        System.out.println("请输入正确选择");
                        x = sc.nextInt();
                    }
                    if (x == 0) {
                        sc.close();
                        System.out.println("程序运行结束");
                        return;
                    } else if (x == 1) {
                        Data.showInfo();
                    } else if (x == 2) {
                        String id;
                        System.out.println("请输入您想换租的汽车类型：");
                        System.out.println("请选择：1.小型汽车  2.客车  3.货车");
                        int s=sc.nextInt();
                        while (s!=1&&s!=2&&s!=3){
                            System.out.println("请输入正确选择");
                            s = sc.nextInt();
                        }
                        if (s==1){
                            Data.show1();
                            System.out.println("请输入您想租用的汽车品牌：");
                            String brand=sc.next();
                            int n=Data.show11(brand);
                            if (n==0){
                                System.out.println("我们没有满足您需求的车辆，请等后续完善");
                            }else {
                                System.out.println("\n请输入要租汽车的车牌号：");
                                id = sc.next();
                                if (Data.findVehicle(id) == null) {
                                    System.out.println("租车失败，输入错误，没有该车牌号的车辆。");
                                }
                                if (Data.findflag(id) == false) {
                                    System.out.println("租车失败，该车辆已被租用");
                                } else {
                                    String ID = this.getVehicleRented();
                                    String className = Data.findVehicle(id).getClass().getName();//使用反射获得类名
                                    String ClassName = Data.findVehicle(ID).getClass().getName();//使用反射获得类名
                                    System.out.println("请输入要租的天数：");
                                    int days = sc.nextInt();
                                    int t=1;
                                    if (Data.findVehicle(id).getPrice()>Data.findVehicle(ID).getPrice()){
                                        if (getBalance() < (Data.findVehicle(id).getPrice()-Data.findVehicle(ID).getPrice())*days) {
                                            System.out.println("对不起，余额不足");
                                            t=0;
                                        }
                                    }if (t==1) {
                                        if (ClassName == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                            Car car = (Car) Data.findVehicle(ID);
                                            car.setFlag("未租");
                                        } else if (ClassName == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                            Bus bus = (Bus) Data.findVehicle(ID);
                                            bus.setFlag("未租");
                                        } else if (ClassName == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                            Truck truck = (Truck) Data.findVehicle(ID);
                                            truck.setFlag("未租");
                                        }
                                        if (className == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                            Car car = (Car) Data.findVehicle(id);
                                            car.setFlag("已租");
                                        } else if (className == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                            Bus bus = (Bus) Data.findVehicle(id);
                                            bus.setFlag("已租");
                                        } else if (className == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                            Truck truck = (Truck) Data.findVehicle(id);
                                            truck.setFlag("已租");
                                        }
                                        int money;
                                        if (Data.findVehicle(id).getPrice() > Data.findVehicle(ID).getPrice()) {
                                            money=Data.findVehicle(id).getPrice()- Data.findVehicle(ID).getPrice();
                                            setBalance(getBalance() - money * days);
                                            Data.setBusiness(Data.getBusiness() + money*days);
                                        }
                                        if (Data.findVehicle(id).getPrice() < Data.findVehicle(ID).getPrice()) {
                                            money=Data.findVehicle(ID).getPrice() - Data.findVehicle(id).getPrice();
                                            setBalance(getBalance() + money * days);
                                            Data.setBusiness(Data.getBusiness() - money*days);
                                        }
                                        System.out.println("替换成功！您当前所租车辆已替换为：");
                                        Data.findVehicle(id).info();
                                        setVehicleRented(id);
                                        Data.write();
                                    }

                                }
                            }
                        }
                        if (s==2){
                            Data.show2();
                            System.out.println("请输入您想租用的汽车品牌：");
                            String brand=sc.next();
                            int n=Data.show22(brand);
                            if (n==0){
                                System.out.println("我们没有满足您需求的车辆，请等后续完善");
                            }else {
                                System.out.println("\n请输入要租汽车的车牌号：");
                                id = sc.next();
                                if (Data.findVehicle(id) == null) {
                                    System.out.println("租车失败，输入错误，没有该车牌号的车辆。");
                                }
                                if (Data.findflag(id) == false) {
                                    System.out.println("租车失败，该车辆已被租用");
                                } else {
                                    String ID = this.getVehicleRented();
                                    String className = Data.findVehicle(id).getClass().getName();//使用反射获得类名
                                    String ClassName = Data.findVehicle(ID).getClass().getName();//使用反射获得类名
                                    System.out.println("请输入要租的天数：");
                                    int days = sc.nextInt();
                                    int t=1;
                                    if (Data.findVehicle(id).getPrice()>Data.findVehicle(ID).getPrice()){
                                        if (getBalance() < (Data.findVehicle(id).getPrice()-Data.findVehicle(ID).getPrice())*days) {
                                            System.out.println("对不起，余额不足");
                                            t=0;
                                        }
                                    }if (t==1) {
                                        if (ClassName == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                            Car car = (Car) Data.findVehicle(ID);
                                            car.setFlag("未租");
                                        } else if (ClassName == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                            Bus bus = (Bus) Data.findVehicle(ID);
                                            bus.setFlag("未租");
                                        } else if (ClassName == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                            Truck truck = (Truck) Data.findVehicle(ID);
                                            truck.setFlag("未租");
                                        }
                                        if (className == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                            Car car = (Car) Data.findVehicle(id);
                                            car.setFlag("已租");
                                        } else if (className == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                            Bus bus = (Bus) Data.findVehicle(id);
                                            bus.setFlag("已租");
                                        } else if (className == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                            Truck truck = (Truck) Data.findVehicle(id);
                                            truck.setFlag("已租");
                                        }
                                        int money;
                                        if (Data.findVehicle(id).getPrice() > Data.findVehicle(ID).getPrice()) {
                                            money=Data.findVehicle(id).getPrice()- Data.findVehicle(ID).getPrice();
                                            setBalance(getBalance() - money * days);
                                            Data.setBusiness(Data.getBusiness() + money*days);
                                        }
                                        if (Data.findVehicle(id).getPrice() < Data.findVehicle(ID).getPrice()) {
                                            money=Data.findVehicle(ID).getPrice() - Data.findVehicle(id).getPrice();
                                            setBalance(getBalance() + money * days);
                                            Data.setBusiness(Data.getBusiness() - money*days);
                                        }
                                        System.out.println("替换成功！您当前所租车辆已替换为：");
                                        Data.findVehicle(id).info();
                                        setVehicleRented(id);
                                        Data.write();
                                    }
                                }
                            }
                        }
                        if (s==3){
                            Data.show3();
                            System.out.println("请输入您想租用的汽车品牌：");
                            String brand=sc.next();
                            int n=Data.show33(brand);
                            if (n==0){
                                System.out.println("我们没有满足您需求的车辆，请等后续完善");
                            }else {
                                System.out.println("\n请输入要租汽车的车牌号：");
                                id = sc.next();
                                if (Data.findVehicle(id) == null) {
                                    System.out.println("租车失败，输入错误，没有该车牌号的车辆。");
                                }
                                if (Data.findflag(id) == false) {
                                    System.out.println("租车失败，该车辆已被租用");
                                } else {
                                    String ID = this.getVehicleRented();
                                    String className = Data.findVehicle(id).getClass().getName();//使用反射获得类名
                                    String ClassName = Data.findVehicle(ID).getClass().getName();//使用反射获得类名
                                    System.out.println("请输入要租的天数：");
                                    int days = sc.nextInt();
                                    int t=1;
                                    if (Data.findVehicle(id).getPrice()>Data.findVehicle(ID).getPrice()){
                                        if (getBalance() < (Data.findVehicle(id).getPrice()-Data.findVehicle(ID).getPrice())*days) {
                                            System.out.println("对不起，余额不足");
                                            t=0;
                                        }
                                    }if (t==1) {
                                        if (ClassName == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                            Car car = (Car) Data.findVehicle(ID);
                                            car.setFlag("未租");
                                        } else if (ClassName == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                            Bus bus = (Bus) Data.findVehicle(ID);
                                            bus.setFlag("未租");
                                        } else if (ClassName == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                            Truck truck = (Truck) Data.findVehicle(ID);
                                            truck.setFlag("未租");
                                        }
                                        if (className == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                            Car car = (Car) Data.findVehicle(id);
                                            car.setFlag("已租");
                                        } else if (className == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                            Bus bus = (Bus) Data.findVehicle(id);
                                            bus.setFlag("已租");
                                        } else if (className == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                            Truck truck = (Truck) Data.findVehicle(id);
                                            truck.setFlag("已租");
                                        }
                                        int money;
                                        if (Data.findVehicle(id).getPrice() > Data.findVehicle(ID).getPrice()) {
                                            money=Data.findVehicle(id).getPrice()- Data.findVehicle(ID).getPrice();
                                            setBalance(getBalance() - money * days);
                                            Data.setBusiness(Data.getBusiness() + money*days);
                                        }
                                        if (Data.findVehicle(id).getPrice() < Data.findVehicle(ID).getPrice()) {
                                            money=Data.findVehicle(ID).getPrice() - Data.findVehicle(id).getPrice();
                                            setBalance(getBalance() + money * days);
                                            Data.setBusiness(Data.getBusiness() - money*days);
                                        }
                                        System.out.println("替换成功！您当前所租车辆已替换为：");
                                        Data.findVehicle(id).info();
                                        setVehicleRented(id);
                                        Data.write();
                                    }
                                }
                            }
                        }
                        /*if (Data.findVehicle(id) == null) {
                            System.out.println("替换失败，输入错误，没有该车牌号的车辆。");
                        } else {
                            String ID = this.getVehicleRented();
                            String className = Data.findVehicle(id).getClass().getName();//使用反射获得类名
                            String ClassName = Data.findVehicle(ID).getClass().getName();//使用反射获得类名
                            if (Data.findVehicle(id).getPrice()>Data.findVehicle(ID).getPrice()){
                                if (getBalance() < (Data.findVehicle(id).getPrice()-Data.findVehicle(ID).getPrice())*5) {
                                    System.out.println("对不起，余额不足");
                                    break;
                                }
                            }
                            if (ClassName == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                Car car = (Car) Data.findVehicle(ID);
                                car.setFlag("未租");
                            } else if (ClassName == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                Bus bus = (Bus) Data.findVehicle(ID);
                                bus.setFlag("未租");
                            } else if (ClassName == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                Truck truck = (Truck) Data.findVehicle(ID);
                                truck.setFlag("未租");
                            }
                            if (className == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                                Car car = (Car) Data.findVehicle(id);
                                car.setFlag("已租");
                            } else if (className == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                                Bus bus = (Bus) Data.findVehicle(id);
                                bus.setFlag("已租");
                            } else if (className == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                                Truck truck = (Truck) Data.findVehicle(id);
                                truck.setFlag("已租");
                            }
                            if (Data.findVehicle(id).getPrice()>Data.findVehicle(ID).getPrice()){
                                setBalance(getBalance() - (Data.findVehicle(id).getPrice()-Data.findVehicle(ID).getPrice())*5);
                            }
                            if (Data.findVehicle(id).getPrice()<Data.findVehicle(ID).getPrice()){
                                setBalance(getBalance() + (Data.findVehicle(id).getPrice()-Data.findVehicle(ID).getPrice())*5);
                            }
                            System.out.println("替换成功！您当前所租车辆已替换为：");
                            Data.findVehicle(id).info();
                            setVehicleRented(id);
                            Data.write();
                        }*/
                    } else if (x == 3) {
                        String id = this.getVehicleRented();
                        this.setVehicleRented("none");
                        String className = Data.findVehicle(id).getClass().getName();//使用反射获得类名
                        if (className == "Vehicles.Car") {        //根据类名对父类对象进行向下转型
                            Car car = (Car) Data.findVehicle(id);
                            car.setFlag("未租");
                        } else if (className == "Vehicles.Bus") {//根据类名对父类对象进行向下转型
                            Bus bus = (Bus) Data.findVehicle(id);
                            bus.setFlag("未租");
                        } else if (className == "Vehicles.Truck") {//根据类名对父类对象进行向下转型
                            Truck truck = (Truck) Data.findVehicle(id);
                            truck.setFlag("未租");
                        }
                        Data.write();
                        System.out.println("退车成功，您当前未租用任何车辆");
                    } else if (x == 4) {
                        System.out.println("请输入您要充值的金额：");
                        int money = sc.nextInt();
                        setBalance(getBalance() + money);
                        Data.write();
                        System.out.println("充值成功");
                    } else if (x == 5) {
                        System.out.println("您当前账户余额为:" + getBalance());
                    }
                    System.out.println("\n            按任意键继续 >>");
                    String string = sc.next();
                    try {
                        new Clear();
                        Clear.clear();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    System.out.println(">> >> >> >> >>");

                //}
            }
            rented=Data.findVehicle(vehicleRented);
        }
    }
    @Override
    //编辑要写入文件的用户信息格式
    public String toString() {
        // TODO Auto-generated method stub
        return super.getId()+"  "+super.getPassword()+"  "+getBalance()+"  "+getVehicleRented();
    }




}