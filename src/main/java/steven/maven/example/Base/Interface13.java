package steven.maven.example.Base;

// 接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字。
// 接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键字。
// 接口中的方法都是公有的。
interface Animal {
    public void eat();

    public void travel();
}

public class Interface13 implements Animal {
    public void eat() {
        System.out.println("Mammal eats");
    }

    public void travel() {
        System.out.println("Mammal travels");
    }

    public int noOfLegs() {
        return 0;
    }

    public static void main(String[] args) {
        Interface13 m = new Interface13();
        m.eat();
        m.travel();
    }
}
