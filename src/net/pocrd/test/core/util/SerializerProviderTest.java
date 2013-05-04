package net.pocrd.test.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import net.pocrd.define.ConstField;
import net.pocrd.test.core.util.TestObj.Test_Obj;
import net.pocrd.test.core.util.TestString.Test_String;
import net.pocrd.util.SerializerProvider;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

public class SerializerProviderTest {

    @Test
    public void testXml() {
        Test_Obj.Builder builder = Test_Obj.newBuilder();
//        builder.setB(true);
//        builder.addBs(true);
//        builder.addBs(false);
//        builder.addBs(true);
//        builder.addBs(false);
//        
//        builder.setD(1.234567D);
//        builder.addDs(1.23D);
//        builder.addDs(1.234D);
//        builder.addDs(1.2345D);
//        
//        builder.setF(1.234567F);
//        builder.addFs(1.23F);
//        builder.addFs(1.234F);
//        builder.addFs(1.2345F);
//        
//        builder.setI(1);
//        builder.addIs(2);
//        builder.addIs(3);
//        builder.addIs(4);
//        
//        builder.setL(123456789L);
//        builder.addLs(123456789L);
//        builder.addLs(1234567890L);
//        builder.addLs(9876543210L);
//        
        builder.setS("hello");
//        builder.addSs("hello");
//        builder.addSs("<![CDATA[<xml>]]>");
//        builder.addSs("!");
//        
//        Test_String.Builder ts = Test_String.newBuilder();
//        ts.setStr("hello world!");
//        builder.setSo(ts.build());
//        builder.addSos(ts.build());
//        builder.addSos(ts.build());
//        builder.addSos(ts.build());
        
        //builder.setAnother(builder.build());
        
        Test_Obj obj = builder.build();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        SerializerProvider.getSerializer(Test_Obj.class).toXml(builder.build(), out1, true);
        System.out.println(new String(out1.toByteArray(), ConstField.UTF8));
        
        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        try {
            Test_Obj obj1 = builder.build();
            obj1.writeTo(out2);
            Test_Obj obj2 = Test_Obj.newBuilder().mergeFrom(new ByteArrayInputStream(out2.toByteArray())).build();
            assertEquals(obj1, obj2);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        
    }
}