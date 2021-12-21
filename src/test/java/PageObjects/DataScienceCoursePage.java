package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public record DataScienceCoursePage(WebDriver webDriver) {

    private static final By DATA_SCIENCE_COURSE_PAGE_HEADER = By.cssSelector("div.tn-elem__3655939861588174360783>h1");

    private static final By GET_DATA_SCIENCE_COURSE_PROGRAM_BUTTON = By.cssSelector("div.tn-elem__3655939861563736002507");
    private static final By DATA_SCIENCE_COURSE_GET_PROGRAM_FORM = By.cssSelector("div.tn-elem__1634404761571433298085>div");
    private static final By PROGRAM_FORM_NAME = By.cssSelector("#form163440476 div[data-input-lid='1531306540094']>div>input");
    private static final By PROGRAM_FORM_EMAIL = By.cssSelector("#form163440476 div[data-input-lid='1531306243545']>div>input");
    private static final By PROGRAM_FORM_PHONE = By.cssSelector("#form163440476 div[data-input-lid='1568972284430']>div>input");
    private static final By PROGRAM_FORM_SUBMIT_BUTTON = By.cssSelector("#form163440476 button");
    private static final By PROGRAM_FORM_CHECK_BOX = By.cssSelector("#form163440476 div.t-input-group_cb div.t-checkbox__indicator");
    private static final By PROGRAM_FORM_ERROR_MESSAGE = By.cssSelector("div.tn-form__errorbox-popup>div>p");

    private static final By SING_UP_ON_COURSE_BUTTON = By.cssSelector("div.tn-elem__2075626331587127234117");
    private static final By OPTIMAL_TARIF_BUTTON = By.cssSelector("div.tn-elem__3655962081620730172352");
    private static final By FORM_NAME = By.cssSelector("form#form242437600 div[data-input-lid='1495810359387']>div>input");
    private static final By FORM_EMAIL = By.cssSelector("form#form242437600 div[data-input-lid='1495810354468']>div>input");
    private static final By FORM_TELEPHONE = By.cssSelector("form#form242437600 div[data-input-lid='1495810410810']>div>input");
    private static final By FORM_SUBMIT_BUTTON = By.cssSelector("form#form242437600 div.t-form__submit>button");
    private static final By FORM_ERROR_MESSAGE = By.cssSelector("form#form242437600 div.t-form__errorbox-middle p.js-rule-error-req:nth-child(2)");
    private static final By FORM_PHONE_ERROR_MESSAGE = By.cssSelector("form#form242437600 div.t-form__errorbox-middle p.js-rule-error-phone:nth-child(5)");


    public void moveToElement(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    public void waitElement(By locatorElem) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorElem));
    }

    public String getDataScienceCoursePageHeader() {
        waitElement(DATA_SCIENCE_COURSE_PAGE_HEADER);
        WebElement pageText = webDriver.findElement(DATA_SCIENCE_COURSE_PAGE_HEADER);
        return pageText.getText();
    }
    public void clickDataScienceCourseGetProgramButton() {
        waitElement(GET_DATA_SCIENCE_COURSE_PROGRAM_BUTTON);
        WebElement button = webDriver.findElement(GET_DATA_SCIENCE_COURSE_PROGRAM_BUTTON);
        moveToElement(button);
        Actions actions = new Actions(webDriver); // такая реализация сделана из-за появления ошибки interseption
        actions.moveToElement(button).click().build().perform();
    }

    public String getDataScienceCourseProgramFormHeader() {
        waitElement(DATA_SCIENCE_COURSE_GET_PROGRAM_FORM);
        WebElement pageText = webDriver.findElement(DATA_SCIENCE_COURSE_GET_PROGRAM_FORM);
        return pageText.getText();
    }
    public void fillFormProgram() {
        waitElement(PROGRAM_FORM_NAME);
        webDriver.findElement(PROGRAM_FORM_NAME).sendKeys("Семён");
        webDriver.findElement(PROGRAM_FORM_EMAIL).sendKeys("email@mail.ru");
        webDriver.findElement(PROGRAM_FORM_PHONE).sendKeys("+7 495 333 33 33");
        webDriver.findElement(PROGRAM_FORM_CHECK_BOX).click();
        webDriver.findElement(PROGRAM_FORM_SUBMIT_BUTTON).click();
    }
    public String getProgramCheckBoxErrorMessage() {
        waitElement(PROGRAM_FORM_ERROR_MESSAGE);
        return webDriver.findElement(PROGRAM_FORM_ERROR_MESSAGE).getText();
    }
    public void clickSubmitButtonWithoutFillProgram(){
        waitElement(PROGRAM_FORM_SUBMIT_BUTTON);
        webDriver.findElement(PROGRAM_FORM_SUBMIT_BUTTON).click();
    }
    public String getFormProgramEmptyFieldsErrorMessage () {
        waitElement(PROGRAM_FORM_ERROR_MESSAGE);
        WebElement message = webDriver.findElement(PROGRAM_FORM_ERROR_MESSAGE);
        return message.getText();
    }
    public void inputIncorrectEmail (String incorrectEmail) {
        waitElement(PROGRAM_FORM_NAME);
        webDriver.findElement(PROGRAM_FORM_NAME).sendKeys("Семён");
        webDriver.findElement(PROGRAM_FORM_EMAIL).sendKeys(incorrectEmail);
        webDriver.findElement(PROGRAM_FORM_PHONE).sendKeys("+7 495 333 33 33");
        webDriver.findElement(PROGRAM_FORM_SUBMIT_BUTTON).click();
    }
    public String getFormProgramIncorrectEmailErrorMessage () {
        waitElement(PROGRAM_FORM_ERROR_MESSAGE);
        WebElement message = webDriver.findElement(PROGRAM_FORM_ERROR_MESSAGE);
        return message.getText();
    }
    public void clickSignUpOnCourseButton() {
        waitElement(SING_UP_ON_COURSE_BUTTON);
        WebElement button = webDriver.findElement(SING_UP_ON_COURSE_BUTTON);
        moveToElement(button);
        button.click();
    }
    public void chooseOptimalTarif() {
        waitElement(OPTIMAL_TARIF_BUTTON);
        WebElement button = webDriver.findElement(OPTIMAL_TARIF_BUTTON);
        Actions actions = new Actions(webDriver); // такая реализация сделана из-за появления ошибки interseption
        actions.moveToElement(button).click().build().perform();
    }
    public void fillFormForSignUpOnCourse() {
        waitElement(FORM_NAME);
        webDriver.findElement(FORM_NAME).sendKeys("Семён");
        webDriver.findElement(FORM_EMAIL).sendKeys("email@mail.ru");
        webDriver.findElement(FORM_TELEPHONE).sendKeys("+7 495 333 33 33");
        webDriver.findElement(FORM_SUBMIT_BUTTON).click();
    }

    public void formSubmitClick() {
        waitElement(FORM_SUBMIT_BUTTON);
        webDriver.findElement(FORM_SUBMIT_BUTTON).click();
    }

    public String getFormErrorMessage() {
        waitElement(FORM_ERROR_MESSAGE);
        WebElement robotMessage = webDriver.findElement(FORM_ERROR_MESSAGE);
        return robotMessage.getText();
    }
    public String getFormPhoneErrorMessage() {
        waitElement(FORM_PHONE_ERROR_MESSAGE);
        WebElement robotMessage = webDriver.findElement(FORM_PHONE_ERROR_MESSAGE);
        return robotMessage.getText();
    }
    public void inputIncorrectPhoneNumber(String incorrectPhoneNumber) {
        waitElement(FORM_NAME);
        webDriver.findElement(FORM_NAME).sendKeys("Семён");
        webDriver.findElement(FORM_EMAIL).sendKeys("email@mail.ru");
        webDriver.findElement(FORM_TELEPHONE).sendKeys(incorrectPhoneNumber);
        webDriver.findElement(FORM_SUBMIT_BUTTON).click();
    }

}
