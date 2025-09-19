package steven.maven.example.Base;
//修饰符
public class Modifier2 {
//    default (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
//    private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
//    public : 对所有类可见。使用对象：类、接口、变量、方法
//    protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。

//    static 修饰符，用来修饰类方法和类变量。
//    final 修饰符，用来修饰类、方法和变量，final 修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。
//    abstract 修饰符，用来创建抽象类和抽象方法 抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。
//    synchronized 和 volatile 修饰符，主要用于线程的编程。
//    synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符

//    序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量
//    public transient int limit = 55;   // 不会持久化
//    public int b; // 持久化

//    volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。可能是 null

}
