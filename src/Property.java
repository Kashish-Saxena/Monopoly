import java.util.Objects;
/**
 * The Property class represents a property in the Monopoly game.
 *
 * @author Kashish Saxena - 101107204
 * @version October 22, 2021
 */

public class Property {

    private String name;
    private Player owner;
    public static Money PURCHASINGCOST;
    private Money rentCost;
    private boolean isAvailable;

    /**
     * Constructor of the Property class
     *
     * @param name Name of the property
     * @param initialCost initial cost of the property
     */
    public Property(String name, Money initialCost) {
        this.name = name;
        PURCHASINGCOST = initialCost;
        isAvailable = true;
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
    public static Money getPurchasingCost() {
        return PURCHASINGCOST;
    }

    /**
     * Returns the rental cost of the property
     * @return the rental cost of the property
     */
    public Money getRentCost() {
        return rentCost;
    }

    /**
     * Sets the owner of the property to the specified owner
     * @param owner specififed owner
     */
    private void setOwner(Player owner) {
        this.owner = owner;
        isAvailable = false;
    }

    /**
     * Sets the rent of the property to the specified rent
     * @param rentCost specififed rent
     */
    private void setRentCost(Money rentCost) {
        this.rentCost = rentCost;
    }

    /**
     * Return true if property is available, false otherwise
     * @return true if property is available, false otherwise
     */
    public boolean isAvailable(){
        return isAvailable;
    }

    /**
     * Returns the string representation of the Property object
     * @return String representation of the Property object
     */
    @Override
    public String toString(){

       return "Property: " + name + "\nOwner: "+ owner + "\nPurchasing Cost: "+ PURCHASINGCOST;
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
}
