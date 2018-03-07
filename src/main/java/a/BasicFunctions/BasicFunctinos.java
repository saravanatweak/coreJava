package a.BasicFunctions;



import java.util.Scanner;

public class BasicFunctinos {
    BasicFunctinos() {}
    private int a;
    public static void main (String args[]) {
        //Getting input
        Scanner input = new Scanner(System.in);
        System.out.println(input.nextLine());

        //Conditional  concepts
        showConditionalConcepts();

        //LoopingConcepts
        showLoopingConcepts();

        //this keyword
        new thisClass();
    }

    private static void showConditionalConcepts() {
        //if else
        if(true) {  }
        else if(true) {     }
        else {  }
        //Nested if
        if(true) {
            if(true) {  }
            else {  }
        }
        else {}

        //Switch
        switch("Any Char, String, int, ") {
            case "limitations of values" :
                //code
                break;
            case "limitations" :
                //code
                break;
            default: //will be executed only when no conditions are met.
                break;// to break the loop once any condition is met.
        }
    }

    private static void showLoopingConcepts() {
        //While loop logic
        int counter = 1;
        while(counter <=10){
            System.out.println(counter);
            counter ++;
        }

        /*  Any time you want to run any function at lest once you use DO WHILE
		 *  Any time you want to run any function only after the condition true, then you should use while loop */

        //DoWhile with normal
        int count =0;
        do{
            System.out.println(count);
            count++;
        }while (count <10);

        //DoWhile executing only once though the condition getting failed.
        int counter1 =15;
        do{	System.out.println(counter);
            counter1++;
        } while (counter1 <=10);

        //for loop
        //for(intialization; condition; +/- loopcount) { operation }
    }

}

class thisClass {
    /*	When a local variable has the same name as an instance variable, the instance variable
        is hidden by the local variable.To gain access to the instance variables,
        keyword "this" is used. The "this" keyword is used to refer to the current object
    */
    int i;
    public thisClass() 	{	}

    public thisClass(int in)
    {
        this(); // will always call the default constructor of the class
        // if Default constructor is not exit, we cant use this() on that scenario
        this.i = in;
    }

}


