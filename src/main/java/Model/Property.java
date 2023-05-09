package Model;

import java.util.ArrayList;

/**
 * @author Soen6441 Team
 */

public abstract class Property {
    /**
     * List of attributes: including: address, type, city, zip, number of bedrooms and bathrooms
     */
    private int ID;
    private PropertyType type;
    private String address;
    private String city;
    private String zip;
    /**
     * 1 ready for rent
     * 2 renovation
     * 3 Occupied
     */
    private int status;
    private int noOfBedrooms;
    private int noOfBathrooms;

    /**
     * Constructor takes a string as input to choose the type of the property to be created by a Fabric
     */
    public Property(PropertyType model){
        this.type = model;
    }

    public Property(int ID, PropertyType type, String address, String city, String zip, boolean rentStatus, int noOfBedrooms, int noOfBathrooms){
        this.ID = ID;
        this.type = type;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.status = status;
        this.noOfBedrooms = noOfBedrooms;
        this.noOfBathrooms = noOfBathrooms;
    }

    public Property(){

    }

    /**
     * Create a property
     */
    public abstract void build(ArrayList<String> list);

    /**
     * Getters and Setters
     */
    public int getID(){
        return ID;
    }
    public void setID (int ID){
        this.ID = ID;
    }
    public PropertyType getType(){
        return type;
    }
    public void setType(PropertyType type){
        this.type = type;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String getZip(){
        return zip;
    }
    public void setZip(String zip){
        this.zip = zip;
    }

    public int getStatus(){
        return status;
    }
    public void setStatus(int rentStatus) {
        this.status = rentStatus;
    }

    public int getNoOfBedrooms(){
        return noOfBedrooms;
    }
    public void setNoOfBedrooms(int noOfBedrooms){
        this.noOfBedrooms = noOfBedrooms;
    }

    public int getNoOfBathrooms(){
        return noOfBathrooms;
    }
    public void setNoOfBathrooms(int noOfBathrooms){
        this.noOfBathrooms = noOfBathrooms;
    }

    @Override
    public String toString () {
        return String.format(" %d", getID ());
    }
}
