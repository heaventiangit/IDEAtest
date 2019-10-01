package IO;

import java.io.UnsupportedEncodingException;

/**
 * 解码：字节 -->字符串
 */
public class ContentDecode {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String s = "哈哈嘻嘻";
        byte[] datas = s.getBytes("utf-8");
        System.out.println(datas.length);

        s = new String(datas, 0, datas.length, "utf8");
        System.out.println(s);
    }
}
