package com.example.ditest.service;

import com.example.ditest.entity.User;
import com.example.ditest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getOneUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User getOneUserByUserId(String userId) {
        return userRepository.findByUserId(userId).get();
    }

    @Transactional
    public User addUser(User user) {
        // password 암호화 - hashpassword
        User user1 = user.hashPassword(passwordEncoder);
        return userRepository.save(user1);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId).get();
        return user;
    }
}
