package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    String BASE_URL = "https://reqres.in";

    Gson converter = new Gson();

    public Response get(String url) {
        return given()
                .when()
                .get(BASE_URL + url)
                .then()
                .log().all()
                .extract().response();
    }


    public Response post(String url, String body) {
        return  given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(BASE_URL + url)
                .then()
                .statusCode(201)
                .log().all()
                .extract().response();
    }

    public Response put(String url, String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(BASE_URL + url)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }
}
