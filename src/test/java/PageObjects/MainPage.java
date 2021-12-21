package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public record MainPage(WebDriver webDriver) {

    private static final String URL = "https://skillfactory.ru/";
    private static final By CLOSE_ADVERTISING_BUTTON = By.cssSelector("div.popmechanic-close");
    private static final By DROP_DOWN_MENU = By.cssSelector(".t978__tm-link");
    private static final By ALL_COURSES_FROM_DROP_DOWN_MENU = By.xpath("//span[text()='ВСЕ КУРСЫ']");
    private static final By DATA_SCIENCE_FROM_DROP_DOWN_MENU = By.xpath("//span[text()='Data Science']");
    private static final By HABR_LINK = By.cssSelector("div.tn-elem__2988276021608735712198");
    private static final By VK_LINK = By.cssSelector("div.tn-elem__2988276021608548393864");
    private static final By MAILING_FORM = By.cssSelector("div[data-input-lid='1621848263444'] input");
    private static final By MAILING_FORM_SUBMIT_BUTTON = By.cssSelector("#form298827602 button");
    private static final By MAILING_FORM_CHECK_BOX = By.cssSelector("div[data-input-lid='1621848263445'] input");
    private static final By MAILING_FORM_ERROR_MESSAGE = By.cssSelector("div.tn-form__errorbox-popup>div>p");
    private static final By PARTNER_LINK = By.cssSelector("div[data-elem-id='1563732871939']");



    public void startMainPage() {
        webDriver.get(URL);
    }

    public void moveToElement(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    public void waitElement(By locatorElem) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorElem));
    }

    public void closeAdvertising() {
        WebElement advertising = webDriver.findElement(CLOSE_ADVERTISING_BUTTON);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(advertising));
        advertising.click();
    }

    private void openDropDownMenu() {
        webDriver.findElement(DROP_DOWN_MENU).click();
    }

    public void chooseAllCoursesCategory() {
        openDropDownMenu();
        webDriver.findElement(ALL_COURSES_FROM_DROP_DOWN_MENU).click();
    }

    public void chooseDataScienceCategory() {
        openDropDownMenu();
        webDriver.findElement(DATA_SCIENCE_FROM_DROP_DOWN_MENU).click();
    }

    public void clickHabrLink() {
        waitElement(HABR_LINK);
        WebElement habrLink = webDriver.findElement(HABR_LINK);
        moveToElement(habrLink);
        habrLink.click();
    }

    public void clickVKLink() {
        waitElement(VK_LINK);
        WebElement habrLink = webDriver.findElement(VK_LINK);
        moveToElement(habrLink);
        habrLink.click();
    }

    public String getUrlFromNewPage() {
        ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles()); // переключение между вкладками
        webDriver.switchTo().window(tabs.get(1));
        String url = webDriver.getCurrentUrl();
        webDriver.switchTo().window(webDriver.getWindowHandle()).close();
        webDriver.switchTo().window(tabs.get(0));
        return url; // получение URL новой вкладки
    }
    public void inputEmailForMailing() {
        waitElement(MAILING_FORM);
        WebElement elem = webDriver.findElement(MAILING_FORM);
        moveToElement(elem);
        elem.sendKeys("email@mail.ru");
    }
    public void clickMailingFormSubmitButton() {
        waitElement(MAILING_FORM_SUBMIT_BUTTON);
        webDriver.findElement(MAILING_FORM_SUBMIT_BUTTON).click();
    }
    public void putAwayFromCheckBox() {
        WebElement checkBox = webDriver.findElement(MAILING_FORM_CHECK_BOX);
        Actions actions = new Actions(webDriver); // такая реализация сделана из-за появления ошибки interseption
        actions.moveToElement(checkBox).click().build().perform();
    }
    public String getMailingFormMessage() {
        waitElement(MAILING_FORM_ERROR_MESSAGE);
        return webDriver.findElement(MAILING_FORM_ERROR_MESSAGE).getText();
    }
    public void inputIncorrectEmailToMailing(String incorrectEmail) {
        waitElement(MAILING_FORM);
        WebElement elem = webDriver.findElement(MAILING_FORM);
        moveToElement(elem);
        elem.sendKeys(incorrectEmail);
    }
    public void clickOnPartnerLink() {
        waitElement(PARTNER_LINK);
        webDriver.findElement(PARTNER_LINK).click();
    }
}
