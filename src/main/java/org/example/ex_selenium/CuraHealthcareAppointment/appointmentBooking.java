package org.example.ex_selenium.CuraHealthcareAppointment;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class appointmentBooking {

    @Test
    public void bookAppointment() {


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get("https://katalon-demo-cura.herokuapp.com/    ");

        WebElement makeAppointment = driver.findElement(By.linkText("Make Appointment"));
        makeAppointment.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement username=driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement pass=driver.findElement(By.id("txt-password"));
        pass.sendKeys("ThisIsNotAPassword");

        WebElement login=driver.findElement(By.id("btn-login"));
        login.click();


        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");


        WebElement nextPage = driver.findElement(By.tagName("h2"));
        assertTrue(nextPage.isDisplayed(), "Make Appointment");


    }
}