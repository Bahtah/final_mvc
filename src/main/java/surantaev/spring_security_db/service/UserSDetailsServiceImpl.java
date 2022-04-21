package surantaev.spring_security_db.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import surantaev.spring_security_db.entity.MyUser;
import surantaev.spring_security_db.entity.User;
import surantaev.spring_security_db.repo.UserRepository;

public class UserSDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("could not find user");
        }
        return new MyUser(user);
    }
}
