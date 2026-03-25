package interview.question3;

public record Country(String code) {
    public boolean isUs() {
        return code.equalsIgnoreCase("US");
    }
}
