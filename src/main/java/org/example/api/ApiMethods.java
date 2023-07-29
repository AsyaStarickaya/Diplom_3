package org.example.api;

import io.qameta.allure.Step;
import org.example.random.RandomGenerator;
import static io.restassured.RestAssured.given;


public class ApiMethods extends RandomGenerator {
    private String token;

    @Step("Создали пользователя")
    public String createUser(CreateUserPojo createUserJson) {
        token = given()
                .header("Content-type", "application/json")
                .body(createUserJson)
                .when().post(ApiConstants.REGISTRATION_URL)
                .then().extract().body().path("accessToken");
        return token;
    }

    @Step("Авторизовались пользователем")
    public String loginUser(String email, String password) {
        LoginUserPojo loginUserJson = new LoginUserPojo(email, password);
        token = given()
                .header("Content-type", "application/json")
                .body(loginUserJson)
                .when().post(ApiConstants.AUTH_URL)
                .then().extract().body().path("accessToken");
        return token;
    }

    @Step("Удалили пользователя")
    public void deleteUser(String token) {
         given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .when().delete(ApiConstants.USER_URL)
                .then();
    }
}
