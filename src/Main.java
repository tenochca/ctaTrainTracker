import org.json.*;
import java.io.*;


public class Main {

    public static String[] greenLineCottageGrove = new String[] {"Cottage Grove", "King Drive", "Ashland / 63rd",
            "Halsted", "Garfield", "52st", "47th", "43rd", "Indiana", "35th-Bronzeville-IIT", "Cernak-McCormick Place",
            "Roosevelt", "Adams/Wabash", "Washington/Wabash", "State/Lake", "Clark/Lake", "Clinton", "Morgan", "Ashland",
            "California", "Kedzie", "Conservatory-Central Park Drive", "Pulaski", "Cicero", "Laramie", "Central", "Austin",
            "Ridgeland", "Oak Park", "Harlem/Lake"};

    public static void main(String[] args) throws JSONException, IOException {
        TrainTracker.getResponse("Green Line");
        Route.populateRoute(Main.greenLineCottageGrove);
        Route.print();
    }
}
