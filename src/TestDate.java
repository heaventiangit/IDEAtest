import java.util.Date;

/**
 * 测试 Date 类的常见方法
 * @author heavenTian
 */
public class TestDate {

    public static void main(String[] args) {

        Date date = new Date(2000);
        System.out.println(date);

        System.out.println(date.getTime());

        Date date1 = new Date();

        System.out.println(date1.getTime());
    }
}
