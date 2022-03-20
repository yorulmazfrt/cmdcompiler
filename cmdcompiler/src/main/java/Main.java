import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[]args) throws IOException {

        System.out.println("Ekrana test yazdıran kodu yazarmısın");

        Scanner scanner = new Scanner(System.in);
        String strkod = scanner.next();
        String strstart = "public class t{public static void main(String[]args) {";
        String strend = "}}";

        File file = new File("t.java");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(strstart);
        bWriter.write(strkod);
        bWriter.write(strend);
        bWriter.close();

        CmdLine cmdLine = new CmdLine();
        cmdLine.CmdLineWrite("javac t.java");

        List<String> a = new ArrayList<>();
        a = cmdLine.CmdLineWrite("java t");
        if (a.get(0).equals("test")){
            System.out.println("SUCCESS");
        }
        else {
            System.out.println("ERROR!");
        }
        file.delete();
        File file2 = new File("t.class");
        file2.delete();

        }
}
