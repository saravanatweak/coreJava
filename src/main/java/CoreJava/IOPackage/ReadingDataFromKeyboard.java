package CoreJava.IOPackage;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;

public class ReadingDataFromKeyboard {
    public static void main(String args[]) throws Exception{
        /*Using InputStreamReader and BufferedReader to read a data from keyboard */
        readDataFromKeyboardLineByLine();

        /*Using Console : USed to read data from outside, have a opting to hide the data reading*/
        consolewithReadData(); // will work through cmd only. not directly from IDE

        /*Another Scanner, printStream input : you are very well aware of that. Hence no codding*/
    }

    public static void readDataFromKeyboardLineByLine() throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader r = new BufferedReader(isr);

        System.out.println("Write the name: ");
        String s = r.readLine();
        System.out.println("your name is: "+s);
    }

    public static void consolewithReadData() {
        Console c=System.console();
        System.out.println(c);
        String uName=c.readLine();
        System.out.println("enter the uPwd: ");
        String uPwd = c.readPassword().toString();
        System.out.println(uName + " " + uPwd);
    }
}