package Examples.Common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sorting {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Integer[] a = new Integer[n];
        for(int i=0; i<n; i++)
        {
            a[i] = input.nextInt();
        }
        //Arrays in ascending order
        Arrays.sort(a);
        for(int j: a)
            System.out.println(j);

        //Arrays in Dscending order
        List<Integer> arrList = Arrays.asList(a);
        Collections.reverse(arrList);
        for(Integer l : arrList)
            System.out.println(l);
    }
}
