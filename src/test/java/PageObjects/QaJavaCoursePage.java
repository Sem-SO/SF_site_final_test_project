package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public record QaJavaCoursePage(WebDriver webDriver) {

    private static final By QA_AUTOMATION_JAVA_COURSE_HEADER = By.cssSelector("div.tn-elem__3596564571619783883087>div");


    public String getQaJavaAutomationHeader() {
        WebElement pageText = webDriver.findElement(QA_AUTOMATION_JAVA_COURSE_HEADER);
        return pageText.getText();
    }
}
