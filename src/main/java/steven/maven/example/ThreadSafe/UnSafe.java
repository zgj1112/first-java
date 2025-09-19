package steven.maven.example.ThreadSafe;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnSafe {
    public static void main(String[] args) {
        Account account = new Account(100); // 初始余额 100

        // 两个人同时取钱
        Runnable task = () -> account.withdraw(80);

        Thread t1 = new Thread(task, "张三");
        Thread t2 = new Thread(task, "李四");

        t1.start();
        t2.start();
    }

}

class Account {
    private final Logger logger = Logger.getLogger(Account.class.getName());
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    // 取钱方法（不加锁）
    public void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " 正在取钱 " + amount);
            try {
                Thread.sleep(100); // 模拟处理时间
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "取钱线程被中断", e);
                Thread.currentThread().interrupt(); // 推荐：恢复中断状态
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " 取钱成功，剩余余额: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " 取钱失败，余额不足");
        }
    }
}
