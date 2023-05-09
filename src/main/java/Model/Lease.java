package Model;

import Controller.LeaseController;

import java.time.LocalDate;

/**
 * @author Soen6441 Team
 */

public class Lease {

    private int leaseID;
    private Tenant tenant;
    private Property property;
    private LocalDate startDate;
    private LocalDate endDate;
    private double amount;
    private boolean status;
    private boolean paymentStatus;

    public Lease(Property property, Tenant tenant, int leaseID, LocalDate startDate, LocalDate endDate, double amount){
        this.property = property;
        this.tenant = tenant;
        this.leaseID = leaseID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    public Lease(){

    }


    /**
     * Getters and setters
     */
    public void setLeaseID(int leaseID){
        this.leaseID = leaseID;
    }
    public int getLeaseID(){
        return leaseID;
    }

    public Tenant getTenant(){
        return tenant;
    }
    public void setTenantID(Tenant tenant){
        this.tenant = tenant;
    }

    public Property getProperty(){
        return property;
    }
    public void setPropertyID(Property property){
        this.property = property;
    }

    public LocalDate getStartDate(){
        return startDate;
    }
    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }
    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount (double amount){
        this.amount = amount;
    }

    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getPaymentStatus(){
        return paymentStatus;
    }
    public void setPaymentStatus(boolean status){
        this.paymentStatus = status;
    }

    @Override
    public String toString(){
        return "Lease with ID " + this.leaseID + " for property " + this.property.toString() + " for tenant " + this.tenant.getFirstName() +
                " with start date " + this.startDate + ", and end date " + this.endDate + ", with amount " + this.amount + " with status " +
                ((this.status) ? "Active": "Terminated") + ", with payment status " + ((this.paymentStatus) ? "Paid.":"Not paid.");
    }
}
