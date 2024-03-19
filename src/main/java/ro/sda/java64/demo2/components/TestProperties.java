package ro.sda.java64.demo2.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestProperties implements CommandLineRunner {

    @Value("${testConfig:Bleah}")
    private String value;

    @Value("${env.value}")
    private String value2;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Am initalizat valoarea cu:" + value);
        System.out.println("Am initalizat env value cu:" + value2);
    }
}
