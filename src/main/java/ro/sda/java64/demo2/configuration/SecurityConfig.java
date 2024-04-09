package ro.sda.java64.demo2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((req) -> req.requestMatchers("/book/**").permitAll()
                .requestMatchers("/webjars/**").permitAll()
                .requestMatchers("/api/*").permitAll()
                .requestMatchers("/api/**").hasRole("user")
                .requestMatchers("/book/create/v1").hasRole("admin")
                .anyRequest().authenticated())
        ;

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

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("darius")
                .password("123")
                .roles("user")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("root")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(List.of(user,admin));
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
