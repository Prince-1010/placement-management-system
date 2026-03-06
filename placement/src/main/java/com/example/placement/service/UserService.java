package com.example.placement.service;

import com.example.placement.entity.UserEntity;
import com.example.placement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder encoder;


    public void saveUser(UserEntity user){

        user.setPassword(
                encoder.encode(user.getPassword())
        );

        repo.save(user);

    }


    public boolean checkLogin(String email,String password){

        UserEntity user=
                repo.findByEmail(email);

        if(user==null)
            return false;

        return encoder.matches(password,
                user.getPassword());

    }
}
