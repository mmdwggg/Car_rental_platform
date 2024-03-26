package RentCar;

import java.io.IOException;
import java.util.Scanner;

import Vehicles.Car;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("*************欢迎使用租车系统*************");
        Data.read();
        Data.write();
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择：1.注册  2.登录  0.退出");
        int op=sc.nextInt();
        int x;
        //用户注册
        while (op!=1&&op!=2&&op!=0){
            System.out.println("请输入正确选择");
            op=sc.nextInt();
        }
        if(op==0){
            System.out.println("程序运行结束");
            return;
        }
        if(op==1) {
            System.out.println("请选择：1.管理员注册  2.用户注册");
            x = sc.nextInt();
            while (x!=1&&x!=2){
                System.out.println("请输入正确选择");
                x=sc.nextInt();
            }
            if (x==1){
                System.out.println("请输入用户名：");
                String test_id=sc.next();
                while (Loginer.equalsID(test_id)==false){
                    System.out.println("该用户已被占用，请重新输入用户名：");
                    test_id=sc.next();
                }
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
            }
            if (x==2){
                System.out.println("请输入用户名：");
                String test_id = sc.next();
                while (Loginer.equalsID(test_id)==false){
                    System.out.println("该用户已被占用，请重新输入用户名：");
                    test_id=sc.next();
                }
                System.out.println("请输入密码：");
                String test_passward1 = sc.next();

                System.out.println("请再次确认密码：");
                String test_passward2 = sc.next();

                if (test_passward1.equals(test_passward2)) {
                    System.out.println("请充值1000元");
                    System.out.println("充值成功，您当前的账户余额为1000元");
                    Data.getUsers().add(new User(test_id, test_passward2, 1000/*初始账户余额*/, "none"));
                    System.out.println("注册成功,您的用户名是：" + test_id + "\n请登录！");
                    Data.write();
                } else {
                    System.out.println("两次密码不一致！注册失败！");
                    sc.close();
                    return;
                }
            }
        }




        /*********************************************/
        //用户登录
        System.out.println("请输入用户名:");
        String id=sc.next();
        System.out.println("请输入密码");
        String password=sc.next();

        Loginer loginer=Loginer.login(new Loginer(id, password) {
            @Override
            public void go() {

            }
        });//调用Loginer的login方法，根据返回值判断登录合法不合法

        if (loginer==null) {
            System.out.println("账号或密码错误，登录失败！");//登录不合法
        }
        else {
            loginer.go();//登录合法，调用go方法，进行下一步操作
        }
        sc.close();
    }


}