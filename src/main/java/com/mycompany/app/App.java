package com.mycompany.app;

/**
 * Hello world!
 */
public class App
{

    private final String message = "Hello World!";

    public App() {}

    public static void main(String[] args) {
    	App app = new App();
    	app.start();
    }

    private final String getMessage() {
        return message;
    }

    public void start() {
        System.out.println(message);
    	
    }
}
