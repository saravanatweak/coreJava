package CoreJava.NIOPacakage.FileSystem;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[] ) {

        try (FileSystem zipFile = openZip(Paths.get("myfile.zip"))) {
            copyToZip(zipFile);
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + " - " + e.getMessage());
        }

    }

    public static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providedFiles = new HashMap<>();
        providedFiles.put("Create","true");

        return null;
    }
    public static void copyToZip(FileSystem zipFile) throws IOException {
       // Path sourceFile = FileSystems.getDefault().getPath("file.txt");//Default way of getting the path
        Path sourceFile = Paths.get("file.txt");//So Paths simplified the above stpe here
        Path destFile = zipFile.getPath("/fileCopied.txt");

        Files.copy(sourceFile,destFile, StandardCopyOption.REPLACE_EXISTING);
    }
}