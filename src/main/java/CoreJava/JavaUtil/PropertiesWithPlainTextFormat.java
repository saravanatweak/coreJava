package CoreJava.JavaUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesWithPlainTextFormat {
    public static void main(String args[]) throws Exception {
        /* Example of Properties class to get information from properties file */
        //readTheFile();

        //Example of Properties class to get all the system properties
        //readSystemProperties();

        //Example of Properties class to create properties file
        createPropertiesFile();
    }


    public static void readTheFile() throws Exception {
        Properties p = new Properties();

        FileReader reader = new FileReader("db.properties");
        p.load(reader);

        System.out.println("userName: " + p.getProperty("user"));
        System.out.println("password: " + p.getProperty("password"));
    }


    public static void readSystemProperties() {
        Properties p = System.getProperties();
        Set set = p.entrySet();

        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }


    public static void createPropertiesFile() throws Exception {
        Properties p = new Properties();
        p.setProperty("name", "Saravanakumar");
        p.setProperty("eamil", "saravanatowin@gmail.com");

        p.store(new FileWriter("info.properties"), "This is Saravanakumar Details");
        System.out.println("file info.properties created successfully");

        //OTher way with try with resources
        try (Writer writer = Files.newBufferedWriter(Paths.get("abc.properties"))) {
            p.store(writer, "this propertiy file creation with try wth resource");
        }

    }
}