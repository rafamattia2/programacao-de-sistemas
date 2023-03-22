package ps.com.example.demo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Reader {
    static class Record {
        char type;
        String data;

        Record(char type, String data) {
            this.type = type;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        String filePath = "path/to/your/object_code_file.txt";
        List<Record> records = readObjectCode(filePath);

        for (Record record : records) {
            System.out.println("Type: " + record.type + " Data: " + record.data);
        }
    }

    public static List<Record> readObjectCode(String filePath) {
        List<Record> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > 0) {
                    char recordType = line.charAt(0);
                    String recordData = line.substring(1);
                    records.add(new Record(recordType, recordData));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return records;
    }
}