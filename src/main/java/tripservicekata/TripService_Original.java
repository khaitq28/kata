package tripservicekata;


import tripservicekata.exception.UserNotLoggedInException;
import tripservicekata.trip.Trip;
import tripservicekata.trip.TripDAO;
import tripservicekata.user.User;
import tripservicekata.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService_Original {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<>();
		User loggedUser = UserSession.getInstance().getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = TripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
	
}
