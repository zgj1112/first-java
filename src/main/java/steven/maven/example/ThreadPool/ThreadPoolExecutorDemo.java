package steven.maven.example.ThreadPool;

import java.util.concurrent.*;

class MyRunnable implements Runnable {
    private final int num;

    public MyRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName() + "正在运行" + i);
        }
    }
}

class MyCallable implements Callable<Number> {
    private final int num;

    public MyCallable(int value) {
        this.num = value;
    }

    @Override
    public Number call() {
        int total = 0;
        for (int i = 0; i <= num; i++) {
            total += i;
        }
        return total;
    }
}

public class ThreadPoolExecutorDemo {
    // 错误捕捉
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (
                // 线程池创建方式一
                ExecutorService pool = new ThreadPoolExecutor(
                        3, 5, 10,
                        TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy()
                )
                // 线程池创建方式二
                // ExecutorService pool1 = Executors.newFixedThreadPool(5);
        ) {
            // Runnable任务 异步
            Runnable r1 = new MyRunnable(5);
            pool.execute(r1); // 直接执行Runnable

            // Callable<Number> c4 = new MyCallable(100);
            // pool.submit(c4); //直接执行Callable

            // Callable任务 同步
            Future<Number> c1 = pool.submit(new MyCallable(100));
            System.out.println("Callable结果: " + c1.get());

            // 提交 Runnable 并获取 Future 阻塞等待 Runnable 执行完成 同步
            Future<Void> rf1 = pool.submit(r1, null);
            rf1.get();
        }
    }
}
