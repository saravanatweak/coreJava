package DesignPatterns.Creational.AbstractFactory;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

/**
 * Created by SaravanaWork on 21-11-2017.
 */
public class DocumentBuilderAPI {

    /*The DocumentBuilderFactory itself is an AbstractFactory. The DocumentBuilder is a factory, and then the document itself is the concrete class that is created from those factories. The document is actually an interface, and the factory chooses an implementation of that concrete class to return to the end user or the client. Let's look at a live example of this code. */
    public static void main (String args[]) throws Exception {

        String xml = "<document><body><stock>AAPL</stock></body></document>";
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());

        //The AbstractFactory in this example is the DocumentBuilderFactory. Now the reason it's an AbstractFactory is because we don't know what the underlying implementation of this is, nor do we know what the underlying implementation of the factory is when we get it. All we know is that we get our document and can eventually run and use that document.

        DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder factory = abstractFactory.newDocumentBuilder();
        Document doc = factory.parse(bais);

        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        //o/p:Root element :document

        System.out.println(abstractFactory.getClass());
        //o/p: class com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl

        System.out.println(factory.getClass());
        //o/p: class com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl

        /*but you can swap out this implementation by switching up a command line parameter that tells it to use a different library. Most people are happy with what the default implementation of it is, which is the apache xerces implementation, but that's why this is an AbstractFactory  We know nothing about what's going on from a client perspective of which implementation is chosen, and we don't care what factory's returning as well. All we care is that we get our document and it's usable. So all of those hideous details of creating that are hidden from us, but we can swap them out if we need to. */

        /*Now, as I've mentioned a couple of times now, the xerces and XML APIs are more of a framework for parsing XML documents, and that's why this is dumping out that code as part of a framework, and it's chosen for us under the hood*/

    }
}