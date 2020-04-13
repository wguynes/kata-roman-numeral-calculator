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

    @Test
    public void sumsToXXX() {
        assertSum("X", "XX", "XXX");
        assertSum("XX", "X", "XXX");
    }

    @Test
    public void sumsToXL() {
        assertSum("X", "XXX", "XL");
        assertSum("XX", "XX", "XL");
        assertSum("XXX", "X", "XL");
    }

    @Test
    public void XXplusXXXsumsToL() {
        assertSum("XX", "XXX", "L");
    }

    @Test
    public void XLplusXsumsToL() {
        assertSum("XL", "X", "L");
        assertSum("X", "XL", "L");
    }

    @Test
    public void sumsToC() {
        assertSum("X", "XC", "C");
        assertSum("XX", "LXXX", "C");
        assertSum("XXX", "LXX", "C");
        assertSum("XL", "LX", "C");
        assertSum("L", "L", "C");
        assertSum("LX", "XL", "C");
        assertSum("LXX", "XXX", "C");
        assertSum("LXXX", "XX", "C");
        assertSum("XC", "X", "C");
    }

    @Test
    public void sumsToXC() {
        assertSum("X", "LXXX", "XC");
        assertSum("XX", "LXX", "XC");
        assertSum("XXX", "LX", "XC");
        assertSum("XL", "L", "XC");
        assertSum("L", "XL", "XC");
        assertSum("LX", "XXX", "XC");
        assertSum("LXX", "XX", "XC");
        assertSum("LXXX", "X", "XC");
    }

    @Test
    public void sumsToD() {
        assertSum("C", "CD", "D");
        assertSum("CC", "CCC", "D");
        assertSum("CCC", "CC", "D");
        assertSum("CD", "C", "D");
    }

    @Test
    public void sumsToCD() {
        assertSum("C", "CCC", "CD");
        assertSum("CC", "CC", "CD");
        assertSum("CCC", "C", "CD");
    }

    @Test
    public void sumsToM() {
        assertSum("C", "CM", "M");
        assertSum("CC", "DCCC", "M");
        assertSum("CCC", "DCC", "M");
        assertSum("CD", "DC", "M");
        assertSum("D", "D", "M");
        assertSum("DC", "CD", "M");
        assertSum("DCC", "CCC", "M");
        assertSum("DCCC", "CC", "M");
        assertSum("CM", "C", "M");
    }

    @Test
    public void sumsToCM() {
        assertSum("C", "DCCC", "CM");
        assertSum("CC", "DCC", "CM");
        assertSum("CCC", "DC", "CM");
        assertSum("CD", "D", "CM");
        assertSum("D", "CD", "CM");
        assertSum("DC", "CCC", "CM");
        assertSum("DCC", "CC", "CM");
        assertSum("DCCC", "C", "CM");
    }

}
