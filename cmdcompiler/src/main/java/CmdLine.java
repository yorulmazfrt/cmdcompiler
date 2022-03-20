import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CmdLine {

    public List<String> CmdLineWrite(String lines) {
        ProcessBuilder processBuilder
                = new ProcessBuilder();
        List<String> builderList = new ArrayList<>();
        List<String> donus = new ArrayList<>();

        // add the list of commands to a list
        builderList.add("powershell.exe");
        builderList.add(lines);

        try {
        // Using the list , trigger the command
        processBuilder.command(builderList);
        Process process = processBuilder.start();

        // To read the output list
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            donus.add(line);
            donus.add("başarılı");
        }
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line1;
        while ((line1 = reader2.readLine()) != null) {
            System.out.println(line1);
            donus.add(line1);
            donus.add("hatalı");

        }
        }
        catch (IOException e) {
            e.printStackTrace();

        }
        return donus;
    }
}
