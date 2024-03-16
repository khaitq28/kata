package tripservicekata.trip;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tripservicekata.exception.UserNotLoggedInException;
import tripservicekata.user.User;
import tripservicekata.user.UserBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@ExtendWith(MockitoExtension.class)
class TripServiceTest {
    private TripService tripService;

    private final User unknownUser = null;
    private final User normalUser = new User();
    private final User friend = new User();
    private User loggedUser;

    @Test
    public void shouldThrowExceptionWhenUserNotLogged() {
        loggedUser = null;
        tripService = new NormalUserTripService();
        Assertions.assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(null));
    }

    @Test
    public void returnEmptyListTripIfNotFiends() {
        loggedUser = normalUser;
        tripService = new NormalUserTripService();
        assertEquals(0, tripService.getTripsByUser(new User()).size());
    }

    @Test
    public void returnTripsIfFiends() {
        tripService = new NormalUserTripService();
        loggedUser = normalUser;
        User user = UserBuilder.builder().addTrips(new Trip()).addFriend(loggedUser).build();
        assertEquals(1, tripService.getTripsByUser(user).size());
    }


    private class NormalUserTripService extends  TripService {
        @Override
        protected User getLoggedUser() {
            return loggedUser;
        }
        @Override
        protected List<Trip> getUserTrips(User user) {
            return user.trips();
        }
    }

}
