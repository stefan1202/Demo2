package ro.sda.java64.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ro.sda.java64.demo2.components.ClassA;
import ro.sda.java64.demo2.components.ClassB;

import javax.sql.DataSource;

@SpringBootApplication()
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

    @Bean
    public ClassA createClassABean(ClassB bean){
        return new ClassA(bean);
    }



}
