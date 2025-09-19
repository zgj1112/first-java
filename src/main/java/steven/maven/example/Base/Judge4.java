package steven.maven.example.Base;

public class Judge4 {
    public static void main(String[] args) {
        Judge4 getJudgeFun = new Judge4();
        getJudgeFun.ifElseFun();
    }

    public void ifElseFun() {
        int x = (int) (Math.random() * 100);//1-100的随机数
        if (x == 10) {
            System.out.println("这是" + x);
        } else if (x == 20) {
            System.out.println("这是" + x);
        } else if (x == 30) {
            System.out.println("这是" + x);
        } else {
            System.out.println("这是" + x);
        }
    }
}
