package ro.sda.java64.demo2.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
@Setter
public class SdaException extends RuntimeException{
    private List<ObjectError> errorsList;

    public SdaException() {
    }

    public SdaException(List<ObjectError> errors) {
        this.errorsList = errors;
    }
}
