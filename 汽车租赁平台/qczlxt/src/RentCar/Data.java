package RentCar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import Vehicles.*;
import java.util.Scanner;

public class Data {
    private static List<User> users=new ArrayList<>();
    private static List<Administrator> administrators=new ArrayList<>();
    private static List<Car> cars=new ArrayList<>();
    private static List<Bus> bus=new ArrayList<>();
    private static List<Truck> trucks=new ArrayList<>();
    private static int business;



    public static List<Car> getCars() {
        return cars;
    }
    public static int getBusiness() {
        return business;
    }
    public static void setBusiness(int business) {
        Data.business = business;
    }
    public static void setCars(List<Car> cars) {
        Data.cars = cars;
    }
    public static List<Bus> getBus() {
        return bus;
    }
    public static void setBus(List<Bus> bus) {
        Data.bus = bus;
    }
    public static List<Truck> getTrucks() {
        return trucks;
    }
    public static void setTrucks(List<Truck> trucks) {
        Data.trucks = trucks;
    }
    public static List<User> getUsers() {
        return users;
    }
    public static void setUsers(List<User> users) {
        Data.users = users;
    }
    public static List<Administrator> getAdministrators() {
        return administrators;
    }
    public static void setAdministrators(List<Administrator> administrators) {
        Data.administrators = administrators;
    }


    public static void show1() {
            System.out.println("小型汽车：");
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).info();
            }
    }
    public static int show11(String brand) {
        System.out.println(brand+":");
        int n=0;
        for (int i = 0; i < cars.size(); i++) {
            if (brand.equals(cars.get(i).getBrand())){
                cars.get(i).info();
                n++;
            }
        }
        return n;
    }
    public static void show2() {
        System.out.println("客车：");
        for (int i = 0; i < bus.size(); i++) {
            bus.get(i).info();
        }
    }
    public static int show22(String brand) {
        System.out.println(brand+":");
        int n=0;
        for (int i = 0; i < bus.size(); i++) {
            if (brand.equals(bus.get(i).getBrand())){
                bus.get(i).info();
                n++;
            }
        }
        return n;
    }
    public static void show3() {
        System.out.println("货车：");
        for (int i = 0; i < trucks.size(); i++) {
            trucks.get(i).info();
        }
    }
    public static int show33(String brand) {
        System.out.println(brand+":");
        int n=0;
        for (int i = 0; i < trucks.size(); i++) {
            if (brand.equals(trucks.get(i).getBrand())){
                trucks.get(i).info();
                n++;
            }
        }
        return n;
    }
    public static void show() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择：1.查看全部车辆  2.查看小型汽车  3.查看客车  4.查看货车");
        int x=sc.nextInt();
        while (x!=1&&x!=2&&x!=3&&x!=4){
            System.out.println("请输入正确选择");
            x=sc.nextInt();
        }
        if (x==1||x==2) {
            show1();
        }
        if (x==1||x==3) {
            show2();
        }
        if (x==1||x==4) {
            show3();
        }
    }
    public static void showInfo() {
            System.out.println("小型汽车：");
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).info();
            }
            System.out.println("客车：");
            for (int i = 0; i < bus.size(); i++) {
                bus.get(i).info();
            }
            System.out.println("货车：");
            for (int i = 0; i < trucks.size(); i++) {
                trucks.get(i).info();
            }
    }

    public static void delete(String id) {
        for(int i=0;i<cars.size();i++) {
            if(id.equals(cars.get(i).getId())) cars.remove(i);
        }
        for(int i=0;i<bus.size();i++) {
            if(id.equals(bus.get(i).getId())) bus.remove(i);
        }
        for(int i=0;i<trucks.size();i++) {
            if(id.equals(trucks.get(i).getId())) trucks.remove(i);
        }
    }
    public static Vehicle findVehicle(String id){
        for(int i=0;i<cars.size();i++) {
            if(id.equals(cars.get(i).getId())) {
                return cars.get(i);
            }
        }
        for(int i=0;i<bus.size();i++) {
            if(id.equals(bus.get(i).getId())) {
                return bus.get(i);
            }
        }
        for(int i=0;i<trucks.size();i++) {
            if(id.equals(trucks.get(i).getId())) {
                return trucks.get(i);
            }
        }
        return null;
    }
    public static boolean findflag(String id){
        for(int i=0;i<cars.size();i++) {
            if(id.equals(cars.get(i).getId())) {
                if (cars.get(i).getflag().equals("已租"))
                    return false;
            }
        }
        for(int i=0;i<bus.size();i++) {
            if(id.equals(bus.get(i).getId())) {
                if (bus.get(i).getflag().equals("已租"))
                    return false;
            }
        }
        for(int i=0;i<trucks.size();i++) {
            if(id.equals(trucks.get(i).getId())) {
                if (trucks.get(i).getflag().equals("已租"))
                    return false;
            }
        }
        return true;
    }
    public static boolean findID(String id){
        for(int i=0;i<cars.size();i++) {
            if(id.equals(cars.get(i).getId())) {
                    return false;
            }
        }
        for(int i=0;i<bus.size();i++) {
            if(id.equals(bus.get(i).getId())) {
                    return false;
            }
        }
        for(int i=0;i<trucks.size();i++) {
            if(id.equals(trucks.get(i).getId())) {
                    return false;
            }
        }
        return true;
    }

    public static void read() throws IOException{

        BufferedReader r_users=null;
        BufferedReader r_administrators=null;
        BufferedReader r_cars=null;
        BufferedReader r_bus=null;
        BufferedReader r_trucks=null;
        BufferedReader r_business=null;

        try {
            r_users=new BufferedReader(new InputStreamReader(new FileInputStream("src\\users.txt"), "UTF-8"));
            r_administrators=new BufferedReader(new InputStreamReader(new FileInputStream("src\\administrators.txt"), "UTF-8"));
            r_cars=new BufferedReader(new InputStreamReader(new FileInputStream("src\\cars.txt"), "UTF-8"));
            r_bus=new BufferedReader(new InputStreamReader(new FileInputStream("src\\bus.txt"), "UTF-8"));
            r_trucks=new BufferedReader(new InputStreamReader(new FileInputStream("src\\trucks.txt"), "UTF-8"));
            r_business=new BufferedReader(new InputStreamReader(new FileInputStream("src\\business.txt"), "UTF-8"));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("存储数据文件读取错误");
        }

        while (true) {
            String str=r_users.readLine();
            if(str==null) break;
            users.add(new User(str.split("  ")[0], str.split("  ")[1],Integer.valueOf(str.split("  ")[2]),str.split("  ")[3]));
        }
        while (true) {
            String str=r_administrators.readLine();
            if(str==null) break;
            administrators.add(new Administrator(str.split("  ")[0], str.split("  ")[1]));
        }
        while(true) {
            String str=r_cars.readLine();
            if(str==null) break;
            cars.add(new Car(str.split("  ")[0], str.split("  ")[1], str.split("  ")[2],Integer.valueOf(str.split("  ")[3]) , str.split("  ")[4]));
        }
        while(true) {
            String str=r_bus.readLine();
            if(str==null) break;
            bus.add(new Bus(str.split("  ")[0], str.split("  ")[1], str.split("  ")[2],Integer.valueOf(str.split("  ")[3]),str.split("  ")[4]));
        }
        while(true) {
            String str=r_trucks.readLine();
            if(str==null) break;
            trucks.add(new Truck(str.split("  ")[0], str.split("  ")[1], str.split("  ")[2],Integer.valueOf(str.split("  ")[3]),str.split("  ")[4]));
        }
        setBusiness(Integer.valueOf(r_business.readLine()));

        r_business.close();
        r_users.close();
        r_administrators.close();
        r_bus.close();
        r_cars.close();
        r_trucks.close();
    }


    public static void write() throws IOException {
        BufferedWriter w_cars=null;
        BufferedWriter w_bus=null;
        BufferedWriter w_trucks=null;
        BufferedWriter w_users=null;
        BufferedWriter 	w_administrators=null;

        BufferedWriter w_business=null;
        try {
            w_cars=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\cars.txt"),"UTF-8"));
            w_bus=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\bus.txt"),"UTF-8"));
            w_trucks=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\trucks.txt"),"UTF-8"));
            w_users=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\users.txt"),"UTF-8"));
            w_administrators=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\administrators.txt"),"UTF-8"));
            w_business=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src\\business.txt"),"UTF-8"));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("存储数据文件写入错误");
        }

        for(int i=0;i<cars.size();i++) {
            w_cars.write(cars.get(i).toString());
            w_cars.newLine();
        }
        for(int i=0;i<bus.size();i++) {
            w_bus.write(bus.get(i).toString());
            w_bus.newLine();
        }
        for(int i=0;i<trucks.size();i++) {
            w_trucks.write(trucks.get(i).toString());
            w_trucks.newLine();
        }
        for(int i=0;i<users.size();i++) {
            w_users.write(users.get(i).toString());
            w_users.newLine();
        }
		for(int i=0;i<administrators.size();i++) {
			w_administrators.write(administrators.get(i).toString());
			w_administrators.newLine();
		}
        w_business.write(((Integer)getBusiness()).toString());

        w_business.close();
        w_bus.close();
        w_cars.close();
        w_trucks.close();
        	w_administrators.close();
        w_users.close();
    }
}
