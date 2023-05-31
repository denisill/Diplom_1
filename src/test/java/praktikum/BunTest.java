package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private String bunName;
    private float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"delicious", 100},
                {"black", 350},
                {"new", 500}
        };
    }

    @Test
    public void getBunName() {
       Bun bun = new Bun(bunName, bunPrice);
       String actualBunName = bun.getName();
       assertEquals(bunName, actualBunName);
    }

    @Test
    public void getBunPrice() {
       Bun bun = new Bun(bunName, bunPrice);
       float actualBunPrice = bun.getPrice();
       Assert.assertEquals(bunPrice, actualBunPrice, 0.00001);
    }
}