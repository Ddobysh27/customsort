package by.dobysh.customsort.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDataFile implements WriterData {

    @Override
    public void writeData(String filePath, String[] content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String str : content) {
                bufferedWriter.write(str);
                if (!str.isEmpty()) {
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}