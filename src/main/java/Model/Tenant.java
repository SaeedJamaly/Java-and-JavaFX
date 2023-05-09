package Model;

import Controller.ViewController;
import View.AdminView;

/**
 * @author Soen6441 Team
 */

public class Tenant  implements Observer{

    private int ID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    ViewController viewController;

    public Tenant(int ID, String firstName, String lastName, String phoneNumber, String email){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Tenant(){

    }

    @Override
    public void sendEmail(){
        System.out.println("Hello, " + this.getFirstName() + " " + this.getLastName() + ". The property is available." +
                "\n Email sent to: " + this.getEmail());
    }


    /**
     * Getters and setter
     */

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String toString () {
        return String.format(" %d", getID ());
    }
}
