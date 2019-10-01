/**
 * 测试字符串的常用方法
 * @author heavenTian
 */
public class TestString {

    public static void main(String[] args) {

        String s1 = "12345678";
        String s2 = "abcdefgh";
        System.out.println(s1.charAt(3));
        System.out.println(s2.charAt(3));
        System.out.println(s1.replace("6", "x"));
        System.out.println(s1.substring(3, 7));
        System.out.println(s2.toUpperCase());
    }
}
