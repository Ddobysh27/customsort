package by.dobysh.customsort.parser;

public class DataParser {
    public static final String REGEX_NEW_LINE = "\\n";

    public String[] parseByRow(String inputString) {
        return inputString.trim().split(REGEX_NEW_LINE);
    }

}
