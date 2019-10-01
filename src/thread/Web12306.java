package thread;

/**
 * 资源共享
 */
public class Web12306 implements Runnable {

    //票数
    private int ticketNums = 99;

    @Override
    public void run() {

        int i = 0;
        while (true){
            if (ticketNums == 0){
                break;
            }
            i++;
            ticketNums--;
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums);
        }
        System.out.println(Thread.currentThread().getName()+"拿到了 " + i + " 张票！");
    }

    public static void main(String[] args) {

        Web12306 web12306 = new Web12306();
        new Thread(web12306, "线程1").start();
        new Thread(web12306, "线程2").start();
        new Thread(web12306, "线程3").start();
    }
}
