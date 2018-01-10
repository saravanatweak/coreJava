package codeChallange.HackersEarth.BasicPgm;


import java.util.Scanner;

/*Proble statement:
* https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/cipher-1/description/*/
/*SAMPLE INPUT
All-convoYs-9-be:Alert1. //First line contains the string to convert. S
4                        //rotation limit//Second line contains the number, encrypt key. K
                          //-, . unchanged.(special characters unchanged)
SAMPLE OUTPUT
Epp-gsrzsCw-3-fi:Epivx5. // o.p


*/
public class RotatingStringsAndNumberForGivenLimit {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int key = in.nextInt();

        char[] ch = s.toCharArray(); //converting given string to char array
        String lc = "abcdefghijklmnopqrstuvwxyz";
        String uc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];

            if (Character.isLetter(c) && Character.isLowerCase(c)) {
                int a = lc.indexOf(c) + key + 1;
                sb.append(getCharForNumber(lc, a));
            } else if (Character.isLetter(c) && Character.isUpperCase(c)) {
                int b = uc.indexOf(c) + key + 1;
                sb.append(getCharForNumber(uc, b));
            } else if (Character.isDigit(c)) {
                int d = Integer.parseInt(String.valueOf(c)) + key;
                if (d > 9) {
                    d = d % 10;
                }
                sb.append(d);
            } else
                sb.append(c);
        }

        System.out.println(sb.toString());
        in.close();
    }


    public static String getCharForNumber(String alphbat, int i) {
        while (i > 26) {
            if (i % 26 == 0) {
                i = 26;
            } else
                i = i % 26;

        }
        return String.valueOf(alphbat.charAt(i - 1));
    }

}
