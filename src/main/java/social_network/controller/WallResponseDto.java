package social_network.controller;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */


@Data
@Builder
public class WallResponseDto {

    private final String userName;
    private final List<String> posts;

    public void print() {
        System.out.println("========================");
        System.out.println("Wall of " + this.userName);
        this.posts.forEach(System.out::println);
    }

}
