package steven.maven.example;

import steven.maven.example.Base.HelloWorld;

public class Main {
    public static void main(String[] args) {

        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
            HelloWorld.main(args);// 用法
        }
    }
}