import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class StartForTest  {
    public static WebDriver driver =LoginUser.driver;
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void startForLogin(String loginName, String password)  {
        driver.findElement(By.id("form_email")).sendKeys(loginName);
        driver.findElement(By.id("form_password")).sendKeys(password);
        WebElement login = driver.findElement(By.id("loginForm"));
        sleep(800);
        login.findElement(By.className("btn")).click();
        sleep(800);
        //WebElement tab =driver.findElement(By.xpath("//*[.='Users']"));
        WebElement tab =driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        tab.click();
        sleep(800);
        tab.findElement(By.xpath("//*[.='User management']")).click();
    }
    public static boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    public static boolean equalsElementByTable(By locator) {
        List<WebElement> table = new ArrayList<WebElement>();
        String[] equalsTextTable = new String[]{"Email", "Name", "Surname", "IM/Skype", "Roles", "Last login", " "};
        try {
            WebElement thead = driver.findElement(locator);
            table = thead.findElements(By.xpath(".//tr/th"));
            for (int i = 0; i < 7; i++) {
                if (equalsTextTable[i].contains(table.get(i).getText())) {
                    try {
                        table.get(i).click();
                    } catch (NoSuchElementException e) {
                        return false;
                    }
                }
            }
                return true;
            }
            catch (Exception e){
                return false;
        }
    }
    public static boolean isElementPresent(By locator, String sendkeys) {
        try {
            driver.findElement(locator).sendKeys(sendkeys);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
    public static boolean isElementPresent(By locator, boolean elPres){
        if (elPres==true){
            try {

                driver.findElement(locator).click();
                return true;

            }
            catch (NoSuchElementException e){
                return false;
            }

        }
        return false;
    }
    public static boolean findElementsRoles(By locator, List<WebElement> elements,String roles){
        try{
            List<WebElement> elementRoles = new ArrayList<WebElement>();
            elementRoles=elements.get(4).findElements(locator);
            //System.out.println(elementRoles.size());
            for (int i = 0; i <elementRoles.size() ; i++) {
                //System.out.println(elementRoles.get(i).getText());

                if (elementRoles.get(i).getText().equals(roles)) {
                    return true;
                }
            }
            return false;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
    public static List<WebElement> findElementsInTable() {
        List<WebElement> table = new ArrayList<WebElement>();
        List<WebElement> table_2 = new ArrayList<WebElement>();
        table = driver.findElements(By.cssSelector("tbody tr"));
        for (WebElement el : table) {
            table_2 = el.findElements(By.cssSelector("td"));
            for (int i = 0; i < table_2.size(); i++) {
                if (table_2.get(i).getText().equals("ForAutoTest@gmail.com")) {
                    return table_2;
                }
            }
        }
        return null;
    }

    public static boolean elementTableClick(By locator, List<WebElement> elements, int countElement){
        List<WebElement> table= new ArrayList<WebElement>();
        try{
            table=elements.get(6).findElements(locator);
            sleep(700);
            table.get(countElement).click();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }
    public static boolean isTableElementPresent(List<WebElement> elements,int countTableUserName, String dataForReg){
        if(elements.get(countTableUserName).getText().equals(dataForReg)) {
           System.out.println(dataForReg);
                return true;
            }
            return false;

    }

}

