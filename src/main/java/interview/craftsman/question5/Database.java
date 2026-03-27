package interview.craftsman.question5;

import java.util.Optional;

public class Database {
    public User find(int id) throws Exception {
        // stub
        return new User();
    }

    public Optional<User> findByUserId(int userId) throws UserNotFoundException {
        // stub
        return Optional.empty();
    }
}
