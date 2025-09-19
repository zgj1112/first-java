package steven.maven.example.RedPacketRain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

class PropleGetRedPacketx extends Thread {
    private final List<Integer> redpacket;
    private final AtomicInteger redPacketCounter; // 引用共享计数器
    private static final double CONTINUE_PROBABILITY = 0.7; // 继续抢红包的概率 会影响剩余红包的数量 0.5以上基本会抢完 0.5以下基本抢不完
    private static final int MAX_ATTEMPTS = 3; // 每个员工最多抢4次
    private final String logname;  // 去掉 static

    public PropleGetRedPacketx(List<Integer> redpacket, String name, AtomicInteger redPacketCounter) {
        // super(name);
        this.redpacket = redpacket;
        this.redPacketCounter = redPacketCounter;
        this.logname = name;
    }

    @Override
    public void run() {
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS && !redpacket.isEmpty()) {
            synchronized (redpacket) {
                if (!redpacket.isEmpty()) {
                    int index = ThreadLocalRandom.current().nextInt(redpacket.size());
                    int money = redpacket.remove(index);
                    // 递增计数器并获取当前红包序号
                    int currentCount = redPacketCounter.incrementAndGet();
                    System.out.println(logname + " 抢到红包 " + money + " (第" + currentCount + "个红包)");
                    attempts++;
                }
            }

            // 随机休眠0-50ms，模拟反应时间
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(50));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            // 概率继续抢，否则退出
            if (ThreadLocalRandom.current().nextDouble() > CONTINUE_PROBABILITY) {
                break;
            }
        }
    }
}