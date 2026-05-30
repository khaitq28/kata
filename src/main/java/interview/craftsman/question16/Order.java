package interview.craftsman.question16;

import java.util.List;

public class Order {
    private String id;
    private String customerEmail;
    private String customerPhone;
    private List<String> items;

    public String getId()             { return id; }
    public String getCustomerEmail()  { return customerEmail; }
    public String getCustomerPhone()  { return customerPhone; }
    public List<String> getItems()    { return items; }
}
