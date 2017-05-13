package steps;

import com.github.mkolisnyk.cucumber.runner.AfterSuite;
import com.github.mkolisnyk.cucumber.runner.BeforeSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import helper.Service;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by Hoang on 4/25/17.
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "report/cucumber.json",
        // rerun if scenario failed
        retryCount = 0,
        detailedReport = true,
        overviewReport = true,
        toPDF = false,
        outputFolder = "report")
@CucumberOptions(
        features = "classpath:features",
        glue = {"steps"},
        tags = {"~@skip"},
        plugin = {"json:report/cucumber.json"}
)
public class Runner {

}
