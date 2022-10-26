package com.projectspring.course.config;

import com.projectspring.course.entities.User;
import com.projectspring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")// para colocar que é específico para teste
public class TestConfig implements CommandLineRunner {       // vai servir para fazer o database seeding (popular o banco de dados)

    @Autowired      // o spring vai resolver essa dependência e associar uma instância do UserRepository
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
