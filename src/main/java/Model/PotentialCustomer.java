package Model;

public class PotentialCustomer implements Subject{

    DataStorage storage;
    private int ID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;


    public PotentialCustomer(){
        this.storage = new DataStorage();
    }

    @Override
    public void attach(Observer observer){
        storage.getPotentialCustomers().add(observer);
    }

    @Override
    public void detach(Observer observer){
        storage.getPotentialCustomers().remove(observer);
    }
    /**
     * The notifyObserver method, send email to registered tenant (concreteObservers)
     */
    @Override
    public void notifyObserver(){
        for (Observer potentialCustomer: storage.getPotentialCustomers() ){
            potentialCustomer.sendEmail();
        }
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
}
