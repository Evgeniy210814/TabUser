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
        driver.navigate().to(DataForTestCreateUsers.url);
    }

    @Test(priority = 1)
    public void testPresenceTabUsers() {
        StartForTest.startForLogin(DataForTestCreateUsers.loginName,DataForTestCreateUsers.password);//вход под root пользователем
        StartForTest.findTabUsers(ByElements.findDropDownListUsers,ByElements.findUserManagerInList);//поиск вкладки users
    }
    @Test(priority = 2)
    public void checkForUsersTabElements() {
        sleep(800);
        assertTrue(StartForTest.isElementPresent(ByElements.findUserControlPanel));
        assertTrue(StartForTest.isElementPresent(ByElements.findElementFieldSearch));
        assertTrue(StartForTest.isElementPresent(ByElements.findElementFieldCount));
        assertTrue(StartForTest.equalsElementByTable(ByElements.findHeadTable));
        assertTrue(StartForTest.isElementPresent(ByElements.findButtonAdd));
        /*sleep(500);
        Alert alert = driver.switchTo().alert();
        alert.accept();*/
    }
    @Test(priority = 3)
    //создание нового пользователя
    public void chectCreateNewUsers(){
        driver.findElement(ByElements.findButtonAdd).click();
        sleep(800);

        assertTrue(StartForTest.isElementPresent(ByElements.findFieldFormEmail,DataForTestCreateUsers.loginForReg));//ввод мыла в поле
        assertTrue(StartForTest.isElementPresent(ByElements.findFieldForPassword,DataForTestCreateUsers.passwordForReg));//ввод пароля в поле
        assertTrue(StartForTest.isElementPresent(ByElements.findFieldForName,DataForTestCreateUsers.nameForReg));//ввод имени в поле
        assertTrue(StartForTest.isElementPresent(ByElements.findFieldForSurName,DataForTestCreateUsers.surnameForReg));//ввод sur name в поле
        assertTrue(StartForTest.isElementPresent(ByElements.findCheckBoxAdminRole,true));//включение роли админа
        assertTrue(StartForTest.isElementPresent(ByElements.findButtonSave,true));//сохранение внесенных изменений
        Date date = new Date();
        String d = date.toString();
        System.out.println(d);


    }
    @Test(priority = 4)
    //проверка созданного пользователя с ролью админа
    public void testTableUsersAdminRole(){
        sleep(500);
        assertTrue(StartForTest.findElementsRoles(By.cssSelector("span"),StartForTest.findElementsInTable(),DataForTestCreateUsers.dataForRoles[0]));//поиск ролей в таблице админ
        //assertTrue(StartForTest.findElementsRoles(By.cssSelector("span"),StartForTest.findElementsInTable(),DataForTestCreateUsers.dataForRoles[1]));
        assertTrue(StartForTest.isTableElementPresent(StartForTest.findElementsInTable(),1,DataForTestCreateUsers.dataForReg[2]));//поиск имени в таблице
        assertTrue(StartForTest.isTableElementPresent(StartForTest.findElementsInTable(),1,DataForTestCreateUsers.dataForReg[3]));//поиск sur name в таблице
        StartForTest.logOut(ByElements.findLogOutList,ByElements.findButtonLogOut);//выход из пользователя
        //assertTrue(StartForTest.elementTableClick(By.cssSelector("a"),StartForTest.findElementsInTable(driver),0));//удаление или редактирование пользователя
        sleep(800);
        StartForTest.startForLogin(DataForTestCreateUsers.loginForReg,DataForTestCreateUsers.passwordForReg);//залогинится под созданным пользователем
        assertTrue(StartForTest.findTabsForTetsRoles((ByElements.findNameTabsForTestRoles), DataForTestCreateUsers.massTabsForRoleTestAdmin));//проверка наличия всех вкладок соответствущих текущему пользователю
        StartForTest.logOut(ByElements.findLogOutList,ByElements.findButtonLogOut);



    }
    @Test(priority = 5)
    //создание пользователя с ролью партнера
    public void editCreatedUserAffiliateRole(){
        StartForTest.startForLogin(DataForTestCreateUsers.loginName,DataForTestCreateUsers.password);//вход под root пользователем
        StartForTest.findTabUsers(ByElements.findDropDownListUsers,ByElements.findUserManagerInList);//поиск вкладки users
        //driver.findElement(ByElements.findButtonAdd).click();
        assertTrue(StartForTest.elementTableClick(By.cssSelector("a"),StartForTest.findElementsInTable(),0));//удаление или редактирование пользователя
        assertTrue(StartForTest.isElementPresent(ByElements.findCheckBoxAdminRole,true));//выключение роли админа
        assertTrue(StartForTest.isElementPresent(ByElements.findCheckBoxAffiliateRole,true));//включение роли партнера
        assertTrue(StartForTest.isElementPresent(ByElements.findButtonSave,true));//сохранение внесенных изменений
        assertTrue(StartForTest.findElementsRoles(By.cssSelector("span"),StartForTest.findElementsInTable(),DataForTestCreateUsers.dataForRoles[1]));//поиск ролей в таблице партнер
        //assertTrue(StartForTest.findElementsRoles(By.cssSelector("span"),StartForTest.findElementsInTable(),DataForTestCreateUsers.dataForRoles[1]));
        assertTrue(StartForTest.isTableElementPresent(StartForTest.findElementsInTable(),1,DataForTestCreateUsers.dataForReg[2]));//поиск имени в таблице
        assertTrue(StartForTest.isTableElementPresent(StartForTest.findElementsInTable(),1,DataForTestCreateUsers.dataForReg[3]));//поиск sur name в таблице
        StartForTest.logOut(ByElements.findLogOutList,ByElements.findButtonLogOut);//выход из пользователя
    }

    @AfterClass
    public void close() {
        driver.quit();

    }

}
