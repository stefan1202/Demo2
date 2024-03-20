package ro.sda.java64.demo2.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

@Component
@ApplicationScope
@Profile("dev")
public class ClassB implements CommandLineRunner {

    public ClassB() {
        System.out.println("Construiesc obiectul ClassB");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sunt in run in ClassB");
    }
}
