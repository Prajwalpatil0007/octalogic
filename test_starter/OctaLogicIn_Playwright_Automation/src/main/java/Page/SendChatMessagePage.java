package Page;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.asserts.SoftAssert;

public class SendChatMessagePage {
    private Page page;
    private SoftAssert softAssert;

    public SendChatMessagePage(Page page, SoftAssert softAssert) {
        this.page = page;
        this.softAssert = softAssert;
    }

    //Locators
    Locator clickChatMenu() {
        return page.locator("(//span[text()='chat']//..//..)[1]");
    }

    Locator clickDejaBradyChat() {
        return page.locator("(//h6[text()='Deja Brady']//..//..)[1]");
    }

    Locator enterMsgInChat() {
        return page.locator("//input[@placeholder='Type a message']");
    }

    Locator verifyDejaBradyMg() {
        return page.locator("//div[text()='Hello, how are you?']");
    }

    public void sendChatMessage() {
        clickChatMenu().click();
        System.out.println("Clicked on chat menu");
        clickDejaBradyChat().click();
        System.out.println("Selected a deja brady chat");
        enterMsgInChat().isVisible();
        enterMsgInChat().click();
        enterMsgInChat().fill("Hello, how are you?");
        page.waitForTimeout(2000.0);
        System.out.println("Entered the Hello, how are you? text");
        page.keyboard().press("Enter");
        verifyDejaBradyMg().isVisible();
        softAssert.assertEquals(verifyDejaBradyMg().innerText().trim(), "Hello, how are you?", "Hello, how are you? --> Msg not sent");
        System.out.println("Verified the message");
    }

}
