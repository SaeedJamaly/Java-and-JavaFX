package Controller;

import Model.DataStorage;
import Model.PotentialCustomer;
import View.AdminView;

/**
 * @author Soen6441 Team
 */

public class ViewController {

    private UserInputController userInputController;
    DataStorage storage;
    AdminView view;
    PotentialCustomer potentialCustomer;


    public ViewController(){
        this.storage = new DataStorage();
        this.view = new AdminView();
        this.potentialCustomer = new PotentialCustomer();
    }

    public void run(){
        view.displayMenu();
    }
}
