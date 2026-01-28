package com.kevin.spring_boot_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.kevin.spring_boot_rest.dao.UserRepo;
import com.kevin.spring_boot_rest.model.User;
import com.kevin.spring_boot_rest.model.UserPrincipal;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUserName(username);

        if (user == null) {
            System.out.println("User not found!");
            throw new UsernameNotFoundException("User 404");
        }

        return new UserPrincipal(user);
    }

    public String signup(User user) throws Exception {
        if (!repo.existsByUserName(user.getUserName())) {
            user.setPassword(user.getPassword());
            repo.save(user);
            return "User created";
        } else {
            throw new Exception("Username is already in use");
        }
    }

}
