package by.dobysh.customsort.process;

import java.util.Comparator;

public class CustomComparator implements Comparator<String> {

    // get number or letter part
    private String getPart(String s, int marker) {
        StringBuilder part = new StringBuilder();
        char c = s.charAt(marker);
        part.append(c);
        marker++;
        if (Character.isDigit(c)) {

            while (marker < s.length()) {
                c = s.charAt(marker);
                if (!Character.isDigit(c))
                    break;
                part.append(c);
                marker++;
            }

        } else {

            while (marker < s.length()) {
                c = s.charAt(marker);
                if (Character.isDigit(c))
                    break;
                part.append(c);
                marker++;
            }

        }
        return part.toString();
    }

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

            // if temp part contain number, then compare by number
            int result = 0;
            if (Character.isDigit(s1Part.charAt(0)) && Character.isDigit(s2Part.charAt(0))) {
                // parts compare by length
                int s1PartLength = s1Part.length();
                result = s1PartLength - s2Part.length();
                // if lengths equal
                if (result == 0) {
                    for (int i = 0; i < s1PartLength; i++) {
                        result = s1Part.charAt(i) - s2Part.charAt(i);
                        if (result != 0) {
                            return result;
                        }
                    }
                }
            } else {
                result = s1Part.compareTo(s2Part);
            }

            if (result != 0)
                return result;
        }

        return s1Length - s2Length;
    }

}