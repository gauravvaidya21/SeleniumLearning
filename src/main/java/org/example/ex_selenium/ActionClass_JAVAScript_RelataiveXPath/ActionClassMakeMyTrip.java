package org.example.ex_selenium.ActionClass_JAVAScript_RelataiveXPath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ActionClassMakeMyTrip {

    // Atomic Test Cases
    // TC who don't have any dep.
    // They serve single purpose 0


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
    public void testPositive() throws InterruptedException {

        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        Thread.sleep(4000);

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("New Delhi").build().perform();

        //autosuggestions

        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestion']/li"));

        for(WebElement demoList:list_auto_complete){
            //System.out.println(demoList.getText());

            if(demoList.getText().contains("New Delhi")){
                demoList.click();
                break;
            }


        }

        Thread.sleep(13000);

        }


    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }

}