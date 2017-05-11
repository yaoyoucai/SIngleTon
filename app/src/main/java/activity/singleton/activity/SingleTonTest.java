package activity.singleton.activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 25110 on 2017/5/11.
 */

public class SingleTonTest {

    public static void main(String[] args) {
        mutiThreadTest();
//        reflectTest();
    }

    /**
     * 反射测试
     */
    private static void reflectTest() {
        SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = null;

        try {
            Class clazz = SingleTon.class;
            Constructor<SingleTon> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleTon2 = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("singleTon1,hashCode:" + singleTon1.hashCode());
        System.out.println("singleTon2,hashCode:" + singleTon2.hashCode());
    }

    private static void mutiThreadTest() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                SingleTon singleTon1 = SingleTon.getInstance();
                System.out.println("singleTon1,hashCode:" + singleTon1.hashCode());
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                SingleTon singleTon2 = SingleTon.getInstance();
                System.out.println("singleTon2,hashCode:" + singleTon2.hashCode());
            }
        };

        thread1.start();
        thread2.start();
    }


}
