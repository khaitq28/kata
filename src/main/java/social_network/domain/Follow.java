package social_network.domain;

import lombok.Data;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */

@Data
public class Follow {
    private User follower;
    private User followee;

    public Follow(User follower, User followee) {
        this.follower = follower;
        this.followee = followee;
    }

}
