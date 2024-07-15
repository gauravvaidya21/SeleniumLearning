package org.example.ex_selenium.VWO_Login_Project;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class vwoPositiveLogin {

    @Test
    public void testVwologinpositive(){

        //TC  user name,pwd
        //1.open http://app.vwo.com
        //2.find email id and enter email address admin@admin.com
        //3.find password and enter pwd
        //4.find submit button and click/
        //5.verify name on dashboard page

        //find email id and enter email address admin@admin.com
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver=new EdgeDriver(edgeOptions);

        driver.get("https://app.vwo.com/");
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");


        WebElement email_input_box=driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("vaidya.gaurav21@gmail.com");

        //find password and enter pwd

        WebElement pwd=driver.findElement(By.id("login-password"));
        pwd.sendKeys("9923@Gaurav");

        //find submit button and click

        WebElement submitbutton=driver.findElement(By.id("js-login-btn"));
        submitbutton.click();

        //wait to verify message

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //verify the message

//        List<WebElement> dashboard_msg=driver.findElements(By.className("Fw(semi-bold) ng-binding"));
//        WebElement first_classname=dashboard_msg.get(0);
//
//        Assert.assertEquals(first_classname.getText(),"Gaurav Vaidya");


//        WebElement nextPage = driver.findElement(By.tagName("span"));
//        assertTrue(nextPage.isDisplayed(), "Gaurav Vaidya");

        //assertThat("Hi V W,", Matchers.equalTo("Hi V W,"));

        //to see result

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
