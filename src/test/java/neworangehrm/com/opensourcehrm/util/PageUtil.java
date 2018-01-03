package neworangehrm.com.opensourcehrm.util;

import neworangehrm.com.opensourcehrm.pages.CommonWebPage;
import neworangehrm.com.opensourcehrm.pages.DashboardPage;
import neworangehrm.com.opensourcehrm.pages.LoginPage;
import neworangehrm.com.opensourcehrm.pages.UserManagementPage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Viswa on 12/31/2017.
 */
public class PageUtil {
    public Map<String, CommonWebPage> pages = new HashMap<>();
    public static CommonWebPage commonWebPage;

    public PageUtil(){
        pages.put("login", new LoginPage());
        pages.put("dashboard", new DashboardPage());
        pages.put("usermanagement", new UserManagementPage());
    }
    public void setCurrentPage(String pageName) {
        commonWebPage = pages.get(pageName);
    }

    public CommonWebPage getCurrentPage() {
        return commonWebPage;
    }

}
