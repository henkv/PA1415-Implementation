package group.b3;

import java.util.ArrayList;

/**
 * Created by hannahlovberg on 2016-05-12.
 */
public class System {
    private ArrayList<User> users;
    private FlightManager flightManager;

    public System(ArrayList<User> users) {
        this.users = users;
    }

    public User getUser(String username, String password){

        User searchedUser = null;

        for (int i= 0; i < users.size() && searchedUser == null; i++){

            if (username == users.get(i).getName() && password == users.get(i).getPassword()){
                searchedUser = users.get(i);
            }

        }

        return searchedUser;
    }

    public void addFLight(Flight flight){
        this.flightManager.addFlight(flight);
    }


}
