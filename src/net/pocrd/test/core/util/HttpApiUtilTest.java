package net.pocrd.test.core.util;

import java.lang.reflect.Method;

import net.pocrd.util.HttpApiUtil;

import org.junit.Test;

public class HttpApiUtilTest {
    public static class TEST {
        public Object add(int i1, int i2) {
            return i1 + i2;
        }
    }

    @Test
    public void test() {
        try {
            Method method = TEST.class.getDeclaredMethods()[0];
            System.out.println("value:" + HttpApiUtil.getApiExecuter("test.Test", method).execute(new String[] { "123", "456" }));
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
