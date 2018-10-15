import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
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
    //
    public static void startForLogin(String loginName, String password)  {
        driver.findElement(By.id("form_email")).sendKeys(loginName);
        driver.findElement(By.id("form_password")).sendKeys(password);
        WebElement login = driver.findElement(By.id("loginForm"));
        sleep(800);
        login.findElement(By.className("btn")).click();
        sleep(800);
        //WebElement tab =driver.findElement(By.xpath("//*[.='Users']"));

    }
    //метод для поиска элементов
    public static boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    //метод для проверки шапки таблицы пользователей
    public static boolean equalsElementByTable(By locator) {
        List<WebElement> table = new ArrayList<WebElement>();
        String[] equalsTextTable = new String[]{"Email", "Name", "Surname", "IM/Skype", "Roles", "Last login", " "};
        try {
            WebElement thead = driver.findElement(locator);
            table = thead.findElements(By.xpath(".//tr/th"));
            for (int i = 0; i < table.size(); i++) {
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
    //метод для поиска элементов
    public static boolean isElementPresent(By locator, String sendkeys) {
        try {
            driver.findElement(locator).sendKeys(sendkeys);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
    //метод для поиска элементов и клик по ним
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
    //метод для потска ролей в таблице пользователя
    public static boolean findElementsRoles(By locator, List<WebElement> elements,String roles){
        try{
            List<WebElement> elementRoles = new ArrayList<WebElement>();
            elementRoles=elements.get(4).findElements(locator);
            System.out.println(elements.get(4).getText());
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
    //метод для поиска заданных элементов в таблице
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
    //для кнопок удалить или редактировать пользователя
    public static boolean elementTableClick(By locator, List<WebElement> elements, int countElement){
        List<WebElement> table= new ArrayList<WebElement>();
        try{

            table=elements.get(6).findElements(locator);
            sleep(700);
            System.out.println(table.size());
            table.get(countElement).click();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }
    //метод для поиска заданного пользователя пользователей
    public static boolean isTableElementPresent(List<WebElement> elements,int countTableUserName, String dataForReg){
        if(elements.get(countTableUserName).getText().equals(dataForReg)) {
           System.out.println(dataForReg);
                return true;
            }
            return false;

    }
    //метод для выхода из текущего пользователя
    public static void logOut(By dropDownList, By buttonOut){
        assertTrue(isElementPresent(dropDownList,true));//поиск списка с логом на выход
        assertTrue(isElementPresent(buttonOut,true));//нажать кнопку что бы вылогиниться
    }
    //метод для поиска и входа на вкладку users
    public static void findTabUsers(By elementDropDownListUsers, By elementUserManager){
        try {
            WebElement tab =driver.findElement(elementDropDownListUsers);
            tab.click();
            sleep(800);
            tab.findElement(elementUserManager).click();
        }
        catch (NoSuchElementException e){
            System.out.println(e);
        }

    }
    //метод для проверки работы выбранных пользователей по наличию доступных вкладок
    public static boolean findTabsForTetsRoles(By element, String[] massTabs){
        List<WebElement> board = new ArrayList<WebElement>();
        board=driver.findElements(element);
        /*if(board.size()==12){
            return true;
        }*/
        for (int i = 0; i <board.size() ; i++) {
            try{
                for (int j = 0; j <board.size(); j++) {
                    if(board.get(i).getText().equals(massTabs[j])){

                    }
                }
            }
            catch (Exception e){
                System.out.println(e);
                return false;
            }

        }
        return true;
    }

    //поиск случайной роли для пользователя
    public static void findRolesInList(By locator,int choiceSectorRoles){
    List<WebElement> listRoles = new ArrayList<WebElement>();
        DataForTestCreateUsers.listRolesSector = driver.findElements(locator);
        System.out.println(DataForTestCreateUsers.listRolesSector.size());
        DataForTestCreateUsers.listRolesSector.get(choiceSectorRoles);
        System.out.println(DataForTestCreateUsers.listRolesSector.get(choiceSectorRoles).getText());
        if(choiceSectorRoles>=5 && choiceSectorRoles<=17){

        }
        for(WebElement element:DataForTestCreateUsers.listRolesSector){
            System.out.println(element.getText());
        }
    }
    public static int generateRandomValue(int max){
        Random random= new Random();
        DataForTestCreateUsers.randomValueForRoles= random.nextInt(max);
        return DataForTestCreateUsers.randomValueForRoles;
    }

}

