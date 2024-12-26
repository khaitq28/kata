package social_network.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class User {
    private final String name;
    private final List<Post> posts;
    private final List<User> following;

    public User(String name) {
        this.name = name;
        this.posts = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public void post(String text) {
        System.out.println(name + " posted");
        this.posts.add(new Post(this, text));
    }

    public void follow(User user) {
        this.following.add(user);
    }

}
