package pluralSight.generics.compatability.erasure;

import java.util.List;

/* run the below cmd on the path of this java file .compile form
javap -s -c -classpath, a directory, and then the name of the class,
and what that javap command does is it says, decompile the bytecode that's been produced by javac
and each line given from the o/p to below of exact java line. Its a metadata */

public class Erasure<T, B extends Comparable<B>> {
//public class pluralSight.generics.ompatability.erasure.Erasure<T, B extends java.lang.Comparable<B>> {

    //default constructor generated and its compiled form is
    /*public pluralSight.generics.ompatability.erasure.Erasure();
    descriptor: ()V */


    public void unbounded(T param) { }
    /*public void unbounded(T);
        descriptor: (Ljava/lang/Object;)V */  // V stands for void
    /**
     * the way generics are implemented we know that erasure will kick-in and at runtime
     * that list of string will really just be a list and you're going to need to add in a cast here
     * to check that it's the correct parameter.
     */
    public void lists(List<String> param, List<List<T>> param2) {
        String s = param.get(0);
    }
    /*public void lists(java.util.List<java.lang.String>, java.util.List<java.util.List<T>>);
        descriptor: (Ljava/util/List;Ljava/util/List;)V */
    //If you note above the descriptor shows two returns list list,
    //Just like it get converted into raw type

    public void bounded(B param) {
    }
    /*public void bounded(B);
        descriptor: (Ljava/lang/Comparable;)V*/
    //Here B extends comparable interface hence the it got erased to take a parameter called comparable
}
/*
After running javap -s Erasure you will get this,
this how jvm understand under the hood its contains metadata of your java file

Compiled from "Erasure.java"
public class pluralSight.generics.ompatability.erasure.Erasure<T, B extends java.lang.Comparable<B>> {

public void unbounded(T);
        descriptor: (Ljava/lang/Object;)V

public void lists(java.util.List<java.lang.String>, java.util.List<java.util.List<T>>);
        descriptor: (Ljava/util/List;Ljava/util/List;)V

public void bounded(B);
        descriptor: (Ljava/lang/Comparable;)V
        }

*/

/*And if you add -c along with existing cmd
 javap -s -c Erasure you will get

 now in line no 84, you could see checkCast is happening
 ***If we hop back to the source code, we took our first parameter, we got the first element out of that list and we assigned it to a variable called S that was a string,
  * and if we look at the bytecode, that's what these things are really doing here, it's calling get on the list method, and then it does a checkcast.
  * That checkcast is saying, this method that I've got out of my get that returns me a java/lang/Object because it's been erased, is this really a string?
  * Is this what I really trust? This is what the compiler is doing. It's inserting runtime checks for situations it can't guarantee a correct compile time.
  * If it can guarantee that they're not correct at compile time, it'll give you a compile error, but for everything else there is checkcast.
  * That is what you get with generics under the hood***


 public class pluralSight.generics.ompatability.erasure.Erasure<T, B extends java.lang.Comparable<B>> {
  public pluralSight.generics.ompatability.erasure.Erasure();
    descriptor: ()V
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void unbounded(T);
    descriptor: (Ljava/lang/Object;)V
    Code:
       0: return

  public void lists(java.util.List<java.lang.String>, java.util.List<java.util.List<T>>);
    descriptor: (Ljava/util/List;Ljava/util/List;)V
    Code:
       0: aload_1
       1: iconst_0
       2: invokeinterface #2,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
       7: checkcast     #3                  // class java/lang/String
      10: astore_3
      11: return

  public void bounded(B);
    descriptor: (Ljava/lang/Comparable;)V
    Code:
       0: return
}*/