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

        Double amt_Total_Spent =0.0;
        Double amt_Total_Earn =0.0;


        WebElement username = driver.findElement(By.xpath("//input[@id=\'username\']"));
        username.sendKeys("Admin");

        WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
        pwd.sendKeys("Password@123");

        WebElement submit=driver.findElement(By.linkText("Sign in"));
        submit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.urlMatches("https://demo.applitools.com/app.html"));

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.applitools.com/app.html");



        List<WebElement> rows_tables = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr"));

        for(WebElement rows:rows_tables){
            System.out.println(rows.getText());

            List<WebElement> col = driver.findElements(By.tagName("td"));

//            for(WebElement column:col){
//                System.out.println(column.getText());
//            }

              String amt=col.get(4).getText();

              if(amt.contains("-")){
                  Double amountInDouble=Double.parseDouble(amt.replace(",", "").replace("USD", "").replace("+", "").replace("-", "").trim());
                  amt_Total_Spent +=amountInDouble;
              }

              if(amt.contains("+")){
                  Double amountInDouble=Double.parseDouble(amt.replace(",", "").replace("USD", "").replace("+", "").replace("-", "").trim());
                  amt_Total_Earn +=amountInDouble;
              }


        }


       ////tr/td[5]/span[@class='text-success']
        System.out.println("total of amount"+amt_Total_Spent);
    }

}