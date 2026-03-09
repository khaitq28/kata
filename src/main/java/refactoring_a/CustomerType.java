package refactoring_a;

public enum CustomerType {
    VIP("VIP"),
    PREMIUM("Premium"),
    REGULAR("Regular");

    private final String displayName;

    CustomerType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
