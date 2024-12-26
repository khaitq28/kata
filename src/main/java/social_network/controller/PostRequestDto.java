package social_network.controller;

import lombok.Data;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2024
 */

@Data
public class PostRequestDto {
    private final String author;
    private final String content;
}
