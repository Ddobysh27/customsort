package by.dobysh.customsort.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderDataFile implements ReaderData {

    @Override
    public List<String> readDataToListString(String filePath) {

        List<String> stringList = new ArrayList<>();
        File file = new File(filePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String dataLine;
            while ((dataLine = bufferedReader.readLine()) != null) {
                stringList.add(dataLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

}