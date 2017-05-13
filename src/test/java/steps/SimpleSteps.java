package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DriverFactory;
import helper.Service;
import io.appium.java_client.AppiumDriver;
import modules.*;

/**
 * Created by Hoang on 5/9/17.
 */
public class SimpleSteps {

    private AppiumDriver driver;

    @Before()
    public void setUp() {
        Service.startService();
        DriverFactory driverFactory = new DriverFactory(DriverFactory.IOS_NO_RESET);
        driver = driverFactory.getDriver();
    }

    @After()
    public void cleanUp() {
        DriverFactory.destroyDriver();
        Service.stopService();
    }

    @Given("^Launch the App$")
    public void launch_the_App() throws Throwable {
        return;
    }

    @Then("^Check/Validate second item in the list is \"([^\"]*)\"$")
    public void check_Validate_second_item_in_the_list_is(String arg1) throws Throwable {
        new SimpleModule(driver).validateSecondItem(arg1);
    }

    @Then("^it has (\\d+)\\* Rating$")
    public void it_has_Rating(int arg1) throws Throwable {
        new SimpleModule(driver).validateSecondStart();
    }

    @When("^Click on the first line Item \"([^\"]*)\"$")
    public void click_on_the_first_line_Item(String arg1) throws Throwable {
        new SimpleModule(driver).tapOnFirstItem();
    }

    @When("^Change the name to \"([^\"]*)\"$")
    public void change_the_name_to(String arg1) throws Throwable {
        new SecondModule(driver).updateNameItem(arg1);
    }

    @When("^Give (\\d+)\\* rating$")
    public void give_rating(int arg1) throws Throwable {
        driver.hideKeyboard();
        new SecondModule(driver).changeFirstStart();
    }

    @When("^Click Save$")
    public void click_Save() throws Throwable {
        new SecondModule(driver).save();
    }

    @Then("^verify that my Salad has (\\d+)\\* rating$")
    public void verify_that_my_Salad_has_rating(int arg1) throws Throwable {
        new SimpleModule(driver).validateFirstStart();
    }


}
