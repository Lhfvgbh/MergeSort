import sort.Sorting;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingStringTest {

    private String empty1Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/in0.txt";
    private String empty2Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/empty.txt";
    private String mixedName = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/mixed2.txt";
    private String string1Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s1.txt";
    private String string2Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s2.txt";
    private String string3Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s3.txt";
    private String string4Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s4.txt";
    private String string5Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s5.txt";
    private String string6Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s6.txt";
    private String string7Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s7.txt";
    private String string8Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/in_s8.txt";
    private String outName = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/out.txt";
    private String outString = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/strings/out_string.txt";

    @Test
    public void intFullAcsDirectTest() throws Exception {
        String[] args = {"-s", "-a", outName, string1Name, string2Name, string3Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(SortingIntTest.readFile(outString), SortingIntTest.readFile(outName));
    }

    @Test
    public void stringFullAcsTest() throws Exception {
        String[] args = {"-s", outName, string2Name, string3Name, string1Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(SortingIntTest.readFile(outString), SortingIntTest.readFile(outName));
    }

    @Test
    public void stringFullDescTest() throws Exception {
        String[] args = {"-s", "-d", outName, string6Name, string7Name, string8Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        List<String> out_t = SortingIntTest.readFile(outString);
        Collections.reverse(out_t);
        Assert.assertEquals(out_t, SortingIntTest.readFile(outName));
    }

    @Test
    public void stringShortTest() throws Exception {
        String[] args = {"-s", "-a", outName, string4Name, string5Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(SortingIntTest.readFile(string3Name).subList(5, 7), SortingIntTest.readFile(outName));
    }

    @Test
    public void stringOneFileTest() throws Exception {
        String[] args = {"-s", "-a", outName, string3Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(SortingIntTest.readFile(string3Name), SortingIntTest.readFile(outName));
    }

    @Test
    public void mixedStringTest() throws Exception {
        String[] args = {"-s", "-a", outName, mixedName, string1Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(
                Arrays.asList("april", "Barbara", "blue", "Christopher", "David", "Elizabeth", "Mary", "Patricia", "tree", "999"),
                SortingIntTest.readFile(outName));
    }
}
