import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RomanNumeral {

    public String value;

    public RomanNumeral(String value) {
        this.value = value;
    }

    List<Character> sortOrder = Arrays.asList('M', 'D', 'C', 'L', 'X', 'V', 'I');

    public RomanNumeral sum(RomanNumeral numeral) {

        this.value = unpack(this.value);
        numeral.value = unpack(numeral.value);
        this.value = this.value + numeral.value;
        sortCharactersByDecreasingValue();
        this.value = pack(this.value);
        return this;
    }

    private String unpack(String s) {
        return s.replaceAll("CM", "DCCCC")
                .replaceAll("CD", "CCCC")
                .replaceAll("XC", "LXXXX")
                .replaceAll("XL", "XXXX")
                .replaceAll("IX", "VIIII")
                .replaceAll("IV", "IIII")
                ;
    }

    private String pack(String s) {
        return s.replaceAll("IIIII", "V")
                .replaceAll("VV", "X")
                .replaceAll("XXXXX", "L")
                .replaceAll("LL", "C")
                .replaceAll("CCCCC", "D")
                .replaceAll("DD","M")
                // 1 unit from a 10 unit
                .replaceAll("DCCCC", "CM")
                .replaceAll("LXXXX", "XC")
                .replaceAll("VIIII", "IX")
                // 1 unit from a 5 unit
                .replaceAll("IIII", "IV")
                .replaceAll("XXXX", "XL")
                .replaceAll("CCCC", "CD")
                ;
    }

    private void sortCharactersByDecreasingValue() {
        List<Character> list = new ArrayList<>();
        for (char ch: this.value.toCharArray()) {
            list.add(ch);
        }

        list.sort(Comparator.comparingInt(left -> sortOrder.indexOf(left)));

        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }
        this.value = sb.toString();
    }
}
