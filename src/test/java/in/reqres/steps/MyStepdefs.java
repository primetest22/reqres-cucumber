package in.reqres.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import in.reqres.userinfo.UserSteps;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.runner.RunWith;


public class MyStepdefs {

    public static ValidatableResponse response;
    @Steps
    UserSteps userSteps;

    @Title("This will get all user information")
    @When("^User send GET request to user endpoint$")
    public void userSendGETRequestToUserEndpoint() {
        response = userSteps.getAllUserInfo();

    }

    @Then("^User must get a valid status code (\\d+)$")
    public void userMustGetAValidStatusCode(int code) {
           response.statusCode(code);
    }

    @When("^User send GET request to get single user with id (\\d+)$")
    public void userSendGETRequestToGetSingleUserWithId(int id) {
        response = userSteps.gerSingleUser(id);
    }

    @When("^User send POST request with email \"([^\"]*)\" firstname \"([^\"]*)\" lastname \"([^\"]*)\" avatar \"([^\"]*)\"$")
    public void userSendPOSTRequestWithEmailFirstnameLastnameAvatar(String email, String firsname, String lastname, String avatar)  {
        response = userSteps.createUser(email,firsname,lastname,avatar);

    }

    @Then("^User should validate status code (\\d+)$")
    public void userShouldValidateStatusCode(int code1) {
        response.statusCode(code1);
    }

    @When("^User send POST request with email\"([^\"]*)\" password \"([^\"]*)\"$")
    public void userSendPOSTRequestWithEmailPassword(String email, String password)  {
       response = userSteps.login(email,password);
    }

    @When("^User send DELETE request to user endpoint$")
    public void userSendDELETERequestToUserEndpoint() {
        response = userSteps.deleteUser(2);

    }

    @Then("^User should see status code (\\d+)$")
    public void userShouldSeeStatusCode(int code) {
        response.statusCode(code);
    }
}
