package codeChallange.HackersRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TwoDArrayHourGlass {
    public static void main(String[] argh) {

        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        List<Integer> hourglass = new ArrayList<Integer>();
        int sum=0;
        int rowLimit = arr.length-2;
        int colLimit = arr[0].length-2;

        for(int a=0; a<rowLimit; a++) {
            for(int b=0; b<colLimit; b++) {
                sum = arr[a][b] + arr[a][b+1] + arr[a][b+2]
                        + arr[a+1][b+1] +
                        arr[a+2][b+0] + arr[a+2][b+1] + arr[a+2][b+2];
                hourglass.add(sum);
            }
        }
        Collections.sort(hourglass);
        System.out.print(hourglass.get(hourglass.size()-1));
        in.close();
    }
}


