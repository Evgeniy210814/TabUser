import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginUser {
    public static WebDriver driver;
    public static WebDriverWait wait;


    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean TheCases(By locator){

        return true;
    }
    @BeforeClass
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test(priority = 1)
    public void testPresenceTabUsers() {
        driver.navigate().to("http://offers.dev.affise.com/");
        StartForTest.startForLogin(DataForTestCreateUsers.loginName,DataForTestCreateUsers.password);
    }
    @Test(priority = 2)
    public void checkForUsersTabElements() {
        sleep(800);
        assertTrue(StartForTest.isElementPresent(By.xpath("//*[@class='hpanel']")));
        assertTrue(StartForTest.isElementPresent(By.xpath("//*[@name='search']")));
        assertTrue(StartForTest.isElementPresent(By.xpath("//*[@name='perpage']")));
        assertTrue(StartForTest.equalsElementByTable(By.xpath("//thead")));
        assertTrue(StartForTest.isElementPresent(By.xpath("//*[.='Add']")));
        /*sleep(500);
        Alert alert = driver.switchTo().alert();
        alert.accept();*/
    }
    //@Test(priority = 3)
    public void chectCreateNewUsers(){
        driver.findElement(By.xpath("//*[.='Add']")).click();
        sleep(800);

        assertTrue(StartForTest.isElementPresent(By.id("form_email"),DataForTestCreateUsers.loginForReg));
        assertTrue(StartForTest.isElementPresent(By.id("password"),DataForTestCreateUsers.passwordForReg));
        assertTrue(StartForTest.isElementPresent(By.id("form_first_name"),DataForTestCreateUsers.nameForReg));
        assertTrue(StartForTest.isElementPresent(By.id("form_last_name"),DataForTestCreateUsers.surnameForReg));
        assertTrue(StartForTest.isElementPresent(By.xpath("//input[@value='ROLE_ADMIN']"),true));
        assertTrue(StartForTest.isElementPresent(By.id("form_save"),true));
        Date date = new Date();
        String d = date.toString();
        System.out.println(d);
    }
    @Test(priority = 4)
    public void testTableUsers(){
        sleep(500);
        assertTrue(StartForTest.findElementsRoles(By.cssSelector("span"),StartForTest.findElementsInTable(),DataForTestCreateUsers.dataForRoles[0]));
        //assertTrue(StartForTest.findElementsRoles(By.cssSelector("span"),StartForTest.findElementsInTable(),DataForTestCreateUsers.dataForRoles[1]));
        assertTrue(StartForTest.isTableElementPresent(StartForTest.findElementsInTable(),1,DataForTestCreateUsers.dataForReg[2]));
        assertTrue(StartForTest.isTableElementPresent(StartForTest.findElementsInTable(),1,DataForTestCreateUsers.dataForReg[3]));
        assertTrue(StartForTest.isElementPresent(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]"),true));
        assertTrue(StartForTest.isElementPresent(By.xpath("//a[contains(text(),'Sign out')]"),true));
        //assertTrue(StartForTest.elementTableClick(By.cssSelector("a"),StartForTest.findElementsInTable(driver),0));
        sleep(800);

    }
    @Test(priority = 5)
    public void editCreatedUser(){
        StartForTest.startForLogin(DataForTestCreateUsers.loginForReg,DataForTestCreateUsers.passwordForReg);
    }

    @AfterClass
    public void close() {
        driver.quit();

    }

}
