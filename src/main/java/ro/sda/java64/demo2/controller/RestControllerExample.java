package ro.sda.java64.demo2.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ro.sda.java64.demo2.exceptions.SdaException;

@Controller
@RequestMapping("/api")
public class RestControllerExample {

    @RequestMapping("/hello")
    public @ResponseBody String helloMessage(@RequestParam(required = false,value = "nume") String name){
        return "Hello" + name;
    }

    @RequestMapping("/hello/nume/{value}")
    public @ResponseBody String helloPathVariableMessage(@PathVariable String value){
        return "Hello pathVariable" + value;
    }

    @RequestMapping("/hello/prenume/{value9}/{value1}/{value2}")
    public ResponseEntity<String> helloResponseEntityMessage(@PathVariable(name="value9") String value,@PathVariable String value2){
        return ResponseEntity.ok("Hello pathVariable" + value);
    }

//    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    @PostMapping("/hello2")
    public ResponseEntity<String> hello2(@RequestBody ResponseObject input){
        String value="Hello using request body :" + input.getName() + " / " + input.getLastName();
        System.out.println(value);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/hello2")
    public ResponseEntity<ResponseDto> hello2_get(@Valid @RequestBody ResponseObject input, Errors errors){
        if (errors.hasErrors()){
            throw new SdaException(errors.getAllErrors());
        }
        String value="Hello using request body :" + input.getName() + " / " + input.getLastName();
        System.out.println(value);
        ResponseDto response =  new ResponseDto();
        response.setLastNameInput(input.getLastName());
        response.setNameInput(input.getName());
        if("TUDOR".equals(input.getName())){
            throw new SdaException();
        }
        throw new ArithmeticException("Ana are pere");
//        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex){
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
