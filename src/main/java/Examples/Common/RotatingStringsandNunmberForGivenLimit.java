package Examples.Common;

import java.util.Scanner;

public class RotatingStringsandNunmberForGivenLimit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = in.nextInt();

        char[] ch = s.toCharArray();
        String lc = "abcdefghijklmnopqrstuvwxyz";
        String uc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<ch.length;i++){
            char c = ch[i];
            if(Character.isLetter(c) && Character.isLowerCase(c)){
                int a=  lc.indexOf(c)+ n +1;
                sb.append(getCharForNumber(lc, a));

            }
            else if(Character.isLetter(c) && Character.isUpperCase(c)){
                int b =  uc.indexOf(c) + n+1;
                sb.append(getCharForNumber(uc, b));
            }
            else if(Character.isDigit(c)){
                int d = Integer.parseInt(String.valueOf(c))+n;
                if(d>9)
                    d = d%10;
                sb.append(d);
            }
            else
                sb.append(c);

        }

        System.out.println(sb.toString());

        in.close();
    }


    public static String getCharForNumber(String alphbat, int i) {
        while(i>26){
            if(i%26 ==0){
                i = 26;
            }else
                i = i%26;

        }
        return String.valueOf(alphbat.charAt(i-1));
    }

}


