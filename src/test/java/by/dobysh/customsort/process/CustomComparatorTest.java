package by.dobysh.customsort.process;

import org.junit.Test;

public class CustomComparatorTest {

    @Test
    public void compare() {
        CustomComparatorString cCustomComparator = new CustomComparatorString();
        cCustomComparator.compare("123","1123");
        cCustomComparator.compare("as12a","as12a");
        cCustomComparator.compare("as12a","as1a");
        int res = cCustomComparator.compare("as12a","");
        System.out.println("res = " + res);

    }
}