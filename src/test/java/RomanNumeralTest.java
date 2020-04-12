import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralTest {

    @Test
    public void takesStringInConstructor() {
        RomanNumeral numeral = new RomanNumeral("I");
        assertEquals("I", numeral.value);
    }

    @Test
    public void givesIIforSumOfIandI() {
        assertSum("I", "I", "II");
    }

    @Test
    public void givesIIIforSumOfIandII() {
        assertSum("I", "II", "III");
    }

    @Test
    public void givesVforSumOfIIandIII() {
        assertSum("II", "III", "V");
    }

    void assertSum(String first, String second, String expectedProduct)
    {
        RomanNumeral numeral = new RomanNumeral(first);
        numeral.sum(new RomanNumeral(second));
        assertEquals(expectedProduct, numeral.value);
    }
}
