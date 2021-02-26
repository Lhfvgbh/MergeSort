import exceptions.IncorrectKeyException;
import org.junit.Assert;
import org.junit.Test;
import sort.Sorting;

import java.util.Arrays;
import java.util.List;

public class SortingKeyTest {
    private static final List<String> LIST = Arrays.asList("in1.txt", "in2.txt", "in3.txt");

    @Test
    public void intAndAscendingDirectTest() throws Exception {
        String[] args = {"-i", "-a", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertFalse(s.isDescending());
        Assert.assertTrue(s.isNumber());
        Assert.assertEquals(LIST, s.getFiles());
    }

    @Test
    public void intAndAscendingTest() throws Exception {
        String[] args = {"-i", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertFalse(s.isDescending());
        Assert.assertTrue(s.isNumber());
        Assert.assertEquals(LIST, s.getFiles());
    }

    @Test
    public void intAndDescendingDirectTest() throws Exception {
        String[] args = {"-i", "-d", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertTrue(s.isDescending());
        Assert.assertTrue(s.isNumber());
        Assert.assertEquals(LIST, s.getFiles());
    }

    @Test
    public void stringAndAscendingDirectTest() throws Exception {
        String[] args = {"-s", "-a", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertFalse(s.isDescending());
        Assert.assertFalse(s.isNumber());
        Assert.assertEquals(LIST, s.getFiles());
    }

    @Test
    public void stringAndDescendingDirectTest() throws Exception {
        String[] args = {"-s", "-d", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertTrue(s.isDescending());
        Assert.assertFalse(s.isNumber());
        Assert.assertEquals(LIST, s.getFiles());
    }

    @Test
    public void stringAndAscendingTest() throws Exception {
        String[] args = {"-s", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertFalse(s.isDescending());
        Assert.assertFalse(s.isNumber());
        Assert.assertEquals(LIST, s.getFiles());
    }

    @Test(expected = IncorrectKeyException.class)
    public void noTypeErrorTest() throws Exception {
        String[] args = {"out.txt", "in1.txt", "in2.txt", "in3.txt"};
        new Sorting(args);
    }

    @Test(expected = IncorrectKeyException.class)
    public void badArgsErrorTest() throws Exception {
        String[] args = {"-z", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        new Sorting(args);
    }

    @Test(expected = IncorrectKeyException.class)
    public void extraArgsErrorTest() throws Exception {
        String[] args = {"-s", "-i", "-z", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        new Sorting(args);
    }
}
