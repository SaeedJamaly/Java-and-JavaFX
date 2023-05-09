package com.example.demo3;

import Controller.MainController;
import Model.DataStorage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.chart.PieChart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        /**
         * Initialize the executor service (thread pool and thread management)
         */
        ExecutorService executor = Executors.newFixedThreadPool(3);


        // Create a thread for GUI (with a task (runnable), then put the task into the thread)
        Runnable runApp = () -> {
            System.out.println("Initializing GUI on thread " + Thread.currentThread().getId());
            try {
                Application.launch(HelloApplication.class, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread guiThread = new Thread(runApp);

        // Create a thread for displayAllProperties, which will automatically refresh every 20 seconds
        Runnable runPrintRMProperties = () -> {
            System.out.println("Initializing display all properties in thread " + Thread.currentThread().getId());
            while (true) {
                System.out.println("=================Display All Properties in the System=================");
                DataStorage.displayPropertiesWhileRunning();
                System.out.println("==========================End of the List=============================");
                System.out.println("The display all properties function is running on thread: " + Thread.currentThread().getId());
                try {
                    // Sleep for 20 second (20000 milliseconds) before refreshing
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread displayAllPropertiesThread = new Thread(runPrintRMProperties);

        // Create a thread for the system, initialize all controllers
        Runnable mainController = new MainController();
        Thread systemThread = new Thread(mainController);

        // Set thread priorities
        guiThread.setPriority(Thread.NORM_PRIORITY);
        displayAllPropertiesThread.setPriority(Thread.NORM_PRIORITY);
        systemThread.setPriority(Thread.NORM_PRIORITY);

        /**
         * Starting all threads using executor service
         */
        executor.execute(guiThread);
        executor.execute(displayAllPropertiesThread);
        executor.execute(systemThread);

        /**
         * Terminating all threads using executor service
         */
        executor.shutdown();
    }
}
