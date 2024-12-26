package social_network.service;

import social_network.domain.Post;
import social_network.domain.User;

import java.util.List;

public interface PostService {
    void post(User user, String text);
    List<Post> getPosts(User user);
}
