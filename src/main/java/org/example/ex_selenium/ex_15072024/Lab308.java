package org.example.ex_selenium.ex_15072024;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab308 {

    public static void main(String[] args) {

        EdgeOptions edgeoptions=new EdgeOptions();
//normal, edger , none
        edgeoptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver = new EdgeDriver();

        driver.get("https://vwo.com");

        System.out.println(driver.getTitle());

        driver.quit();
    }
}
