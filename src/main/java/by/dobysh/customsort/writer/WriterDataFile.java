package by.dobysh.customsort.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterDataFile implements WriterData {

    @Override
    public void writeData(String filePath, List<String[]> content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < content.size(); i++) {
                for (String element : content.get(i)) {
                    bufferedWriter.write(element);
                    bufferedWriter.write('\t');
                }
                if (i != content.size() - 1 ) {
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}