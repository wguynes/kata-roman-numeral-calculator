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
        RomanNumeral numeral = new RomanNumeral("I");
        numeral.sum(numeral);
        assertEquals("II", numeral.value);
    }

    @Test
    public void givesIIIforSumOfIandII() {
        RomanNumeral numeral = new RomanNumeral("I");
        numeral.sum(new RomanNumeral("II"));
        assertEquals("III", numeral.value);
    }
}
