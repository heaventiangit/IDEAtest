package IO;

/**
 * 编码：字符串 -->字节
 * @author heavenTian
 */
public class ContentEncode {

    public static void main(String[] args) {

        String s = "哈哈嘻嘻";
        byte[] datas = s.getBytes();
        System.out.println(datas.length);
    }
}
