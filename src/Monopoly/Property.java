package Monopoly;
import java.util.ArrayList;
import java.util.Objects;
/**
 * The Monopoly.Property class represents a property in the Monopoly game.
 *
 * @author Kashish Saxena - 101107204
 * @version October 22, 2021
 */

public class Property {

    private final String name;
    private Player owner;
    private boolean isAvailable;
    private final int purchasingCost;
    private int rentCost;
    private int houseCost;
    private final int position;
    private final String colour;
    private int houses;
    private boolean colourSet;


    /**
     * Constructor of the Monopoly.Property class
     *
     * @param name Name of the property
     * @param initialCost initial cost of the property
     */
    public Property(String name, int initialCost, int rentCost,int houseCost,  int position, String colour, boolean colourSet) {
        this.name = name;
        purchasingCost = initialCost;
        isAvailable = true;
        this.rentCost = rentCost;
        this.position = position;
        this.colour = colour;
        this.houseCost = houseCost;
        this.houses = 0;
        this.colourSet = false;
    }

    /**
     * Returns the name of the property
     * @return Name of the property
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the owner of the property
     * @return owner of the property
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Returns the purchasing cost of the property
     * @return the purchasing cost of the property
     */
    public int getPurchasingCost() {
        return purchasingCost;
    }

    /**
     * Returns the rental cost of the property
     * @return the rental cost of the property
     */
    public int getRentCost() {
        return rentCost;
    }

    /**
     * Returns the colour of the property
     * @return the colour of the property
     */
    public String getColour() {return colour; }

    /**
     * Sets the owner of the property to the specified owner
     * @param owner specififed owner
     */
    public void setOwner(Player owner) {
        isAvailable = owner == null;
        this.owner = owner;
    }

    /**
     * Removes the owner of the property
     */
    public void removeOwner() {
        this.owner = null;
        isAvailable = true;
    }

    /**
     * Returns the position of the property on the board
     */
    public int getPosition(){
        return position;
    }

    /**
     * Sets the rent of the property to the specified rent
     * @param rentCost specififed rent
     */
    private void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }

    /**
     * Return true if property is available, false otherwise
     * @return true if property is available, false otherwise
     */
    public boolean checkAvailability(){
        return isAvailable;
    }

    public int getHouses(){return houses;}

    /**
     * Returns the string representation of the Monopoly.Property object
     * @return String representation of the Monopoly.Property object
     */
    @Override
    public String toString(){

       return "Property: " + name + ", Colour: "+ colour + ", Purchasing Cost: " + purchasingCost + ", Rent cost: " + rentCost + "\n";
    }

    /**
     * Compares two properties
     * @param o Object to be compared with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Property)) return false;
        Property property = (Property) o;
        return Objects.equals(name, property.name) &&
                Objects.equals(owner, property.owner);
    }

    public void buyHouse(int housesOnProperty){
        if(housesOnProperty == 0) {
            setRentCost(getRentCost()*5);
        }else if(housesOnProperty == 1){
            setRentCost(getRentCost()*3);
        }
        else if(housesOnProperty == 2){
            setRentCost(getRentCost()*3);
        }
        else if(housesOnProperty==3){
            setRentCost(getRentCost()*3);
        }
        else{
            buyHotel(getHouses());
        }
    }
    public void buyHotel(int housesOnProperty){
        if(housesOnProperty ==4){
            setRentCost(getRentCost()*2);
        }
    }

    public int getColourCount(ArrayList<Property> properties,String colour){
        int count=0;
        for(int i = 0; i < properties.size();i++){
            if(properties.get(i).getColour() == colour){
                count ++;
            }
        }
        return count;
    }

    public void setColourSet(){
        colourSet = true;
    }

}
