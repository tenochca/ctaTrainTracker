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
            StationNode newStation = new StationNode(name); //create new node ln
            newStation.prev = tail; //lns prev becomes the tail
            tail.next = newStation; //ln becomes tails next
            tail = newStation; //ln becomes tail
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
            System.out.print(walker.name + " "); //print out walker.data
            walker = walker.next; //update walker
        }

        System.out.println();
    }
}
