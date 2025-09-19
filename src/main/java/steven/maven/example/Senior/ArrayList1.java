package steven.maven.example.Senior;

import java.util.ArrayList;
import java.util.Collections; //用于排序

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<>();
        sites.add("Google");
        sites.add("Runoob");
//        sites.add("Taobao");
        sites.add("Weibo");

        System.out.println(sites.get(1));  // 访问第二个元素
        sites.set(2, "Wiki"); // 第一个参数为索引位置，第二个为要修改的值 增加
        sites.remove(1); // 删除第四个元素
        System.out.println(sites.size());//元素数量
        System.out.println(sites); //打印全部
        Collections.sort(sites);//排序

        //循环方式
        for (String site : sites) {
            System.out.println(site);
        }
        arrayTest();
    }

//    对比array和arraylist
    public static void arrayTest() {
        //数组
        int[] numbers = new int[5]; // 初始化一个长度为5的数组
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(numbers[0]); // 输出: 1

        //二维数组
        int[][] matrix = new int[2][3];
        // 也可以这样初始化：
        int[][] scores = {
                {90, 85, 80},
                {75, 88, 92}
        };
        for (int[] score : scores) {          // 行数
            for (int i : score) {   // 每一行的列数
                System.out.print(i + " ");
            }
            System.out.println();
        }


        ArrayList<Integer> list = new ArrayList<>(); // 初始化一个空的ArrayList
        list.add(1); // 添加元素
        list.add(2);
        System.out.println(list.getFirst()); // 输出: 1
    }

}

// add()	将元素插入到指定位置的 arraylist 中
// addAll()	添加集合中的所有元素到 arraylist 中
// clear()	删除 arraylist 中的所有元素
// clone()	复制一份 arraylist
// contains()	判断元素是否在 arraylist
// get()	通过索引值获取 arraylist 中的元素
// indexOf()	返回 arraylist 中元素的索引值
// removeAll()	删除存在于指定集合中的 arraylist 里的所有元素
// remove()	删除 arraylist 里的单个元素
// size()	返回 arraylist 里元素数量
// isEmpty()	判断 arraylist 是否为空
// subList()	截取部分 arraylist 的元素
// set()	替换 arraylist 中指定索引的元素
// sort()	对 arraylist 元素进行排序
// toArray()	将 arraylist 转换为数组
// toString()	将 arraylist 转换为字符串
// ensureCapacity()	设置指定容量大小的 arraylist
// lastIndexOf()	返回指定元素在 arraylist 中最后一次出现的位置
// retainAll()	保留 arraylist 中在指定集合中也存在的那些元素
// containsAll()	查看 arraylist 是否包含指定集合中的所有元素
// trimToSize()	将 arraylist 中的容量调整为数组中的元素个数
// removeRange()	删除 arraylist 中指定索引之间存在的元素
// replaceAll()	将给定的操作内容替换掉数组中每一个元素
// removeIf()	删除所有满足特定条件的 arraylist 元素
// forEach()	遍历 arraylist 中每一个元素并执行特定操作