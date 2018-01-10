package UnUsual;

public class BoxingUnBoxing {

    public static void main(String args[]) {
        //Basic boxing and unboxing
        //new BoxingAndUnBoxing().expBoxUnBox();

        //Example of Autoboxing where widening beats boxing
        //new WideningBeatsBoxing().methodCall();

        //Example of Autoboxing where widening beats varargs
        //new WideningBeatsVarargs().call();

        //Example of Autoboxing where boxing beats varargs
        //new BoxingBeatsVarargs().call();

    }
}

class BoxingAndUnBoxing {
    public void expBoxUnBox() {
        int a=50;
        Integer a2=new Integer(a);//Boxing
        Integer a3=5;//Boxing

        System.out.println(a2+" "+a3);

        Integer i=new Integer(50);
        int a1=i;

        System.out.println(a1);
    }
}

class WideningBeatsBoxing {

    void m(int i) {System.out.println("int");    }
    void m(Integer i) { System.out.println("Integer");}

    public void methodCall() {
        short s = 10;
        m(s);
    }
}

class WideningBeatsVarargs {
    void n(int i, int i2) { System.out.println("int");}
    void n(Integer...i) { System.out.println("varargs");}

    void call() {
        short s1 = 10, s2 = 20;
        n(s1,s2);
    }
}

class BoxingBeatsVarargs {
    void o(Integer i, Integer i2) { System.out.println("Integer");     }
    void o(Integer...i) {System.out.println("Var args");     }

    void call() {
        int a1=10, a2=20;
        o(a1,a2);
    }
}

