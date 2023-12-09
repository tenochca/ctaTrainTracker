import org.json.*;
import java.io.*;
import java.util.*;


public class Main {

    public static String[] greenLineCottageGrove = new String[] {"Cottage Grove", "King Drive", "Ashland/63rd",
            "Halsted", "Garfield", "52st", "47th", "43rd", "Indiana", "35th-Bronzeville-IIT", "Cernak-McCormick Place",
            "Roosevelt", "Adams/Wabash", "Washington/Wabash", "State/Lake", "Clark/Lake", "Clinton", "Morgan", "Ashland",
            "California", "Kedzie", "Conservatory-Central Park Drive", "Pulaski", "Cicero", "Laramie", "Central", "Austin",
            "Ridgeland", "Oak Park", "Harlem/Lake"};
    public static String[] orangeLine = new String[] {"Midway", "Pulaski", "Kedzie", "Western","35th/Archer",
            "Ashland", "Halsted", "Roosevelt", "Harold Washington Library-State/Van Buren", "LaSalle/Van Buren",
            "Quincy", "Washington/Wells", "Clark/lake", "State/lake", "Washington/Wabash", "Adams/Wabash"};
    public static String[] redLine = new String[] {"95th/Dan Ryan", "87th", "79th", "69th", "63rd", "Garfield",
            "47th", "Sox-35th", "Cermak-Chinatown", "Roosevelt", "Harrison", "Jackson", "Monroe", "Lake", "Grand",
            "Chicago", "Clark/Division", "North/Clybourn", "Fullerton", "Belmont", "Addison", "Sheridan", "Wilson",
            "Lawrence", "Argyle", "Berwyn", "Bryn Mawr", "Thorndale", "Granville", "Loyola", "Morse", "Jarvis", "Howard"};
    public static String[] blueLine = new String[] {"Forest Park", "Harlem", "Oak Park", "Austin", "Cicero",
            "Pulaski", "Kedzie-Homan", "Western (Forest Park Branch)", "Illinois Medical District", "Racine",
            "UIC-Halsted", "Clinton", "LaSalle", "Jackson", "Monroe", "Washington", "Clark/Lake", "Grand", "Chicago",
            "Division", "Damen", "Western (O'Hare Branch)", "California", "Logan Square", "Belmont", "Addison", "Irving Park",
            "Montrose", "Jefferson Park", "Harlem", "Cumberland", "Rosemont", "O'Hare"};
    public static String[] brownLine = new String[] {"Kimball", "Kedzie", "Francisco", "Rockwell", "Western", "Damen",
            "Montrose", "Irving Park", "Addison", "Paulina", "Southport", "Belmont", "Wellington", "Diversey", "Fullerton",
            "Armitage", "Sedgwick", "Chicago", "Merchandise Mart", "Washington/Wells", "LaSalle/Van Buren", "Harold Washington Library-State/Van Buren",
            "Adams/Wabash", "Washington/Wabash", "State/Lake", "Clark/lake"};
    public static String[] pinkLine = new String[] {"54th/Cermak", "Cicero", "Kostner", "Pulaski", "Central Park", "Kedzie",
            "California", "Western", "Damen", "18th", "Polk", "Ashland", "Morgan", "Clinton", "Clark/Lake", "State/Lake",
            "Washington/Wabash", "Adams/Wabash", "Adamns/Wabash", "Harold Washington Library-State/Van Buren", "LaSalle/Van Buren",
            "Quincy", "Washington/Wells"};
    public static String[] purpleLine = new String[] {"Linden", "Central", "Noyes", "Foster", "Davis", "Dempster", "Main",
            "South Blvd", "Howard", "Wilson", "Belmont", "Wellington", "Diversey", "Fullerton", "Armitage", "Sedgwick",
            "Chicago", "Merchandise March", "Clark/lake", "State/Lake", "Washington/Wabash", "Adams/Wabash", "Adamns/Wabash",
            "Harold Washington Library-State/Van Buren", "LaSalle/Van Buren", "Quincy", "Washington/Wells"};
    public static String[] skokieSwift = new String[] {"Dempster-Skokie", "Oakton-Skokie", "Howard"};
public static void printTrains(String input, String[] route) throws JSONException, IOException {
    ArrayList<Train> trains = TrainTracker.getResponse(input);
    Route.populateRoute(route);
    assert trains != null;
    Route.assignTrains(trains);
    Route.print();
}


    public static void main(String[] args) throws IOException, JSONException {

        Map<String, String[]> trainLines = new HashMap<>() {{
            put("Green Line", greenLineCottageGrove);
            put("Orange Line", orangeLine);
            put("Red Line", redLine);
            put("Blue Line", blueLine);
            put("Brown Line", brownLine);
            put("Pink Line", pinkLine);
            put("Purple Line", purpleLine);
            put("Skokie Swift", skokieSwift);
        }};

        System.out.println("""
                Welcome to the cta Train Tracker :)
                
                Please choose from the following train lines:
                >Green Line
                >Orange Line
                >Red Line
                >Blue Line
                >Brown Line
                >Pink Line
                >Purple Line
                >Skokie Swift
                
               """);


        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter here: ");
            String trainLine = scanner.nextLine();

            if (trainLines.containsKey(trainLine)) {
                try {
                    printTrains(trainLine, trainLines.get(trainLine));
                } catch (JSONException noTrains) {
                    System.out.println("!!!Current Line has no train service!!!");
                }
            } else {
                System.out.println("!!!Invalid Line!!!\nPlease make sure to use the names shown above");
            }

            System.out.println("""
                    Choose from the following:
                    <1> SELECT NEW LINE
                    <2> REFRESH CURRENT LINE
                    <3> EXIT PROGRAM
                    
                    Please enter the corresponding number:
                    """);
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("3")) {
                break;
            }
            else if(response.equalsIgnoreCase("2")) {
                printTrains(trainLine, trainLines.get((trainLine)));
                System.out.println("""
                    Choose from the following:
                    <1> SELECT NEW LINE
                    <2> REFRESH CURRENT LINE
                    <3> EXIT PROGRAM
                    
                    Please enter the corresponding number:
                    """);
            }
        }
    }
}
