package ro.sda.java64.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ro.sda.java64.demo2.components.ClassA;
import ro.sda.java64.demo2.components.ClassB;

@SpringBootApplication()


public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

    @Bean
    @Profile("dev")
    public ClassA createClassABean(ClassB bean){
        return new ClassA(bean);
    }



}
