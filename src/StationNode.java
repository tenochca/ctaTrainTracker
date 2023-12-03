public class StationNode {

    String name;
    StationNode prev;
    StationNode next;
    Train run;

    public StationNode(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
        this.run = null;
    }


}
