package sia.tacocloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sia.tacocloud.Users;
import sia.tacocloud.data.UserRepository;

/**
 * @author sayCode
 * @date 2023/3/2 16:32
 * @project taco-cloud
 * @Title UserRepositoryUserDetailService
 * @description TODO
 */
@Service
public class UserRepositoryUserDetailService implements UserDetailsService {
    private final UserRepository userRepo;

    @Autowired
    public UserRepositoryUserDetailService(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user != null){
            return user;
        }
        throw new UsernameNotFoundException(
                "User '" + username +"' not found"
        );
    }
}
