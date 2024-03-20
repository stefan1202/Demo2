package ro.sda.java64.demo2.components;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "sda.java64")
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Profile("!dev")
@Validated
public class ConfigPropEx {
    private String name;

    @Min(18)
    private int age;

    @NotNull
    private String lastName;
    @AssertTrue(message = "Age must be greater than 18 and less than 50")
    public boolean isLegalToVote(){
        return age>18 && age<50;
    }

    @AssertFalse(message = "There must be only one name")
    public boolean isSingleName(){
        return lastName.split(" ").length>1;
    }
}
