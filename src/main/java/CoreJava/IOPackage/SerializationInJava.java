package CoreJava.IOPackage;

import java.io.*;



public class SerializationInJava {
    public static void main(String args[]) throws  Exception{

        Student s1 = new Student(1, "Saravana", 28);
        /**Calling Serializable class from a class */
        persist(s1); //SerializationExp

        /*DeSerialization: extracting the serializable class from inputStream */
        dePersist(s1); //DeSerializationExp

        /*Changing value during serializaion and deserialization */
        s1.setId(100);
        dePersist(s1);
    }


    public static void persist(Student s) throws Exception {


        FileOutputStream fout = new FileOutputStream("Serialization.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(s);
        oos.flush();
        fout.close();
    }

    public static void dePersist(Student s) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Serialization.txt"));
        Student student = (Student) ois.readObject();
        System.out.println(student.id + " " + student.name + " " + student.age+" "+Student.address);
    }
}

class Student implements Serializable { //now its objects can be converted into stream.
    private static final long serialVersionUID = -4574057171550866942L;
    int id;
    String name;
    //Non-Serializable members
    transient int age; // in this case, default value will be printed while deserialization
    static String address =" Bangalore"; // Here, it wont be added into the serialization part itself, because static is the part of class not object.

    public Student () { }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(int id) { this.id = id;}
}
