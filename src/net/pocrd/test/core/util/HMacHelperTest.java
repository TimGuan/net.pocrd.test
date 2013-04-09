package net.pocrd.test.core.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import net.pocrd.util.HMacHelper;

import org.junit.Test;

/**
 * 测试结论，对于HMacHelper这种，绝大部分时间都是同一个密钥在工作， 但是需要在多线程访问时进行同步的辅助类，使用ThreadLocal为每一个 线程缓存一个实例可以避免进行锁操作
 * 
 * @author rendong
 */
public class HMacHelperTest {

    static {
        HMacHelper.setMacPwd("0123456789");
    }

    @Test
    public void testHMacHelper() {
        HMacHelper mac = HMacHelper.getInstance();
        assertNotNull(mac);
    }

    @Test
    public void testVerify() {
        HMacHelper mac1 = HMacHelper.getInstance();
        assertNotNull(mac1);
        HMacHelper mac2 = HMacHelper.getInstance();
        assertNotNull(mac2);
        assertArrayEquals(mac1.sign("11111111111111111111111111111".getBytes()), mac2.sign("11111111111111111111111111111".getBytes()));
    }

    @Test
    public void testMultiThread() {
        final HMacHelper mac = HMacHelper.getInstance();
        final byte[] result = mac.sign("11111111111111111111111111111".getBytes());
        long s = System.currentTimeMillis();
        Thread[] ts = new Thread[10];
        for (int k = 0; k < ts.length; k++) {
            ts[k] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 300000; i > 0; i--) {
                        HMacHelper m = HMacHelper.getInstance();
                        byte[] r = m.sign("11111111111111111111111111111".getBytes());
                        assertArrayEquals(result, r);
                    }
                }
            });
            ts[k].start();
        }
        for (int k = 0; k < ts.length; k++) {
            try {
                ts[k].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - s);
    }

    @Test
    public void testPerformance() {
        long s = System.currentTimeMillis();
        HMacHelper mac = HMacHelper.getInstance();
        for (int i = 3000000; i > 0; i--) {
            mac.sign("11111111111111111111111111111".getBytes());
        }
        System.out.println(System.currentTimeMillis() - s);
        s = System.currentTimeMillis();
        for (int i = 3000000; i > 0; i--) {

            HMacHelper m = HMacHelper.getInstance();

            m.sign("11111111111111111111111111111".getBytes());
        }
        System.out.println(System.currentTimeMillis() - s);
    }

}
