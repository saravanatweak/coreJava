
public class ImmutableClassExp {

    private static String s1 ;
    private static String s2 ;
    private static String s3 ;
    private static String s4 ;
    public static void main(String args[]) {
        s1 ="abc";
        s2 ="abc";
        s3 = new String("abc");
        s4 = new String("abc").intern();

        System.out.println(s1== s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);

    }
}
