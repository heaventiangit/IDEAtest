/**
 * 测试泛型
 * @author heavenTian
 */
public class TestGeneric {

    public static void main(String[] args) {

        MyCollection<String> myCollection = new MyCollection<>();

        myCollection.set("haha", 0);
        myCollection.set("xixi", 1);
        myCollection.set("你好", 2);

        System.out.println(myCollection.get(0));
        System.out.println(myCollection.get(2));
    }
}


class MyCollection<E> {

    Object[] s = new Object[7];

    public void set(E e, int index){
        s[index] = e;
    }

    public E get(int index){
        return (E) s[index];
    }

}
