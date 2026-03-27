package interview.craftsman.question5;

import org.assertj.core.util.Strings;

public class User {
    private int id;
    private String name;
    private String email;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public boolean hasEmail() {
        return !Strings.isNullOrEmpty(email);
    }
}
