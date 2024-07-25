package org.example.ex_selenium.PracticeTable;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Tablecalculate {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testLab328() throws InterruptedException {
        driver.manage().window().maximize();
        String URL = "https://demo.applitools.com";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//input[@id=\'username\']"));
        username.sendKeys("Admin");

        WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
        pwd.sendKeys("Password@123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.urlMatches("https://demo.applitools.com/app.html"));

        WebElement submit=driver.findElement(By.linkText("Sign in"));

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.applitools.com/app.html");

        WebElement table = driver. findElement(By.xpath("//table[@class='table table-padded']"));
        List<WebElement> rows_tables = table.findElements(By.tagName("tr"));
        System.out.println(rows_tables.size());
    }

}