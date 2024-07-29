package org.example.ex_selenium.Window_Action_DragDrop;

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

public class DranDrop_FileUpload {

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
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);


       driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));


        // 1st method

        //actions.dragAndDrop(from,to).perform();

        // 2nd method
        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();

        Thread.sleep(2000);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testFileUpload() throws InterruptedException {

        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));

        String dir = System.getProperty("user.dir");
        System.out.println(dir);

        uploadFileInput.sendKeys(dir+"\\src\\main\\java\\org\\example\\ex_selenium\\Window_Action_DragDrop\\upload.txt");
        driver.findElement(By.name("submit")).click();


    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
