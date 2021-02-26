import exceptions.SortingException;
import org.junit.Assert;
import org.junit.Test;
import sort.Sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingIntTest {

    private String empty1Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/in0.txt";
    private String empty2Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/empty.txt";
    private String mixedName = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/mixed1.txt";
    private String int1Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/in1.txt";
    private String int2Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/in2.txt";
    private String int3Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/in3.txt";
    private String int4Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/in4.txt";
    private String int5Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/in5.txt";
    private String int6Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/in6.txt";
    private String int7Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/in7.txt";
    private String int8Name = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/in8.txt";
    private String outName = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/out.txt";
    private String out_t = "/Users/eisaeva/Desktop/MergeSort/src/test/resouces/ints/out_int.txt";

    static List<String> readFile(String fileName) {
        List<String> lines = new LinkedList<>();
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Test
    public void intFullAcsDirectTest() throws Exception {
        String[] args = {"-i", "-a", outName, int2Name, int3Name, int1Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(readFile(out_t), readFile(outName));
    }

    @Test
    public void intFullAcsTest() throws Exception {
        String[] args = {"-i", outName, int1Name, int2Name, int3Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(readFile(out_t), readFile(outName));
    }

    @Test
    public void intFullDescTest() throws Exception {
        String[] args = {"-i", "-d", outName, int6Name, int7Name, int8Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        List<String> list = readFile(out_t);
        Collections.reverse(list);
        Assert.assertEquals(list, readFile(outName));
    }

    @Test
    public void intShortTest() throws Exception {
        String[] args = {"-i", "-a", outName, int4Name, int5Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(readFile(out_t).subList(7, 9), readFile(outName));
    }

    @Test(expected = SortingException.class)
    public void intOneEmptySpaceTest() throws Exception {
        String[] args = {"-i", "-a", outName, empty2Name, int3Name, int2Name, int1Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
    }

    @Test
    public void intOneEmptyTest() throws Exception {
        String[] args = {"-i", "-a", outName, empty1Name, int3Name, int2Name, int1Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(readFile(out_t), readFile(outName));
    }

    @Test(expected = SortingException.class)
    public void intAllEmptySpacesTest() throws Exception {
        String[] args = {"-i", "-a", outName, empty1Name, empty2Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
    }

    @Test
    public void intAllEmptyTest() throws Exception {
        String[] args = {"-i", "-a", outName, empty1Name, empty1Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(new LinkedList<>(), readFile(outName));
    }

    @Test//(expected = SortingException.class)
    public void intOneEmptyFileTest() throws Exception {
        String[] args = {"-i", "-a", outName, empty1Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(new LinkedList<>(), readFile(outName));
    }

    @Test
    public void intOneFileTest() throws Exception {
        String[] args = {"-i", "-a", outName, int3Name};
        Sorting s = new Sorting(args);
        s.sortFiles();
        Assert.assertEquals(readFile(out_t).subList(2, 5), readFile(outName));
    }

    @Test(expected = SortingException.class)
    public void mixedIntTest() throws Exception {
        String[] args = {"-i", "-a", outName, int1Name, mixedName};
        Sorting s = new Sorting(args);
        s.sortFiles();
    }
}
