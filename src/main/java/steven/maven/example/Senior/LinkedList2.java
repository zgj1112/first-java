package steven.maven.example.Senior;
// 引入 LinkedList 类
import java.util.LinkedList;
// | 特性           | `ArrayList`        | `LinkedList`           |
//         | ------------ | ------------------ | ---------------------- |
//         | 底层结构         | 动态数组（连续内存）         | 双向链表                   |
//         | 查询效率（get）    | ✅ 快，O(1)           | ❌ 慢，O(n)，需要从头/尾遍历      |
//         | 插入效率（add）    | ✅ 尾部插入快（O(1），扩容除外） | ✅ 任意位置插入快（O(1) 若有节点指针） |
//         | 删除效率（remove） | ❌ 需要移动元素（O(n)）     | ✅ 快，O(1)               |
//         | 内存占用         | 较低，每个元素只占一个空间      | 较高，需要额外指针（前后指向）        |
//         | 是否线程安全       | ❌ 非线程安全            | ❌ 非线程安全                |
//         | 随机访问（索引）     | ✅ 非常快（数组直接取）       | ❌ 很慢（链表必须从头走）          |


public class LinkedList2 {
    public static void main(String[] args) {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.addFirst("Wiki");// 使用 addFirst() 在头部添加元素
        sites.addLast("Wiki");// 使用 addLast() 在尾部添加元素
        sites.removeFirst();// 使用 removeFirst() 移除头部元素
        sites.removeLast();        // 使用 removeLast() 移除尾部元素

        for (int size = sites.size(), i = 0; i < size; i++) {
            System.out.println(sites.get(i));
        }

        // ArrayList2.main(args);
    }
}

