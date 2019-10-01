/**
 * 数组Copy测试
 * @author heavenTian
 */
public class TestArrayCopy {

    public static void main(String[] args) {

        String[] s1 = {"AA", "BB", "CC", "DD", "EE"};
        String[] s2 = new String[8];

        System.arraycopy(s1, 2, s2, 3, 3);

        for (String s : s2){
            System.out.println(s);
        }
    }
}
