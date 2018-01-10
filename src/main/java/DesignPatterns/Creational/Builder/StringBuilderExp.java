package DesignPatterns.Creational.Builder;

/**
 * Created by Saravanakumar_K05 on 11/20/2017.
 */
public class StringBuilderExp {

    //very well overcome of '+' or String.concat approaches and memory utilization is very less compare to + or concat
    //Good approache over StringBuffer as its provides better peformance compare to it
    public static void main(String[] args) {
        StringBuilder builderExp = new StringBuilder();

        builderExp.append("This is an example ");

        builderExp.append("of the builder pattern. ");

        builderExp.append("It has methods to append ");

        builderExp.append("almost anything we want to a String. ");

        builderExp.append(42);

        System.out.println(builderExp.toString()); //Here we used advantage of toString method to build a string.
    }
}
