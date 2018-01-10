package Examples.Common;

import java.util.Scanner;

public class GivenArrayInReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }
        int arr2[] = new int[n];
        int l = n-1;
        for(int j=l;j>=0;j--) {
            arr2[j] = arr[l-j];
        }
        for(int a: arr2){
            System.out.print(a+" ");
        }

        in.close();
    }
}
