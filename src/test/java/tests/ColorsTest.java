package tests;

import com.google.gson.Gson;
import objects.ColorsList;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ColorsTest {

    @Test
    public void listResourceTest() {
        String body = given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
        ColorsList list = new Gson().fromJson(body, ColorsList.class);
        Assert.assertEquals(list.getData().get(0).getName(), "cerulean");
        Assert.assertEquals(list.getData().get(0).getYear(), 2000);
        Assert.assertEquals(list.getData().get(0).getColor(), "#98B2D1");
    }
}
