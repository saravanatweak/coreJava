package codeChallange.HackersEarth.BasicPgm.InOut;


/*
* https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/magical-word/*/
//TODO: Try to draw a algorithm from the code
import java.util.Scanner;

/*
SAMPLE INPUT
1 //limit
6 //letters lenght
AFREEN //given letter

SAMPLE OUTPUT
CGSCCO
Rules for converting:

1.Each character should be replaced by the nearest Dhananjay's Magical alphabet.

2.If the character is equidistant with 2 Magical alphabets.
The one with lower ASCII value will be considered as its replacement.

*/
public class FindingNearsetPrimeOfAsciiValueOfGivenChar {

    // 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 103 107 109 113 127
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t>0) {
            int l = in.nextInt();
            String s = in.next();
            int lc=0,rc=0;
            StringBuilder sb = new StringBuilder();
            for(char c: s.toCharArray()) {
                int asciiVal =c ;

                if(Character.isLowerCase(asciiVal)){
                    asciiVal = getNearestPrimeForAscii(asciiVal, 97, 122);//Getting aschii value for lower case
                }
                else if(Character.isUpperCase(asciiVal))
                {
                    asciiVal = getNearestPrimeForAscii(asciiVal, 65,90 ); //Getting aschii value for lower case
                }
                else if(asciiVal<65){                  //If its not charcter but before A=65 is the least
                    while(asciiVal<65){
                        asciiVal++;
                    }
                    asciiVal = getNearestPrimeForAscii(asciiVal, 65,90);
                }
                else
                {
                    asciiVal = getNearestPrimeForAscii(asciiVal,89, 126);
                }


                sb.append((char)asciiVal);
            }
            System.out.println(sb.toString());

            t--;
        }

        in.close();
    }

    private static int getNearestPrimeForAscii(int asciVal, int lowLimit, int highLimit) {
        int i1=asciVal, i2=asciVal;
        boolean givenPrime = isPrimeNumber(asciVal);
        int j=0,k=0;
        if(asciVal==lowLimit)   // Just care next immediate prime number(char)
        {
            while (!isPrimeNumber(asciVal)) {
                asciVal += 1;
            }
        }
        else if(asciVal==highLimit) // Just care previous immediate prime number(char)
        {
            while (!isPrimeNumber(asciVal)){
                asciVal -=1;
            }
        }
        else
        {
            //Finding the counts in order to differeniate which prime number is very near to given char
            while(!isPrimeNumber(asciVal=asciVal-1) && asciVal>lowLimit){
                j++;
            }
            while(!isPrimeNumber(i1=i1+1) && i1<highLimit){
                k++;
            }

            if(j==k && !isPrimeNumber(asciVal)){// If left and right are matches we are
                asciVal = i1;
            }
            else if(j>k && i1!=highLimit){

                if(i1>i2 && !givenPrime )
                    asciVal = i1;
                else
                    asciVal = i2;
            }
            else if(givenPrime){
                asciVal=i2;
            }

        }
        return asciVal;
    }

    private static boolean isPrimeNumber(int i) {
        int j = i/2;
        for(int a=2; a<j;a++){
            if(i%a ==0){
                return false;
            }
        }
        return true;
    }



}

