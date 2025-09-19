package steven.maven.example.Senior;

import java.util.HashSet;
// 引入 HashMap 类
import java.util.HashMap;
import java.util.Map;

public class Hash3 {
    public static void main(String[] args) {
        // HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。
        // HashSet 允许有 null 值。
        // HashSet 是无序的，即不会记录插入的顺序。
        // HashSet 不是线程安全的， 如果多个线程尝试同时修改 HashSet，则最终结果是不确定的。 您必须在多线程访问时显式同步对 HashSet 的并发访问。
        // HashSet 实现了 Set 接口。
        HashSet<String> HashSetVal = new HashSet<>();
        HashSetVal.add("Google");
        HashSetVal.add("Runoob");
        // HashSetVal.add("Runoob");  // 重复的元素不会被添加
        System.out.println(HashSetVal);


        // HashMap 是一个散列表，它存储的内容是键值对(key-value)映射。
        // HashMap 实现了 Map 接口，根据键的 HashCode 值存储数据，具有很快的访问速度，最多允许一条记录的键为 null，不支持线程同步。
        // HashMap 是无序的，即不会记录插入的顺序。
        // HashMap 继承于AbstractMap，实现了 Map、Cloneable、java.io.Serializable 接口。
        HashMap<Integer, String> HashMapVal = new HashMap<>();
        // 添加键值对
        HashMapVal.put(1, "Google");
        HashMapVal.put(2, "Runoob");
        System.out.println(HashMapVal);

        // 返回所有 value 值
        for (String value : HashMapVal.values()) {
            // 输出每一个value
            System.out.print(value + ", ");
        }

        System.out.println("test");
        Hash3 test = new Hash3();
        test.CustomLoadFactor();

//        CustomLoadFactor.main( null);
        // clear()	删除 hashMap 中的所有键/值对
        // clone()	复制一份 hashMap
        // isEmpty()	判断 hashMap 是否为空
        // size()	计算 hashMap 中键/值对的数量
        // put()	将键/值对添加到 hashMap 中
        // putAll()	将所有键/值对添加到 hashMap 中
        // putIfAbsent()	如果 hashMap 中不存在指定的键，则将指定的键/值对插入到 hashMap 中。
        // remove()	删除 hashMap 中指定键 key 的映射关系
        // containsKey()	检查 hashMap 中是否存在指定的 key 对应的映射关系。
        // containsValue()	检查 hashMap 中是否存在指定的 value 对应的映射关系。
        // replace()	替换 hashMap 中是指定的 key 对应的 value。
        // replaceAll()	将 hashMap 中的所有映射关系替换成给定的函数所执行的结果。
        // get()	获取指定 key 对应对 value
        // getOrDefault()	获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值
        // forEach()	对 hashMap 中的每个映射执行指定的操作。
        // entrySet()	返回 hashMap 中所有映射项的集合集合视图。
        // keySet()	返回 hashMap 中所有 key 组成的集合视图。
        // values()	返回 hashMap 中存在的所有 value 值。
        // merge()	添加键值对到 hashMap 中
        // compute()	对 hashMap 中指定 key 的值进行重新计算
        // computeIfAbsent()	对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hashMap 中
        // computeIfPresent()	对 hashMap 中指定 key 的值进行重新计算，前提是该 key 存在于 hashMap 中。
    }

    //负载因子
    public void CustomLoadFactor() {
        // 创建一个 HashMap：初始容量为 16，负载因子为 0.5（比默认的 0.75 更保守） 第8个开始扩容
        Map<String, String> map = new HashMap<>(16, 0.5f);

        // 添加数据
        map.put("apple", "苹果");
        map.put("banana", "香蕉");
        map.put("orange", "橘子");

        // 遍历输出
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("当前元素个数: " + map.size());
    }
}
