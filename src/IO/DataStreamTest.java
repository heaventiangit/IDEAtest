package IO;

import java.io.*;

/**
 * 数据流：
 * 1、先写出，后读取
 * 2、读取的顺序与写出保持一致
 *      DataInputStream
 *      DataOutputStream
 */
public class DataStreamTest {

    public static void main(String[] args) throws IOException {

        //写出
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));

        //操作数据类型 + 数据
        dos.writeUTF("蒸汽与机械的浪潮中，谁能触及非凡？");
        dos.writeInt(99);
        dos.writeBoolean(false);
        dos.writeChar('b');
        dos.flush();
        byte[] datas = bos.toByteArray();

        //读取
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
    }
}
