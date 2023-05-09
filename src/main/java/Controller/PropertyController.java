package Controller;

import Model.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PropertyController {
    /**
     * Class that keeps the handlers for Property functions
     */
    PropertyFactory propertyFactory;
    Property property;
    DataStorage storage;

    public PropertyController(){
        this.propertyFactory = new PropertyFactory();
        this.storage = new DataStorage();
    }

    public void add(ArrayList<String> list){
        property = propertyFactory.createProperty(list.get(0));
        System.out.println("Building a " + list.get(0) + "...");
        property.build(list);
        storage.getProperties().add(property);
        System.out.println("Property " + property.getType() +  " added to the storage.");
    }

    public void remove(int ID){

        try {
            if(!(storage.getProperties().isEmpty())) {
                property = storage.findPropertyByID(ID);
                System.out.println("property ID to remove is " + property.getID() + " in city " + property.getCity());
                int index = storage.getProperties().indexOf(storage.findPropertyByID(ID));
                storage.getProperties().remove(index);
            }
            else {
                System.out.println("The property list is empty.");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }
    }

    public void displayAll(){
        System.out.println("****************** All Properties ********************");
        System.out.println();
        List<Property> properties = storage.getProperties();

        for (int i=0; i<properties.size(); i++){
            if (!(properties.get(i) instanceof House)){
                System.out.println(properties.get(i).getType() + " with ID " + properties.get(i).getID() + " at No." + ((properties.get(i) instanceof Condo) ? ( (Condo) properties.get(i)).getUnitNo(): "") + ((properties.get(i) instanceof Apartment) ? ( (Apartment) properties.get(i)).getUnitNo(): "") + " " + properties.get(i).getAddress() + ", " + properties.get(i).getCity() + ", " + properties.get(i).getZip() + " with rent status " + ((properties.get(i).getStatus()==3) ? "(Rented)" : "(Not rented)" ) + " with " + properties.get(i).getNoOfBedrooms() +(properties.get(i).getNoOfBedrooms()>1 ? " bedrooms and " : " bedroom and ") + properties.get(i).getNoOfBathrooms() + (properties.get(i).getNoOfBathrooms()>1 ? " bathrooms." : " bathroom."));
            }
            else {
                System.out.println(properties.get(i).getType() + " with ID " + properties.get(i).getID() + " at " + properties.get(i).getAddress() + ", " + properties.get(i).getCity() + ", " + properties.get(i).getZip() + " with rent status " + ((properties.get(i).getStatus()==3) ? "(Rented)" : "(Not rented)" ) + " with " + properties.get(i).getNoOfBedrooms() + properties.get(i).getNoOfBedrooms() + (properties.get(i).getNoOfBedrooms()>1 ? " bedrooms and " : " bedroom and ") + properties.get(i).getNoOfBathrooms() + (properties.get(i).getNoOfBathrooms()>1 ? " bathrooms" : " bathroom"));
            }
        }
    }

    public void displayPropertiesByRentStatus(boolean rentStatus){
        if (rentStatus){
            System.out.println("****************** All Rented Properties ********************");
            for(Property p: storage.getProperties()){
                if (p.getStatus() == 3){
                    System.out.println(p.getType() + " with ID " + p.getID() + " at No." + ((p instanceof Condo) ? ( (Condo) p).getUnitNo(): "") + ((p instanceof Apartment) ? ( (Apartment) p).getUnitNo(): "") + " " + p.getAddress() + ", " + p.getCity() + ", " + p.getZip() + " with " + p.getNoOfBedrooms() +(p.getNoOfBedrooms()>1 ? " bedrooms and " : " bedroom and ") + p.getNoOfBathrooms() + (p.getNoOfBathrooms()>1 ? " bathrooms." : " bathroom."));
                }
            }
        }
        else {
            for(Property p: storage.getProperties()){
                if (p.getStatus() == 1){
                    System.out.println("****************** All Vacant Properties ********************");
                    System.out.println(p.getType() + " with ID " + p.getID() + " at No." + ((p instanceof Condo) ? ( (Condo) p).getUnitNo(): "") + ((p instanceof Apartment) ? ( (Apartment) p).getUnitNo(): "") + " " + p.getAddress() + ", " + p.getCity() + ", " + p.getZip() + " with " + p.getNoOfBedrooms() +(p.getNoOfBedrooms()>1 ? " bedrooms and " : " bedroom and ") + p.getNoOfBathrooms() + (p.getNoOfBathrooms()>1 ? " bathrooms." : " bathroom."));
                }
            }
       }

    }
}