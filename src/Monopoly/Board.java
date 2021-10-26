package Monopoly;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

public class Board {
    public ArrayList<Property> propertyList;

    public Board() {
        ArrayList<Property> propertyList = new ArrayList<Property>();
        JSONObject o = new JSONObject(json);
        System.out.println(o.length());
        for(int i = 0 ; i < o.length(); i++) {
            String toS = Integer.toString(i);
            JSONObject pos = o.getJSONObject(toS);
            String costS = pos.getString("purchasingCost");
            int cost = Integer.parseInt(costS);
            String rentCost = pos.getString("baseRentCost");
            int rCost = Integer.parseInt(rentCost);
            String val = pos.getString("colour");
            propertyList.add(new Property(pos.getString("name"), cost, rCost, i,val));
        }
    }

    public ArrayList<Property> getBoard(){
        return propertyList;
    }

    static String json ="{\n" +
            "\t\"0\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\n" +
            "\t\"1\": {\n" +
            "\t\t\"name\": \"Mediterranean Avenue\",\n" +
            "\t\t\"purchasingCost\": \"60\",\n" +
            "\t\t\"baseRentCost\": \"2\",\n" +
            "\t\t\"colour\": \"brown\"\n" +
            "\t},\n" +
            "\t\"2\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"3\": {\n" +
            "\t\t\"name\": \"Baltic Avenue\",\n" +
            "\t\t\"purchasingCost\": \"60\",\n" +
            "\t\t\"baseRentCost\": \"4\",\n" +
            "\t\t\"colour\": \"brown\"\n" +
            "\t},\n" +
            "\t\"4\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"5\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"6\": {\n" +
            "\t\t\"name\": \"Oriental Avenue\",\n" +
            "\t\t\"purchasingCost\": \"100\",\n" +
            "\t\t\"baseRentCost\": \"6\",\n" +
            "\t\t\"colour\": \"lightblue\"\n" +
            "\t},\n" +
            "\t\"7\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"8\": {\n" +
            "\t\t\"name\": \"Vermont Avenue\",\n" +
            "\t\t\"purchasingCost\": \"100\",\n" +
            "\t\t\"baseRentCost\": \"6\",\n" +
            "\t\t\"colour\": \"lightblue\"\n" +
            "\t},\n" +
            "\t\"9\": {\n" +
            "\t\t\"name\": \"Connecticut Avenue\",\n" +
            "\t\t\"purchasingCost\": \"120\",\n" +
            "\t\t\"baseRentCost\": \"8\",\n" +
            "\t\t\"colour\": \"lightblue\"\n" +
            "\t},\n" +
            "\t\"10\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"11\": {\n" +
            "\t\t\"name\": \"St. Charles Place\",\n" +
            "\t\t\"purchasingCost\": \"140\",\n" +
            "\t\t\"baseRentCost\": \"10\",\n" +
            "\t\t\"colour\": \"pink\"\n" +
            "\t},\n" +
            "\t\"12\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"13\": {\n" +
            "\t\t\"name\": \"States Avenue\",\n" +
            "\t\t\"purchasingCost\": \"140\",\n" +
            "\t\t\"baseRentCost\": \"10\",\n" +
            "\t\t\"colour\": \"pink\"\n" +
            "\t},\n" +
            "\t\"14\": {\n" +
            "\t\t\"name\": \"Virginia Avenue\",\n" +
            "\t\t\"purchasingCost\": \"160\",\n" +
            "\t\t\"baseRentCost\": \"12\",\n" +
            "\t\t\"colour\": \"pink \"\n" +
            "\t},\n" +
            "\t\"15\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"16\": {\n" +
            "\t\t\"name\": \"St. James Place\",\n" +
            "\t\t\"purchasingCost\": \"180\",\n" +
            "\t\t\"baseRentCost\": \"14\",\n" +
            "\t\t\"colour\": \"orange\"\n" +
            "\t},\n" +
            "\t\"17\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"18\": {\n" +
            "\t\t\"name\": \"Tennessee Avenue\",\n" +
            "\t\t\"purchasingCost\": \"180\",\n" +
            "\t\t\"baseRentCost\": \"14\",\n" +
            "\t\t\"colour\": \"orange\"\n" +
            "\t},\n" +
            "\t\"19\": {\n" +
            "\t\t\"name\": \"New York Avenue\",\n" +
            "\t\t\"purchasingCost\": \"200\",\n" +
            "\t\t\"baseRentCost\": \"16\",\n" +
            "\t\t\"colour\": \"orange\"\n" +
            "\t},\n" +
            "\t\"20\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"21\": {\n" +
            "\t\t\"name\": \"Kentucky Avenue\",\n" +
            "\t\t\"purchasingCost\": \"220\",\n" +
            "\t\t\"baseRentCost\": \"18\",\n" +
            "\t\t\"colour\": \"red\"\n" +
            "\t},\n" +
            "\t\"22\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"23\": {\n" +
            "\t\t\"name\": \"Indiana Avenue\",\n" +
            "\t\t\"purchasingCost\": \"220\",\n" +
            "\t\t\"baseRentCost\": \"18\",\n" +
            "\t\t\"colour\": \"red\"\n" +
            "\t},\n" +
            "\t\"24\": {\n" +
            "\t\t\"name\": \"Illinois Avenue\",\n" +
            "\t\t\"purchasingCost\": \"240\",\n" +
            "\t\t\"baseRentCost\": \"20\",\n" +
            "\t\t\"colour\": \"red\"\n" +
            "\t},\n" +
            "\t\"25\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"26\": {\n" +
            "\t\t\"name\": \"Atlantic Avenue\",\n" +
            "\t\t\"purchasingCost\": \"260\",\n" +
            "\t\t\"baseRentCost\": \"22\",\n" +
            "\t\t\"colour\": \"yellow\"\n" +
            "\t},\n" +
            "\t\"27\": {\n" +
            "\t\t\"name\": \"Ventnor Avenue\",\n" +
            "\t\t\"purchasingCost\": \"260\",\n" +
            "\t\t\"baseRentCost\": \"22\",\n" +
            "\t\t\"colour\": \"yellow\"\n" +
            "\t},\n" +
            "\t\"28\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"29\": {\n" +
            "\t\t\"name\": \"Marvin Gardens\",\n" +
            "\t\t\"purchasingCost\": \"280\",\n" +
            "\t\t\"baseRentCost\": \"24\",\n" +
            "\t\t\"colour\": \"yellow\"\n" +
            "\t},\n" +
            "\t\"30\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"31\": {\n" +
            "\t\t\"name\": \"Pacific Avenue\",\n" +
            "\t\t\"purchasingCost\": \"300\",\n" +
            "\t\t\"baseRentCost\": \"26\",\n" +
            "\t\t\"colour\": \"green\"\n" +
            "\t},\n" +
            "\t\"32\": {\n" +
            "\t\t\"name\": \"North Carolina Avenue\",\n" +
            "\t\t\"purchasingCost\": \"300\",\n" +
            "\t\t\"baseRentCost\": \"26\",\n" +
            "\t\t\"colour\": \"green\"\n" +
            "\t},\n" +
            "\t\"33\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"34\": {\n" +
            "\t\t\"name\": \"Pennsylvania Avenue\",\n" +
            "\t\t\"purchasingCost\": \"320\",\n" +
            "\t\t\"baseRentCost\": \"28\",\n" +
            "\t\t\"colour\": \"green\"\n" +
            "\t},\n" +
            "\t\"35\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"36\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"37\": {\n" +
            "\t\t\"name\": \"Park Place\",\n" +
            "\t\t\"purchasingCost\": \"350\",\n" +
            "\t\t\"baseRentCost\": \"35\",\n" +
            "\t\t\"colour\": \"darkblue\"\n" +
            "\t},\n" +
            "\t\"38\": {\n" +
            "\t\t\"name\": \"Free Square\",\n" +
            "\t\t\"purchasingCost\": \"0\",\n" +
            "\t\t\"baseRentCost\": \"0\",\n" +
            "\t\t\"colour\": \"none\"\n" +
            "\t},\n" +
            "\t\"39\": {\n" +
            "\t\t\"name\": \"Boardwalk\",\n" +
            "\t\t\"purchasingCost\": \"400\",\n" +
            "\t\t\"baseRentCost\": \"50\",\n" +
            "\t\t\"colour\": \"darkblue\"\n" +
            "\t}\n" +
            "\n" +
            "}";
}
