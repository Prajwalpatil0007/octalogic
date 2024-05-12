package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.asserts.SoftAssert;

public class SearchOrderPage {
    private Page page;
    private SoftAssert softAssert;

    public SearchOrderPage(Page page, SoftAssert softAssert) {
        this.page = page;
        this.softAssert = softAssert;
    }

    //Locators
    Locator clickOrderMenu() {
        return page.locator("(//span[text()='order']//..//..)[1]");
    }

    Locator clickListSubMenu() {
        return page.locator("(//span[text()='list']//..//..)[1]");
    }

    Locator searchInput() {
        return page.locator("//input[@placeholder='Search customer or order number...']");
    }

    Locator verifyCortezHerring() {
        return page.locator("//span[text()='Cortez Herring']");
    }

    public void searchOrder() {
        clickOrderMenu().click();
        System.out.println("Clicked on Order menu");
        clickListSubMenu().click();
        System.out.println("Clicked on list submenu");
        searchInput().focus();
        searchInput().fill("cor");
        System.out.println("Searched the data");
        softAssert.assertEquals(verifyCortezHerring().innerText().trim(), "Cortez Herring", "Cortez Herring data is not searched");
        System.out.println("Verified the searched data with actual and expected");
    }

}
