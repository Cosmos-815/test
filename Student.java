package scx;

import java.util.Scanner;

public class Student {
    private int stuid;
    private String name;
    private int age;
    private String address;
    Scanner sc = new Scanner(System.in);

    public Student() {

    }

    public void setAddress() {
        System.out.println("请输入学生居住地：");
        address = sc.next();
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        try {
            int stuid = sc.nextInt();
            System.out.println("合法的学号！");
            this.stuid = stuid;
        } catch (Exception e) {
            System.out.println("学号不合法！请重新输入学生学号：");
            setStuid();
        }

    }

    public void setName() {
        System.out.println("请输入学生姓名：");
        name = sc.next();
    }

    public void setAge() {
        System.out.println("请输入学生年龄：");
        age = sc.nextInt();
    }

    @Override
    public String toString() {
        return "学号：" + stuid + ", 姓名：" + name + ", 年龄：" + age + ", 居住地：" + address;
    }
}
