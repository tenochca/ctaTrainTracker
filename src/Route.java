public class Route {

    static StationNode head;
    static StationNode tail;
    static int size = 0;

    public static void addLast(String name) {
        if (size == 0) { // if the list is empty
            StationNode newStation = new StationNode(name); //creates a new single node in the list
            head = newStation;
            tail = newStation;
            size++;
        } else {
            StationNode newStation = new StationNode(name);
            newStation.prev = tail;
            tail.next = newStation;
            tail = newStation;
            size++; //increase the size
        }
    }

    public static void populateRoute(String[] stationNames) {
        for (String i : stationNames) { //iterate through array
            addLast(i); //add the stations to the route
        }
    }

    public static void print() {
        StationNode walker = head; //create walker
        while (walker != null) { //while walker is not null
            System.out.print(walker.name + " -> ");
            if (walker.run != null && walker.run.isDue.equals("1")) {
                System.out.print(" (Train Due: Run #" + walker.run.runNumber + " going to " + walker.run.destination + ")");
            }
            System.out.println(" ");
            walker = walker.next; //update walker
        }
        System.out.println();
    }

    public static StationNode getStationNode(String name) {
        StationNode walker = head;
        while (walker != null) {
            if (walker.name.equals(name)) { //walk the list until we find the station
                return walker; //return the station
            }
            walker = walker.next;
        }
        return null; //return null if no station with the name is found
    }
}
