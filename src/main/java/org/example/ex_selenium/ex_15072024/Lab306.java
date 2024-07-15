package org.example.ex_selenium.ex_15072024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

// chome options for selenium.
//https://peter.sh/experiments/chromium-command-line-switches/


public class Lab306 {

    public static void main(String[] args) {

        EdgeOptions options= new EdgeOptions();

        //headless mode(no ui) or full mode --browser run
        //1.headless -- no ui performance good fast execution
        //2.full mode --ui performance lag >100

        //options - browser-start maximise,add extension,add options or parameter

        //1. first option to maximize
        // options.addArguments("--start-maximized");


        //options.addArguments("--window-size=800,600");

        options.addArguments("--guest");

        WebDriver driver = new EdgeDriver(options);

        driver.get("https://google.com");

        // //2.option to maximize

        driver.manage().window().maximize();

        try {
            Thread.sleep(5000); //worst way to add wait
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
