package Examples.SenarioBased;

import java.util.*;

public class MaximumLeadForGivenRounds {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] p1 = new int[n];
        int[] p2 = new int[n];

        Map<Integer, Integer> pos = new HashMap<>();
        int p1Tot = 0,p2Tot=0;
        TreeSet mySet = new TreeSet();

        for(int i=0; i<n; i++)
        {
            p1[i] =  input.nextInt();
            p2[i] =  input.nextInt();
            p1Tot += p1[i];
            p2Tot += p2[i];

            if(p1Tot > p2Tot)
                pos.put(p1Tot-p2Tot, 1);
            else
                pos.put(p2Tot -p1Tot, 2);

        }

        mySet.addAll(pos.keySet());
        List maxList = new ArrayList<>(mySet);
        Object maxValue = maxList.get(maxList.size()-1);
        System.out.println(pos.get(maxValue)+" " + maxValue.toString());
    }

}
