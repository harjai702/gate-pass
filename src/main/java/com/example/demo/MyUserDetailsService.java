package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    userrepo userRepository;
    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<users> user=userRepository.findByUsername(username);
       user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+username));
       return user.map(MyUserDetails::new).get();
    }
}
