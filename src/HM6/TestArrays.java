package HM6;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;

public class TestArrays {



    ArraysMethods arraysMethods = new ArraysMethods();

    @Test
    public void containsOneOrFourTest() {
        Assert.assertTrue(arraysMethods.containsOneOrFour(new int[]{1, 1, 4, 4, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest1() {
        Assert.assertFalse(arraysMethods.containsOneOrFour(new int[]{1, 1, 4, 3, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest2() {
        Assert.assertFalse(arraysMethods.containsOneOrFour(new int[]{1, 0, 1, 1, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest3() {
        Assert.assertFalse(arraysMethods.containsOneOrFour(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void containsOneOrFourTest4() {
        Assert.assertFalse(arraysMethods.containsOneOrFour(new int[]{4, 4, 4, 4, 4, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void containsOneOrFourTest5() {
        Assert.assertFalse(arraysMethods.containsOneOrFour(new int[]{}));
    }

    @Test
    public void cutForTest() {
        Assert.assertArrayEquals(new int[]{5, 6}, arraysMethods.cutFor(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void cutForTest1() {
        Assert.assertArrayEquals(new int[]{5, 6, 7}, arraysMethods.cutFor(new int[]{1, 2, 4, 4, 5, 6, 7}));
    }

    @Test
    public void cutForTest2() {
        Assert.assertArrayEquals(new int[]{}, arraysMethods.cutFor(new int[]{1, 2, 3, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void cutForTest4() {
        Assert.assertArrayEquals(new int[]{}, arraysMethods.cutFor(new int[]{1, 2, 3, 10, 5, 3}));
    }

    @Test(expected = RuntimeException.class)
    public void cutForTest5() {
        Assert.assertArrayEquals(new int[]{}, arraysMethods.cutFor(new int[]{}));
    }
}