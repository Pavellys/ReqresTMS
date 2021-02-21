package adapters;

import io.restassured.response.Response;
import objects.CreateUser;

public class UsersAdapter extends BaseAdapter{

    private static final String CREATE_USER_URL = "/api/users";
    private static final String UPDATE_USER_URL = "/api/users/2";

    public Response createUser(CreateUser createUser){
        return post(CREATE_USER_URL, converter.toJson(createUser));
    }

    public Response updateUser(CreateUser createUser){
        return put(UPDATE_USER_URL, converter.toJson(createUser));
    }
}
