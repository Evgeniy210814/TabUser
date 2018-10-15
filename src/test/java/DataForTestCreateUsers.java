import org.openqa.selenium.WebElement;

import java.util.List;

public class DataForTestCreateUsers {
   public static String loginForReg = "ForAutoTest@gmail.com";
   public static  String passwordForReg = "123456";
   public static String nameForReg = "ForAutoTest";
   public static String surnameForReg = "ForAutoTest";
   public static String loginName = "root@user.admin";
   public static String password = "Kjaw28:7%sdfU1";
   public static String[] dataForReg = new String[]{"ForAutoTets@gmail.com", "123456", nameForReg,surnameForReg, "Not login", ""};
   public static String[] dataForRoles = new String[]{"Administrator","Affiliate manager","Sales manager"};
   public static String forRoles;
   public static String url = "http://offers.dev.affise.com/";
   public static String[] massTabsForRoleTestAdmin = new String[]{"Dashboard","Statistics","Offers","Advertisers","Affiliates","Tickets","Billing","Users","News","Settings","Instruments","Export"};
   public static String[] massTabsForRoleTestAffiliate = new String[]{"Dashboard","Statistics","Offers","Advertisers","Affiliates","Tickets","Billing","News","Instruments","Export"};
   public static String[] massTabsForRoleTestSales = new String[]{"Dashboard","Statistics","Offers","Advertisers","Tickets","Billing","News","Instruments","Export"};
   public static List<WebElement> listRolesSector;
   public static int randomValueForRoles;
   public static String[] massTabsForRolesSector = new String[]{"Dashboard","Offers","Advertisers","Affiliates","Statistics","News"," ","Billing","Tickets","Settings","Instruments","Export"};

}
