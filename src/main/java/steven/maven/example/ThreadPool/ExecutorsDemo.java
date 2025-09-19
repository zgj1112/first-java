package steven.maven.example.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//不建议使用这个 会造成 堆满了 内存溢出之类的问题
public class ExecutorsDemo {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService pool1 = Executors.newFixedThreadPool(5);
        Runnable r1 = new MyRunnable(5);

        // 创建一个单线程的线程池
        ExecutorService pool2 = Executors.newSingleThreadExecutor();

        // 创建一个可缓存的线程池
        ExecutorService pool3 = Executors.newCachedThreadPool();

        // 创建一个定长线程池，支持定时及周期性任务执行
        // ScheduledExecutorService pool = Executors.newScheduledThreadPool(int corePoolSize);
    }
}
