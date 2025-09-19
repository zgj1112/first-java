package steven.maven.example.Senior;
// E - Element (在集合中使用，因为集合中存放的是元素)
// T - Type（Java 类）
// K - Key（键）
// V - Value（值）
// N - Number（数值类型）
// ？ - 表示不确定的 java 类型

import java.util.ArrayList;
import java.util.List;
import java.util.*;



// 泛型类：T 表示通用类型
class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}


public class Generic5 {

    // 泛型接口：使用 K 表示键，V 表示值
    interface KeyValuePrinter<K, V> {
        void print(K key, V value);
    }

    public static void main(String[] args) {
        Generic5 demo = new Generic5();

        // 使用泛型类 Box<T>
        Box<String> stringBox = new Box<>();
        stringBox.set("泛型盒子");
        System.out.println("Box 内容: " + stringBox.get());

        // 使用泛型方法
        demo.printGeneric(123);               // 打印整数
        demo.printGeneric("Hello 泛型方法");    // 打印字符串

        // 使用泛型数组方法
        Integer[] intArr = {1, 2, 3};
        demo.printArray(intArr);

        // 使用通配符 ?
        List<String> strList = List.of("A", "B", "C");
        demo.printListUnknown(strList);

        // 使用 ? extends Number
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);
        demo.sumNumbers(doubleList);

        // 使用 ? super Integer
        List<Number> numberList = new ArrayList<>();
        demo.addIntegers(numberList);
        demo.printListUnknown(numberList);

        // 使用泛型接口
        KeyValuePrinter<Integer, String> printer = new KeyValuePrinter<>() {
            public void print(Integer key, String value) {
                System.out.println("键：" + key + ", 值：" + value);
            }
        };
        printer.print(1, "泛型接口");
    }

    // 泛型方法：T 表示任意传入类型
    public <T> void printGeneric(T value) {
        System.out.println("打印通用类型: " + value);
    }

    // 泛型方法：打印数组中每个元素（E 代表集合元素 Element）
    public <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // 使用通配符 ? 表示未知类型
    public void printListUnknown(List<?> list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    // 使用上限通配符 ? extends Number：只能读，不能写
    public void sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        System.out.println("总和为: " + sum);
    }

    // 使用下限通配符 ? super Integer：可以写入 Integer 或其子类
    public void addIntegers(List<? super Integer> list) {
        list.add(100);
        list.add(200);
        System.out.println("添加完成，长度：" + list.size());
    }

}




