package com.example.placement.Service;

import com.example.placement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testfindbyuser(){
        assertNotNull(userRepository.findByEmail("princekusba4214@gmail.com"));
    }
}
