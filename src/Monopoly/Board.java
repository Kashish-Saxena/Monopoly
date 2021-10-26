package Monopoly;
import org.json.JSONObject;
import java.util.ArrayList;

public class Board {
    public ArrayList<Property> propertyList;

    public Board() {
        propertyList = new ArrayList<>();
        JSONObject o = new JSONObject(json);
        for (int i = 0 ; i < o.length(); i++) {
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

    static String json = "{\n" +
            "  \"0\": {\n" +
            "    \"name\":\"Free Square (GO)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "\n" +
            "  \"1\": {\n" +
            "    \"name\":\"Mediterranean Avenue\",\n" +
            "    \"purchasingCost\":\"60\",\n" +
            "    \"baseRentCost\":\"2\",\n" +
            "    \"colour\":\"brown\"\n" +
            "  },\n" +
            "  \"2\": {\"name\":\"Free Square (Community Chest)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"3\": {\n" +
            "    \"name\":\"Baltic Avenue\",\n" +
            "    \"purchasingCost\":\"60\",\n" +
            "    \"baseRentCost\":\"4\",\n" +
            "    \"colour\":\"brown\"\n" +
            "  },\n" +
            "  \"4\": {\"name\":\"Free Square (Income Tax)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"5\": {\"name\":\"Free Square (Reading Railroad)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"6\": {\n" +
            "    \"name\":\"Oriental Avenue\",\n" +
            "    \"purchasingCost\":\"100\",\n" +
            "    \"baseRentCost\":\"6\",\n" +
            "    \"colour\":\"lightblue\"\n" +
            "  },\n" +
            "  \"7\": {\"name\":\"Free Square (Chance)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"8\": {\n" +
            "    \"name\":\"Vermont Avenue\",\n" +
            "    \"purchasingCost\":\"100\",\n" +
            "    \"baseRentCost\":\"6\",\n" +
            "    \"colour\":\"lightblue\"\n" +
            "  },\n" +
            "  \"9\": {\n" +
            "    \"name\":\"Connecticut Avenue\",\n" +
            "    \"purchasingCost\":\"120\",\n" +
            "    \"baseRentCost\":\"8\",\n" +
            "    \"colour\":\"lightblue\"\n" +
            "  },\n" +
            "  \"10\": {\"name\":\"Free Square (Jail)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"11\": {\n" +
            "    \"name\":\"St. Charles Place\",\n" +
            "    \"purchasingCost\":\"140\",\n" +
            "    \"baseRentCost\":\"10\",\n" +
            "    \"colour\":\"pink\"\n" +
            "  },\n" +
            "  \"12\": {\"name\":\"Free Square (Electric Company)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"13\": {\n" +
            "    \"name\":\"States Avenue\",\n" +
            "    \"purchasingCost\":\"140\",\n" +
            "    \"baseRentCost\":\"10\",\n" +
            "    \"colour\":\"pink\"\n" +
            "  },\n" +
            "  \"14\": {\n" +
            "    \"name\":\"Virginia Avenue\",\n" +
            "    \"purchasingCost\":\"160\",\n" +
            "    \"baseRentCost\":\"12\",\n" +
            "    \"colour\":\"pink \"\n" +
            "  },\n" +
            "  \"15\": {\"name\":\"Free Square (Pennsylvania Railroad)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"16\": {\n" +
            "    \"name\":\"St. James Place\",\n" +
            "    \"purchasingCost\":\"180\",\n" +
            "    \"baseRentCost\":\"14\",\n" +
            "    \"colour\":\"orange\"\n" +
            "  },\n" +
            "  \"17\": {\"name\":\"Free Square (Community Chest)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"18\": {\n" +
            "    \"name\":\"Tennessee Avenue\",\n" +
            "    \"purchasingCost\":\"180\",\n" +
            "    \"baseRentCost\":\"14\",\n" +
            "    \"colour\":\"orange\"\n" +
            "  },\n" +
            "  \"19\": {\n" +
            "    \"name\":\"New York Avenue\",\n" +
            "    \"purchasingCost\":\"200\",\n" +
            "    \"baseRentCost\":\"16\",\n" +
            "    \"colour\":\"orange\"\n" +
            "  },\n" +
            "  \"20\": {\"name\":\"Free Square (Free Parking)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"21\": {\n" +
            "    \"name\":\"Kentucky Avenue\",\n" +
            "    \"purchasingCost\":\"220\",\n" +
            "    \"baseRentCost\":\"18\",\n" +
            "    \"colour\":\"red\"\n" +
            "  },\n" +
            "  \"22\": {\"name\":\"Free Square (Chance)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"23\": {\n" +
            "    \"name\":\"Indiana Avenue\",\n" +
            "    \"purchasingCost\":\"220\",\n" +
            "    \"baseRentCost\":\"18\",\n" +
            "    \"colour\":\"red\"\n" +
            "  },\n" +
            "  \"24\": {\n" +
            "    \"name\":\"Illinois Avenue\",\n" +
            "    \"purchasingCost\":\"240\",\n" +
            "    \"baseRentCost\":\"20\",\n" +
            "    \"colour\":\"red\"\n" +
            "  },\n" +
            "  \"25\": {\"name\":\"Free Square (B&O Railroad)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"26\": {\n" +
            "    \"name\":\"Atlantic Avenue\",\n" +
            "    \"purchasingCost\":\"260\",\n" +
            "    \"baseRentCost\":\"22\",\n" +
            "    \"colour\":\"yellow\"\n" +
            "  },\n" +
            "  \"27\": {\n" +
            "    \"name\":\"Ventnor Avenue\",\n" +
            "    \"purchasingCost\":\"260\",\n" +
            "    \"baseRentCost\":\"22\",\n" +
            "    \"colour\":\"yellow\"\n" +
            "  },\n" +
            "  \"28\": {\"name\":\"Free Square (Waterworks)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"29\": {\n" +
            "    \"name\":\"Marvin Gardens\",\n" +
            "    \"purchasingCost\":\"280\",\n" +
            "    \"baseRentCost\":\"24\",\n" +
            "    \"colour\":\"yellow\"\n" +
            "  },\n" +
            "  \"30\": {\"name\":\"Free Square (Go to Jail)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"31\": {\n" +
            "    \"name\":\"Pacific Avenue\",\n" +
            "    \"purchasingCost\":\"300\",\n" +
            "    \"baseRentCost\":\"26\",\n" +
            "    \"colour\":\"green\"\n" +
            "  },\n" +
            "  \"32\": {\n" +
            "    \"name\":\"North Carolina Avenue\",\n" +
            "    \"purchasingCost\":\"300\",\n" +
            "    \"baseRentCost\":\"26\",\n" +
            "    \"colour\":\"green\"\n" +
            "  },\n" +
            "  \"33\": {\"name\":\"Free Square (Community Chest)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"34\": {\n" +
            "    \"name\":\"Pennsylvania Avenue\",\n" +
            "    \"purchasingCost\":\"320\",\n" +
            "    \"baseRentCost\":\"28\",\n" +
            "    \"colour\":\"green\"\n" +
            "  },\n" +
            "  \"35\": {\"name\":\"Free Square (Short Line)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"36\": {\"name\":\"Free Square (Chance)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"37\": {\n" +
            "    \"name\":\"Park Place\",\n" +
            "    \"purchasingCost\":\"350\",\n" +
            "    \"baseRentCost\":\"35\",\n" +
            "    \"colour\":\"darkblue\"\n" +
            "  },\n" +
            "  \"38\": {\"name\":\"Free Square (Luxury Tax)\",\n" +
            "    \"purchasingCost\":\"0\",\n" +
            "    \"baseRentCost\":\"0\",\n" +
            "    \"colour\":\"none\"},\n" +
            "  \"39\": {\n" +
            "    \"name\":\"Boardwalk\",\n" +
            "    \"purchasingCost\":\"400\",\n" +
            "    \"baseRentCost\":\"50\",\n" +
            "    \"colour\":\"darkblue\"\n" +
            "  }\n" +
            "\n" +
            "}";
}
