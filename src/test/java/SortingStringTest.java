import org.junit.Assert;
import org.junit.Test;
import sort.Sorting;

import java.util.*;

public class SortingStringTest {

    private String empty = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/in0.txt";
    private String spaces = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/empty.txt";
    private String mixed = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/mixed2.txt";
    private String stringAcs1 = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s1.txt";
    private String stringAcs2 = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s2.txt";
    private String stringAcs3 = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s3.txt";
    private String stringOne1 = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s4.txt";
    private String stringOne2 = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s5.txt";
    private String stringDecs1 = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s6.txt";
    private String stringDecs2 = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s7.txt";
    private String stringDecs3 = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s8.txt";
    private String actualOutput = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/out.txt";
    private String expectedOutput = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/out_string.txt";

    @Test
    public void intFullAcsDirectTest() throws Exception {
        String[] args = {"-s", "-a", actualOutput, stringAcs1, stringAcs2, stringAcs3};
        Sorting s = new Sorting(args);
        s.sortFiles(String.class);
        Assert.assertEquals(SortingIntTest.readFile(expectedOutput), SortingIntTest.readFile(actualOutput));
    }

    @Test
    public void stringFullAcsTest() throws Exception {
        String[] args = {"-s", actualOutput, stringAcs2, stringAcs3, stringAcs1};
        Sorting s = new Sorting(args);
        s.sortFiles(String.class);
        Assert.assertEquals(SortingIntTest.readFile(expectedOutput), SortingIntTest.readFile(actualOutput));
    }

    @Test
    public void stringFullDescTest() throws Exception {
        String[] args = {"-s", "-d", actualOutput, stringDecs1, stringDecs2, stringDecs3};
        Sorting s = new Sorting(args);
        s.sortFiles(String.class);
        List<String> out_t = SortingIntTest.readFile(expectedOutput);
        Collections.reverse(out_t);
        Assert.assertEquals(out_t, SortingIntTest.readFile(actualOutput));
    }

    @Test
    public void stringShortTest() throws Exception {
        String[] args = {"-s", "-a", actualOutput, stringOne1, stringOne2};
        Sorting s = new Sorting(args);
        s.sortFiles(String.class);
        Assert.assertEquals(SortingIntTest.readFile(stringAcs3).subList(5, 7), SortingIntTest.readFile(actualOutput));
    }

    @Test
    public void stringOneFileTest() throws Exception {
        String[] args = {"-s", "-a", actualOutput, stringAcs3};
        Sorting s = new Sorting(args);
        s.sortFiles(String.class);
        Assert.assertEquals(SortingIntTest.readFile(stringAcs3), SortingIntTest.readFile(actualOutput));
    }

    @Test
    public void mixedStringTest() throws Exception {
        String[] args = {"-s", "-a", actualOutput, mixed, stringAcs1};
        Sorting s = new Sorting(args);
        s.sortFiles(String.class);
        Assert.assertEquals(
                Arrays.asList("april", "Barbara", "blue", "Christopher", "David", "Elizabeth", "Mary", "Patricia", "tree", "999"),
                SortingIntTest.readFile(actualOutput));
    }

    @Test
    public void stringSpacesTest() throws Exception {
        String[] args = {"-s", "-a", actualOutput, spaces, stringAcs1};
        Sorting s = new Sorting(args);
        s.sortFiles(String.class);
        Assert.assertEquals(SortingIntTest.readFile(stringAcs1), SortingIntTest.readFile(actualOutput));
    }

    @Test
    public void stringEmptyTest() throws Exception {
        String[] args = {"-s", "-a", actualOutput, empty, stringAcs1};
        Sorting s = new Sorting(args);
        s.sortFiles(String.class);
        Assert.assertEquals(SortingIntTest.readFile(stringAcs1), SortingIntTest.readFile(actualOutput));
    }

    @Test
    public void stringEmptySpacesTest() throws Exception {
        String[] args = {"-s", "-a", actualOutput, empty, spaces};
        Sorting s = new Sorting(args);
        s.sortFiles(String.class);
        Assert.assertEquals(new ArrayList<>(), SortingIntTest.readFile(actualOutput));
    }
}
