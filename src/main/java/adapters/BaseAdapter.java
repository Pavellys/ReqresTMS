package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    Gson converter = new Gson();

    public String get(String url) {
        return given()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
    }

    public void getError404(String url) {
         given()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(404);
    }

    public Response post(String url, String body) {
        return given()
                .body(body)
                .when()
                .post(url)
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
                //.using()
                .log().all()
                .statusCode(200)
                .extract().response();
    }
}
