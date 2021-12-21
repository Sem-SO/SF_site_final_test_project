package TestRun;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.runner.RunWith;


import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", tags = "@regress") // @regress @success @bug
public class RunCucumberTest {

    @AfterClass
    public static void tearDown() {
        System.out.println("tearDown execute");
        StepDefinitions.webDriver.quit();
    }
}
