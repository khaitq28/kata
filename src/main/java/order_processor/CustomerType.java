package order_processor;

import lombok.Getter;

@Getter
public enum CustomerType {
    VIP,
    MEMBER,
    GUEST;

    public static CustomerType fromString(String customerType) {
        for (CustomerType dt : CustomerType.values()) {
            if (dt.name().equals(customerType)) return dt;
        }
        return null;
    }
}
