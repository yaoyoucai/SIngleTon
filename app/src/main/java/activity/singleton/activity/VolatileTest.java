package activity.singleton.activity;

/**
 * Created by 25110 on 2017/5/11.
 */

public class VolatileTest extends Thread{
    private volatile static boolean flag = false;
    public void run() {
        while (!flag){

        };
        System.out.println("停止了");
    }

    public static void main(String[] args) throws Exception {

        new VolatileTest().start(); //sleep的目的是等待线程启动完毕,也就是说进入run的无限循环体了

        Thread.sleep(100);
        flag = true;
    }
}
