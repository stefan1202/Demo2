package ro.sda.java64.demo2.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.java64.demo2.controller.ResponseObject;

@Configuration
public class FirstConfig {


    @Bean(name = "Gigi")
 public ResponseObject createFirstBean(){
     return new ResponseObject("Stefan","Praslea");
 }

 @Bean
 public ObjectMapper objectMapper(){
       ObjectMapper om = new ObjectMapper();
       om.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
       return om;
 }

}
