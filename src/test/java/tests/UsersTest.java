package tests;

import adapters.BaseAdapter;
import adapters.UsersAdapter;
import com.google.gson.Gson;
import consntants.TestConstants;
import io.restassured.response.Response;
import objects.CreateUser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest implements TestConstants {
    Gson converter = new Gson();

    @Test
    public void listUsersTest() {
        Assert.assertEquals(new BaseAdapter().get(LIST_USERS_URL).asString(), LIST_USERS_EXP_RESULT);
    }

    @Test
    public void singleUserTest() {
        Assert.assertEquals(new BaseAdapter().get(SINGLE_USER_URL).asString(), SINGE_USER_EXP_RESULT);
    }

    @Test
    public void notFoundTest() {
        Assert.assertEquals(new BaseAdapter().get(NOT_FOUND_URL).getStatusCode(), 404);
    }

    @Test
    public void createUserTest() {
        CreateUser expectedResult = converter.fromJson("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}", CreateUser.class);
        CreateUser addUser = CreateUser.builder()
                .name("morpheus")
                .job("leader")
                .build();
        Response crateUserFromResponse = new UsersAdapter().createUser(addUser);
        CreateUser actualResult = converter.fromJson(crateUserFromResponse.asString(), CreateUser.class);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void updateUserTest(){
        CreateUser expectedResult = converter.fromJson("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}", CreateUser.class);
        CreateUser updateUser = CreateUser.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        Response updateUserFromResponse = new UsersAdapter().updateUser(updateUser);
        CreateUser actualResult = converter.fromJson(updateUserFromResponse.asString(), CreateUser.class);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
