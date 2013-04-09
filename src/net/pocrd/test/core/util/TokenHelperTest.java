package net.pocrd.test.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import net.pocrd.entity.CallerInfo;
import net.pocrd.util.AesHelper;
import net.pocrd.util.Base64Util;
import net.pocrd.util.TokenHelper;

import org.junit.Test;

public class TokenHelperTest {

    @Test
    public void testTokenHelper() {
        String tokenPwd = Base64Util.encodeToString(AesHelper.randomKey(256));
        TokenHelper th = new TokenHelper(tokenPwd);
        CallerInfo ci = new CallerInfo();
        ci.appid = 123456;
        ci.expire = 987654321;
        ci.groups = new String[] { "TEST", "VIP" };
        ci.key = "1111111";
        ci.level = 10;
        ci.securityLevel = 9;
        ci.sn = 22222222222222L;
        ci.uid = 33333333333333L;
        String token = th.generateToken(ci);
        CallerInfo caller = th.parse(token);
        assertEquals(ci.appid, caller.appid);
        assertEquals(ci.expire, caller.expire);
        assertNull(caller.groups);
        assertNull(caller.key);
        assertTrue(caller.level > 0);
        assertTrue(caller.securityLevel > 0);
        assertTrue(caller.sn > 0);
        assertTrue(caller.uid > 0);
    }

    @Test
    public void testMultithread() {
        String tokenPwd = Base64Util.encodeToString(AesHelper.randomKey(256));
        final TokenHelper th = new TokenHelper(tokenPwd);
        final CallerInfo ci = new CallerInfo();
        ci.appid = 123456;
        ci.expire = 987654321;
        ci.groups = new String[] { "TEST", "VIP" };
        ci.key = "1111111";
        ci.level = 10;
        ci.securityLevel = 9;
        ci.sn = 22222222222222L;
        ci.uid = 33333333333333L;

        MultithreadTestHelper.runInMultithread(5, 10000, new Runnable() {

            @Override
            public void run() {
                String token = th.generateToken(ci);
                CallerInfo caller = th.parse(token);
                assertEquals(ci.appid, caller.appid);
                assertEquals(ci.expire, caller.expire);
                assertNull(caller.groups);
                assertNull(caller.key);
                assertTrue(caller.level > 0);
                assertTrue(caller.securityLevel > 0);
                assertTrue(caller.sn > 0);
                assertTrue(caller.uid > 0);
            }
        });
    }
}
