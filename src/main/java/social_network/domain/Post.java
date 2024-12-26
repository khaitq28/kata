package social_network.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

import static social_network.domain.TimeUtils.getTimeDiff;

@Data
@AllArgsConstructor
public class Post {

    private final User author;
    private final String text;
    private final LocalDateTime time;
    public Post(User author, String text) {
        this.author = author;
        this.text = text;
        this.time = LocalDateTime.now();
    }

    public String toString() {
        return author.getName() + ": " + text + " (" + getTimeDiff(time) + ")";
    }
    public void println() {
        System.out.println(toString());
    }

}
