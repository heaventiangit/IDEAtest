package collection;

/**
 * 自定义一个链表
 * @author heavenTian
 */
public class MyLinkedList<E> {

    private Node first;
    private Node last;
    private int size;

    public void add(E element){

        Node node = new Node(element);

        if (size == 0){

            first = node;
            last = node;
        }else {

            node.setPrevious(last);
            last.setNext(node);

            last = node;
        }
        size++;
    }

    public E get(int index){
        checkRange(index);

        Node n = getNode(index);


        return (E) n.getElement();
    }

    public void remove(int index){
        checkRange(index);

        Node temp = getNode(index);
        System.out.println(temp.getElement());

        if (temp != null){

            Node up = temp.getPrevious();
            Node down = temp.getNext();
            if (up != null){
                up.setNext(down);
            }else {
                first = down;
            }
            if (down != null){
                down.setPrevious(up);
            }else {
                last = up;
            }
        }
        size--;
    }

    public void add(int index, E element){

        Node n = getNode(index);
        Node newNode = new Node(element);
        if (n != null){
            Node up = n.getPrevious();
            if (up != null){
                up.setNext(newNode);
                newNode.setPrevious(up);
            }else {
                first = newNode;
            }
            newNode.setNext(n);
            n.setPrevious(newNode);
        }
        size++;
    }

    private Node getNode(int index){

        Node n = null;
        if (index <= (size>>1)){ //size>>1相当于除以2

            n = first;
            for (int i = 0; i < index; i++){
                n = n.getNext();
            }
        }else{

            n = last;
            for (int i = size-1; i > index; i--){
                n = n.getPrevious();
            }
        }
        return n;
    }

    private void checkRange(int index){

        if (index<0 || index>(size-1)){
            throw new RuntimeException("索引：" + index + "不合法！");
        }
    }

    @Override
    public String toString() {

        Node n = first;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 1;
        while (true){

            sb.append(n.getElement());
            if (i == size)
                break;
            sb.append(", ");
            n = n.getNext();
            i++;
        }
        sb.append("]");
        return sb.toString();
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {

        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.add("aa");
        linkedList.add("bb");
        linkedList.add("cc");
        linkedList.add("dd");
        linkedList.add("ee");
        linkedList.add("ff");
        System.out.println(linkedList);
        linkedList.add(4, "你好");
        linkedList.add(0, "你好啊");
        System.out.println(linkedList);
        System.out.println(linkedList.get(4));
    }
}
