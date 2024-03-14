package ro.sda.java64.demo2.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {


    @Autowired
    public void setResponseObject(ResponseObject responseObject) {
        this.responseObject = responseObject;
    }

    private  ResponseObject responseObject;




    @GetMapping("/hello")
    public ResponseObject helloWorld(){
        return responseObject;
    }
}
