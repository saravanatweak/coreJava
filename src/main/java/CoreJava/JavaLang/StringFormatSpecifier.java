package CoreJava.JavaLang;

import javax.print.DocFlavor;

public class StringFormatSpecifier {

    public static void main(String args[] ) {
        //Various String.Format Specifiers with their output
       // differentCoversion();

        //Format:Flag#(padding with 0)
        //Note will not applicable for d and h
       // FlagForHaskKey();

        //Format:Flag 0 or -(justify)
        //flagWith0orjustifyKey();

        //Format:Flag , grouping separator
        //flagGroupSeperator();

        //Format:Flag, space, + (
        //flagUsingSpacePlusLeftParenthisis();



    }

    private static void flagUsingSpacePlusLeftParenthisis() {
        //Space : Leaves place for positive numbers
        toOut(String.format("%d", 123));        //123
        toOut(String.format("%d", -456));       //-456

        toOut(String.format("% d",123));        // 123 (Note it have space infornt the number
        toOut(String.format("%-d",-456));       //-456

        //+     : Always shows the sign
        toOut(String.format("%+d", 123));       //+123
        toOut(String.format("%+d",-123));       //-456

        //(     : Enclose negative vvalues wiht parantesis
        toOut(String.format("%(d", 123));       //123
        toOut(String.format("%(d", -456));      //(456)
        toOut(String.format("% (d", 123));      // 123   (prefix and suffix have space wiht the value.
    }

    private static void flagGroupSeperator() {
        toOut(String.format("%d", 1234567));            //1234567
        toOut(String.format("%,d", 1234567));           //1,234,567
        toOut(String.format("%,.2f", 1234567.0));       //1,234,567.00
    }

    private static void flagWith0orjustifyKey() {
        //With normal
        toOut(String.format("W:%d X:%d", 5 , 235));     //W:5 X:235
        toOut(String.format("Y:%d Z:%d", 481, 12));     //Y:481 Z:12

        //With givne number : so number get aligned with given value.
        toOut(String.format("W:%4d X:%4d", 5 , 235));     //W:   5 X: 235
        toOut(String.format("Y:%4d Z:%4d", 481, 12));     //Y: 481 Z:  12

        //With 0 added given number
        toOut(String.format("W:%04d X:%04d", 5 , 235));     //W: 0005 X: 0235
        toOut(String.format("Y:%04d Z:%04d", 481, 12));     //Y: 0481 Z: 0012

        //With Justify(-) by default it was left justinfied
        toOut(String.format("W:%-4d X:%-4d", 5 , 235));     //W:   5 X: 235
        toOut(String.format("Y:%-4d Z:%-4d", 481, 12));     //Y: 481 Z:  12
    }

    private static void FlagForHaskKey() {
        //# also called as radix
        toOut(String.format("%#o",32)); //040
        toOut(String.format("%#x",32)); //0x20
        toOut(String.format("%#X",32)); //0X20
    }

    private static void differentCoversion() {
        toOut(String.format("%d",32)); //32
        toOut(String.format("%o",32)); //40
        toOut(String.format("%h",32)); //20
        toOut(String.format("%x",32)); //20
    }
    private static void toOut(String string) {
        System.out.println(string);
    }
}
