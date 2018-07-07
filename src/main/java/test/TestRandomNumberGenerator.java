package test;

import com.training.model.RandomNumberGenerator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRandomNumberGenerator {

    private static RandomNumberGenerator randomNumberGenerator;

    @BeforeClass
    public static void init()
    {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    public void testRand() {
        int min = 0;
        int max = 1000;
        int result;

        for (int i = 0; i < max; i++) {
            result = randomNumberGenerator.rand(min, max);
            Assert.assertTrue(result >= min && result <= max);
        }
    }

    @Test
    public void testRandOnSameInputValue() {
        int result = randomNumberGenerator.rand(1, 1);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void testRandOnMaxValue() {
        int result = randomNumberGenerator.rand(Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
        Assert.assertTrue(result == Integer.MAX_VALUE - 1 || result == Integer.MAX_VALUE);
    }

}
