package thread;

/**
 * 通过实现 Runnable 接口来实现多线程（需要重写 run() 方法）
 */
public class StartRunnable extends Thread {

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
        StartRunnable runnable = new StartRunnable();
        new Thread(runnable).start();

        for (int i = 1; i < 20; i++){
            System.out.println("主线程："+i);
        }
    }
}
