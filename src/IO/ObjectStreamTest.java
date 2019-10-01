package IO;

import java.io.*;

/**
 * 对象流
 * 1、先写出，后读取
 * 2、读取的顺序与写出保持一致
 * 3、不是所有的对象都可以序列化
 *      ObjectInputStream
 *      ObjectOutputStream
 */
public class ObjectStreamTest {

    //写入到字节数组中
    public static void outIn() throws IOException, ClassNotFoundException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        //操作数据类型 + 数据
        oos.writeUTF("蒸汽与机械的浪潮中，谁能触及非凡？");
        oos.writeInt(99);
        oos.writeBoolean(false);
        oos.writeChar('b');
        //可以加入对象
        oos.writeObject("这是一个 String 对象");
        oos.flush();

        byte[] datas = bos.toByteArray();
        //读取类容
        ByteArrayInputStream bis = new ByteArrayInputStream(datas);
        ObjectInputStream ois = new ObjectInputStream(bis);
        String s = ois.readUTF();
        int age = ois.readInt();
        boolean b = ois.readBoolean();
        char c = ois.readChar();
        String s1 = (String)ois.readObject();
        System.out.println(s);
        System.out.println(age);
        System.out.println(b);
        System.out.println(c);
        System.out.println(s1);
    }

    //写入到文件中
    public static void outIn2() throws IOException, ClassNotFoundException {


        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));

        //操作数据类型 + 数据
        oos.writeUTF("蒸汽与机械的浪潮中，谁能触及非凡？");
        oos.writeInt(99);
        oos.writeBoolean(false);
        oos.writeChar('b');
        //可以加入对象
        oos.writeObject("这是一个 String 对象");
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
        String s = ois.readUTF();
        int age = ois.readInt();
        boolean b = ois.readBoolean();
        char c = ois.readChar();
        String s1 = (String)ois.readObject();
        System.out.println(s);
        System.out.println(age);
        System.out.println(b);
        System.out.println(c);
        System.out.println(s1);
        ois.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        outIn();
        outIn2();
    }
}
