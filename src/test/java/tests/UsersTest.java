package tests;

import adapters.BaseAdapter;
import adapters.UsersAdapter;
import consntants.TestConstants;
import objects.CreateUser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest implements TestConstants {

    @Test
    public void listUsersTest() {
        Assert.assertEquals(new BaseAdapter().get(LIST_USERS_URL), LIST_USERS_EXP_RESULT);
    }

    @Test
    public void singleUserTest() {
        Assert.assertEquals(new BaseAdapter().get(SINGLE_USER_URL), SINGE_USER_EXP_RESULT);
    }

    @Test
    public void notFoundTest() {
        new BaseAdapter().getError404("https://reqres.in/api/users/23");
    }

    @Test
    public void createUserTest() {
        CreateUser createUser = CreateUser.builder()
                .name("morpheus")
                .job("leader")
                .build();
        new UsersAdapter().createUser(createUser);
    }

    @Test
    public void updateUserTest(){
        CreateUser updateUser = CreateUser.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        new UsersAdapter().updateUser(updateUser);
    }
}
