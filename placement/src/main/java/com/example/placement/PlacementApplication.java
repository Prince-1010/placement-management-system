package com.example.placement;

import com.example.placement.entity.Role;
import com.example.placement.entity.UserEntity;
import com.example.placement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PlacementApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlacementApplication.class, args);
	}
	@Bean
	public CommandLineRunner createAdmin(UserRepository repo, PasswordEncoder encoder){
		return args->{
			String adminEmail="princekusba1010@gmail.com";
			if (repo.findByEmail(adminEmail)==null){
				UserEntity admin=new UserEntity();
				admin.setEmail(adminEmail);
				admin.setPassword(encoder.encode("1010"));
				admin.setRole(Role.ROLE_ADMIN);
				repo.save(admin);
			}
		};
	}
}
