package interview.craftsman.question16.correction;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String id;
    private String customerEmail;
    private String customerPhone;
    private List<String> items;
}
