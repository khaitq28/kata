package interview.craftsman.question4;

public class UserAccountBank {

    public static void main(String[] args) {
        UserAccountBank userAccountBank = new UserAccountBank.UserAccountBankBuilder()
                                                .userName("John Doe")
                                                .build();

    }

    private final String username;
    private final String email;
    private final String phone;
    private final String address;
    private final boolean active;
    private final boolean admin;
    private final int age;


    private UserAccountBank(UserAccountBankBuilder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.active = builder.active;
        this.admin = builder.admin;
        this.age = builder.age;
    }
    public static class UserAccountBankBuilder {

        public UserAccountBank build() {
            return new UserAccountBank(this);
        }

        public UserAccountBankBuilder userName(String username) {
            this.username = username;
            return this;
        }

        public UserAccountBankBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserAccountBankBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserAccountBankBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserAccountBankBuilder active(boolean active) {
            this.active = active;
            return this;
        }

        public UserAccountBankBuilder admin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public UserAccountBankBuilder age(int age) {
            this.age = age;
            return this;
        }

        private String username;
        private String email;
        private String phone;
        private String address;
        private boolean active;
        private boolean admin;
        private int age;
    }

}
