package social_network.service;

import social_network.domain.Follow;
import social_network.domain.User;
import social_network.repository.FollowRepository;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */

public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public void follow(User follower, User followee) {
        this.followRepository.saveFollow(new Follow(follower, followee));
    }

    @Override
    public void unfollow(User follower, User followee) {
        this.followRepository.deleteFollow(new Follow(follower, followee));
    }

}
