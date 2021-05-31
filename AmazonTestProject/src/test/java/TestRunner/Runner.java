package TestRunner;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;




@CucumberOptions(features={"src/test/java/FeatureFile"}
        ,glue={"StepDefinitions"}
        ,plugin = {"pretty", "html:target/Reports"}
)

public class Runner extends AbstractTestNGCucumberTests {


}