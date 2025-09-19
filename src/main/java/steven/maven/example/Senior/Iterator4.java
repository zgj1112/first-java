package steven.maven.example.Senior;
// 引入 ArrayList 和 Iterator 类

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator4 {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");

        // 获取迭代器
        Iterator<String> it = sites.iterator();
        // 输出集合中的第一个元素
        System.out.println(it.next());
    }
}

// hasNext()	是否还有下一个元素（返回 true/false）
// next()	获取下一个元素（指针向前移动）
// remove()	删除当前迭代到的元素（⚠️迭代过程中唯一安全删除方式）