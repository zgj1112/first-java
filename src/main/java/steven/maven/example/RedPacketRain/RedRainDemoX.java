package steven.maven.example.RedPacketRain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RedRainDemoX {
    // 共享计数器，记录当前抢到的红包序号
    private static final AtomicInteger redPacketCounter = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("红包雨");
        List<Integer> redPackets = getRedPacket();

        // 创建固定大小的线程池，限制同时运行的线程数
        ExecutorService executor = Executors.newFixedThreadPool(100); // 增加到20以提高并发
        for (int i = 0; i < 100; i++) {
            executor.submit(new PropleGetRedPacketx(redPackets, "员工" + i, redPacketCounter));
        }

        // 关闭线程池，等待所有任务完成
        executor.shutdown();

        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }

        System.out.println("剩余红包：" + redPackets);
        System.out.println("总共抢了 " + redPacketCounter.get() + " 个红包");
    }

    // 获取红包
    public static List<Integer> getRedPacket() {
        final int RED_PACKET_TOTALL = 200;
        final int RED_PACKET_SMALL = (int) (RED_PACKET_TOTALL * 0.8);
        final int RED_PACKET_BIG = (int) (RED_PACKET_TOTALL * 0.2);
        final int MIN_SMALL = 1;
        final int MAX_SMALL = 30;
        final int MIN_BIG = 31;
        final int MAX_BIG = 100;

        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < RED_PACKET_SMALL; i++) {
            randomNumbers.add(ThreadLocalRandom.current().nextInt(MIN_SMALL, MAX_SMALL + 1));
        }
        for (int i = 0; i < RED_PACKET_BIG; i++) {
            randomNumbers.add(ThreadLocalRandom.current().nextInt(MIN_BIG, MAX_BIG + 1));
        }
        Collections.shuffle(randomNumbers);
        System.out.println("混合的" + randomNumbers);
        return randomNumbers;
    }
}

// 员工
