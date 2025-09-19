package steven.maven.example.Senior;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
// import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// Thread和runnable不会返回结果 因为内置的run方法前面固定为void Callable会返回一个数据 可以等待结果
public class Thread7 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread(); // 创建实现方式一
        // MyThread t2 = new MyThread();

        Runnable r3 = new MyRunnable();// 创建实现方式二
        Thread t3 = new Thread(r3, "线程3");

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "正在运行" + i);
            }
        }, "线程4").start();// 创建方式三

        // 创建方式四
        Callable<String> c4 = new MyCallable(10); // 与类同名的函数叫构造函数 可以直接调用
        FutureTask<String> ft4 = new FutureTask<>(c4);
        Thread t4 = new Thread(ft4, "线程5");


        t1.setName("线程1");
        // t2.setName("线程2");
        // t3.setName("线程3");
        t1.start();// 必须start才能运行 调用run方法是单线程的
        // t2.start();
        t3.start();
        t4.start();

        // join等待线程1和线程3结束
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 1. 启动线程

        // 2. 获取结果（阻塞直到 call() 执行完）
        String result;
        try {
            result = ft4.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t4.getName() + "执行结果: " + result);
    }
}

// 多线程第一种方式Thread
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + "正在运行" + i);
        }
    }
}

// 多线程第二种方式Runnable
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "正在运行" + i);
        }
    }
}


// 创建方式四
class MyCallable implements Callable<String> {
    int num;

    public MyCallable(int n) {
        this.num = n;
    }

    @Override
    public String call() {
        int total = 0;
        for (int i = 0; i < num; i++) {
            total += i;
        }
        return "结果为" + total;
    }
}