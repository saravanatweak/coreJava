package CoreJava.JavaUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class LoadingDefaultPropertiesFromPackage {
    public static void main(String args[]) {
        try {
            Properties defaultProps = new Properties();
            try(InputStream in = LoadingDefaultPropertiesFromPackage.class.getResourceAsStream("MyDefaultValues.xml")) {
                defaultProps.loadFromXML(in);
            }

            Properties userProps = new Properties(defaultProps);
            loadDefaultPropes(userProps);

            System.out.println(userProps.getProperty("welcomeMessage"));
            System.out.println(userProps.getProperty("farewellMessage"));

            //check and updating the user specific values if hte app has ever been ran before
            if(userProps.getProperty("isFirstRun").equalsIgnoreCase("Y")) {
                userProps.setProperty("welcomeMessage","Welcome back");
                userProps.setProperty("farewellMessage","Thngs will be familiar now");
                userProps.setProperty("isFirstRun","N");
                showUserProps(userProps);
            }
            //Try to delete userValue.xml thne run it
            //For first run app will print the defaul values which we gave to props file. and
            //also it will change the default values with abouve values. so second run onwards
            //it will print the above messages only.
        } catch (IOException e) {
            System.out.println("Exception <" + e.getClass().getSimpleName()+"> "+e.getMessage());
        }
    }

    public static void loadDefaultPropes(Properties userProps) throws IOException{
        Path userFile = Paths.get("userValues.xml");
        if(Files.exists(userFile)) {
            try (InputStream in = Files.newInputStream(userFile)) {
                userProps.loadFromXML(in);
            }
        }
    }

    public static void showUserProps(Properties userProps) throws IOException {
        try(OutputStream out = Files.newOutputStream(Paths.get("userValues.xml"))) {
            userProps.storeToXML(out,null);
        }
    }
}
