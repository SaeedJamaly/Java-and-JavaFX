package Controller;

import Model.*;
import Model.Lease;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Soen6441 Team
 */

public class TenantController {
    /**
     * Class that keeps the handlers for Tenant functions
     */
    Tenant tenant;
    Lease lease;
    DataStorage storage;

    public TenantController(){
        this.tenant = new Tenant();
        this.lease = new Lease();
        this.storage = new DataStorage();
    }

    public void add(ArrayList<String> list){
        tenant = new Tenant();
        tenant.setID(Integer.parseInt(list.get(0)));
        tenant.setFirstName(list.get(1));
        tenant.setLastName(list.get(2));
        tenant.setPhoneNumber(list.get(3));
        tenant.setEmail(list.get(4));

        storage.getTenants().add(tenant);
    }

    public void remove(int ID) {

        try {

            if(!(storage.getTenants().isEmpty())){
                tenant = storage.findTenantByID(ID);
                System.out.println("Tenant ID to remove is " + tenant.getID() + " with name " + tenant.getFirstName());
                int index = storage.getTenants().indexOf(storage.findTenantByID(ID));
                storage.getTenants().remove(index);
            }
            else {
                System.out.println("The tenant list is empty.");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }
    }

    public void displayAll(){
        System.out.println("****************** All Tenants ********************");
        System.out.println();
        List<Tenant> tenants = storage.getTenants();
        for (int i=0; i<tenants.size(); i++){
            System.out.println( tenants.get(i).getFirstName() + " " + tenants.get(i).getLastName() + " with ID " + tenants.get(i).getID() + ", phone number: " + tenants.get(i).getPhoneNumber() + ", email: " + tenants.get(i).getEmail());
        }
    }

    /**
     * Getters and setters
     */
    public void setTenant(int ID){
        tenant.setID(ID);
    }
    public int getID(){
        return tenant.getID();
    }

    public void setFirstName(String firstName){
        tenant.setFirstName(firstName);
    }
    public String getFirstName(){
        return tenant.getFirstName();
    }

    public void setLastName(String lastName){
        tenant.setLastName(lastName);
    }
    public String getLastName(){
        return tenant.getLastName();
    }

    public void setPhoneNumber(String phoneNumber){
        tenant.setPhoneNumber(phoneNumber);
    }
    public String getPhoneNumber(){
        return tenant.getPhoneNumber();
    }

    public void setEmail(String email){
        tenant.setEmail(email);
    }
    public String getEmail(){
        return tenant.getEmail();
    }
}
