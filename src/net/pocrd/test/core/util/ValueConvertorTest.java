package net.pocrd.test.core.util;

import static org.junit.Assert.assertEquals;
import net.pocrd.entity.CallerInfo;
import net.pocrd.util.ValueConvertor;

import org.junit.Test;

public class ValueConvertorTest {
    public static class A {
        public String     name;
        public int        age;
        public long       expire;
        public CallerInfo caller;
    }

    public static class B {
        public String     name;
        public int        age;
        public long       expire;
        public CallerInfo caller;
    }

    @Test
    public void testValueConvertor() {
        A a = new A();
        B b = new B();
        b.name = "123";
        b.age = 456;
        b.expire = Long.MAX_VALUE;
        b.caller = new CallerInfo();
        b.caller.appid = 123;
        b.caller.expire = Long.MIN_VALUE;
        b.caller.groups = new String[] { "1", "3", "5" };
        b.caller.key = "aaa";
        b.caller.level = 999;
        b.caller.securityLevel = 333;
        b.caller.sn = Long.MAX_VALUE;
        b.caller.uid = Long.MAX_VALUE;
        ValueConvertor.evaluate(a, b);
        assertEquals(a.name, b.name);
        assertEquals(a.age, b.age);
        assertEquals(a.expire, b.expire);
        assertEquals(a.caller.appid, b.caller.appid);
        assertEquals(a.caller.expire, b.caller.expire);
        org.junit.Assert.assertArrayEquals(a.caller.groups, b.caller.groups);
        assertEquals(a.caller.key, b.caller.key);
        assertEquals(a.caller.level, b.caller.level);
        assertEquals(a.caller.securityLevel, b.caller.securityLevel);
        assertEquals(a.caller.sn, b.caller.sn);
        assertEquals(a.caller.uid, b.caller.uid);
    }

}
