package ro.sda.java64.demo2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.java64.demo2.controller.ResponseObject;

@Configuration
public class FirstConfig {


    @Bean(name = "Gigi")
 public ResponseObject createFirstBean(){
     return new ResponseObject("Stefan","Praslea");
 }
}
