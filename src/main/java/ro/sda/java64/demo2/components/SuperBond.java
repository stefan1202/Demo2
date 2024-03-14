package ro.sda.java64.demo2.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SuperBond implements CommandLineRunner {
    @Autowired
    @Qualifier("Dorel")
    private BondInterface bondInterface;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("SuperBond:" + bondInterface.getName());
    }
}
