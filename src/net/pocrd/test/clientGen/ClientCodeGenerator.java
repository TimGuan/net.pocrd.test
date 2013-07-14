package net.pocrd.test.clientGen;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            System.out.println(str);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("http://localhost:8080/info.api");
            XPath path = XPathFactory.newInstance().newXPath();
            NodeList nl = (NodeList)path.evaluate("//apiInfoList/apiInfo", doc, XPathConstants.NODESET);
            int len = nl.getLength();
            String outputPath = "./bin/java_request/";
            File folder = new File(outputPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            for (int i = 0; i < len; i++) {
                Element e = (Element)nl.item(i);
                String methodName = e.getElementsByTagName("methodName").item(0).getFirstChild().getNodeValue();
                int index = methodName.indexOf('.');
                methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1, index) + "_"
                        + methodName.substring(index + 1, index + 2).toUpperCase() + methodName.substring(index + 2);
                String fileName = outputPath + methodName + ".java";
                File source = new File(fileName);
                if (!source.exists()) {
                    source.createNewFile();
                }
                
                trans.transform(new DOMSource(e), new StreamResult(source));
            }
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
