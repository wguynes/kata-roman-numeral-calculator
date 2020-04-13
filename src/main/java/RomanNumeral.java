import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RomanNumeral {

    public String value;

    public RomanNumeral(String value) {
        this.value = value;
    }

    List<Character> sortOrder = Arrays.asList('V','I');

    public RomanNumeral sum(RomanNumeral numeral) {
        this.value = this.value.replaceAll("IX", "VIIII");
        this.value = this.value.replaceAll("IV", "IIII");

        numeral.value = numeral.value.replaceAll("IX", "VIIII");
        numeral.value = numeral.value.replaceAll("IV", "IIII");

        this.value = new StringBuilder().append(this.value).append(numeral.value).toString();

        sortValueCharacters();

        this.value = this.value.replaceAll("IIIII", "V");
        this.value = this.value.replaceAll("VV", "X");
        this.value = this.value.replaceAll("VIIII", "IX");
        this.value = this.value.replaceAll("IIII", "IV");

        return this;
    }

    private void sortValueCharacters() {
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
