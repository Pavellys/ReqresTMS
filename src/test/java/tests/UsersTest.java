package tests;

import com.google.gson.Gson;
import objects.UsersList;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersTest {

    @Test
    public void listUsersTest() {
        String body = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
        UsersList list = new Gson().fromJson(body, UsersList.class);
        Assert.assertEquals(list.getData().get(0).getId(), 7);
        Assert.assertEquals(list.getData().get(2).getFirstName(), "Tobias");
        Assert.assertEquals(list.getData().get(4).getLastName(), "Edwards");
    }

    @Test
    public void singleUserTest() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void notFoundTest() {
        given()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void createUserTest() {
        given().body("{\n" +
                "    \"first_name\": \"morpheus\",\n" +
                "    \"last_name\": \"leader\"\n" +
                "}")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    public void updateUserTest(){
        given().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}")
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .using()
                .log().body()
                .statusCode(200);
    }
}
