package pluralSight.Stream;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main (String args[]) {

        if(args.length ==0) {
            System.out.println("No files given! Please provide any file");
            return;
        }
        String filename = args[0];
        if(Files.exists(Paths.get(filename))) {
            return;
        }

        showFileLines(filename);
    }

    private static void showFileLines(String filename) {
        System.out.println();

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(reader.readLine());
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName()+" | "+e.getMessage());
        }
    }
}

