package steven.maven.example.Example;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class RedRainDemo {
    public static void main(String[] args) {
        System.out.println("红包雨");
        List<Integer> redPackets = getRedPacket();
        for (int i = 0; i < 100; i++) {
            new PropleGetRedPacket(redPackets, "员工" + i).start();
        }
    }

    public static List<Integer> getRedPacket() {
        // 相关变量
        final int RED_PACKET_TOTALL = 200; // 红包总数
        final int RED_PACKET_SMALL = (int) (RED_PACKET_TOTALL * 0.8);// 0-30的红包
        final int RED_PACKET_BIG = (int) (RED_PACKET_TOTALL * 0.2); // 31-100的红包

        final int MIN_SMALL = 1;
        final int MAX_SMALL = 30;

        final int MIN_BIG = 31;
        final int MAX_BIG = 100;

        // 核心数组
        List<Integer> randomNumbers = new ArrayList<>();
        // 小红包填充
        for (int i = 0; i < RED_PACKET_SMALL; i++) {
            // randomNumbers[i] = ThreadLocalRandom.current().nextInt(MIN_SMALL, MAX_SMALL + 1);
            randomNumbers.add(ThreadLocalRandom.current().nextInt(MIN_SMALL, MAX_SMALL + 1));
        }
        // 大红包填充
        for (int i = RED_PACKET_SMALL; i < RED_PACKET_TOTALL; i++) {
            randomNumbers.add(ThreadLocalRandom.current().nextInt(MIN_BIG, MAX_BIG + 1));
        }

        // 分割成小红包列表和大红包列表
        // List<Integer> smallList = new ArrayList<>(randomNumbers.subList(0, RED_PACKET_SMALL));
        // List<Integer> bigList = new ArrayList<>(randomNumbers.subList(RED_PACKET_SMALL, RED_PACKET_TOTALL));
        // System.out.print("小的" + smallList);
        // System.out.println();
        // System.out.print("大的" + bigList);
        // System.out.println();
        // int[] SMALL_Arr = Arrays.copyOfRange(randomNumbers, 0, RED_PACKET_SMALL);
        // int[] BIG_Arr = Arrays.copyOfRange(randomNumbers, RED_PACKET_SMALL, RED_PACKET_TOTALL);

        // 打乱顺序，让小红包和大红包混合
        Collections.shuffle(randomNumbers);

        System.out.print("混合的" + randomNumbers);
        return randomNumbers;
    }
}

// 生成一百个员工的线程对红包进行抢夺
class PropleGetRedPacket extends Thread {
    private final List<Integer> redpacket;
    private static final double CONTINUE_PROBABILITY = 0.5; // 50%概率继续抢
    private static final int MAX_ATTEMPTS = 4; // 每个员工最多抢3次

    public PropleGetRedPacket(List<Integer> redpacket, String name) {
        super(name);
        this.redpacket = redpacket;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        // synchronized (redpacket) {
        //     if (!redpacket.isEmpty()) {
        //         // int money = redpacket.removeFirst();
        //         // System.out.println(getName()+"抢到红包"+money);
        //         int index = ThreadLocalRandom.current().nextInt(redpacket.size());
        //         int money = redpacket.remove(index); // 随机位置删除
        //         System.out.println(name + " 抢到红包 " + money);
        //     }
        // }

        int attempts = 0;
        while (attempts < MAX_ATTEMPTS && !redpacket.isEmpty()) {
            synchronized (redpacket) {
                if (!redpacket.isEmpty()) {
                    int index = ThreadLocalRandom.current().nextInt(redpacket.size());
                    int money = redpacket.remove(index);
                    System.out.println(name + " 抢到红包 " + money);

                    System.out.println("第 " + (200 - redpacket.size()) + " 个红包");
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
            // 以50%概率继续抢，否则退出
            if (ThreadLocalRandom.current().nextDouble() > CONTINUE_PROBABILITY) {
                break;
            }
        }
    }
}
