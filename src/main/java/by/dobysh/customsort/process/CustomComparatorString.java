package by.dobysh.customsort.process;

import java.util.Comparator;

public class CustomComparatorString implements Comparator<String> {

    // get number or letter part
    private String getPart(String s, int marker) {
        StringBuilder part = new StringBuilder();
        char c = s.charAt(marker);
        part.append(c);
        marker++;
        if (Character.isDigit(c) || c == '-') {
            while (marker < s.length()) {
                c = s.charAt(marker);
                if (!Character.isDigit(c) && c != '.')
                    break;
                part.append(c);
                marker++;
            }

        } else {

            while (marker < s.length()) {
                c = s.charAt(marker);
                if (Character.isDigit(c) || c == '-')
                    break;
                part.append(c);
                marker++;
            }

        }
        return part.toString();
    }

    @Override
    public int compare(String s1, String s2) {
        if ((s1 == null) || (s2 == null)) {
            return 0;
        }

        int s1Marker = 0;
        int s2Marker = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();

        // if both parts are not empty
        while (s1Marker < s1.length() && s2Marker < s2.length()) {
            String s1Part = getPart(s1, s1Marker);
            s1Marker += s1Part.length();

            String s2Part = getPart(s2, s2Marker);
            s2Marker += s2Part.length();

            boolean sub1IsDigit = (Character.isDigit(s1Part.charAt(0)) || (s1Part.charAt(0) == '-' && s1Part.length() > 1 && Character.isDigit(s1Part.charAt(1))));
            boolean sub2IsDigit = (Character.isDigit(s2Part.charAt(0)) || (s2Part.charAt(0) == '-' && s2Part.length() > 1 && Character.isDigit(s2Part.charAt(1))));
            // if temp part contain number, then compare by number
            int result = 0;
            if (sub1IsDigit && sub2IsDigit) {

                double part1 = Double.parseDouble(s1Part);
                double part2 = Double.parseDouble(s2Part);

                result = Double.compare(part1, part2);

            } else if (sub1IsDigit) {
                result = -1;
            } else if (sub2IsDigit) {
                result = 1;
            } else {
                result = s1Part.compareTo(s2Part);
            }

            if (result != 0) {
                return result;
            }
        }

        return s1Length - s2Length;
    }

}