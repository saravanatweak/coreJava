package CoreJava.IOPackage;

import java.io.*;
import java.util.Vector;


public class InputOutputStream {
    public static void main(String args[]) throws Exception {
        /*Calling file output Stream to write a data into a file */
        fileOutputStream();

        /* Calling file input Stream to read the data from the file */
        fileInputStream();

        /* Reading the current class to another class */
        readWriteSameClass();

        /* Writing same file to multiple files */
        byteArrayOutputStreamWithOnetoManyMethod();

        /* read data from multiple streams at a same time */
        byteArrayOutputStreamWithOneToManyMethod();

        /* Enumeration usage: read data from multiple streams at a same time. */
        sequenceInputStreamEnumerationExp();

        /*Buffered output Stream : Mainly used to increase the performance in case of huge data*/
        bufferedOutputStreamExp();

        /*Buffered input Stream : Mainly used to increase the performance in case of huge data*/
        bufferedInputStreamExp();

        /*FileWriter: Preferred over input/output stream for reading and writing Textual Information */
        fileWriterExp();
        fileReaderExp();

        /*Calling CharArrayWriter: USed to write same textual infromation to different files*/
        charArrayWriterExp();
    }

    public static void fileOutputStream (){
        try {
            FileOutputStream out = new FileOutputStream("abc.txt");
            String s = " Do better! Else Please dont do it";
            byte b[] = s.getBytes(); // converting string into byte array, as we can write only byte or int value using input stream
            out.write(b);
            out.close();
        } catch (IOException e) { System.out.println(e.getMessage());}
    }

    public static void fileInputStream() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("abc.txt");
        try {
            int i=0;
            while( (i=in.read()) != -1 )
                System.out.print((char)i);

        } catch (IOException e) { System.out.println(e.getMessage());}
    }

    public static void readWriteSameClass() throws IOException {
        FileInputStream in = new FileInputStream("src/CoreJava.IOPackage/InputOutputStream.java");
        FileOutputStream out = new FileOutputStream("Delete.java");
        try {
            int i=0;
            while((i=in.read()) != -1){
                out.write((char)i);
            }
        } catch (IOException e) { System.out.println(e.getMessage()); }
        in.close();
        out.close();
    }

    public static void byteArrayOutputStreamWithOneToManyMethod() throws Exception {
        FileOutputStream fout1 = new FileOutputStream("del1.txt");
        FileOutputStream fout2 = new FileOutputStream("del2.txt");

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        bout.write("onetomany".getBytes()); //holds a copy of data
        bout.writeTo(fout1);
        bout.writeTo(fout2);
        fout1.close();        fout2.close();
        bout.flush();
        bout.close(); // has no response
    }

    public static void byteArrayOutputStreamWithOnetoManyMethod() throws Exception {
        FileInputStream fin1 = new FileInputStream("del1.txt");
        FileInputStream fin2 = new FileInputStream("del2.txt");

        FileOutputStream fout = new FileOutputStream("del3.txt");

        SequenceInputStream sin = new SequenceInputStream(fin1,fin2);

        int i=0;
        while((i = sin.read()) != -1)
        {
            fout.write(i);
        }

        sin.close(); fin1.close(); fin2.close(); fout.close();

    }

    public static void sequenceInputStreamEnumerationExp() throws Exception {
        //readAndWriteMultipleData
        FileInputStream fin1 = new FileInputStream("del1.txt");
        FileInputStream fin2 = new FileInputStream("del2.txt");
        FileInputStream fin3 = new FileInputStream("src/CoreJava.IOPackage/InputOutputStream.java");
        FileInputStream fin4 = new FileInputStream("del3.txt");
        FileOutputStream fout = new FileOutputStream("del4.txt");

        Vector v = new Vector();
        v.add(fin1);    v.add(fin2);    v.add(fin3);    v.add(fin4);

        SequenceInputStream sin = new SequenceInputStream(v.elements());

        int i=0;
        while((i = sin.read()) != -1)
            fout.write(i);

        fin1.close(); fin2.close(); fin3.close(); fin4.close(); fout.close();
        sin.close();
    }

    public static void bufferedOutputStreamExp() throws Exception {
        /*Java BufferedOutputStream class uses an internal buffer to store data.
        It adds more efficiency than to write data directly into a stream. So, it makes the performance fast.*/
        String s ="Saravana cant understand other people feeelings";

        FileOutputStream fout = new FileOutputStream("del5.txt");
        //
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        byte b[] = s.getBytes();

        bout.write(b);
        bout.flush(); //he flush() flushes the data of one stream and send it into stream.
        fout.close();
    }

    public static void bufferedInputStreamExp() throws Exception {
        FileInputStream fin = new FileInputStream("del5.txt");
        BufferedInputStream bin = new BufferedInputStream(fin);

        int i=0;
        while((i = bin.read()) != -1)
            System.out.print((char)i);

        bin.close();    fin.close();
    }

    /*Java has suggested not to use the FileInputStream and FileOutputStream
    classes if you have to read and write the textual information.*/
    public static void fileWriterExp() throws Exception{
        FileWriter fw= new FileWriter("del6.txt");
        fw.write("saravana is lazy".toCharArray());
        fw.write("As he saving the energy all the time");
        fw.close();
    }

    public static void fileReaderExp() throws Exception{
        FileReader fr = new FileReader("del6.txt");
        int i;
        while((i=fr.read()) != -1)
            System.out.print((char)i);
        fr.close();;
    }

    /*The CharArrayWriter class can be used to write data to multiple files. This class implements
    the Amendable interface. Its buffer automatically grows when data is written in this stream.
    Calling the close() method on this object has no effect.*/
    public static void charArrayWriterExp() throws Exception {
        CharArrayWriter caw = new CharArrayWriter();
        caw.write("This is Char Array Writer And used to write textual information");

        FileWriter f = new FileWriter("del.txt");
        FileWriter f2 = new FileWriter("del2.txt");
        FileWriter f3 = new FileWriter("del3.txt");
        FileWriter f4 = new FileWriter("del4.txt");

        caw.writeTo(f);
        caw.writeTo(f2);
        caw.writeTo(f3);
        caw.writeTo(f4);

        f.close();  f2.close(); f3.close(); f4.close();

    }
}


