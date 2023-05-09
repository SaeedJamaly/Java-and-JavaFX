package Model;

import Controller.TenantController;

import java.util.*;

/**
 * @author Soen6441 Team
 */

public class DataStorage {

    private static List<Tenant> tenants;
    private final List<Observer> potentialCustomers;
    public static List<Property> properties = new ArrayList<>();
    private static List<Lease> leases;
    private static Property property;
    private static Tenant tenant;
    private static Lease lease;


    public DataStorage() {
        properties = new ArrayList<>();
        tenants = new ArrayList<>();
        this.potentialCustomers = new ArrayList<>();
        leases = new ArrayList<>();
        tenant = new Tenant();
        lease = new Lease();
    }

    public static Property findPropertyByID(int ID){
        for(int i=0; i<properties.size(); i++){
            if(properties.get(i).getID()==ID){
                property = properties.get(i);
                break;
            }
        }
        return property;
    }

    public static Tenant findTenantByID(int ID){
        for (int i=0; i<tenants.size(); i++){
            if (tenants.get(i).getID()==ID){
                tenant = tenants.get(i);
                break;
            }
        }
        return tenant;
    }

    public static Lease findLeaseByPropertyAndTenant(Property property, Tenant tenant){
        for (Lease l: leases){
            if(l.getTenant()==tenant && l.getProperty()==property){
                lease = l;
                break;
            }
        }
        return lease;
    }

    public List<Property> getProperties(){
        return properties;
    }

    public List<Tenant> getTenants(){
        return tenants;
    }

    public List<Observer> getPotentialCustomers(){
        return potentialCustomers;
    }

    public List<Lease> getLeases(){
        return leases;
    }

    //public static List<Property> properties = new ArrayList<>();

    public static void displayPropertiesWhileRunning() {

        for (Property value : properties) {
            System.out.println(value);
        }


    }
}
