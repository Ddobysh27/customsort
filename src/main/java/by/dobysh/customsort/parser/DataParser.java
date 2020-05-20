package by.dobysh.customsort.parser;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public static final String REGEX_NEW_ELEMENT = "\\t";


    public List<String[]> parseByCol(List<String> inputListString) {
        List<String[]> paesedList = new ArrayList<>();
        for (String line : inputListString) {
            String[] elements = line.split(REGEX_NEW_ELEMENT, -1);
            paesedList.add(elements);
        }
        return paesedList;
    }

}
