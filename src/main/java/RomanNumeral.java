import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class RomanNumeral {

    public String value;

    public RomanNumeral(String value) {
        this.value = value;
    }

    List<Character> sortOrder = Arrays.asList('M', 'D', 'C', 'L', 'X', 'V', 'I');
    List<Pair<String, String>> ORDERED_LIST_OF_UNPACKING_PAIRS = Arrays.asList(
            new Pair<>("CM", "DCCCC"),
            new Pair<>("CD", "CCCC"),
            new Pair<>("XL", "XXXX"),
            new Pair<>("XC", "LXXXX"),
            new Pair<>("IX", "VIIII"),
            new Pair<>("IV", "IIII")
    );
    List<Pair<String, String>> ORDERED_LIST_OF_PACKING_PAIRS = Arrays.asList(
            // pack
            new Pair<>("IIIII", "V"),
            new Pair<>("VV", "X"),
            new Pair<>("XXXXX", "L"),
            new Pair<>("LL", "C"),
            new Pair<>("CCCCC", "D"),
            new Pair<>("DD","M"),
            // reintroduce 9s
            new Pair<>("DCCCC", "CM"),
            new Pair<>("LXXXX", "XC"),
            new Pair<>("VIIII", "IX"),
            // reintroduce 4s
            new Pair<>("CCCC", "CD"),
            new Pair<>("XXXX", "XL"),
            new Pair<>("IIII", "IV")
    );


    public RomanNumeral sum(RomanNumeral numeral) {
        this.substituteSubStrings(ORDERED_LIST_OF_UNPACKING_PAIRS);
        numeral.substituteSubStrings(ORDERED_LIST_OF_UNPACKING_PAIRS);

        this.value = this.value + numeral.value;
        sortCharactersByDecreasingValue();

        this.substituteSubStrings(ORDERED_LIST_OF_PACKING_PAIRS);
        return this;
    }

    private void substituteSubStrings(List<Pair<String, String>> pairList) {
        for (Pair<String, String> p : pairList) {
            this.value = this.value.replaceAll(p.getL(), p.getR());
        }
    }

    private void sortCharactersByDecreasingValue() {
        this.value = this.value
                .chars()
                .mapToObj(e -> (char)e)
                .sorted(Comparator.comparingInt(left -> sortOrder.indexOf(left)))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
