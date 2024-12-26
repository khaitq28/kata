package social_network.service;

import social_network.domain.User;
import social_network.repository.UserRepository;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        User user =  userRepository.findByName(name);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }
}
