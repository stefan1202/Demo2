package outsideSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeanOutside implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sunt BeanOutside");
    }
}
