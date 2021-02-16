package adapters;

import objects.CreateUser;

public class UsersAdapter extends BaseAdapter{

    private static final String CREATE_USER_URL = "https://reqres.in/api/users";
    private static final String UPDATE_USER_URL = "https://reqres.in/api/users/2";

    public void createUser(CreateUser createUser){
        post(CREATE_USER_URL, converter.toJson(createUser));
    }

    public void updateUser(CreateUser createUser){
        put(UPDATE_USER_URL, converter.toJson(createUser)).body().path("job", "name");
    }
}
