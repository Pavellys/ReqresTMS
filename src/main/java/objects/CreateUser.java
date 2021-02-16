package objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUser {
    String name;
    String job;
}
