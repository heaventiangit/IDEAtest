package IO;

import java.io.*;

/**
 * 随机读取和写入流：RandomAccessFile
 */
public class RandomAccessFIleTest {

    /**
     * 指定起始位置，读取剩余所有内容
     * @throws IOException
     */
    public static void test1() throws IOException {

        RandomAccessFile random = new RandomAccessFile("abc.txt", "r");
//        InputStreamReader isr = new InputStreamReader(new RandomAccessFile("abc.txt", "r"));
        //随机读取
        random.seek(2); //读取 索引2 以后的的字符

        //读取
        byte[] datas = new byte[1024];
        int len = -1;
        while ((len=random.read(datas)) != -1){
            System.out.println(new String(datas, 0, len));
        }
    }

    /**
     * 指定第 i 块的起始位置和实际长度
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    public static void split(int i, int beginPos, int actualSize) throws IOException {

        RandomAccessFile random = new RandomAccessFile("abc.txt", "r");

        //起始位置
//        int beginPos = 2+1026;
        //实际大小
//        int actualSize = 1026;
        //随机读取
        random.seek(beginPos); //读取 索引beginPos 以后的的字符

        //读取
        byte[] datas = new byte[1024];
        int len = -1;
        while ((len=random.read(datas)) != -1){

            if (actualSize > len){
                System.out.println(new String(datas, 0, len));
                actualSize-=len;
            } else {
                System.out.println(new String(datas, 0, actualSize));
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {

//        test2();
        //分多少块
        File file = new File("abc.txt");
        //总长度
        long len = file.length();
        //每块大小
        int blockSize = 1024;
        //多少块
        int size = (int) Math.ceil(len*1.0/blockSize);
        System.out.println(size);

        //起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int) (blockSize>len?len:blockSize);
        for (int i = 0; i < size; i++){
            beginPos = i * blockSize;
            if (i == (size-1)){ //最后一块
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len-=blockSize; //剩余量
            }
            System.out.println("第"+i+"块"+"从"+beginPos+"开始 -->"+"读取"+actualSize);
            split(i, beginPos, actualSize);
        }
    }
}
