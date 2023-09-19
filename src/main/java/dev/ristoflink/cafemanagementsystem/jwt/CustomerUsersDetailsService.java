package dev.ristoflink.cafemanagementsystem.jwt;

import dev.ristoflink.cafemanagementsystem.dao.UserDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@AllArgsConstructor
@Service
@Slf4j
public class CustomerUsersDetailsService implements UserDetailsService {

    UserDao userDao;

    private dev.ristoflink.cafemanagementsystem.pojo.User userDetail;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername");
        userDetail = userDao.findByEmailId(username);
        if (!Objects.isNull(userDetail))
            return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
        else throw new UsernameNotFoundException("User not found");
    }

    public dev.ristoflink.cafemanagementsystem.pojo.User getUserDetail() {
        return userDetail;
    }
}
