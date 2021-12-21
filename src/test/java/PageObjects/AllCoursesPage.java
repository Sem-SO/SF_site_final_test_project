package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public record AllCoursesPage(WebDriver webDriver) {

    private static final By ALL_COURSES_PAGE_HEADER = By.cssSelector("h1.tn-atom");
    private static final By DATA_SCIENCE_COURSE_BUTTON = By.xpath("//div[@data-product-lid='577818545711']");
    private static final By QA_AUTOMATION_JAVA_COURSE_BUTTON = By.xpath("//div[@data-product-lid='763793576191']");
    private static final By UNITY_DEVELOPER_COURSE_BUTTON = By.cssSelector("div[data-product-lid='642349628171']");
    private static final By CHECK_BOX_THEME_C_SHARP = By.cssSelector("input[name='C#']+div");
    private static final By CHECK_BOX_DURATION_FROM_0_TO_12 =By.cssSelector("input[name='от 0 до 12']+div");
    private static final By COURSE_DURATION = By.cssSelector("div.t-store__card__descr>br+br+span");
    //private final By COURSE_DISCRIPTION = By.cssSelector("div[field='st_descr__379158548611']");
    private static final By COURSE_DISCRIPTION = By.cssSelector("div.t951__grid-cont div.t-store__card__textwrapper>div:nth-child(3)");
    private static final By CAREER_CENTER_LINK = By.cssSelector("div.tn-elem__3775221791633615138545");
    private static final By CAREER_CENTER_PAGE_HEADER = By.cssSelector("div[data-elem-id='1628851978862']>h1");
    private static final By DOP = By.cssSelector("div.t-descr_xxs div[data-filter-name='charact:1517350']");


    public void moveToElement(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", elem);
    }
    public void waitElement(By locatorElem) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locatorElem));
    }
    public String getAllCoursesHeader() {
        waitElement(ALL_COURSES_PAGE_HEADER);
        WebElement pageText = webDriver.findElement(ALL_COURSES_PAGE_HEADER);
        moveToElement(pageText);
        return pageText.getText();
    }
    public void chooseDataScienceCourse() {
        waitElement(DATA_SCIENCE_COURSE_BUTTON);
        WebElement courseButton = webDriver.findElement(DATA_SCIENCE_COURSE_BUTTON);
        moveToElement(courseButton);
        courseButton.click();
    }
    public void chooseQAJavaAutomationCourse() {
        waitElement(DOP);
        WebElement firstMove = webDriver.findElement(DOP);
        moveToElement(firstMove);
        waitElement(QA_AUTOMATION_JAVA_COURSE_BUTTON);
        WebElement courseButton = webDriver.findElement(QA_AUTOMATION_JAVA_COURSE_BUTTON);
        moveToElement(courseButton);
        courseButton.click();
    }
    public void chooseUnityDeveloperCourse() {
        waitElement(DOP);
        WebElement firstMove = webDriver.findElement(DOP);
        moveToElement(firstMove);
        waitElement(QA_AUTOMATION_JAVA_COURSE_BUTTON);
        WebElement secondMove = webDriver.findElement(QA_AUTOMATION_JAVA_COURSE_BUTTON);
        moveToElement(secondMove);
        WebElement courseButton = webDriver.findElement(UNITY_DEVELOPER_COURSE_BUTTON);
        moveToElement(courseButton);
        courseButton.click();
    }
    public void selectCheckBoxThemeCSharp() {
        waitElement(CHECK_BOX_THEME_C_SHARP);
        WebElement checkBoxElem = webDriver.findElement(CHECK_BOX_THEME_C_SHARP);
        moveToElement(checkBoxElem);
        checkBoxElem.click();
    }
    public void selectCheckBoxDurationFrom0To12() {
        waitElement(CHECK_BOX_DURATION_FROM_0_TO_12);
        WebElement checkBoxElem = webDriver.findElement(CHECK_BOX_DURATION_FROM_0_TO_12);
        moveToElement(checkBoxElem);
        checkBoxElem.click();
    }
    public List getListOfCourseDurations() {
        List<String> textList = new ArrayList<>();
        List<WebElement> listOfElements = webDriver.findElements(COURSE_DURATION);
        for (WebElement elem :listOfElements) {
            textList.add(elem.getText());
        }
        return textList;
    }
    public List getListOfCourse() {
        List<WebElement> listOfElements = webDriver.findElements(COURSE_DISCRIPTION);
        return listOfElements;
    }
    public void goToCareerCenterPage() {
        waitElement(CAREER_CENTER_LINK);
        webDriver.findElement(CAREER_CENTER_LINK).click();
    }

    public String getCareerCenterPageHeader() {
        ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles()); // переключение между вкладками
        webDriver.switchTo().window(tabs.get(1));
        String header = webDriver.findElement(CAREER_CENTER_PAGE_HEADER).getText();
        webDriver.switchTo().window(webDriver.getWindowHandle()).close();
        webDriver.switchTo().window(tabs.get(0));
        return header;
    }
}
