package Controller;

import Model.*;
import View.AdminView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeaseController {
    /**
     * Class that keeps the handlers for Lease functions
     */
    static Lease lease;
    static DataStorage storage;
    static PotentialCustomer potentialCustomer;
    Property property;
    Tenant tenant;
    AdminView view;

    public LeaseController(){
        this.lease = new Lease();
        this.tenant = new Tenant();
        this.storage = new DataStorage();

        this.potentialCustomer = new PotentialCustomer();
    }

    public void addLease(ArrayList<String> list){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        tenant = storage.findTenantByID(Integer.parseInt(list.get(1)));
        System.out.println("Tenant " + tenant.getFirstName() + " added to the lease.");

        property = storage.findPropertyByID(Integer.parseInt(list.get(0)));
        System.out.println("Property at " + property.getCity() + " added to the lease.");

        if ( property.getStatus()==1 ){
            int leaseID = Integer.parseInt(list.get(2));
            LocalDate startDate = LocalDate.parse(list.get(3), formatter);
            LocalDate endDate = LocalDate.parse(list.get(4), formatter);
            double amount = Double.parseDouble(list.get(5));
            lease = new Lease(property, tenant, leaseID, startDate, endDate, amount);
            lease.setStatus(true);
            lease.setPaymentStatus(false);
            storage.getLeases().add(lease);
            property.setStatus(3);
            System.out.println("The contract has been created for the lease ID " + leaseID + " and " + tenant.getFirstName() + " " +
                    tenant.getLastName() + " is the new tenant in the property " + property.toString());
        }
        else {
            view = new AdminView();
            if (view.addToWaitingList()) {
                potentialCustomer.attach(tenant);
            }
        }
    }

    public void endLease(ArrayList<String> list){


        int leaseID = Integer.parseInt(list.get(0));
        String reason = list.get(1);
        for (Lease l: storage.getLeases()){
            if (l.getLeaseID() == leaseID){
                lease = l;
            }
        }

        if (reason.equalsIgnoreCase("Relisting")){
            lease.getProperty().setStatus(1);
        }
        else if (reason.equalsIgnoreCase("Renovation")){
            lease.getProperty().setStatus(2);
        }
        lease.setStatus(false);
        storage.getLeases().remove(leaseID);

        System.out.println("The following lease has been terminated.");
       // lease.toString();
        potentialCustomer.notifyObserver();
    }

    public void displayAll(){
        System.out.println("****************** All Leases ********************");
        System.out.println();
        for (Lease l: storage.getLeases()){
            System.out.println(l.toString());
        }
    }

    public void pay(ArrayList<String> list){

        if (!(storage.findTenantByID(Integer.parseInt(list.get(0)))==null) && !(storage.findPropertyByID(Integer.parseInt(list.get(1)))==null)){
            tenant = storage.findTenantByID(Integer.parseInt(list.get(0)));
            property = storage.findPropertyByID(Integer.parseInt(list.get(1)));
            lease = storage.findLeaseByPropertyAndTenant(property, tenant);
            System.out.println("The amount of the lease, " + lease.getAmount() + "CAD, has been paid successfully.");
            lease.setPaymentStatus(true);
        }
        else if ( (storage.findTenantByID(Integer.parseInt(list.get(0)))==null) && !(storage.findPropertyByID(Integer.parseInt(list.get(1)))==null) ){
            System.out.println("The tenant with ID " + Integer.parseInt(list.get(0)) + " does not exist. Please try again.");
        }
        else if ( !(storage.findTenantByID(Integer.parseInt(list.get(0)))==null) && (storage.findPropertyByID(Integer.parseInt(list.get(1)))==null) ) {
            System.out.println("The property with ID " + Integer.parseInt(list.get(1)) + " does not exist. Please try again.");
        }
        else {
            System.out.println("Entered information is not valid. Please try again.");
        }
    }

    public void checkPaymentStatus(int propertyID) {
        property = DataStorage.findPropertyByID(propertyID);

        if (property.getStatus() == 3){
            for (Lease l: storage.getLeases()) {
                if (l.getProperty().equals(property)){
                    if (l.getPaymentStatus()){
                        System.out.println("The payment was made.");
                    }
                    else System.out.println("Payment record not found.");
                }
            }
        }
        else System.out.println("This property is vacant.");
    }

    /**
     * Getters and setters
     */
    public int getID(){
        return lease.getLeaseID();
    }
    public void setID(int ID){
        lease.setLeaseID(ID);
    }

    public LocalDate getStartDate(){
        return lease.getStartDate();
    }
    public void setStartDate(LocalDate date){
        lease.setStartDate(date);
    }

    public LocalDate getEndDate(){
        return lease.getEndDate();
    }
    public void setEndDate(LocalDate date){
        lease.setEndDate(date);
    }

    public double getAmount(){
        return lease.getAmount();
    }
    public void setAmount(double amount){
        lease.setAmount(amount);
    }

    public boolean getStatus(){
        return lease.getStatus();
    }
    public void setStatus(boolean status){
        lease.setStatus(status);
    }
}
