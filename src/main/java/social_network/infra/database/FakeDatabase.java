package social_network.infra.database;

import social_network.domain.Follow;
import social_network.domain.Post;
import social_network.domain.User;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */

public class FakeDatabase {

    private static final Map<User, List<Post>> userPosts = new HashMap<>();

    private static final Set<Follow> follows = new HashSet<>();

    public static void savePost(User user, Post post) {
        userPosts.putIfAbsent(user, new ArrayList<>());
        userPosts.get(user).add(post);
    }

    public static void saveUser(User user) {
        userPosts.putIfAbsent(user, new ArrayList<>());
    }

    public static List<Post> findPost(User user) {
        return userPosts.get(user);
    }

    public static User findUser(String name) {
        return userPosts.keySet().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static void saveFollow(Follow follow) {
        follows.add(follow);
    }

    public static void deleteFollow(Follow follow) {
        follows.removeIf(e -> e.getFollower().equals(follow.getFollower()) && e.getFollowee().equals(follow.getFollowee()));
    }

    public static List<User> findFollowing(User user) {
        return follows.stream()
                .filter(follow -> follow.getFollower().equals(user))
                .map(Follow::getFollowee)
                .toList();
    }
}
