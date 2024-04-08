package ro.sda.java64.demo2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((req) -> req.requestMatchers("/book/**").permitAll()
                .requestMatchers("/webjars/**").permitAll()
                .requestMatchers("/api/*").permitAll()
                .requestMatchers("/api/**").permitAll()
                .requestMatchers("book/create/v1").permitAll()
                .anyRequest().authenticated());

//        http.formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
        http.formLogin((login) -> login.permitAll().successForwardUrl("/success"));
        http.logout((logout) -> logout.permitAll().clearAuthentication(true).invalidateHttpSession(true));
        http.httpBasic(withDefaults());
//        http.csrf(AbstractHttpConfigurer::disable);
        http.csrf((csrf) -> csrf.ignoringRequestMatchers("/api/**","book/create/v1"));
        http.cors(AbstractHttpConfigurer::disable);
        http.cors(withDefaults());

        return http.build();
    }

    //Configure CORS for Angular to allow connections from Angular DEV Server and specific HTTP methods
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedMethods("GET","POST","PUT","DELETE").allowedOrigins("http://localhost:4200");
            }
        };
    }
}
