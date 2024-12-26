package social_network.controller;

import social_network.service.FollowService;
import social_network.service.UserService;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */

public class FollowController {

    private final FollowService followService;
    private final UserService userService;

    public FollowController(FollowService followService, UserService userService) {
        this.followService = followService;
        this.userService = userService;
    }

    public void follow(FollowRequestDto followRequest) {
        String followerName = followRequest.getFollowerName();
        String followingName = followRequest.getFollowingName();
        this.followService.follow(userService.findByName(followerName), userService.findByName(followingName));
    }

    public void unfollow(FollowRequestDto followRequest) {
        String followerName = followRequest.getFollowerName();
        String followingName = followRequest.getFollowingName();
        this.followService.unfollow(userService.findByName(followerName), userService.findByName(followingName));
    }
}
