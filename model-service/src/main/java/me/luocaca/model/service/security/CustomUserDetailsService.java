package me.luocaca.model.service.security;

import me.luocaca.model.entity.CustomUserDetails;
import me.luocaca.model.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<me.luocaca.model.entity.User> optionalUsers =
                userRepository.findByName(username);


        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));



        return optionalUsers
                .map(CustomUserDetails::new).get();
//                .map(CustomUserDetails::new).get();

//        logger.info("用户的用户名: {}", username);
//        // TODO 根据用户名，查找到对应的密码，与权限
//
//
//        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
//        User user = new User(username, "123456",
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//        return user;
    }


}
