package social_network.repository;

import social_network.domain.Follow;
import social_network.domain.User;

import java.util.List;

public interface FollowRepository {
    void saveFollow(Follow follow);
    void deleteFollow(Follow follow);
    List<User> findFollowing(User user);
}
