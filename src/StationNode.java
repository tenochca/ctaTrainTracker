public class StationNode {

    String name;

    StationNode prev;
    StationNode next;

    public StationNode(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }


}
