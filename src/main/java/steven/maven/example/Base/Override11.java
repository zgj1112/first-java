package steven.maven.example.Base;

public class Override11 {
    public static void main(String[] args) {
        // 测试父类
        Override11 parent = new Override11();
        parent.overrideFun(); // 输出：overrideFun1
        parent.overrideFun(10); // 输出：overrideFun2

        // 测试子类（多态）
        Override11 child = new Override12();
        child.overrideFun(); // 输出：overrideFun3
        child.overrideFun(10); // 输出：overrideFun4
    }

    // 重载方法：无参数
    public void overrideFun() {
        System.out.println("overrideFun1");
    }

    // 重载方法：带一个整型参数
    public void overrideFun(int num) {
        System.out.println("overrideFun2");
    }
}

class Override12 extends Override11 {
    // 重写父类的无参数方法
    @Override
    public void overrideFun() {
        System.out.println("overrideFun3");
    }

    // 重写父类的带参数方法 重载
    @Override
    public void overrideFun(int num) {
        System.out.println("overrideFun4");
    }
}