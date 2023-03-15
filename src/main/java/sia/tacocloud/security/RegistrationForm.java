package sia.tacocloud.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.Users;

/**
 * @author sayCode
 * @date 2023/3/2 19:37
 * @project taco-cloud
 * @Title RegistrationForm
 * @description TODO
 */

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Users toUser(PasswordEncoder passwordEncoder){
        return new Users(
                username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone
        );
    }
}
