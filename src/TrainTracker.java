import org.json.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
public class TrainTracker {

    static Map<String, String> trainRoute = new HashMap<>()  {{
        put("Red Line", "Red");
        put("Blue Line", "Blue");
        put("Brown Line", "Brn");
        put("Green Line", "G");
        put("Orange Line", "Org");
        put("Purple line", "P");
        put("Pink Line", "Pink");
        put("Skokie Swift", "Y");
    }};

    //api endpoint for getting train information
    public static final String BASE_URL = "https://lapi.transitchicago.com/api/1.0/ttpositions.aspx?key=";
    public static final String API_KEY = "57ab1165b4644d7a90321c937243a2b8";

    public static void getResponse(String trainLine) throws IOException, JSONException {
        String API_URL = BASE_URL + API_KEY + "&outputType=JSON" + "&rt=" + trainRoute.get(trainLine);

        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //opens a connection for the given url
        connection.setRequestMethod("GET"); //sets the method, in this case we only want to get info
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) { //checking if the request was a success
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); //storing the response data
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) { //storing the readLine in inputLine while that line != null
                response.append(inputLine); //append that line to response

            }
            //closing the buffered reader
            in.close();

            //parse JSON
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject ctattObject = jsonResponse.getJSONObject("ctatt");
            JSONArray route = ctattObject.getJSONArray("route");

            for (int i = 0; i < route.length(); i++) {
                JSONObject routeObject = route.getJSONObject(i);
                JSONArray trains = routeObject.getJSONArray("train");

                for (int j = 0; j < trains.length(); j++) {
                    JSONObject trainObject = trains.getJSONObject(j);
                    String destination = trainObject.getString("destNm");
                    String nextStop = trainObject.getString("nextStaNm");
                    String arrivalTime = trainObject.getString("arrT");
                    String isApproaching = trainObject.getString("isApp");
                    if (isApproaching.equals("1")) {
                        isApproaching = "Due now";
                    } else {
                        isApproaching = "Due at " + arrivalTime;
                    }
                    System.out.println(nextStop + " " + isApproaching);
                }
            }
        }
    }
}
