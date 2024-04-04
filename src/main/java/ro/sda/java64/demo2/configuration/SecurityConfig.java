package ro.sda.java64.demo2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((req)-> req.requestMatchers("/book/**").permitAll()
        .requestMatchers("/webjars/**").permitAll()
        .requestMatchers("/api/*").permitAll()
        .requestMatchers("/api/**").permitAll()
        .anyRequest().authenticated());

//        http.formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
        http.formLogin((login)-> login.permitAll().successForwardUrl("/success"));
        http.logout((logout)-> logout.permitAll().clearAuthentication(true).invalidateHttpSession(true));
        http.httpBasic(withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        http.csrf((csrf)-> csrf.ignoringRequestMatchers("/api/**"));
        http.cors(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
