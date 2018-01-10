package CoreJava.newBoatsMan.oops;

public class InheritanceExp {

	public static void main (String args[]){
		InheritanceSub1 obj = new InheritanceSub1();
		obj.method1(); // method1 is overridden in subclass1. hence its taking from sub1
		obj.method2(); // method2 is not overridden in subclass1. Hence its taking from sub3
	}
}

class InheritanceSub1 extends InheritanceSub2{

	public void method1(){
		System.out.println("I am the method from 1st subclass but overridden");
	}
}

class InheritanceSub2 extends InheritanceSub3{

}

class InheritanceSub3 {


	public void method1(){
		System.out.println("I am the method form 3rd sub class");
	}

	public void method2(){
		System.out.println("I am the method2 fromm 3rd sub class");
	}

}
