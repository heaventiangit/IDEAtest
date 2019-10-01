import java.util.Scanner;

/**
 * 测试控制台输入交互
 */
public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字：");
        String name = scanner.nextLine();
        System.out.println("请输入爱好：");
        String favor = scanner.nextLine();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();

        System.out.println("--------------------------");
        System.out.println("您的名字是：" + name + "\n爱好是：" + favor + "\n来到地球天数是：" + age * 365);
    }
}
