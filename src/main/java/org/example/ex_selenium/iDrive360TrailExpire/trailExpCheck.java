package org.example.ex_selenium.iDrive360TrailExpire;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class trailExpCheck {

    @Test

    public void verifyTrail(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get("https://www.idrive360.com/enterprise/login");


        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("augtest_040823@idrive.com");

        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("123456");

        WebElement login=driver.findElement(By.id("frm-btn"));
        login.click();

        Assert.assertEquals(driver.getCurrentUrl(),
        "https://www.idrive360.com/enterprise/account?upgradenow=true");

        driver.quit();

    }
}
