import exceptions.IncorrectKeyException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sort.Sorting;

import java.util.LinkedList;
import java.util.List;

public class SortingKeyTest {
    private static List<String> list;

    @BeforeClass
    public static void getList() {
        list = new LinkedList<>();
        //list.add("out.txt");
        list.add("in1.txt");
        list.add("in2.txt");
        list.add("in3.txt");
    }


    //Number, Ascending direct
    @Test
    public void numericAndAscendingDirectTest() throws Exception {
        String[] args = {"-i", "-a", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertFalse(s.isDescending());
        Assert.assertTrue(s.isNumber());
        Assert.assertEquals(list, s.getFiles());
    }

    //Number, Ascending hidden
    @Test
    public void numericAndAscendingTest() throws Exception {
        String[] args = {"-i", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertFalse(s.isDescending());
        Assert.assertTrue(s.isNumber());
        Assert.assertEquals(list, s.getFiles());
    }

    //Number, Descending direct
    @Test
    public void numericAndDescendingDirectTest() throws Exception {
        String[] args = {"-i", "-d", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertTrue(s.isDescending());
        Assert.assertTrue(s.isNumber());
        Assert.assertEquals(list, s.getFiles());
    }

    //String, Ascending direct
    @Test
    public void stringAndAscendingDirectTest() throws Exception {
        String[] args = {"-s", "-a", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertFalse(s.isDescending());
        Assert.assertFalse(s.isNumber());
        Assert.assertEquals(list, s.getFiles());
    }

    //String, Descending direct
    @Test
    public void stringAndDescendingDirectTest() throws Exception {
        String[] args = {"-s", "-d", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertTrue(s.isDescending());
        Assert.assertFalse(s.isNumber());
        Assert.assertEquals(list, s.getFiles());
    }

    //String, Ascending
    @Test
    public void stringAndAscendingTest() throws Exception {
        String[] args = {"-s", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Sorting s = new Sorting(args);
        Assert.assertFalse(s.isDescending());
        Assert.assertFalse(s.isNumber());
        Assert.assertEquals(list, s.getFiles());
    }

    //NoTypeError
    @Test(expected = IncorrectKeyException.class)
    public void noTypeErrorTest() throws Exception {
        String[] args = {"out.txt", "in1.txt", "in2.txt", "in3.txt"};
        new Sorting(args);
    }

    //BadArgsError
    @Test(expected = IncorrectKeyException.class)
    public void badArgsErrorTest() throws Exception {
        String[] args = {"-z", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        new Sorting(args);
    }

    //ExtraArgsError
    @Test(expected = IncorrectKeyException.class)
    public void extraArgsErrorTest() throws Exception {
        String[] args = {"-s", "-i", "-z", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        new Sorting(args);
    }
}
