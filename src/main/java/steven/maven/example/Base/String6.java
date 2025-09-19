package steven.maven.example.Base;

public class String6 {
    public static void main(String[] args) {
        String6 getString = new String6();
        getString.StringChange();
    }

    //基本类型转换
    public void StringChange() {
        String str = "zgj";
        // String str2 = new String("steven");

        int len = str.length();
        System.out.println("菜鸟教程网址长度 : " + len);

        //StringBuilder 比 StringBuffer好用
        StringBuilder sb = new StringBuilder(10);
        //noinspection SpellCheckingInspection
        sb.append("hhhhhh..");
        System.out.println(sb);
        sb.delete(5, 8);
    }

}
