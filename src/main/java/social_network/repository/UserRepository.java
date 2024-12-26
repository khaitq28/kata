package social_network.repository;

import social_network.domain.User;

public interface UserRepository {
    void save(User user);
    User findByName(String name);
}
