package net.pocrd.test.core.util;

import net.pocrd.util.SingletonUtil;
import org.junit.Test;

public class ConnectPoolTest {
    @Test
    public void testCommon(){
        System.out.println("使用传统方式：");
        MultithreadTestHelper.runInMultithread(5, 3, new Runnable() {
            @Override
            public void run() {
                try {
                    long start=System.currentTimeMillis();
                    SingletonUtil.getSingleton(TestDAO.class).testCommonConnect();
                    System.out.println("cost: "+(System.currentTimeMillis()-start));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    @Test
    public void testC3P0Pool(){
        System.out.println("使用C3P0方式：");
        MultithreadTestHelper.runInMultithread(5, 3, new Runnable() {
            @Override
            public void run() {
                try {
                    long start=System.currentTimeMillis();
                    SingletonUtil.getSingleton(TestDAO.class).testC3p0();
                    System.out.println("cost: "+(System.currentTimeMillis()-start));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    @Test
    public void testJDBCPool() {
        System.out.println("使用Tomcat JDBC pool方式：");
        MultithreadTestHelper.runInMultithread(5, 3, new Runnable() {
            @Override
            public void run() {
                try {
                    long start=System.currentTimeMillis();
                    SingletonUtil.getSingleton(TestDAO.class).testJDBC();
                    System.out.println("cost: "+(System.currentTimeMillis()-start));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
}
