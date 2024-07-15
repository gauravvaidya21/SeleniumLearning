package org.example.ex_selenium.ex_15072024;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Lab307 {

    public static void main(String[] args) {


        EdgeOptions options = new EdgeOptions();

        options.addArguments("--guest");


        // VPN -- is like proxy

        Proxy proxy=new Proxy();
        proxy.setHttpProxy("121:40:185:42:1080");
       options.setCapability("proxy",proxy);

        WebDriver driver = new EdgeDriver(options);

        driver.get("https://google.com");

    }
}