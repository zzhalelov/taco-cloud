package kz.example.tacocloud.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryUserDetailsManager {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> usersList = new ArrayList<>();
        usersList.add(new User(
                "buzz", encoder.encode("password"),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))
        ));
        usersList.add(new User(
                "woody", encoder.encode("password"),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))
        ));
        return (UserDetailsService) new InMemoryUserDetailsManager();
    }
}