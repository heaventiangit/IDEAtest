package collection;

/**
 * 自定义实现一个 ArrayList
 * @author heavenTian
 */
public class MyArrayList<E> {

    private Object[] elementData;
    private int size;

    private static final int DEFALT_CAPACITY = 10;

    public MyArrayList(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public MyArrayList(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){

        //判断数组是否满了，需要扩容吗
        if (size == elementData.length){

            //数组的扩容操作
            Object[] newArray = new Object[elementData.length + (elementData.length>>1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }

        elementData[size++] = element;
    }

    public E get(int index){

        checkRange(index);
        return (E)elementData[index];
    }

    public void set(E element, int index){

        checkRange(index);
        elementData[index] = element;
    }

    public void checkRange(int index){

        if (index<0 || index>(size-1)){
            throw new RuntimeException("索引：" + index + "不合法！");
        }
    }

    public void remove(E element){

        boolean flag = true;
        for (int i = 0; i < size; i++){
            if (element.equals(elementData[i])){
                remove(i);
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("没有找到！");
    }

    public void remove(int index){
        checkRange(index);

        int numMoved = elementData.length - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);

        elementData[--size] = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0?true:false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(elementData[i]);
            if (i == (size-1)){
                break;
            }
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {

        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("aa");
        myArrayList.add("bb");
        for (int i = 1; i < 30; i++){
            myArrayList.add("哈哈" + i);
        }
        System.out.println(myArrayList);
        System.out.println(myArrayList.get(2));
        myArrayList.set("嘻嘻", 3);
        System.out.println(myArrayList);
        myArrayList.remove("哈哈99");
        System.out.println(myArrayList);
        System.out.println(myArrayList.isEmpty());
        System.out.println(myArrayList.size());
    }
}
