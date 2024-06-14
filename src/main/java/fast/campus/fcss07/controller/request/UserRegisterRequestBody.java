package fast.campus.fcss07.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegisterRequestBody {
    private final String username;
    private final String password;
}
