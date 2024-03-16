package tripservicekata.user;


import tripservicekata.trip.Trip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 30/01/2024
 */

public class UserBuilder {

    private final List<User> friends = new ArrayList<>();
    private final List<Trip> trips = new ArrayList<>();

    public static UserBuilder builder() {
        return new UserBuilder();
    }
    public UserBuilder addFriend(User ...users) {
        this.friends.addAll(Arrays.asList(users));
        return this;
    }
    public UserBuilder addTrips(Trip ...trips) {
        this.trips.addAll(Arrays.asList(trips));
        return this;
    }
    public User build() {
        User user = new User();
        for (Trip t: trips) user.addTrip(t);
        for (User u: friends) user.addFriend(u);
        return user;
    }
}
