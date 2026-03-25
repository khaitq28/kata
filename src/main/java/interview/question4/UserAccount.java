package interview.question4;

/**
 * INTERVIEW QUESTION 4 — Original (smelly) code.
 */
public class UserAccount {

    private String username;
    private String email;
    private String phone;
    private String address;
    private boolean active;
    private boolean admin;
    private int age;

    public UserAccount(String username, String email) {
        this(username, email, null, null, true, false, 0);
    }

    public UserAccount(String username, String email, String phone) {
        this(username, email, phone, null, true, false, 0);
    }

    public UserAccount(String username, String email, String phone, String address) {
        this(username, email, phone, address, true, false, 0);
    }

    public UserAccount(String username, String email, String phone,
                       String address, boolean active, boolean admin, int age) {
        this.username = username;
        this.email    = email;
        this.phone    = phone;
        this.address  = address;
        this.active   = active;
        this.admin    = admin;
        this.age      = age;
    }

    // caller — can you tell what true, false, 30 mean without an IDE?
    public static void main(String[] args) {
        UserAccount u = new UserAccount("alice", "alice@example.com", null, null, true, false, 30);
    }
}
