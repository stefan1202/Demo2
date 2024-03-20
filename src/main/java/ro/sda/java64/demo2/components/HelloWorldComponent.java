package ro.sda.java64.demo2.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Profile("dev")
public class HelloWorldComponent implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sunt in cadrul CommandLineRunner");
        System.out.println(Arrays.toString(args));
    }
}
