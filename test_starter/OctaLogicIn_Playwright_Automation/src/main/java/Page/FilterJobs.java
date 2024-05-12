package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class FilterJobs {
    private Page page;
    private SoftAssert softAssert;

    public FilterJobs(Page page, SoftAssert softAssert) {
        this.page = page;
        this.softAssert = softAssert;
    }

    //Locators
    Locator clickJobMenu() {
        return page.locator("(//span[text()='job']//..//..)[1]");
    }

    Locator clickListSubMenu() {
        return page.locator("(//span[text()='list']//..//..)[1]");
    }

    Locator clickFilters() {
        return page.locator("//button[text()='Filters']");
    }

    Locator selectCheckBoxForOnDemand() {
        return page.locator("//h6[text()='Employment Types']//..//label[3]//input");
    }

    Locator closeSideBar() {
        return page.locator("//button[@aria-label='Reset']//following-sibling::button");
    }

    List<Locator> verifyListOfOnDemand() {
        return page.locator("//div[@class='MuiBox-root css-1csqgpf']//span[text()='On Demand']").all();
    }

    public void SearchOrder() {
        clickJobMenu().click();
        System.out.println("Clicked on job menu");
        clickListSubMenu().click();
        System.out.println("Clicked on list from sub menu");
        clickFilters().click();
        System.out.println("Clicked on filters panel");
        selectCheckBoxForOnDemand().click();
        System.out.println("selected the on demand checkbox");
        closeSideBar().click();
        System.out.println("Closed the filter panel");
        //verify using for loop
        for (Locator l : verifyListOfOnDemand()){
            l.innerText().trim().equals("On Demand");
        }
        //verify using single value index
        softAssert.assertEquals(verifyListOfOnDemand().get(0).innerText().trim(), "On Demand", "On Demand value not present");
        softAssert.assertEquals(verifyListOfOnDemand().get(1).innerText().trim(), "On Demand", "On Demand value not present");
        softAssert.assertEquals(verifyListOfOnDemand().get(2).innerText().trim(), "On Demand", "On Demand value not present");
        softAssert.assertEquals(verifyListOfOnDemand().get(3).innerText().trim(), "On Demand", "On Demand value not present");
        System.out.println("Verified all the on demand values");
    }
}
