package tripservicekata.trip;


import tripservicekata.exception.UserNotLoggedInException;
import tripservicekata.user.User;
import tripservicekata.user.UserSession;

import java.util.ArrayList;
import java.util.List;
public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = getLoggedUser();
		validateLoggedUser(loggedUser);

		if (user.isFriendWith(loggedUser))
			return getUserTrips(user);

		return new ArrayList<>();
	}

	private void validateLoggedUser(User loggedUser) {
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
	}

	protected List<Trip> getUserTrips(User user) {
		return TripDAO.findTripsByUser(user);
	}

	protected User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}

}
