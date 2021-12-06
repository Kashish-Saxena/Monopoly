package Monopoly;
import org.json.JSONObject;


import java.io.*;
import java.util.ArrayList;


public class Board implements Serializable {
    public ArrayList<Property> propertyList;
    public ArrayList<Property> propertyList2;

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
            String house = pos.getString("houseCost");
            int hCost = Integer.parseInt(house);
            propertyList.add(new Property(pos.getString("name"), cost,hCost, rCost, i,val));
        }
    }

    public ArrayList<Property> getBoard(){
        return propertyList;
    }

    /**
     * saves/serializes this BoardGUI object.
     */
    public void serializeBoard (String filename){
        try {
            FileOutputStream fileOut = new FileOutputStream("saves/" + filename + "_game");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * loads/deserializes BoardGUI object.
     */
    public static Board deserializeBoard(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream("saves/" +filepath+ "_game");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Board board = (Board) objectIn.readObject();
            objectIn.close();
            return board;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void saveState(){
        this.propertyList2 = propertyList;
    }

    public void loadState(){
        propertyList = this.propertyList2;
    }

    static String json = "{\n" +
            "  \"0\": {\n" +
            "    \"name\": \"Free Square (GO)\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"1\": {\n" +
            "    \"name\": \"Mediterranean Avenue\",\n" +
            "    \"purchasingCost\": \"60\",\n" +
            "    \"baseRentCost\": \"2\",\n" +
            "    \"houseCost\": \"50\",\n" +
            "    \"colour\": \"brown\"\n" +
            "  },\n" +
            "  \"2\": {\n" +
            "    \"name\": \"Free Square (Community Chest)\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"3\": {\n" +
            "    \"name\": \"Baltic Avenue\",\n" +
            "    \"purchasingCost\": \"60\",\n" +
            "    \"baseRentCost\": \"4\",\n" +
            "    \"houseCost\": \"50\",\n" +
            "    \"colour\": \"brown\"\n" +
            "  },\n" +
            "  \"4\": {\n" +
            "    \"name\": \"Income Tax\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"200\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"5\": {\n" +
            "    \"name\": \"Reading Railroad\",\n" +
            "    \"purchasingCost\": \"200\",\n" +
            "    \"baseRentCost\": \"25\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"rail\"\n" +
            "  },\n" +
            "  \"6\": {\n" +
            "    \"name\": \"Oriental Avenue\",\n" +
            "    \"purchasingCost\": \"100\",\n" +
            "    \"baseRentCost\": \"6\",\n" +
            "    \"houseCost\": \"50\",\n" +
            "    \"colour\": \"lightblue\"\n" +
            "  },\n" +
            "  \"7\": {\n" +
            "    \"name\": \"Free Square (Chance)\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"8\": {\n" +
            "    \"name\": \"Vermont Avenue\",\n" +
            "    \"purchasingCost\": \"100\",\n" +
            "    \"baseRentCost\": \"6\",\n" +
            "    \"houseCost\": \"50\",\n" +
            "    \"colour\": \"lightblue\"\n" +
            "  },\n" +
            "  \"9\": {\n" +
            "    \"name\": \"Connecticut Avenue\",\n" +
            "    \"purchasingCost\": \"120\",\n" +
            "    \"baseRentCost\": \"8\",\n" +
            "    \"houseCost\": \"50\",\n" +
            "    \"colour\": \"lightblue\"\n" +
            "  },\n" +
            "  \"10\": {\n" +
            "    \"name\": \"Jail\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"11\": {\n" +
            "    \"name\": \"St. Charles Place\",\n" +
            "    \"purchasingCost\": \"140\",\n" +
            "    \"baseRentCost\": \"10\",\n" +
            "    \"houseCost\": \"100\",\n" +
            "    \"colour\": \"pink\"\n" +
            "  },\n" +
            "  \"12\": {\n" +
            "    \"name\": \"Electric Company\",\n" +
            "    \"purchasingCost\": \"150\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"util\"\n" +
            "  },\n" +
            "  \"13\": {\n" +
            "    \"name\": \"States Avenue\",\n" +
            "    \"purchasingCost\": \"140\",\n" +
            "    \"baseRentCost\": \"10\",\n" +
            "    \"houseCost\": \"100\",\n" +
            "    \"colour\": \"pink\"\n" +
            "  },\n" +
            "  \"14\": {\n" +
            "    \"name\": \"Virginia Avenue\",\n" +
            "    \"purchasingCost\": \"160\",\n" +
            "    \"baseRentCost\": \"12\",\n" +
            "    \"houseCost\": \"100\",\n" +
            "    \"colour\": \"pink\"\n" +
            "  },\n" +
            "  \"15\": {\n" +
            "    \"name\": \"Pennsylvania Railroad\",\n" +
            "    \"purchasingCost\": \"200\",\n" +
            "    \"baseRentCost\": \"25\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"rail\"\n" +
            "  },\n" +
            "  \"16\": {\n" +
            "    \"name\": \"St. James Place\",\n" +
            "    \"purchasingCost\": \"180\",\n" +
            "    \"baseRentCost\": \"14\",\n" +
            "    \"houseCost\": \"100\",\n" +
            "    \"colour\": \"orange\"\n" +
            "  },\n" +
            "  \"17\": {\n" +
            "    \"name\": \"Free Square (Community Chest)\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"18\": {\n" +
            "    \"name\": \"Tennessee Avenue\",\n" +
            "    \"purchasingCost\": \"180\",\n" +
            "    \"baseRentCost\": \"14\",\n" +
            "    \"houseCost\": \"100\",\n" +
            "    \"colour\": \"orange\"\n" +
            "  },\n" +
            "  \"19\": {\n" +
            "    \"name\": \"New York Avenue\",\n" +
            "    \"purchasingCost\": \"200\",\n" +
            "    \"baseRentCost\": \"16\",\n" +
            "    \"houseCost\": \"100\",\n" +
            "    \"colour\": \"orange\"\n" +
            "  },\n" +
            "  \"20\": {\n" +
            "    \"name\": \"Free Square (Free Parking)\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"21\": {\n" +
            "    \"name\": \"Kentucky Avenue\",\n" +
            "    \"purchasingCost\": \"220\",\n" +
            "    \"baseRentCost\": \"18\",\n" +
            "    \"houseCost\": \"150\",\n" +
            "    \"colour\": \"red\"\n" +
            "  },\n" +
            "  \"22\": {\n" +
            "    \"name\": \"Free Square (Chance)\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"23\": {\n" +
            "    \"name\": \"Indiana Avenue\",\n" +
            "    \"purchasingCost\": \"220\",\n" +
            "    \"baseRentCost\": \"18\",\n" +
            "    \"houseCost\": \"150\",\n" +
            "    \"colour\": \"red\"\n" +
            "  },\n" +
            "  \"24\": {\n" +
            "    \"name\": \"Illinois Avenue\",\n" +
            "    \"purchasingCost\": \"240\",\n" +
            "    \"baseRentCost\": \"20\",\n" +
            "    \"houseCost\": \"150\",\n" +
            "    \"colour\": \"red\"\n" +
            "  },\n" +
            "  \"25\": {\n" +
            "    \"name\": \"B&O Railroad\",\n" +
            "    \"purchasingCost\": \"200\",\n" +
            "    \"baseRentCost\": \"25\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"rail\"\n" +
            "  },\n" +
            "  \"26\": {\n" +
            "    \"name\": \"Atlantic Avenue\",\n" +
            "    \"purchasingCost\": \"260\",\n" +
            "    \"baseRentCost\": \"22\",\n" +
            "    \"houseCost\": \"150\",\n" +
            "    \"colour\": \"yellow\"\n" +
            "  },\n" +
            "  \"27\": {\n" +
            "    \"name\": \"Ventnor Avenue\",\n" +
            "    \"purchasingCost\": \"260\",\n" +
            "    \"baseRentCost\": \"22\",\n" +
            "    \"houseCost\": \"150\",\n" +
            "    \"colour\": \"yellow\"\n" +
            "  },\n" +
            "  \"28\": {\n" +
            "    \"name\": \"Waterworks\",\n" +
            "    \"purchasingCost\": \"150\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"util\"\n" +
            "  },\n" +
            "  \"29\": {\n" +
            "    \"name\": \"Marvin Gardens\",\n" +
            "    \"purchasingCost\": \"280\",\n" +
            "    \"baseRentCost\": \"24\",\n" +
            "    \"houseCost\": \"150\",\n" +
            "    \"colour\": \"yellow\"\n" +
            "  },\n" +
            "  \"30\": {\n" +
            "    \"name\": \"Go to Jail\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"31\": {\n" +
            "    \"name\": \"Pacific Avenue\",\n" +
            "    \"purchasingCost\": \"300\",\n" +
            "    \"baseRentCost\": \"26\",\n" +
            "    \"houseCost\": \"200\",\n" +
            "    \"colour\": \"green\"\n" +
            "  },\n" +
            "  \"32\": {\n" +
            "    \"name\": \"North Carolina Avenue\",\n" +
            "    \"purchasingCost\": \"300\",\n" +
            "    \"baseRentCost\": \"26\",\n" +
            "    \"houseCost\": \"200\",\n" +
            "    \"colour\": \"green\"\n" +
            "  },\n" +
            "  \"33\": {\n" +
            "    \"name\": \"Free Square (Community Chest)\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"34\": {\n" +
            "    \"name\": \"Pennsylvania Avenue\",\n" +
            "    \"purchasingCost\": \"320\",\n" +
            "    \"baseRentCost\": \"28\",\n" +
            "    \"houseCost\": \"200\",\n" +
            "    \"colour\": \"green\"\n" +
            "  },\n" +
            "  \"35\": {\n" +
            "    \"name\": \"Short Line\",\n" +
            "    \"purchasingCost\": \"200\",\n" +
            "    \"baseRentCost\": \"25\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"rail\"\n" +
            "  },\n" +
            "  \"36\": {\n" +
            "    \"name\": \"Free Square (Chance)\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"0\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"37\": {\n" +
            "    \"name\": \"Park Place\",\n" +
            "    \"purchasingCost\": \"350\",\n" +
            "    \"baseRentCost\": \"35\",\n" +
            "    \"houseCost\": \"200\",\n" +
            "    \"colour\": \"darkblue\"\n" +
            "  },\n" +
            "  \"38\": {\n" +
            "    \"name\": \"Luxury Tax\",\n" +
            "    \"purchasingCost\": \"0\",\n" +
            "    \"baseRentCost\": \"100\",\n" +
            "    \"houseCost\": \"0\",\n" +
            "    \"colour\": \"none\"\n" +
            "  },\n" +
            "  \"39\": {\n" +
            "    \"name\": \"Boardwalk\",\n" +
            "    \"purchasingCost\": \"400\",\n" +
            "    \"baseRentCost\": \"50\",\n" +
            "    \"houseCost\": \"200\",\n" +
            "    \"colour\": \"darkblue\"\n" +
            "  }\n" +
            "}";
}
