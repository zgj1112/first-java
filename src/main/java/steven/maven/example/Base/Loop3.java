package steven.maven.example.Base;

public class Loop3 {
    public static void main(String[] args) {
        Loop3 getLoopFun = new Loop3();
        getLoopFun.forFun();
        getLoopFun.whileFun();
        getLoopFun.breakFun();
        getLoopFun.continueFun();
    }

    public void forFun() {
        //普通for循环
        for (int i = 10; i < 20; i = i + 1) {
            System.out.print("value of i : " + i);
            System.out.print("\n");
        }

        //增强for循环
        int[] numbers = {10, 20, 30, 40, 50};
        for (int x : numbers) {
            System.out.print(x);
            System.out.print(",");
        }
        System.out.print("\n");

        String[] names = {"James", "Larry", "Tom", "Lacy"};
        for (String name : names) {
            System.out.print(name);
            System.out.print(",");
        }
    }

    public void whileFun() {
        // while
        int x = 10;
        while (x < 20) {
            System.out.print("x of test : " + x);
            x++;
            System.out.print("\n");
        }

        // do while
        int y = 10;
        do {
            System.out.print("value of y : " + y);
            y++;
            System.out.print("\n");
        } while (y < 20);
    }

    public void  breakFun() {
        int [] numbers = {10, 20, 30, 40, 50};

        for(int x : numbers ) {
            // x 等于 30 时跳出循环
            if( x == 30 ) {
                break;
            }
            System.out.print( x );
            System.out.print("\n");
        }
        // 打印
        // 10
        // 20
    }

    public void continueFun() {
        int [] numbers = {10, 20, 30, 40, 50};

        for(int x : numbers ) {
            if( x == 30 ) {
                continue;
            }
            System.out.print( x );
            System.out.print("\n");
        }
        // 打印
        // 10
        // 20
        // 40
        // 50
    }

}
