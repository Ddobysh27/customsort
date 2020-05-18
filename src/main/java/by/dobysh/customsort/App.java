package by.dobysh.customsort;

import by.dobysh.customsort.parser.DataParser;
import by.dobysh.customsort.process.CustomComparator;
import by.dobysh.customsort.reader.ReaderData;
import by.dobysh.customsort.reader.ReaderDataFile;
import by.dobysh.customsort.writer.WriterData;
import by.dobysh.customsort.writer.WriterDataFile;

import java.util.Arrays;

public class App {

    private static final String dataFilePathInput = "data/in.txt";
    private static final String dataFilePathOutput = "data/out.txt";

    public static void main(String[] args) {

        ReaderData readerData = new ReaderDataFile();
        WriterData writerData = new WriterDataFile();
        DataParser dataParser = new DataParser();

        String sourceData = readerData.readDataToString(dataFilePathInput);

        String[] parsed = dataParser.parseByRow(sourceData);

        //sort
        Arrays.sort(parsed, new CustomComparator());

        writerData.writeData(dataFilePathOutput, parsed);


    }


}
