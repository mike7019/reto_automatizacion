package testing.page.drivers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    private String[] dataArray;

    public FileReaderDemo(String filePath) {
        this.dataArray = readFile(filePath);
    }

    private String[] readFile(String filePath) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.append(line);
                data.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // here we can sort the way to split and validate the data
        return data.toString().split("\n");
    }

    public void printData() {
        for(String data : dataArray) {
            if (data.contains("PAL07")){
                System.out.println(data);
                break;
            }
        }
    }
}
