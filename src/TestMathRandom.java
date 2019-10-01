public class TestMathRandom {
    static double b = Math.random();

    public static void main(String[] args) {
        int a = 6;
        System.out.println(b);
        System.out.println(a);
        System.out.println(a * b);
        System.out.println((int)(a * b)+1);
        System.out.println(new TestMathRandom() instanceof Object);
    }
}
