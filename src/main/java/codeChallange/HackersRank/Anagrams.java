package codeChallange.HackersRank;

import java.util.*;
public class Anagrams {

    /**
     * Print a count of integer denoting the number of characters you must
     * delete to make given two strings as anagrams of each other.
     */
    public static int numberNeeded(String s1, String s2) {
        int i = 0;

        ArrayList<Character> lists1 = new ArrayList<>();
        ArrayList<Character> lists2 = new ArrayList<>();
        for (char c : s1.toCharArray()) {
            lists1.add(c);
        }
        for (char c : s2.toCharArray()) {
            lists2.add(c);
        }

        for (int a = 0; a < s1.length(); a++) {
            if (lists2.contains(lists1.get(a))) {
                i++;
                lists2.remove(lists1.get(a));
            }
        }

        return (s1.length() + s2.length() - (2 * i));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));

        // Given list of words(t) we are checking how many letters needs to be removed in order make all the words as anagram
        makeAnagramForGivenWords();


    }

    public static void makeAnagramForGivenWords() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        String[] strings = new String[t];
        for (int i = 0; i < t; i++) {
            strings[i] = in.next();
        }
        int i = 0;

        ArrayList<ArrayList<Character>> lists = new ArrayList<>();

        for (int j = 0; j < t; j++) {
            ArrayList<Character> list = new ArrayList<>();
            for (char c : strings[j].toCharArray()) {
                list.add(c);
            }
            lists.add(list);
        }

        ArrayList<Character> list1 = lists.get(0);
        String S1 = strings[0];
        for (int l = 1; l < t; l++) {
            ArrayList<Character> list2 = lists.get(l);
            for (int m = 0; m < S1.length(); m++) {
                if (list2.contains(list1.get(m))) {
                    i++;
                    list2.remove(list1.get(m));
                }
            }
        }

        System.out.println(t * i);
    }

    public static void deletionOfGivenWordsToMakeAnnagram() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t > 0) {
            int i = 0;
            String s1 = in.next();
            String s2 = in.next();
            ArrayList<Character> lists1 = new ArrayList<>();
            ArrayList<Character> lists2 = new ArrayList<>();
            for (char c : s1.toCharArray()) {
                lists1.add(c);
            }
            for (char c : s2.toCharArray()) {
                lists2.add(c);
            }

            for (int a = 0; a < s1.length(); a++) {
                if (lists2.contains(lists1.get(a))) {
                    i++;
                    lists2.remove(lists1.get(a));
                }
            }

            System.out.println(s1.length() + s2.length() - (2 * i));
            t--;

        }
    }
}