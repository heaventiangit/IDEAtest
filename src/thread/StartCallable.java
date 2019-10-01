package thread;

import java.util.concurrent.*;

/**
 * 通过实现 Callable 接口来实现多线程（需要重写 run() 方法）
 */
public class StartCallable implements Callable<Integer> {

    /**
     * 线程的入口
     */
    @Override
    public Integer call() {
        Integer m = 0;
        for (int i = 1; i < 20; i++){
            System.out.println(i);
            m++;
        }
        System.out.println(Thread.currentThread().getName());
        return m;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建执行服务:
        ExecutorService ser= Executors.newFixedThreadPool(1);
        //提交执行:
        Future<Integer> result1 =ser.submit(new StartCallable()) ;
        //获取结果:
        int r1 =result1.get();
        System.out.println(Thread.currentThread().getName()+"执行结果为："+r1);
        //关闭服务:
        ser.shutdownNow();

    }
}
