package social_network.service;

import social_network.domain.User;

public interface FollowService {
    void follow(User follower, User followee);
    void unfollow(User follower, User followee);
}
