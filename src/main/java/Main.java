import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public final static String FILE_NAME = "result.txt";

    public static void main(String[] args) throws IOException {
        StringBuilder resultString = new StringBuilder();

        // create list files. sort by natural
        List<Path> list;
        try (Stream<Path> stream = Files.walk(Paths.get(System.getProperty("user.dir")))
                .filter(Files::isRegularFile)
                .sorted(Comparator.naturalOrder())) {
            list = stream.toList();
        }

        // open, read, collecting in the row
        for (Path path : list) {
            String stringPath = String.valueOf(path);

            // if it is a text file, and it is not "result.txt", "Task1.jar"
            if (stringPath.matches(".+(result.txt)") || stringPath.matches(".+(Task1.jar)")) continue;

            if (stringPath.matches(".+(.txt)")) {
                File textFile = new File(stringPath);
                Scanner scanner = new Scanner(textFile);

                while (scanner.hasNextLine()) {
                    resultString.append(" ").append(scanner.nextLine());
                }
                scanner.close();
            } else System.out.println("This folder contains not text files: " + stringPath);
        }

        File resultFile = createFile(FILE_NAME);

        // write in file
        PrintWriter pw = new PrintWriter(resultFile);
        pw.println(resultString);
        pw.close();

        System.out.println("File " + FILE_NAME + " has been created/updated in the root folder");
    }

    // creating the result file
    public static File createFile(String pathName) {
        File file = new File(pathName);
        try {
            file.createNewFile();
            return file;
        } catch (Exception e) {
            System.out.println("File \"" + pathName + "\" couldn't be created. Check your rights to the folder.");
            throw new RuntimeException(e);
        }
    }

}
