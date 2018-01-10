package HackersRank;

import java.util.Scanner;

public class RotationOfStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arr_size = input.nextInt();
        int l_rot = input.nextInt();
        int given_arr[] = new int[arr_size];

        for (int a = 0; a < arr_size; a++) {
            given_arr[a] = input.nextInt();
        }

        int z;
        int final_arr[] = new int[arr_size];
        for (int b = 0; b < arr_size; b++) {
            z = b + l_rot;
            if (z < arr_size)
                final_arr[b] = given_arr[z];
            else
                final_arr[b] = given_arr[z - arr_size];
        }
        for (int c : final_arr) {
            System.out.print(c + " ");
        }
    }
}
