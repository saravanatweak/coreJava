package Algorithm;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] initialArray = new int[T];
        for(int a=0; a<T; a++) {
            initialArray[a] = in.nextInt();
        }
        printArray("Given Array is: ", initialArray);

        //Performing bubble Sort --> Traverse through out the array and swap two elements in ascending order
        int[] arr = initialArray;
        boolean isSorted =false;
        int lastUnSorted = arr.length-1;
        while(!isSorted) {
            isSorted = true;
            for(int b=0; b<lastUnSorted; b++) {
                if (arr[b] > arr[b + 1]) {
                    //Real Sorting
                    swap(arr, b, b+ 1);
                    isSorted = false;
                }
            }
            lastUnSorted--;//This is the optimization part where we are skipping the last element at each
                           //new search as that element will get placed as high during the last search itself.
        }
        printArray("\nAfter Bubble Sort: ", arr);

    }
    public static void swap(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    public static void printArray(String s, int[] array) {
        System.out.print(s);
        for(int a: array) {
            System.out.print(a+" ");
        }
    }
}
