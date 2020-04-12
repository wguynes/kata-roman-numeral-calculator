public class RomanNumeral {

    public String value;

    public RomanNumeral(String value) {
        this.value = value;
    }

    public RomanNumeral sum(RomanNumeral numeral) {
        this.value = new StringBuilder().append(this.value).append(numeral.value).toString();
        this.value = this.value.replaceAll("IIIII", "V");

        return this;
    }
}
