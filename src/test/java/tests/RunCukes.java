package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        tags = "~@to-do",
        glue = "tests",
        features = "classpath:volo2.features"
)

public class RunCukes extends AbstractTestNGCucumberTests {
}