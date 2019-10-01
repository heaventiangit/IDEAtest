public class TestException {

    public static void main(String[] args) {

        try {
            int a = 4 / 0;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("算数异常");
        }
    }
}
