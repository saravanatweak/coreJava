package UnUsual;

class CallByvalue{
    int data = 100;
    void change(int data) {  data = data+50;    }
    void changeByThis(int data) {   this.data = data+50;}
}

class CallByReference{
    int data = 50;
    void change(CallByReference ref)    {        ref.data = ref.data+100;    }
}
public class CallByValueAndRefrence {

    public static void main(String args[])
    {
        CallByvalue val = new CallByvalue();
        System.out.println("Before passing by value"+val.data);
        val.change(100);
        System.out.println("After passsing by value"+val.data);
        //you can notice, there will be no change in output, as local modification will not affect the instance variable

        System.out.println("Before passing by value using this keyword "+ val.data);
        val.changeByThis(150);
        System.out.println("After passing by value using this keyword "+val.data);
        //But if you add this keyword infront of data variable, then actual value will get change. As this pointing to instance variable.

        CallByReference ref = new CallByReference();
        System.out.println("Before passing by reference"+ref.data);
        ref.change(ref);
        System.out.println("After passing by reference"+ref.data);
    }


}
