package steven.maven.example.Base;

import java.io.*;
import java.nio.charset.StandardCharsets;

// java.io 包是 Java 标准库中的一个核心包，提供了用于系统输入和输出的类，它包含了处理数据流（字节流和字符流）、文件读写、序列化以及数据格式化的工具。
// java.io 是处理文件操作、流操作以及低级别 IO 操作的基础包。
// java.io 包中的流支持很多种格式，比如：基本类型、对象、本地化字符集等等。
public class StreamFile9 {
    public static void main(String[] args) throws IOException {
        StreamFile9 StreamFileFun = new StreamFile9();
        // StreamFileFun.bufferReadFun();
        StreamFileFun.InputOutStream();
        // StreamFileFun.breakFun();
        // StreamFileFun.continueFun();
    }

    //使用 BufferedReader 在控制台读取字符
    public void bufferReadFun() throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
    // 包含异常捕获 throws IOException
    public void InputOutStream() throws IOException {
        FileInputStream fip = getFileInputStream();
        // 构建FileInputStream对象

        InputStreamReader reader = new InputStreamReader(fip, StandardCharsets.UTF_8);
        // 构建InputStreamReader对象,编码与写入相同

        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // 转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        // 关闭读取流

        fip.close();
        // 关闭输入流,释放系统资源
    }

    // 包含异常捕获throws IOException
    private static FileInputStream getFileInputStream() throws IOException {
        File f = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(f);
        // 构建FileOutputStream对象,文件不存在会自动新建

        OutputStreamWriter writer = new OutputStreamWriter(fop, StandardCharsets.UTF_8);
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

        writer.append("中文输入");
        // 写入到缓冲区

        writer.append("\r\n");
        // 换行

        writer.append("English");
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

        writer.close();
        // 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

        fop.close();
        // 关闭输出流,释放系统资源

        return new FileInputStream(f);
    }
}
