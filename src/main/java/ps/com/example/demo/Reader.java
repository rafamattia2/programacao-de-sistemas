package ps.com.example.demo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Reader {
    public static List<Loaded> readObjectCode(String filePath) {
        List<Loaded> loading = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > 0) {
                    char recordType = line.charAt(0);
                    String recordData = line.substring(1);
                    loading.add(new Loaded(recordType, recordData));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return loading;
    }
}