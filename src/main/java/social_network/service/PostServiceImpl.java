package social_network.service;

import social_network.domain.Post;
import social_network.domain.User;
import social_network.repository.PostRepository;

import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void post(User user, String text) {
        Post post = new Post(user, text);
        postRepository.save(post);
    }

    @Override
    public List<Post> getPosts(User user) {
        return postRepository.findByUser(user);
    }

}
