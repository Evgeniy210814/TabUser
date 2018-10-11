import org.openqa.selenium.By;

public class ByElements {
    public static By findUserControlPanel = By.xpath("//*[@class='hpanel']");
    public static By findElementFieldSearch = By.xpath("//*[@name='search']");
    public static By findElementFieldCount =By.xpath("//*[@name='perpage']");
    public static By findHeadTable = By.xpath("//thead");
    public static By findButtonAdd = By.xpath("//*[.='Add']");
    public static By findFieldFormEmail = By.id("form_email");
    public static By findFieldForPassword = By.id("password");
    public static By findFieldForName =By.id("form_first_name");
    public static By findFieldForSurName =By.id("form_last_name");
    public static By findCheckBoxAdminRole = By.xpath("//input[@value='ROLE_ADMIN']");
    public static By findCheckBoxAffiliateRole =By.xpath("//input[@value='ROLE_MANAGER_AFFILIATE']");
    public static By findButtonSave = By.id("form_save");
    public static By findLogOutList = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]");
    public static By findButtonLogOut = By.xpath("//a[contains(text(),'Sign out')]");
    public static By findDropDownListUsers = By.xpath("//span[contains(text(),'Users')]");
    public static By findUserManagerInList = By.xpath("//*[.='User management']");
    public static By findNameTabsForTestRoles =By.xpath("//ul[@class='nav']/li");


}
