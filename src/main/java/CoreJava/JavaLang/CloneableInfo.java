package CoreJava.JavaLang;

public class CloneableInfo implements Cloneable {
    int rollno;
    String name;

    CloneableInfo(int rollno,String name){
        this.rollno=rollno;
        this.name=name;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String args[]){
        try{
            CloneableInfo s1=new CloneableInfo(101,"amit");

            CloneableInfo s2=(CloneableInfo)s1.clone();

            /*As you can see in the above example, both reference variables have the same value.
            Thus, the clone() copies the values of an object to another.
            So we don't need to write explicit code to copy the value of an object to another.
            If we create another object by new keyword and assign the values of another object to this one,
            it will require a lot of processing on this object. So to save the extra processing task we use clone() method.*/
            System.out.println(s1.rollno+" "+s1.name);
            System.out.println(s2.rollno+" "+s2.name);

        }catch(CloneNotSupportedException c){}

    }
}
