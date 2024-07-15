package org.example.ex_selenium.ex_15072024;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Lab311 {

    @Test
    public void testVerifyFreeTrail(){


        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver=new EdgeDriver(edgeOptions);

        driver.get("https://app.vwo.com/");

        WebElement freetrail=driver.findElement(By.linkText("Start a free trial"));
        freetrail.click();

        WebElement enterEmail=driver.findElement(By.id("page-v1-step1-email"));
        enterEmail.sendKeys("admin@admin.com");

        WebElement consentBox=driver.findElement(By.name("gdpr_consent_checkbox"));
        consentBox.click();

        //find elements
        List<WebElement> buttonList=driver.findElements(By.tagName("button"));
        buttonList.get(0).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_email_exist=driver.findElement(By.className("invalid-reason"));
        System.out.println(error_email_exist.getText());


        driver.quit();
    }
}
