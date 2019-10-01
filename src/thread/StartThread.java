package thread;

/**
 * 通过继承 Thread 类来实现多线程（需要重写 run() 方法）
 */
public class StartThread extends Thread {

    /**
     * 线程的入口
     */
    @Override
    public void run() {
        for (int i = 1; i < 20; i++){
            System.out.println("线程1："+i);
        }
    }

    public static void main(String[] args) {

        //启动线程
        StartThread thread = new StartThread();
        thread.start();

        for (int i = 1; i < 20; i++){
            System.out.println("主线程："+i);
        }
    }
}
