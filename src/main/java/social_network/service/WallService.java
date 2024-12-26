package social_network.service;

import social_network.domain.Post;
import social_network.domain.User;

import java.util.List;

public interface WallService {
    List<Post> getWallPostsFor(User user);
}
