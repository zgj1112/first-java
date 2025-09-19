package steven.maven.example.Base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Number5 {
    public static void main(String[] args) {
        Number5 getNumber = new Number5();
        getNumber.NumberChange();
        getNumber.MathChange();
    }

    //基本类型转换
    public void NumberChange() {
        Number num = 1234.56; // 自动装箱为 Double（Double 是 Number 的子类）
        System.out.println(num.intValue());    // 1234 （截断小数部分）
        System.out.println(num.longValue());   // 1234
        System.out.println(num.floatValue());  // 1234.56
        System.out.println(num.doubleValue()); // 1234.56

        BigInteger bigInt = new BigInteger("12345678901234567890");
        BigDecimal bigDec = new BigDecimal("1234567890.1234567890");
        // 大数运算
        BigInteger sum = bigInt.add(new BigInteger("1"));
        BigDecimal product = bigDec.multiply(new BigDecimal("2"));
    }

    //Math运算
    public void MathChange() {
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI / 2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI / 3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI / 2));
        System.out.println(Math.PI);

        //指数对数运算
        double result = Math.exp(1) + Math.log(Math.E) + Math.log10(100); // 数学表达式
        // Number number = Double.valueOf(result); // 包装成 Number 对象
        System.out.println("这是 " + result); // 会自动调用 number.toString()

        // 随机数生成
        double random = Math.random();
        // 生成[1, 100]的随机整数
        int randomInt = (int) (Math.random() * 100) + 1;
        System.out.println("这是 " + random + ',' + randomInt); // 会自动调用 number.toString()
    }


}
