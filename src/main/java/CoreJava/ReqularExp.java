package CoreJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mks on 5/1/2017.
 */
public class ReqularExp {

    public static void main(String args[]){
        //String with Reqular expressions:
        //replaceMethodsUsage();

        //Using dedicated reqular expressins classes
        String value1 ="apple, apple and orange please";
        Pattern pattern = Pattern.compile("\\w+"); //which gives the instances of the pattern class has the compiled informaton about the req expressions
        Matcher matcher = pattern.matcher(value1); // used to match the compile requ expression with the string
        while (matcher.find())
            toOut(matcher.group());

    }

    private static void replaceMethodsUsage() {
        //replaceFirst and ReplaceAll
        String s1 = "apple, apple and orange please";
        toOut(s1.replaceFirst("ple", "ricot"));         //will replace first ple from the above string(appricot, apple and orange please'
        toOut(s1.replaceAll("ple","ricot"));            //will replace all the the words which contains ple with ricot (Appricot, apricot and orange ricotase"
        toOut(s1.replaceAll("ple\\b", "ricot"));        // appricot, appricot and orange please
    }

    private static void toOut(String string) {
        System.out.println(string);
    }
}
