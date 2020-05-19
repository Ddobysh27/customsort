package by.dobysh.customsort.process;

import java.util.Comparator;

public class CustomComparatorArrayString implements Comparator<String[]> {


    @Override
    public int compare(String[] s1, String[] s2) {

        int s1Length = s1.length;
        int s2Length = s2.length;
        int lim = Math.min(s1Length, s2Length);

        int result = 0;

        for (int i = 0; i < lim; i++) {
            result = new CustomComparatorString().compare(s1[i], s2[i]);
            if (result != 0) {
                return result;
            }
        }

        return s1Length - s2Length;
    }
}
