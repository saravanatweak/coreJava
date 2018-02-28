
public class TrailingZerosInFactorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list  = new ArrayList<>();
        list.set(0,1);



        for(int i=1; i<=20;i++){
            long value = factorial(i);
            int a=0;
            while(value %10 ==0){
                a++;
                value = value/10;
            }
            map.put(i,a);
        }
        int t= in.nextInt();
        String output ="";
        int b=0,j=1;
        boolean c = true;
        while(t>0){
            int m = in.nextInt();
            for(int i=1; i<21;i++){
                if(map.get(i) == m ){
                    b++;
                    output += i+" ";
                }
                else if(j !=i)
                    break;

                else
                    j++;

            }
            System.out.println(b);
            System.out.println(output);
            t--;
        }

        in.close();
    }
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

/*10
235
679
729
738
738
661
506
802
210
642

0
5
2725 2726 2727 2728 2729
5
2925 2926 2927 2928 2929
5
2965 2966 2967 2968 2969
5
2965 2966 2967 2968 2969
5
2650 2651 2652 2653 2654
5
2030 2031 2032 2033 2034
5
3215 3216 3217 3218 3219
0
5
2575 2576 2577 2578 2579

10
235
679
729
738
738
661
506
802
210
642

0
5
2725 2726 2727 2728 2729
5
2925 2926 2927 2928 2929
5
2965 2966 2967 2968 2969
5
2965 2966 2967 2968 2969
5
2650 2651 2652 2653 2654
5
2030 2031 2032 2033 2034
5
3215 3216 3217 3218 3219
0
5
2575 2576 2577 2578 2579

*/
