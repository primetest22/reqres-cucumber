package in.reqres.userinfo;

import in.reqres.constants.EndPoints;
import in.reqres.constants.Path;
import in.reqres.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;


public class UserSteps {

    @Step("Getting all user information")
    public ValidatableResponse getAllUserInfo() {

        return SerenityRest.given().log().all()
                .when()
                .queryParam("/?page=2")
                .get(EndPoints.GET_ALL_USERS)
                .then().log().all();

    }
    @Step("Getting single user information with id 12")
    public ValidatableResponse gerSingleUser(int id){
        return SerenityRest.given().log().all()
                .pathParam("ID",id)
                .when()
                .get(EndPoints.GET_SINGLE_USER)
                .then().log().all();

    }
    @Step("Create user with email firstname lastname and avatar")
    public ValidatableResponse createUser(String email,String first_name,String last_name,
                                          String avatar){
        UserPojo userPojo = UserPojo.getUserPojo(email,first_name,last_name,avatar);
        return SerenityRest.given().log().all()
               // .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .body(userPojo)
                .when()
                .post(EndPoints.CREATE_USERS)
                .then().log().all();
    }
    @Step("user should able to login successfully")
    public ValidatableResponse login(String email,String password){

        UserPojo userPojo =  UserPojo.loginPojo(email,password);
      return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(userPojo)
                .when()
                .post(EndPoints.LOGIN)
                .then().log().all();

    }
}