package social_network.controller;

import social_network.domain.Post;
import social_network.domain.User;
import social_network.service.PostService;
import social_network.service.UserService;

import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */

public class PostController {

    private final PostService postService;

    private final UserService userService;
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    public void post(PostRequestDto postRequest) {
        String author = postRequest.getAuthor();
        String content = postRequest.getContent();
        User user = null;
        try {
            user = this.userService.findByName(author);
        } catch (RuntimeException e) {
            user = new User(author);
        }
        this.postService.post(user, content);
    }

    public List<Post> getPosts(String author) {
        User user = this.userService.findByName(author);
        return this.postService.getPosts(user);
    }

}
