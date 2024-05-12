package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.asserts.SoftAssert;

public class LoginPage {
    private Page page;
    private SoftAssert softAssert;

    public LoginPage(Page page, SoftAssert softAssert) {
        this.page = page;
        this.softAssert = softAssert;
    }

    //Locators
    Locator clickLogin() {
        return page.locator("//a[text()='Login']");
    }

    Locator username() {
        return page.locator("//input[@id=':r28:']");
    }

    Locator password() {
        return page.locator("//input[@id=':r29:']");
    }

    Locator clickLoginBtn() {
        return page.locator("//button[text()='Login']");
    }

    Locator clickApp() {
        return page.locator("(//span[text()='app']//../..//..)[1]");
    }

    public void login() {
        clickLogin().click();
        username().focus();
        username().fill(Constants.username);
        System.out.println("Entered username");
        password().focus();
        password().fill(Constants.password);
        System.out.println("Entered password");
        clickLoginBtn().click();
        System.out.println("clicked on login button then page will land to dashboard page");
        page.waitForLoadState();
    }

    public void gotoDashboard() {
        clickApp().isVisible();
        clickApp().click();
        System.out.println("Clicked on APP to goto dashboard page");
    }
}
