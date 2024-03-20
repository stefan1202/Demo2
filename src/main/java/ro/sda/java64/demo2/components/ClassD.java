package ro.sda.java64.demo2.components;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class ClassD {
    private  ClassC classC;

    @Override
    public String toString() {
        return "ClassD{" +

                '}';
    }
}
