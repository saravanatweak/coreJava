package CoreJava.IOPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressAndDeCompress {
    public static void main(String[] args) throws Exception {
        /*Compress: Using Default algo by default */
        compressingTheFile();

        /*Decompress: Using Deflat alog by default */
        deCompressingTheFile();
    }

    public static void compressingTheFile() throws Exception {
        FileInputStream fin = new FileInputStream("src/CoreJava/IOPackage/CompressAndDeCompress.java");
        FileOutputStream fout = new FileOutputStream("temp.txt");
        DeflaterOutputStream out = new DeflaterOutputStream(fout);

        int i;
        while ((i = fin.read()) != -1) {
            out.write((byte) i);

        }
        out.flush();
        out.close();
        fin.close();
        fout.close();
    }

    public static void deCompressingTheFile() throws Exception {
        FileInputStream fin = new FileInputStream("temp.txt");
        InflaterInputStream in = new InflaterInputStream(fin);
        FileOutputStream fout = new FileOutputStream("temp.java");

        int i = 0;
        while ((i = in.read()) != -1) {
            fout.write((byte) i);

        }
        fout.flush();
        fin.close();
        fout.close();
        in.close();
    }
}
