package by.dobysh.customsort;

import by.dobysh.customsort.parser.DataParser;
import by.dobysh.customsort.process.CustomComparatorArrayString;
import by.dobysh.customsort.reader.ReaderData;
import by.dobysh.customsort.reader.ReaderDataFile;
import by.dobysh.customsort.writer.WriterData;
import by.dobysh.customsort.writer.WriterDataFile;

import java.util.List;

public class App {

    private static final String dataFilePathInput = "data/1.txt";
    private static final String dataFilePathOutput = "data/out.txt";

    public static void main(String[] args) {

        ReaderData readerData = new ReaderDataFile();
        WriterData writerData = new WriterDataFile();
        DataParser dataParser = new DataParser();

        List<String> stringList = readerData.readDataToListString(dataFilePathInput);

        List<String[]> parsedList = dataParser.parseByCol(stringList);

        parsedList.sort(new CustomComparatorArrayString());

        writerData.writeData(dataFilePathOutput, parsedList);

    }


}
