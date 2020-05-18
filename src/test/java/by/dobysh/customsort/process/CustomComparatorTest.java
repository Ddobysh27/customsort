package by.dobysh.customsort.process;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomComparatorTest {

    @Test
    public void compare() {
        CustomComparator cCustomComparator = new CustomComparator();
        cCustomComparator.compare("123","1123");
        cCustomComparator.compare("as12a","as12a");
        cCustomComparator.compare("as12a","as1a");
        int res = cCustomComparator.compare("as12a","");
        System.out.println("res = " + res);

    }
}