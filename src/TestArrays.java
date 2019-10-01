import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        //静态初始化
        int [] a = new int[]{1,2,3};
        int [] b = {3,4,5};

        String[] s = {"3","76","23","34","1","4"};
        int[] ints = {324,1,6,34,12};

        Arrays.sort(ints);

        System.out.println(Arrays.toString(ints));

        //默认初始化
        int [] m = new int[4];
        User[] users = new User[5];

        //动态初始化
        users[0] = new User(23, "李四");
        users[1] = new User(64, "张三");

        for (int i = 0; i < users.length; i++){
            System.out.println(users[i]);
        }
    }
}
