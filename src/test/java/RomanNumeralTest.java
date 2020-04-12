import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralTest {

    @Test
    public void takesStringInConstructor() {
        RomanNumeral numeral = new RomanNumeral("I");
        assertEquals("I", numeral.value);
    }
}
