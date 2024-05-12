import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Page.*;
import org.testng.asserts.SoftAssert;

public class AllTestCases {
    public Playwright playwright = Playwright.create();
    Page page;
    SoftAssert softAssert = new SoftAssert();

    public AllTestCases() {

    }

    @BeforeClass
    public void loginSetup() throws InterruptedException {
        try {
            BrowserType chromium = playwright.chromium();
            page = chromium.launch((new BrowserType.LaunchOptions()).setHeadless(false)).newPage();
            page.navigate(Constants.URL);
            LoginPage loginPage = new LoginPage(page, softAssert);
            loginPage.login();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Description("Test case 1 update Billing Information")
    @Test(priority = 1)
    public void updateBillingInformation() {
        UpdateBillingInformationPage updateBillingInformationPage = new UpdateBillingInformationPage(page, softAssert);
        System.out.println("Navigation and updating the data");
        updateBillingInformationPage.updateBillingAddress();
        System.out.println("Validation for billing name and payment method");
        updateBillingInformationPage.verifyBillingDetails();
    }

    @Description("Test case 2 Search Order")
    @Test(priority = 2)
    public void searchOrder() {
        LoginPage loginPage = new LoginPage(page, softAssert);
        SearchOrderPage searchOrderPage = new SearchOrderPage(page, softAssert);
        loginPage.gotoDashboard();
        System.out.println("Navigation, searching the data and validation");
        searchOrderPage.searchOrder();
    }

    @Description("Test case 3 Filter Jobs")
    @Test(priority = 3)
    public void FilterJobs() {
        LoginPage loginPage = new LoginPage(page, softAssert);
        FilterJobs filterJobs = new FilterJobs(page, softAssert);
        loginPage.gotoDashboard();
        System.out.println("Navigation, Filter the data and validation");
        filterJobs.SearchOrder();
    }

    @Description("Test case 4 Send Chat Message")
    @Test(priority = 4)
    public void sendChatMessage() {
        LoginPage loginPage = new LoginPage(page, softAssert);
        SendChatMessagePage sendChatMessagePage = new SendChatMessagePage(page, softAssert);
        loginPage.gotoDashboard();
        System.out.println("Navigation, enter the msg and validation of message");
        sendChatMessagePage.sendChatMessage();
    }

    @Description("Test case 5 Delete Files")
    @Test(priority = 5)
    public void deleteFiles() {
        LoginPage loginPage = new LoginPage(page, softAssert);
        DeleteFiles deleteFiles = new DeleteFiles(page, softAssert);
        loginPage.gotoDashboard();
        System.out.println("Navigation, select all the items, delete items and validation after deletion");
        deleteFiles.deleteFiles();
    }
}
