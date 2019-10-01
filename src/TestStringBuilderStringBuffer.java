/**
 * 测试StringBuilder、StringBuffer
 */
public class TestStringBuilderStringBuffer {

    public static void main(String[] args) {

//        StringBuilder stringBuiler = new StringBuilder("abcdefg");
//
//        System.out.println(Integer.toHexString(stringBuiler.hashCode()));
//        System.out.println(stringBuiler);
//
//        stringBuiler.setCharAt(2, 'H');
//        System.out.println(Integer.toHexString(stringBuiler.hashCode()));
//        System.out.println(stringBuiler);

        String s = String.valueOf("abcdefghijklmnopqrstuvwxyz");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++){

            sb.append((char) ('a'+i));
        }

        System.out.println(s);
        System.out.println(sb);


        sb.reverse();
        System.out.println(sb);

        sb.setCharAt(4, '好');
        System.out.println(sb);

        sb.insert(0, '天').insert(4, '剑');
        System.out.println(sb);
        System.out.println(sb.insert(8, '客'));

        sb.delete(0, 4);
        System.out.println(sb);

    }
}
