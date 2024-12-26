package social_network;


import social_network.controller.*;
import social_network.infra.database.FollowRepositoryImpl;
import social_network.infra.database.PostRepositoryImpl;
import social_network.infra.database.UserRepositoryImpl;
import social_network.service.FollowServiceImpl;
import social_network.service.PostServiceImpl;
import social_network.service.UserServiceImpl;
import social_network.service.WallServiceImpl;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        App app = new App();
        app.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if(input.equals("exit")) break;
            try {
                processInput(input);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private UserController userController = new UserController(new UserServiceImpl(new UserRepositoryImpl()));
    private final PostController postController = new PostController(new PostServiceImpl(new PostRepositoryImpl()), new UserServiceImpl(new UserRepositoryImpl()));
    private final FollowController followController = new FollowController(new FollowServiceImpl(new FollowRepositoryImpl()), new UserServiceImpl(new UserRepositoryImpl()));
    private final WallController wallController = new WallController(new UserServiceImpl(new UserRepositoryImpl()),
                                                            new WallServiceImpl(new PostRepositoryImpl(), new FollowRepositoryImpl()));
    private void processInput(String input) {
        if (input.contains("->")) {
            String[] parts = input.split(" -> ");
            String username = parts[0].trim();
            String message = parts[1].trim();
            post(username, message);
        } else if (input.contains("unfollows")) {
            String[] parts = input.split(" unfollows ");
            String follower = parts[0].trim();
            String followee = parts[1].trim();
            unfollow(follower, followee);
        } else if (input.contains("follows")) {
            String[] parts = input.split(" follows ");
            String follower = parts[0].trim();
            String followee = parts[1].trim();
            follow(follower, followee);
        } else if (input.contains("wall")) {
            String username = input.replace("wall ", "").trim();
            wall(username);
        } else {
            String username = input.trim();
            read(username);
        }
    }

    private void unfollow(String follower, String followee) {
        followController.unfollow(new FollowRequestDto(follower, followee));
    }

    private void read(String username) {
        postController.getPosts(username).forEach(System.out::println);
    }

    private void wall(String username) {
        wallController.getWallOf(username).print();
    }

    private void follow(String follower, String followee) {
        followController.follow(new FollowRequestDto(follower, followee));
    }


    private void post(String username, String message) {
        postController.post(new PostRequestDto(username, message));
    }
}
