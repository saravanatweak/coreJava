package CoreJava.JavaLang;
/** Non frequency methods with examples */
public class StringClass {
    public static void main(String args[]) {
        String s1 = "Saravana";
        String s2 = "Saravana";
        String s3 = "kumar";

        //compareTo method
        System.out.print("" + s1.compareTo(s2));//0
        System.out.print("" + s1.compareTo(s3));//1(because s1>s3)
        System.out.print("" + s3.compareTo(s1));//-1(because s3 < s1 )

        //String concatenation by + operato
        String con = s1 + s3; // Originalyy compier will perform this task by below way.
        //String con = (new StringBuilder()).append("Saravana").append(" kumar").toString();
        // After a string literal, all the + will be treated as string concatenation operator.

        //TODO: Try to get good examples of format method.

        //The java string join() method returns a string joined with given delimiter. In string join method, delimiter is copied for each elements.
        //In case of null element, "null" is added. The join() method is included in java string since JDK 1.8.
        String joinString1 = String.join("-", "welcome", "to", "javatpoint");
        System.out.println(joinString1); // welcome-to-javatpoint.


        String s4 = "java string split method by javatpoint";
        String[] words = s4.split("\\s");//splits the string based on whitespace
        //String[] words1 = s4.split("\\s",2); // Upto sencond word it will print.
        for (String w : words) {
            System.out.println(w);
        }
    }
}
