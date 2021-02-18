package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    String BASE_URL = "https://reqres.in/api/";

    Gson converter = new Gson();

    public String get(String url) {
        return given()
                .when()
                .get(BASE_URL + url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
    }

    public int getCode(String url) {
        return given()
                .when()
                .get(BASE_URL + url)
                .then()
                .log().all()
                .extract().statusCode();
    }

    public Response post(String url, String body) {
        return given()
                .body(body)
                .when()
                .post(BASE_URL + url)
                .then()
                .log().all()
                .statusCode(201)
                .extract().response();
    }

    public Response put(String url, String body){
        return given()
                .body(body)
                .when()
                .put(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }
}
