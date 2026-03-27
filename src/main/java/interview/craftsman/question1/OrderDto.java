package interview.craftsman.question1;

import java.math.BigDecimal;

/**
 * Strong-typed DTO replacing Map<String, Object>.
 */
public record OrderDto(String orderId, String customerName, BigDecimal amount) {}
