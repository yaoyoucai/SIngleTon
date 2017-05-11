package activity.singleton.activity;

/**
 * Created by 25110 on 2017/5/11.
 */

public class SingleTon {
    private volatile static SingleTon sSingleTon;

    private SingleTon() {
        //防止通过反射的方式获取实例
        if (sSingleTon != null) {
            throw new RuntimeException("只能通过getInstance的方法获取当前类的实例");
        }
    }

    public static SingleTon getInstance() {
        if (sSingleTon == null) {
            synchronized (SingleTon.class) {
                if (sSingleTon == null) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sSingleTon = new SingleTon();
                }
            }

        }

        return sSingleTon;
    }
}

