package steven.maven.example.Base;
//基础类型
public class BaseDataType1 {
//    byte b = 0 ; //8位 内存是int的1/4 默认值0 最小值是 -128（-2^7）; 最大值是 127（2^7-1）;
//    short s = 0 ; //16位 内存是int的1/2  默认值0 最小值是 -32768（-2^15）; 最大值是 32767（2^15 - 1）;
//    int i = 0 ;//32位 默认值0 最小值是 -2,147,483,648（-2^31）; 最大值是 2,147,483,647（2^31 - 1）;
//    long l = 0L ; //64位 内存是int的2倍  默认值0L 最小值是 -9,223,372,036,854,775,808（-2^63）; 最大值是 9,223,372,036,854,775,807（2^63 -1）;
//    float f = 0.0F ;//32位
//    double d = 0.0D ;//64位
//    boolean bool = false ;//true 或 false
//    char c = '1' ; //单一字面量
//    final double PI = 3.1415927; //  final 修饰常量 在程序运行时是不能被修改的

    static boolean bool;
    static byte by;
    static short sh;
    static int i;
    static long l;
    static float f;
    static double d;
    static char ch;
    static String str;
    char c = '1' ; //单一字面量

    public static void main(String[] args) {

        BaseDataType1 base = new BaseDataType1();
        //  基础默认值输出
        base.BaseDefaultLog();
        // 最小值最大值输出
        BaseMinMaxLog();
    }

    public void BaseDefaultLog() {
        System.out.println("Bool :" + bool);
        System.out.println("Byte :" + by);
        System.out.println("Character:" + ch);
        System.out.println("Double :" + d);
        System.out.println("Float :" + f);
        System.out.println("Integer :" + i);
        System.out.println("Long :" + l);
        System.out.println("Short :" + sh);
        System.out.println("String :" + str);
        System.out.println("String :" + c);
    }

    //输出各类型
    public static void BaseMinMaxLog() {
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);
    }

}

