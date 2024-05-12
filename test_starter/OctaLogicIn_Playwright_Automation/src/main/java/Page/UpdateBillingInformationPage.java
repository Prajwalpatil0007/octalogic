package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.asserts.SoftAssert;

public class UpdateBillingInformationPage {

    private Page page;
    private SoftAssert softAssert;

    public UpdateBillingInformationPage(Page page, SoftAssert softAssert) {
        this.page = page;
        this.softAssert = softAssert;
    }

    //Locators
    Locator clickUserMenu() {
        return page.locator("(//span[text()='user']//..//..)[1]");
    }

    Locator clickAccountSubMenu() {
        return page.locator("//a[@href='/dashboard/user/account']");
    }

    Locator clickBillingTab() {
        return page.locator("//div[@class='MuiTabs-flexContainer css-7sga7m']//button[2]");
    }

    Locator clickBillingName() {
        return page.locator("//div[text()='Billing name']//..//div//button");
    }

    Locator selectDejaBrady() {
        return page.locator("//div[@class='MuiStack-root css-5mj9jh']//div[3]");
    }

    Locator clickPaymentMethod() {
        return page.locator("//div[text()='Payment method']//..//div//button");
    }

    Locator selectMasterCard() {
        return page.locator("//div[@class='MuiPaper-root MuiPaper-outlined MuiPaper-rounded MuiStack-root css-1v8rs44'][1]");
    }

    public void updateBillingAddress() {
        clickUserMenu().click();
        System.out.println("Clicked on user menu");
        clickAccountSubMenu().click();
        System.out.println("Clicked on account submenu");
        clickBillingTab().click();
        System.out.println("opened billing tab");
        clickBillingName().click();
        selectDejaBrady().click();
        System.out.println("Updated billing name");
        clickPaymentMethod().click();
        selectMasterCard().click();
        System.out.println("Updated payment method");
    }

    public void verifyBillingDetails() {
        softAssert.assertEquals(clickBillingName().innerText().trim(), "Deja Brady", "Deja Brady billing name is not updated");
        System.out.println("Verified the Billing name");
        softAssert.assertEquals(clickPaymentMethod().innerText().trim(), "**** **** **** 1234", "master card is not updated");
        System.out.println("verified the payment name");
    }
}
