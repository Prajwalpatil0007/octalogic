package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.asserts.SoftAssert;

public class DeleteFiles {
    private Page page;
    private SoftAssert softAssert;

    public DeleteFiles(Page page, SoftAssert softAssert) {
        this.page = page;
        this.softAssert = softAssert;
    }

    //Locators
    Locator clickFileManagerMenu() {
        return page.locator("(//span[text()='File Manager']//..//..)[1]");
    }

    Locator selectTheCheckbox() {
        return page.locator("//span[text()='Name']//..//preceding-sibling::th//input");
    }

    Locator clickDeleteIcon() {
        return page.locator("//button[@aria-label='Delete']");
    }

    Locator clickDeleteBtn() {
        return page.locator("//button[text()='Delete']");
    }

    Locator verifyNoDataText() {
        return page.locator("//span[text()='No Data']");
    }

    public void deleteFiles() {
        clickFileManagerMenu().click();
        System.out.println("Clicked on Dile manager menu");
        selectTheCheckbox().click();
        System.out.println("Select all items listed");
        clickDeleteIcon().click();
        System.out.println("clicked on delete icon");
        clickDeleteBtn().click();
        System.out.println("Clicked on delete button iin the confirmation popup");
        softAssert.assertEquals(verifyNoDataText().innerText().trim(), "No Data", "All the files is not deleted");
        System.out.println("Verified the No Data text after deleting");
    }
}
