package Controller;

/**
 * @author Xiaoyu Cheng
 * @student_ID 40254110
 * @description Main controller to initialize all controllers
 */
public class MainController implements Runnable{

    /**
     * Runnable, initialize all controllers
     */
    @Override
    public void run() {
        System.out.println("System is initializing on thread " + Thread.currentThread().getId());
        LeaseController leaseController = new LeaseController();
        PropertyController propertyController = new PropertyController();
        TenantController tenantController = new TenantController();
        UserInputController userInputController = new UserInputController();
        ViewController viewController = new ViewController();
    }
}
