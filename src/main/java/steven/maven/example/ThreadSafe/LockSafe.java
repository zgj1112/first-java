package steven.maven.example.ThreadSafe;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockSafe {
    public static void main(String[] args) {
        LockAccount acc = new LockAccount(200); // 初始余额 100

        // 两个人同时取钱
        Runnable task = () -> acc.withdraw(80);

        Thread t1 = new Thread(task, "张三");
        Thread t2 = new Thread(task, "李四");

        t1.start();
        t2.start();
    }
}


class LockAccount {
    private final Logger logger = Logger.getLogger(LockAccount.class.getName());
    private final Lock lock = new ReentrantLock();

    private int balance;

    public LockAccount(int balance) {
        this.balance = balance;
    }

    // 加锁保证线程安全
    public void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " 正在取钱 " + amount);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.log(Level.SEVERE, "取钱线程被中断", e);
                    Thread.currentThread().interrupt(); // 推荐：恢复中断状态
                }
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " 取钱成功，剩余余额: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " 取钱失败，余额不足");
            }
        } finally {
            lock.unlock();
        }

    }
}