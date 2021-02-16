package objects;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Users {
    int id;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("last_name")
    String lastName;
}
