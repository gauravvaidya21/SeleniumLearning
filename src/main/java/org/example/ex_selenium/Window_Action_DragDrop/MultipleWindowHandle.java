package org.example.ex_selenium.Window_Action_DragDrop;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowHandle {
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

        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);

        //handle windows

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before Click "+mainWindowHandle);

        //click on link which will open new window

        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        //getting list of window handle including new

        Set<String> windowHandles = driver.getWindowHandles();

        // All the Windows Tab have a unique name
        for (String handle : windowHandles){

            driver.switchTo().window(handle);
            System.out.println(handle);

            //switching to new window

            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test case Passed");
            }
        }
            //switching back to original window

        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(2000);


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
}
}