package Model;

import Model.Apartment;
import Model.Condo;
import Model.House;
import Model.Property;

/**
 * @author Soen6441 Team
 */

/**
 * Takes the type as input, and create different concrete products using the factory pattern

 */
public class PropertyFactory {

    public Property createProperty(String type){
        Property property = null;

        if (type.equalsIgnoreCase("Condo")) {
            property = new Condo();
        } else if (type.equalsIgnoreCase("Apartment")) {
            property = new Apartment();
        } else if (type.equalsIgnoreCase("House")) {
            property = new House();
        }

        return property;
    }
}
