package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public record UnityDeveloperCoursePage(WebDriver webDriver) {

    private static final By UNITY_DEVELOPER_COURSE_HEADER = By.cssSelector("div[field='tn_text_1626348777362']");

    public String getUnityDeveloperPageHeader() {
        WebElement pageText = webDriver.findElement(UNITY_DEVELOPER_COURSE_HEADER);
        return pageText.getText();
    }

}
