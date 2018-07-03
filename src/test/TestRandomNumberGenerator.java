package test;

import com.training.model.RandomNumberGenerator;
import org.junit.Assert;
import org.junit.Test;

public class TestRandomNumberGenerator {
    @Test
    public void testRand() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int result = randomNumberGenerator.rand();
        for (int i = 0; i < RandomNumberGenerator.RAND_MAX; i++) {
            Assert.assertTrue(result >= 0 && result <= RandomNumberGenerator.RAND_MAX);
        }

        int min = 0;
        int max = 1;
        result = randomNumberGenerator.rand(min, max);
        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(result >= min && result <= max);
        }

        min = 1;
        max = 1;
        result = randomNumberGenerator.rand(min, max);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(result == 1);
        }
    }
}
