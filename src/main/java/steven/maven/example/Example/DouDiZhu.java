package steven.maven.example.Example;

import java.util.*;
public class DouDiZhu {
    public static void main(String[] args) {
        start();
    }
    public static void start() {
        String[] poker = new String[54];
        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2",};

//
        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                poker[index++] = color + number;
            }
        }

        poker[index++] = "小王";
        poker[index] = "大王";


        List<String> pokerList = Arrays.asList(poker);  // 数组转列表（固定长度）
        Collections.shuffle(pokerList); // 洗牌
        System.out.println("第一次洗牌: " + Arrays.toString(poker));
        shuffleArray(poker);
        System.out.println("第二次洗牌: " + Arrays.toString(poker));

    }

    public static void shuffleArray(String[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // 交换元素
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
