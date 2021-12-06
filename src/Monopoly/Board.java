package Monopoly;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Board {
    public ArrayList<Property> propertyList;

    public Board() throws IOException {
        String myJson = new Scanner(new File("C:\\Users\\Sahil\\Desktop\\School\\Year 4\\Sem 1\\SYSC 3110\\Labs\\Monopoly\\src\\Monopoly\\properties.json")).useDelimiter("\\Z").next();
        propertyList = new ArrayList<>();
        JSONObject o = new JSONObject(myJson);
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
            propertyList.add(new Property(pos.getString("name"), cost,hCost, rCost, i,val,false));
        }
    }

    public ArrayList<Property> getBoard(){
        return propertyList;
    }


}