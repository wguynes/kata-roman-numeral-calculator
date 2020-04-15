import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class StringPair extends Pair<String,String> {
    public StringPair(String left, String right) {
        super(left, right);
    }
}

public class RomanNumeral {

    public String value;

    public RomanNumeral(String value) {
        this.value = value;
    }

    List<Character> CHARACTER_VALUE_ORDER = Arrays.asList('M', 'D', 'C', 'L', 'X', 'V', 'I');
    List<StringPair> ORDERED_LIST_OF_UNPACKING_PAIRS = Arrays.asList(
            new StringPair("CM", "DCCCC"),
            new StringPair("CD", "CCCC"),
            new StringPair("XL", "XXXX"),
            new StringPair("XC", "LXXXX"),
            new StringPair("IX", "VIIII"),
            new StringPair("IV", "IIII")
    );
    List<StringPair> ORDERED_LIST_OF_PACKING_PAIRS = Arrays.asList(
            // pack
            new StringPair("IIIII", "V"),
            new StringPair("VV", "X"),
            new StringPair("XXXXX", "L"),
            new StringPair("LL", "C"),
            new StringPair("CCCCC", "D"),
            new StringPair("DD","M"),
            // reintroduce 9s
            new StringPair("DCCCC", "CM"),
            new StringPair("LXXXX", "XC"),
            new StringPair("VIIII", "IX"),
            // reintroduce 4s
            new StringPair("CCCC", "CD"),
            new StringPair("XXXX", "XL"),
            new StringPair("IIII", "IV")
    );


    public RomanNumeral sum(RomanNumeral numeral) {
        this.applyOrderedSubstitutions(ORDERED_LIST_OF_UNPACKING_PAIRS);
        numeral.applyOrderedSubstitutions(ORDERED_LIST_OF_UNPACKING_PAIRS);

        this.value = this.value + numeral.value;
        sortCharactersByDecreasingValue();

        this.applyOrderedSubstitutions(ORDERED_LIST_OF_PACKING_PAIRS);
        return this;
    }

    private void applyOrderedSubstitutions(List<StringPair> pairList) {
        for (StringPair p : pairList) {
            this.value = this.value.replaceAll(p.getLeft(), p.getRight());
        }
    }

    private void sortCharactersByDecreasingValue() {
        this.value = this.value
                .chars()
                .mapToObj(e -> (char)e)
                .sorted(Comparator.comparingInt(left -> CHARACTER_VALUE_ORDER.indexOf(left)))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public RomanNumeral difference(RomanNumeral numeral) {

//        long leftCountOfI = left.chars().filter(ch -> ch == 'I').count();
//        long rightCountOfI = right.chars().filter(ch -> ch == 'I').count();
//        long countToRemove = Math.min(leftCountOfI, rightCountOfI);

        long rightCount = numeral.value.chars().filter(ch -> ch == 'I').count();
        for (long i = 0; i < rightCount; i++) {
            this.value = this.value.replaceFirst("I","");
        }


        return this;
    }
}
