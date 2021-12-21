package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public record PartnerProgramPage(WebDriver webDriver) {

    private static final By HIGH_REWARD_BUTTON = By.cssSelector("div[data-elem-id='1613484586227']");
    private static final By BECAME_PARTNER = By.cssSelector("div[data-elem-id='1587723260884']");
    private static final By SOME_TEXT_ON_PAGE = By.cssSelector("div[field='li_descr__1581600655963']");
    private static final By JOIN_TO_PROGRAM_BUTTON = By.cssSelector("div#rec281356625 div.t142__submit_size_lg");
    private static final By REGISTRATION_PAGE_HEADER = By.cssSelector("div.sidebar__title");


    public void moveToElement(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    public void waitElement(By locatorElem) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorElem));
    }

    public void clicJoinToPartnerProgramButton() {
        waitElement(HIGH_REWARD_BUTTON);
        WebElement firstMove = webDriver.findElement(HIGH_REWARD_BUTTON);
        moveToElement(firstMove);
        waitElement(BECAME_PARTNER);
        WebElement secondMove = webDriver.findElement(BECAME_PARTNER);
        secondMove.click();
        WebElement thirdMove = webDriver.findElement(SOME_TEXT_ON_PAGE);
        moveToElement(thirdMove);
        WebElement button = webDriver.findElement(JOIN_TO_PROGRAM_BUTTON);
        moveToElement(button);
        button.click();
    }
    public String getRegistrationPageHeader() {
        waitElement(REGISTRATION_PAGE_HEADER);
        return webDriver.findElement(REGISTRATION_PAGE_HEADER).getText();
    }
}
