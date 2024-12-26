package social_network.service;

import social_network.domain.User;

public interface UserService {
    void create(User user);

    User findByName(String name);
}
