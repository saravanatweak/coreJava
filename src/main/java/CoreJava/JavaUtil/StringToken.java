package CoreJava.JavaUtil;

import java.util.StringTokenizer;

public class StringToken {
    //StringTokenizer class is deprecated now. It is recommended to use split() method of String class or regex (Regular Expression).
    //Todo: Try to explore more on this. if it not covered by you

    public static void main(String args[]){
        StringTokenizer st = new StringTokenizer("my name is khan"," ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}

