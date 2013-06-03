package net.pocrd.test.clientGen;

import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class ClientCodeGenerator {
    public static void main(String[] args) {
        HttpClient client = getClient();
        HttpGet get = new HttpGet("http://localhost:8080/info.api");
        try {
            HttpResponse resp = client.execute(get);
            String str = EntityUtils.toString(resp.getEntity());
            InputStream xslt = ClientCodeGenerator.class.getClassLoader().getResourceAsStream("java.xslt");
            TransformerFactory f = TransformerFactory.newInstance();
            Transformer trans = f.newTransformer(new StreamSource(xslt));
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.getConnectionManager().shutdown();
        }
    }

    public static HttpClient getClient() {
        HttpClient client = new DefaultHttpClient();
        HttpParams p = client.getParams();
        p.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        p.setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);
        p.setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
        p.setParameter(CoreProtocolPNames.USER_AGENT, "net.pocrd.autogen");
        return client;
    }
}
