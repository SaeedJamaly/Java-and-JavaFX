package View;

//import Controller;

import java.util.ArrayList;

/**
 * @author Soen6441 Team
 */

public class AdminView {

    Controller.PropertyController propertyController;
    Controller.TenantController tenantController;
    Controller.LeaseController leaseController;
    Controller.UserInputController scanner;
    private ArrayList<String> newArray;

    public AdminView(){
        this.propertyController = new Controller.PropertyController();
        this.tenantController = new Controller.TenantController();
        this.leaseController = new Controller.LeaseController();
        this.scanner = new Controller.UserInputController();
        this.newArray = new ArrayList<>();
    }

    public void displayMenu() {
        while (true){
            System.out.println("\n==== Main Menu ====");
            System.out.println("1.  Add a property");
            System.out.println("2.  Remove a property");
            System.out.println("3.  Add a tenant");
            System.out.println("4.  Remove a tenant");
            System.out.println("5.  Rent a unit");
            System.out.println("6.  Display all properties");
            System.out.println("7.  Display all tenants");
            System.out.println("8.  Display all rented units");
            System.out.println("9.  Display all vacant units");
            System.out.println("10. Display all leases");
            System.out.println("12. Pay rent");
            System.out.println("13. Check property/tenant payment status");
            System.out.println("14. End Lease for a property");
            System.out.println("15. Exit");
            System.out.print("Enter your choice: ");

            scanner = new Controller.UserInputController();
            int option = scanner.scannerObj().nextInt();

            switch (option) {
                case 1  -> addProperty();
                case 2  -> removeProperty();
                case 3  -> addTenant();
                case 4  -> removeTenant();
                case 5  -> rentUnit();
                case 6  -> displayProperties();
                case 7  -> displayTenants();
                case 8  -> displayRentedProperties();
                case 9  -> displayVacantProperties();
                case 10 -> displayLease();
                case 12 -> payRent();
                case 13 -> checkPaymentStatus();
                case 14 -> endLease();
                case 15 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public void addProperty(){
        newArray.clear();
        System.out.println("Select the Property type: House, Condo, Apartment");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter ID:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the address");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the city");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the zip code");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the number of bedrooms");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the number of bathrooms");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        if(!newArray.get(0).equalsIgnoreCase("House")){
            System.out.println("For Condo/Apartment enter the unit number");
            newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        }

        propertyController.add(newArray);
        System.out.println("..." + newArray.get(0) + " added successfully.");
    }

    public void removeProperty(){
        System.out.println("Enter the property ID to remove");
        int propertyID = scanner.scannerObj().nextInt();
        propertyController.remove(propertyID);
    }

    public void addTenant(){
        newArray.clear();
        System.out.println("Enter ID:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the first name:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter last name:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the phone number:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the email address:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());

        tenantController.add(newArray);
        System.out.println("... Tenant added successfully.");
    }

    public void removeTenant(){
        System.out.println("Enter the tenant ID to remove");
        int tenantID = scanner.scannerObj().nextInt();
        tenantController.remove(tenantID);
    }

    public void rentUnit(){
        System.out.println("************ Renting a Unit **************");
        newArray.clear();
        System.out.println("Enter the property ID:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the tenant ID:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Assign a lease ID to this contract:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the lease start date (yyyy-mm-dd): ");
        newArray.add(scanner.scannerObj().next().toUpperCase());
        System.out.println("Enter the lease end date (yyyy-mm-dd): ");
        newArray.add(scanner.scannerObj().next().toUpperCase());
        System.out.println("Enter the lease amount:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());

        leaseController.addLease(newArray);
    }

    public void displayProperties(){
        propertyController.displayAll();
    }

    public void displayTenants(){
        tenantController.displayAll();
    }

    public void displayRentedProperties(){
        boolean rentStatus = true;
        propertyController.displayPropertiesByRentStatus(rentStatus);
    }

    public void displayVacantProperties(){
        boolean rentStatus = false;
        propertyController.displayPropertiesByRentStatus(rentStatus);
    }

    public void displayLease(){
        leaseController.displayAll();
    }

    public void payRent(){
        newArray.clear();
        System.out.println("*************** Paying a rent ***************");
        System.out.println();
        System.out.println("Enter the tenant ID:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());
        System.out.println("Enter the property ID:");
        newArray.add(scanner.scannerObj().next().trim().toUpperCase());

        leaseController.pay(newArray);
    }

    public void checkPaymentStatus(){
        System.out.println("Enter the property ID");
        int propertyID = scanner.scannerObj().nextInt();
        System.out.println();
        leaseController.checkPaymentStatus(propertyID);
    }

    public void endLease(){
        newArray.clear();
        System.out.println("****************************** Terminating a lease ****************************");
        System.out.println("Enter the lease ID:");
        newArray.add(scanner.scannerObj().next());
        System.out.println("Select a reason for ending the lease: (Relisting) or (Renovation)");
        newArray.add(scanner.scannerObj().next());
        leaseController.endLease(newArray);
    }

    public boolean addToWaitingList(){
        boolean response = false;
        System.out.println("This property is occupied.");
        System.out.println("Do you want to register for the waiting list for this property: (Yes/No)");
        if (scanner.scannerObj().next().equalsIgnoreCase("YES")){
            System.out.println("You will be notified via email when the property is available.");
            response = true;
        }
        else {
            System.out.println("Rental management system wishes you the bests. Have a good day!");
            response = false;
        }

        return response;
    }
}
