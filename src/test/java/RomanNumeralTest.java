import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralTest {

    void assertSum(String first, String second, String expectedProduct)
    {
        RomanNumeral numeral = new RomanNumeral(first);
        numeral.sum(new RomanNumeral(second));
        assertEquals(expectedProduct, numeral.value);
    }

    @Test
    public void takesStringInConstructor() {
        RomanNumeral numeral = new RomanNumeral("I");
        assertEquals("I", numeral.value);
    }

    @Test
    public void sumsToII() {
        assertSum("I", "I", "II");
    }

    @Test
    public void sumsToIII() {
        assertSum("I", "II", "III");
        assertSum("II", "I", "III");
    }

    @Test
    public void sumsToIV() {
        assertSum("I", "III", "IV");
        assertSum("II", "II", "IV");
        assertSum("III", "I", "IV");
    }

    @Test
    public void sumsToV() {
        assertSum("I", "IV", "V");
        assertSum("II", "III", "V");
        assertSum("III", "II", "V");
        assertSum("IV", "I", "V");
    }

    @Test
    public void sumsToVI() {
        assertSum("I", "V", "VI");
        assertSum("II", "IV", "VI");
        assertSum("III", "III", "VI");
        assertSum("IV", "II", "VI");
        assertSum("V", "I", "VI");
    }

    @Test
    public void sumsToIX() {
        assertSum("I", "VIII", "IX");
        assertSum("II", "VII", "IX");
        assertSum("III", "VI", "IX");
        assertSum("IV", "V", "IX");
        assertSum("V", "IV", "IX");
        assertSum("VI", "III", "IX");
        assertSum("VII", "II", "IX");
        assertSum("VIII", "I", "IX");
    }

    @Test
    public void sumsToX() {
        assertSum("I", "IX", "X");
        assertSum("II", "VIII", "X");
        assertSum("III", "VII", "X");
        assertSum("IV", "VI", "X");
        assertSum("V", "V", "X");
        assertSum("VI", "IV", "X");
        assertSum("VII", "III", "X");
        assertSum("VIII", "II", "X");
        assertSum("IX", "I", "X");
    }
}
