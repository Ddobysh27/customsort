package by.dobysh.customsort.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDataFile implements ReaderData {

    @Override
    public String readDataToString(String pathToFile) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}