package CoreJava.JavaUtil;


import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesWithXmlFormat {
    public static void main(String args[]) throws Exception {
        //Stroing content into Xml
        Properties pros = new Properties();
        pros.setProperty("name","Saravanakumar");
        pros.setProperty("email","saravanakumar_k05@infosys.com");

        try(OutputStream stream = Files.newOutputStream(Paths.get("property.xml"))) {
            pros.storeToXML(stream, "prperty with xml");
        }

        //Loading properties from xml
        Properties property = new Properties();

        try (InputStream iStream = Files.newInputStream(Paths.get("property.xml"))) {
            property.loadFromXML(iStream);

         }
        System.out.println(property.getProperty("name"));
        System.out.println(property.getProperty("email"));
    }

}
