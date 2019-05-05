/*实验五 面向对象程序设计
1、用面向对象的思想分析“小明在湛江上大学”，抽象出这一句话中包含的类。
2、建立类和类之间的关系，体现面向对象中的接口、抽象类、继承、聚合等概念。
3、定义每个类。
4、建立测试类。*/

public class Experiment5 {
    public static void main(String[] args) {  //别漏了String[] args否则无法Run
        Student ming = new Student();
        ming.name = "小明";
        City zhan = new City();
        zhan.name = "湛江";
        AttendSchool da = new AttendSchool();
        da.name = "上大学";
        Test.test(ming.who(), zhan.where(), da.doSth());
    }
}

abstract class Human {  //声明抽象类关键字：abstract
    String name;

    abstract public String who();  //抽象方法一定要在抽象类里，后面用分号而不是大括号
}

abstract class Site {
    String name;

    abstract public String where();
}

abstract class Behavior {
    String name;

    abstract public String doSth();
}

class Student extends Human {  //类继承关键字：extends
    public String who() {
        return name;
    }
}

class City extends Site {
    public String where() {
        return name;
    }
}

class AttendSchool extends Behavior {
    public String doSth() {
        return name;
    }
}

class Test {
    static void test(String who, String where, String doSth) {
        System.out.println(who + "在" + where + doSth);
    }
}