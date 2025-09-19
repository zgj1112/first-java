package steven.maven.example.Base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimal15 {
    public static void main(String[] args) {
        // 常规使用需要转换字符串  可以这样BigDecimal b1 = new BigDecimal(Double.toString(0.1));
        BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.2");

        // 官方优化后使用
        BigDecimal a1 = BigDecimal.valueOf(0.1);
        BigDecimal a2 = BigDecimal.valueOf(0.2);

        // 演示加法
        BigDecimal sum = a1.add(a2);
        System.out.println("加法 (0.1 + 0.2): " + sum); // 预期输出: 0.3

        // 演示减法
        BigDecimal subtraction = a2.subtract(a1);
        System.out.println("减法 (0.2 - 0.1): " + subtraction); // 预期输出: 0.1

        // 演示乘法
        BigDecimal multiplication = a1.multiply(a2);
        System.out.println("乘法 (0.1 * 0.2): " + multiplication); // 预期输出: 0.02

        // 演示除法，指定精度和舍入模式
        BigDecimal division = a2.divide(a1, 2, RoundingMode.HALF_UP); // 保留2位小数，四舍五入
        System.out.println("除法 (0.2 / 0.1): " + division); // 预期输出: 2.00
    }
}
