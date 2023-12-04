public class Train {

    String runNumber;
    String nextStop;
    String arrivalTime;
    String isDue;
    String destination;

    public Train(String runNumber, String nextStop, String arrivalTime, String isDue, String destination) {
        this.runNumber = runNumber;
        this.nextStop = nextStop;
        this.arrivalTime = arrivalTime;
        this.isDue = isDue;
        this.destination = destination;
    }
}
