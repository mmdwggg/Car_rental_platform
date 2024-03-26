package RentCar;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.ls.LSOutput;

import java.awt.AWTException;

import Vehicles.Bus;
import Vehicles.Car;
import Vehicles.Truck;

public class Administrator extends Loginer{

    public Administrator(String id, String password) {
        super(id, password);
    }

    @Override
    //进入系统菜单
    public void go() throws IOException {

        Scanner sc=new Scanner(System.in);
        System.out.println("\n管理员登陆成功！");
        System.out.println("欢迎管理员:"+super.getId()+",当前营业额为:"+Data.getBusiness()+"元。");
        System.out.println("\n||☺✘☺✘☺✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘✘☺✘☺✘☺||\n");
        while(true) {
            System.out.println("\n\n");
            System.out.println("请输入操作的编号:");
            System.out.println("1、查看车辆 2、添加车辆 3、修改车辆 4、删除车辆 5、查看营业额 0、退出系统");
            int x=sc.nextInt();
            while (x!=0&&x!=1&&x!=2&&x!=3&&x!=4&&x!=5){
                System.out.println("请输入正确选择");
                x=sc.nextInt();
            }
            if(x==0)
            {
                sc.close();
                System.out.println("程序运行结束");
                return;
            }

		/*else if(x==6)
			{
				System.out.println("请输入用户名：");
				String test_id=sc.next();
				System.out.println("请输入密码：");
				String test_passward1=sc.next();

				System.out.println("请再次确认密码：");
				String test_passward2=sc.next();

				if(test_passward1.equals(test_passward2))
				{


					Data.getAdministrators().add(new Administrator(test_id, test_passward2));
					System.out.println("管理员注册成功,用户名是："+test_id+"\n");
					Data.write();

				}
				else {
					System.out.println("两次密码不一致！注册失败！");
					sc.close();
					return;
				}
			}*/


            else if(x==1) {
                Data.show();
            }
            else if(x==2) {
                System.out.println("请输入添加车辆的类型编号：");
                System.out.println("1、小型汽车  2、客车  3、货车");
                x=sc.nextInt();
                System.out.println("请输入增加车辆的品牌");
                String brand=sc.next();
                System.out.println("请输入增加车辆的车牌号");
                String id=sc.next();
                while (Data.findID(id)==false){
                    System.out.println("该车牌号重复，请更改车牌号");
                    id=sc.next();
                }
                System.out.println("请输入增加车辆的日租金(一个整数):");
                int price=sc.nextInt();
                if(x==1) {
                    System.out.println("请输入增加车辆的类型");
                    Data.getCars().add(new Car(brand, id,sc.next(), price,"未租"));
                }
                else if(x==2) {
                    System.out.println("请输入增加车辆的载客量");
                    Data.getBus().add(new Bus(brand, id,sc.next(), price,"未租"));
                }
                else if(x==3) {
                    System.out.println("请输入增加车辆的载货量");
                    Data.getTrucks().add(new Truck(brand, id,sc.next(), price,"未租"));
                }
                System.out.println("添加成功！");
                Data.write();
            }else if (x==3) {
                Data.showInfo();
                System.out.println("请输入要修改车辆的车牌号:");
                String id=sc.next();
                if(Data.findVehicle(id)==null) {
                    System.out.println("输入错误，该车牌号不存在");
                }
                else {
                    System.out.println("请输入修改后车辆的品牌:");
                    String brand=sc.next();
                    System.out.println("请输入修改后车辆的车牌号:");
                    String id1=sc.next();
                    System.out.println("请输入修改后车辆的日租金(一个整数):");
                    int price=sc.nextInt();
                    String className=Data.findVehicle(id).getClass().getName();//使用反射获得类名
                    if(className=="Vehicles.Car") {		//根据类名对父类对象进行向下转型
                        Car car=(Car) Data.findVehicle(id);
                        car.setBrand(brand);
                        car.setId(id1);
                        car.setPrice(price);
                        System.out.println("请输入修改后车辆的类型:");
                        car.setType(sc.next());
                        Data.write();
                    }
                    else if (className=="Vehicles.Bus") {//根据类名对父类对象进行向下转型
                        Bus bus=(Bus)Data.findVehicle(id);
                        bus.setBrand(brand);
                        bus.setId(id1);
                        bus.setPrice(price);
                        System.out.println("请输入修改后车辆的载客量:");
                        bus.setPassengerCapacity(sc.next());
                        Data.write();
                    }
                    else if(className=="Vehicles.Truck") {//根据类名对父类对象进行向下转型
                        Truck truck=(Truck)Data.findVehicle(id);
                        truck.setBrand(brand);
                        truck.setId(id1);
                        truck.setPrice(price);
                        System.out.println("请输入修改后车辆的载货量:");
                        truck.setLoadCapacity(sc.next());
                        Data.write();
                    }
                    System.out.println("修改成功！");
                }
            }
            else if (x==4) {
                Data.showInfo();
                System.out.println("请输入要删除车辆的车牌号");
                String id=sc.next();
                if (Data.findVehicle(id)==null) {
                    System.out.println("删除失败，该车牌号不存在");
                }
                else {
                    Data.delete(id);
                    Data.write();
                    System.out.println("删除成功！");
                }
            }
            else if(x==5)
            {
                System.out.println("当前营业额为:"+Data.getBusiness()+"元。\n");
            }
            System.out.println("\n            按任意键继续 >>");
            String string=sc.next();
            new Clear();
            try {
                Clear.clear();
            } catch (AWTException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
            System.out.println(">> >> >> >> >>");


        }
    }
    public String toString() {
        // TODO Auto-generated method stub
        return super.getId()+"  "+super.getPassword();
    }


}
