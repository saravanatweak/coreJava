
public class ShinoFightOutCome {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long N = in.nextInt();
        //int totalNoOfFights = N%2;
        long que = in.nextInt();
        //int fighters[] = new int[N];
        List<Integer> listOfFighters = new ArrayList<>();
        Map<Integer, Integer> noOfFights = new HashMap<>();

        long n=0, q=0;
        while( n<N) {
            int fighter= in.nextInt();
            listOfFighters.add(fighter);
            noOfFights.put(fighter, 0);
            n++;
        }

        List<Integer> refighters ;


        while(listOfFighters.size()>1) {
            int limit = listOfFighters.size();
            refighters = new ArrayList<>();
            for(int a=0; a< limit-1; a +=2) {
                int first = listOfFighters.get(a) ;
                int second = listOfFighters.get(a +1 );

                if(first > second) {
                    refighters.add(first);
                }
                else {
                    refighters.add(second);
                }
                noOfFights.put(first, noOfFights.get(first) +1);
                noOfFights.put(second, noOfFights.get(second) +1);


            }
            if(limit%2 != 0)
                refighters.add(listOfFighters.get(limit-1));
            listOfFighters = refighters;
        }

        while(que >0) {
            int key = in.nextInt();
            System.out.println(noOfFights.get(key));
            que --;
        }

        in.close();
    }




}
