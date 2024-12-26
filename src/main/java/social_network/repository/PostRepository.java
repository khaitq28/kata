package social_network.repository;

import social_network.domain.Post;
import social_network.domain.User;

import java.util.List;

public interface PostRepository {
    void save(Post post);
    List<Post> findByUser(User user);
}
