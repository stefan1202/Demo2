package ro.sda.java64.demo2.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "sda.java64")
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfigPropEx {
    private String name;
    private int age;

    private String lastName;
}
