package ro.sda.java64.demo2.controller;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseObject {
    @NotNull
    private String name;
    @Length(min = 4, max=20)
    private  String lastName;
}
