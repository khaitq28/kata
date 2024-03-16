package tripservicekata.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {


    @Test
    public void testNotFriend() {
        User Alice = UserBuilder.builder().build();
        User Bod = UserBuilder.builder().build();
        Assertions.assertFalse(Alice.isFriendWith(Bod));
    }


    @Test
    public void testCaseFriend() {
        User Alice = UserBuilder.builder().build();
        User Tom = UserBuilder.builder().build();
        User Bod = UserBuilder.builder().addFriend(Alice).addFriend(Tom).build();
        Assertions.assertTrue(Bod.isFriendWith(Alice));
        Assertions.assertTrue(Bod.isFriendWith(Tom));
    }
}
