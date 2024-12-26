package social_network.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */

@Data
@Builder
@AllArgsConstructor
public class FollowRequestDto {
    private String followerName;
    private String followingName;
}
