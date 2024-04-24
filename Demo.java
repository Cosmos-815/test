package scx;

import java.util.*;

public class Demo extends Student {


    public static void main(String[] args) {
        ArrayList<Student> List = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入操作：\n1.添加学生信息 2.查询学生信息 3.修改学生信息 4.删除学生信息 5.退出");
            int choice = sc.nextInt();
            try {
                if (choice < 1 || choice > 5) {
                    System.out.println("无效操作，请重新输入。");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("无效操作，请重新输入。");
                continue;
            }
            switch (choice) {
                case 1: addStu(List);break;
                case 2: showMenu(List);break;
                case 3: updateStu(List);break;
                case 4: deleteStu(List);break;
                case 5: System.exit(1);break;
            }
        }
    }

    public static void addStu(ArrayList<Student> List) {
        Student s = new Student();
        s.setStuid();
        for (Student stu : List) {
            if (stu.getStuid() == s.getStuid()) {
                System.out.println("该学号已存在，请重新输入。");
                addStu(List);
                return;
            }
        }
        s.setName();
        s.setAge();
        s.setAddress();
        List.add(s);
    }

    public static void showMenu(ArrayList<Student> List) {
        if(List.isEmpty()){
            System.out.println("当前没有学生信息,请手动添加学生信息！");
            addStu(List);
        }
        else{
            System.out.println("学生信息如下：");
            for (Student student : List) {
                System.out.println(student);
            }
        }
    }

    public static void updateStu(ArrayList<Student> List) {
        if (List.isEmpty()) {
            System.out.println("当前没有学生信息,请手动添加学生信息！");
            addStu(List);
        }
        else {
            System.out.println("请输入要修改的学生学号：");
            Scanner sc = new Scanner(System.in);
            int stuid = sc.nextInt();
            for (Student stu : List) {
                if (stu.getStuid() == stuid) {
                    System.out.println("请输入要修改的信息：\n1.姓名 2.年龄 3.地址 4.退出");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1: stu.setName();break;
                        case 2: stu.setAge();break;
                        case 3: stu.setAddress();break;
                        case 4: break;
                        default:
                            System.out.println("无效操作。");
                            break;
                    }
                } else {
                    System.out.println("该学号不存在，请重新输入。");
                    updateStu(List);
                }
            }
        }
    }

    public static void deleteStu(ArrayList<Student> List) {
        if (List.isEmpty()) {
            System.out.println("当前没有学生信息,请手动添加学生信息！");
            addStu(List);
        }
        else {
            System.out.println("请输入要删除的学生学号：");
            Scanner sc = new Scanner(System.in);
            int stuid = sc.nextInt();
            for (Student stu : List) {
                if (stu.getStuid() == stuid) {
                    List.remove(stu);
                    System.out.println("删除成功。");
                    return;
                } else {
                    System.out.println("该学号不存在，请重新输入。");
                    deleteStu(List);
                }
            }
        }
    }
}
