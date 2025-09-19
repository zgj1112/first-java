package steven.maven.example.Base;

// enum Color
// {
//     RED, GREEN, BLUE;
// }

// 枚举的实际实现方式
// class Color
// {
//     public static final Color RED = new Color();
//     public static final Color BLUE = new Color();
//     public static final Color GREEN = new Color();
// }

public class Enum14 {
    enum Color {
        RED, GREEN, BLUE;
    }

    // 执行输出结果
    public static void main(String[] args) {
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}
