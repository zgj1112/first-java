package steven.maven.example.Base;

public abstract class Abstract12 {
    // 抽象方法：没有方法体，子类必须实现
    public abstract void makeSound();

    // 具体方法：提供默认实现
    public void sleep() {
        System.out.println("This animal is sleeping.");
    }

    // 静态内部类：子类 Dog
    static class Dog extends Abstract12 {
        // 实现父类的抽象方法
        @Override
        public void makeSound() {
            System.out.println("Dog barks: Woof!");
        }
    }

    // 主方法：测试抽象类和子类的用法
    public static void main(String[] args) {
        // 不能实例化抽象类
        // Abstract12 animal = new Abstract12(); // 错误：Abstract12 是抽象的

        // 创建子类实例
        Abstract12 dog = new Dog();
        dog.makeSound(); // 输出：Dog barks: Woof!
        dog.sleep();     // 输出：This animal is sleeping.
    }
}